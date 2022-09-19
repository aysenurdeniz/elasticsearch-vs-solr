Elasticsearch'e özel JSON formatında veri setlerini içermektedir.

Dönüştürme işlemi için CSV-to-NewJSON.py kullanılmaktadır.

Örnek birkaç satır:

```json
{"create": {"_index": "papers", "_id": "1"}
{"App":"10 Best Foods for You", "Translated_Review":"I like eat delicious food. That's I'm cooking food myself, case "10 Best Foods" helps lot, also "Best Before (Shelf Life)"", "Sentiment":"Positive", "Sentiment_Polarity":"1", "Sentiment_Subjectivity":"0.533333333"}
{"create": {"_index": "papers", "_id": "2"}
{"App":"10 Best Foods for You", "Translated_Review":"This help eating healthy exercise regular basis", "Sentiment":"Positive", "Sentiment_Polarity":"0.25", "Sentiment_Subjectivity":"0.288461538"}
{"create": {"_index": "papers", "_id": "3"}
{"App":"10 Best Foods for You", "Translated_Review":"nan", "Sentiment":"nan", "Sentiment_Polarity":"nan", "Sentiment_Subjectivity":"nan"}
```

Üç tane veri seti bulunmaktadır:

1- papers-data.zip > papers-data.txt
2- reviews-data.zip > reviews-data.txt
3- wos-data.txt
