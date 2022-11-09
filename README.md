# Elasticsearch vs Solr

Below are datasets that used in this project:
| Dataset | Volume |
| ----------- | ----------- |
| teamfights_players.csv - [Dota 2 Matches](https://www.kaggle.com/datasets/devinanzelmo/dota-2-matches) | ~300 MB / 1500000 |
| X.txt - [Web of Science Dataset](https://data.mendeley.com/datasets/9rw3vkcfy4/6) | ~70 MB / 46985 |
| googleplaystore_user_reviews.csv - [Google Play Store Apps](https://www.kaggle.com/lava18/google-play-store-apps) | ~17 MB / 64295 |


# Query Codes

### Apache Solr 
```java
public void solrGeneralQuery(String indexName, String query, String size) {
        QueryResponse response;
        final Map<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("q", query);
        queryParamMap.put("rows", size);
        //queryParamMap.put("sort", sort);
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);
        try {
            for (int i = 0; i < 5; i++) {
                timer.Timer.start();
                response = client.query(indexName, queryParams);
                System.out.println("Found " + response.getResults().getNumFound() + " documents");
                timer.Timer.stop();
                System.out.println("----------------------\nGeçen Süre:" + timer.Timer.getElapsedMilliseconds());
                fileW.file_print(response.jsonStr(), "solr.txt");
                cmdCommand.CmdCommand.Wait(3000);
            }
        } catch (SolrServerException | IOException ex) {
            Logger.getLogger(SolrMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
}
```

### Elasticsearch 
```java

public void esGeneralQuery(String indexName, String fields, String values, int size) {
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
                System.out.println("----------------------\nGeçen Süre:" + timer.Timer.getElapsedMilliseconds());
                fileW.file_print(response.toString(), "elasticsearch.txt");
                cmdCommand.CmdCommand.Wait(3000);
            }
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(ESMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
```
