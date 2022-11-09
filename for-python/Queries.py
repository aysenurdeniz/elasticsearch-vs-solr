import pysolr
from elasticsearch import Elasticsearch
from Timer import Timer

timer = Timer()

queries = ["Translated_Review:nan",
           "Sentiment_Subjectivity:[0.1 TO 0.746]",
           "App:*Food* AND Sentiment:Positive AND Translated_Review:*Full* OR Translated_Review:*great* OR "
           "Translated_Review:*good* OR Translated_Review:*enjoy*",
           "Sentiment_Subjectivity:[0.79 TO 0.82] AND Sentiment_Polarity:0.716666667",
           "Keywords:*Parkinson*",
           "Keywords:*algorithm*  OR Abstract:*algorithm*",
           "Keywords:analysis OR Domain:*CS* OR Abstract:system",
           "xp_end:32417",
           "buybacks:1 AND deaths:1",
           "buybacks:0 AND deaths:1 AND damage:0 OR gold_delta:0"
           ]

indexes = ["apps_reviews", "wos_papers", "teamfights_players"]

sizes = [26863, 26866, 6, 6, 294, 3955, 14926, 237, 26089, 55263]

# def Searching_Solr(index_name, query, size):
#     solr_client = pysolr.Solr('http://localhost:8983/solr/' + index_name + '/')
#     print("Solr Results:")
#     for i in range(5):
#         timer.start_time()
#         response = solr_client.search(query, **{'rows': size})
#         searching_time = timer.finish_time();
#         print(searching_time)
#         # print(len(response))
# 
# 
# def Searching_Elastic(index_name, query, size):
#     es_client = Elasticsearch('http://localhost:9200/')
#     print("Elasticsearch Results:")
#     for i in range(5):
#         timer.start_time()
#         response = es_client.search(index=index_name, size=size, track_total_hits=True,
#                                                                   query={"query_string": {"query": query}})
#         searching_time = timer.finish_time();
#         print(searching_time)
#         # print(response['hits']['total']['value'])

def Searching_Solr(index_name, query, size):
    timer.start_time()
    response = pysolr.Solr('http://localhost:8983/solr/' + index_name + '/').search(query, **{'rows': size})
    searching_time = timer.finish_time();
    print(searching_time)
    # print(len(response))


def Searching_Elastic(index_name, query, size):
    timer.start_time()
    response = Elasticsearch('http://localhost:9200/').search(index=index_name, size=size, track_total_hits=True,
                                                              query={"query_string": {"query": query}})
    searching_time = timer.finish_time();
    print(searching_time)
    # print(response['hits']['total']['value'])



print("-----------1---------------")
Searching_Solr(indexes[0], queries[0], sizes[0])
Searching_Elastic(indexes[0], queries[0], sizes[0])
print("-----------2---------------")
Searching_Solr(indexes[0], queries[1], sizes[1])
Searching_Elastic(indexes[0], queries[1], sizes[1])
print("-----------3---------------")
Searching_Solr(indexes[0], queries[2], sizes[2])
Searching_Elastic(indexes[0], queries[2], sizes[2])
print("-----------4---------------")
Searching_Solr(indexes[0], queries[3], sizes[3])
Searching_Elastic(indexes[0], queries[3], sizes[3])
print("-----------5---------------")
Searching_Solr(indexes[1], queries[4], sizes[4])
Searching_Elastic(indexes[1], queries[4], sizes[4])
print("-----------6---------------")
Searching_Solr(indexes[1], queries[5], sizes[5])
Searching_Elastic(indexes[1], queries[5], sizes[5])
print("-----------7---------------")
Searching_Solr(indexes[1], queries[6], sizes[6])
Searching_Elastic(indexes[1], queries[6], sizes[6])
print("-----------8---------------")
Searching_Solr(indexes[2], queries[7], sizes[7])
Searching_Elastic(indexes[2], queries[7], sizes[7])
print("-----------9---------------")
Searching_Solr(indexes[2], queries[8], sizes[8])
Searching_Elastic(indexes[2], queries[8], sizes[8])
print("-----------10---------------")
Searching_Solr(indexes[2], queries[9], sizes[9])
Searching_Elastic(indexes[2], queries[9], sizes[9])


