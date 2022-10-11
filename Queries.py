import pysolr
from elasticsearch import Elasticsearch
from get_timer.Timer import Timer

timer = Timer()

queries = ["Translated_Review:nan",
           "Sentiment_Subjectivity:[0.1 TO 0.746]",
           "App:*Food* AND Sentiment:Positive AND Translated_Review:*Full* OR Translated_Review:*great* OR "
           "Translated_Review:*good* OR Translated_Review:*enjoy*",
           "Sentiment_Subjectivity:[0.79 TO 0.82] AND Sentiment_Polarity:0.716666667",
           "keywords:*Parkinson*",
           "keywords:*algorithm*  OR Abstract:*algorithm*",
           "keywords:analysis OR Domain:*CS* OR Abstract:system",
           "q=xp_end:32417",
           "buybacks:1 AND deaths:1",
           "buybacks:0 AND deaths:1 AND damage:0 OR gold_delta:0"
           ]

indexes = ["apps_reviews", "wos_papers", "teamfights_players"]


def Searching_Solr(index_name, query):
    timer.start_time()
    response = pysolr.Solr('http://localhost:8983/solr/' + index_name + '/').search(query, **{"rows":"100"})
    print(timer.finish_time())
    print(response.hits)


def Searching_Elastic(index_name, query):
    timer.start_time()
    response = Elasticsearch('http://localhost:9200/').search(index=index_name, size=100, query={"query_string": {"query": query}})
    print(timer.finish_time())
    print(response['hits']['total']['value'])


for i in range(5):
    Searching_Elastic(indexes[0], queries[0])
    Searching_Solr(indexes[0], queries[0])

for i in range(5):
    Searching_Solr(indexes[0], queries[1])
    Searching_Elastic(indexes[0], queries[1])

Searching_Solr(indexes[0], queries[2])
Searching_Elastic(indexes[0], queries[2])

Searching_Solr(indexes[0], queries[3])
Searching_Elastic(indexes[0], queries[3])

Searching_Solr(indexes[1], queries[4])
Searching_Elastic(indexes[1], queries[4])

Searching_Solr(indexes[1], queries[5])
Searching_Elastic(indexes[1], queries[5])

Searching_Solr(indexes[1], queries[6])
Searching_Elastic(indexes[1], queries[6])

Searching_Solr(indexes[2], queries[7])
Searching_Elastic(indexes[2], queries[7])

Searching_Solr(indexes[2], queries[8])
Searching_Elastic(indexes[2], queries[8])

Searching_Solr(indexes[2], queries[9])
Searching_Elastic(indexes[2], queries[9])
