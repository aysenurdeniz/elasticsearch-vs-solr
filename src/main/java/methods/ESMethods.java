/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import fileWriter.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.action.search.SearchResponse;

/**
 * Elasticsearch sorgularının bulunduğu sınıf
 *
 * @author aysenurdeniz
 */
public class ESMethods extends cmdCommand.CmdCommand{

    RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http"),
                    new HttpHost("localhost", 9201, "http")));

    public ESMethods() {
        // ESMethods.super.excCommand("elasticsearch");
    }
    
    fileWriter.FileWriter fileW = new FileWriter();

    /**
     *
     * @param indexName
     * @param fields
     * @param values
     * @param size
     */
    public void generalQuery(String indexName, String fields, String values, int size) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery(fields, values));
        sourceBuilder.trackTotalHits(true);
        sourceBuilder.size(size);

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(indexName);
        searchRequest.source(sourceBuilder);

        try {
            for (int i = 0; i < 10; i++) {
                timer.Timer.start();
                SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
                System.out.println("Found " + response.getHits().getTotalHits());
                timer.Timer.stop();
                System.out.println("----------------------\nTime:" + timer.Timer.getElapsedMilliseconds());
                fileW.file_print(response.toString(), "elasticsearch.txt");
                cmdCommand.CmdCommand.Wait(3000);
            }

            client.close();
        } catch (IOException ex) {
            Logger.getLogger(ESMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
