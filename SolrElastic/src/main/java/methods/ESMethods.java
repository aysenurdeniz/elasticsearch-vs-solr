/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHost;
//import org.elasticsearch.action.ActionFuture;
//import org.elasticsearch.action.ActionListener;
//import org.elasticsearch.action.ActionRequest;
//import org.elasticsearch.action.ActionResponse;
//import org.elasticsearch.action.ActionType;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.action.search.SearchType;
//import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHits;
//import org.elasticsearch.search.aggregations.AggregationBuilders;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.elasticsearch.search.sort.SortOrder;
//import org.elasticsearch.threadpool.ThreadPool;

/**
 * Elasticsearch sorgularının bulunduğu sınıf
 *
 * @author aysenurdeniz
 */
public class ESMethods {

    // Create the low-level client
    RestClient restClient = RestClient.builder(new HttpHost("localhost", 9300)).build();

    // Create the transport with a Jackson mapper
    ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

    // And create the API client
    ElasticsearchClient client = new ElasticsearchClient(transport);

    
    public ESMethods() {
        
    }

    public void generalQuery() {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", "");
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest indexRequest = new IndexRequest("posts").id("1").source(jsonMap);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
    }

//    private static synchronized RestHighLevelClient makeConnection() {
//
//        if (restHighLevelClient == null) {
//            restHighLevelClient = new RestHighLevelClient(
//                    RestClient.builder(
//                            new HttpHost(HOST, PORT, SCHEME)));
//        }
//
//        return restHighLevelClient;
//    }
//
//    private static synchronized void closeConnection() throws IOException {
//        restHighLevelClient.close();
//        restHighLevelClient = null;
//    }
}
