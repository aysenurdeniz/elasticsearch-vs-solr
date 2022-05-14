/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import entity.EntityModel;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;

/**
 * Elasticsearch sorgularının bulunduğu sınıf
 *
 * @author aysenurdeniz
 */
public class ESMethods {

    // Create the low-level client
    RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build();

    // Create the transport with a Jackson mapper
    ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

    // And create the API client
    ElasticsearchClient client = new ElasticsearchClient(transport);
//
//    private static final String HOST = "localhost";
//    private static final int PORT = 9200;
//    private static final String SCHEME = "http";
//    private static RestHighLevelClient restHighLevelClient;
//
//    SearchSourceBuilder builder = new SearchSourceBuilder();
//    SearchRequest searchRequest = new SearchRequest();

//    private static final String INDEX = "reviews";
    public ESMethods() {
        //makeConnection();
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
    //Sorgu 1
    public void queryOne() {
       
    }

    //Sorgu 2
    public void queryTwo() {

    }

    //Sorgu 3
    public void queryThree() {

    }

    //Sorgu 4
    public void queryFour() {

    }

    //Sorgu 5
    public void queryFive() {

    }

    //Sorgu 6
    public void querySix() {

    }

    //Sorgu 7
    public void querySeven() {

    }
//
//    //Sorgu 8
//    public void queryEigth() {
//        builder = new SearchSourceBuilder()
//                .query(QueryBuilders.matchQuery("Sentiment", "Positive"))
//                .query(QueryBuilders.fuzzyQuery("App", "*Food*"))
//                .query(QueryBuilders.fuzzyQuery("Translated_Review", "*Full*"));
//    }
//
//    //Sorgu 9
//    public void queryNine() {
//
//    }
//
//    //Query 10
//    public void queryTen() {
//
//    }
//
}
