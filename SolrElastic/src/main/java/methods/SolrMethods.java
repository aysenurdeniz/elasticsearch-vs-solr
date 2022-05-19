/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import static org.apache.solr.client.solrj.SolrQuery.ORDER.asc;
import static org.apache.solr.client.solrj.SolrQuery.ORDER.desc;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;

/**
 * Solr sorgularının bulunduğu sınıf
 *
 * @author aysenurdeniz
 */
public class SolrMethods {

    //Solr arama motoru bağlantı - client oluşturma
    public SolrClient client = new HttpSolrClient.Builder("http://localhost:8983/solr").build();

    //Sorgu nesnesi
    SolrQuery query = new SolrQuery();

    public SolrMethods() {
    }

    public void generalQuery(String indexName, String query, String fl, String sort) {
        final QueryResponse response;
        final Map<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("q", query);
        queryParamMap.put("fl", fl);
        queryParamMap.put("sort", sort);
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);
        try {
            timer.Timer.start();
            response = client.query(indexName, queryParams);
            System.out.println("Found " + response.getResults().getNumFound() + " documents");
            System.out.println(response.getResults());
//            final SolrDocumentList documents = response.getResults();
//            for (SolrDocument document : documents) {
//                System.out.println(document.toString());
//            }
//            if (documents.size() > 10) {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(documents.get(i));
//                }
//            } else {
//                for (int i = 0; i < documents.size(); i++) {
//                    System.out.println(documents.get(i));
//                }
//            }
            timer.Timer.stop();
            System.out.println("----------------------\nGeçen Süre:" + timer.Timer.getElapsedMilliseconds());
        } catch (SolrServerException | IOException ex) {
            Logger.getLogger(SolrMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//
//    //Sorgu 1
//    public void queryOne() {
//        query.set("q", "Translated_Review:nan");
//        query.setFields("App", "Translated_Review", "Sentiment", "id",
//                "Sentiment_Polarity", "Sentiment_Subjectivity");
//        query.setFacet(true);
//        query.set("facet.query", "Translated_Review:nan");
//        query.set("defType", "lucene");
//        query.setRows(Integer.MAX_VALUE);
//    }
//
//    //Sorgu 2
//    public void queryTwo() {
//        query.set("q", "Sentiment_Polarity: {0.5 TO * ] AND Sentiment_Subjectivity: [* TO 0.5}");
//        query.setFields("App", "Translated_Review", "Sentiment", "id", "Sentiment_Polarity", "Sentiment_Subjectivity");
//        query.setStart(0);
//        query.setRows(Integer.MAX_VALUE);
//        query.set("defType", "lucene");
//    }
//
//    //Sorgu 3
//    public void queryThree() {
//        query.set("q", "Sentiment_Polarity:0.5*");
//        query.setFields("App", "Translated_Review", "Sentiment", "id", "Sentiment_Polarity", "Sentiment_Subjectivity");
//        query.setStart(0);
//        query.setRows(Integer.MAX_VALUE);
//        query.set("defType", "lucene");
//    }
//
//    //Sorgu 4
//    public void queryFour() {
//        query.set("q", "Sentiment_Subjectivity:[0.8 TO 1.0]");
//        query.setFields("App");
//        query.set("defType", "lucene");
//    }
//
//    //Sorgu 5
//    public void queryFive() {
//        query.set("q", "Sentiment_Subjectivity:[0.2 TO 0.7]");
//        query.setFields("App");
//        query.set("defType", "lucene");
//    }
//
//    //Sorgu 6
//    public void querySix() {
//        query.set("q", "Sentiment:Negative");
//        query.setFacet(true);
//        query.set("facet.field", "App");
//        query.set("defType", "lucene");
//    }
//
//    //Sorgu 7
//    public void querySeven() {
//        query.set("q", "Sentiment:Negative");
//        query.setFacet(true);
//        query.set("facet.field", "App");
//        query.setSort("Sentiment_Polarity", asc);
//        query.set("defType", "lucene");
//    }
//
//    //Sorgu 8
//    public void queryEigth() {
//        query.set("q", "App:*Food* AND Sentiment:Positive AND Translated_Review:*Full*");
//        query.setFields("App");
//        query.set("defType", "lucene");
//    }
//
//    //Sorgu 9
//    public void queryNine() {
//        query.set("q", "Sentiment:Positive AND Translated_Review:*great* AND Translated_Review:*good* AND Translated_Review:*enjoy*");
//        query.setFields("App", "Translated_Review", "Sentiment", "id", "Sentiment_Polarity", "Sentiment_Subjectivity");
//        query.setSort("Sentiment_Polarity", desc);
//        query.set("fl", "App");
//        query.setRows(Integer.MAX_VALUE);
//        query.set("defType", "lucene");
//    }
//
//    //Query 10
//    public void queryTen() {
//        query.set("q", "Sentiment:Negative");
//        query.setFields("App", "Translated_Review", "Sentiment", "id", "Sentiment_Polarity", "Sentiment_Subjectivity");
//        query.setFacet(true);
//        query.set("facet.field", "Translated_Review");
//        query.set("defType", "lucene");
//        query.setRows(Integer.MAX_VALUE);
//    }
//
//    //Sonuç Yazdırma
//    public void print() throws SolrServerException, IOException {
//        QueryResponse response = client.query(query);
//        SolrDocumentList results = response.getResults();
//        if (results.size() > 10) {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(results.get(i));
//            }
//        } else {
//            for (int i = 0; i < results.size(); i++) {
//                System.out.println(results.get(i));
//            }
//        }
//
//        System.out.println(results.getNumFound() + " adet sonuç bulundu.");
//    }
//
//    public QueryResponse query(String query) {
//        try {
//            QueryResponse rsp = client.query(
//                    new SolrQuery(query).setRows(Integer.MAX_VALUE));
//            System.out.println(rsp.getResults().size());
////            for (int i = 0; i < 10; i++) {
////                System.out.println(rsp.getResults().get(i));
////            }
//            return rsp;
//        } catch (IOException | SolrServerException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
