/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.io.IOException;
import java.util.Arrays;
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
import org.elasticsearch.search.sort.SortOrder;

/**
 * Elasticsearch sorgularının bulunduğu sınıf
 *
 * @author aysenurdeniz
 */
public class ESMethods {

    RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http"),
                    new HttpHost("localhost", 9201, "http")));

    public ESMethods() {

    }

    /**
     *
     * @param indexName
     * @param fields
     * @param values
     */
    public void generalQuery(String indexName, String fields, String values) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery(fields, values));
        sourceBuilder.trackTotalHits(true);

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(indexName);
        searchRequest.source(sourceBuilder);

        try {
            timer.Timer.start();
            SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
            System.out.println("Found " + response.getHits().getTotalHits());
            System.out.println(response.getHits());
            timer.Timer.stop();
            System.out.println("----------------------\nGeçen Süre:" + timer.Timer.getElapsedMilliseconds());
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(ESMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
