import csv

with open("C:\\Users\\anurd\\Downloads\\wos-engineering.csv", "r") as f1:
    reader = csv.reader(f1)
    next(reader)
    data = []
    number = 1
    st = '{\"create\": {\"_index\": \"wos\", \"_id\": \"'
    strdata = ['{\"Journal_Name\":\"', '\", \"Publisher\":\"', '\", \"ISSN_eISSN\":\"',
               '\", \"WoS_Core_Collection\":\"', '\", \"Additional_WoS_Indexes\":\"',
               '\", \"Journal_Website\":\"', '\", \"Publication_Frequency\":\"', '\", \"Aims_and_Scope\":\"',
               '\", \"Indexing_and_Abstracting\":\"']
    with open("wos-data.txt", "w") as tx:
        for row in reader:
            tx.write(st + str(number) + "\"}\n")
            tx.write(strdata[0] + str(row[0]) + strdata[1] + str(row[1]) + strdata[2] + str(row[2]) + strdata[3]
                     + str(row[3]) + strdata[4] + str(row[4]) + strdata[5] + str(row[5]) + strdata[6] + str(row[6])
                     + strdata[7] + str(row[7]) + strdata[8] + str(row[8]) + "\"}\n")
            number = number + 1
        tx.close()

with open("C:\\Users\\anurd\\Downloads\\googleplaystore_user_reviews.csv", "r") as f2:
    reader = csv.reader(f2)
    next(reader)
    data = []
    number = 1
    st = '{\"create\": {\"_index\": \"reviews\", \"_id\": \"'
    strdata = ['{\"App\":\"', '\", \"Translated_Review\":\"', '\", \"Sentiment\":\"', '\", \"Sentiment_Polarity\":\"',
               '\", \"Sentiment_Subjectivity\":\"']
    with open("reviews-data.txt", "w") as tx:
        for row in reader:
            tx.write(st + str(number) + "\"}\n")
            tx.write(strdata[0] + str(row[0]) + strdata[1] + str(row[1]) + strdata[2] + str(row[2]) + strdata[3]
                     + str(row[3]) + strdata[4] + str(row[4]) + "\"}\n")
            number = number + 1
        tx.close()

with open("C:\\Users\\anurd\\Downloads\\papers-data.csv", "r") as f3:
    reader = csv.reader(f3)
    next(reader)
    data = []
    number = 1
    st = '{\"create\": {\"_index\": \"papers\", \"_id\": \"'
    strdata = ['{\"Y\":\"', '\", \"Y2\":\"', '\", \"Y1\":\"', '\", \"Domain\":\"', '\", \"Area\":\"',
               '\", \"Keywords\":\"', '\", \"Abstract\":\"']
    with open("papers-data.txt", "w") as tx:
        for row in reader:
            tx.write(st + str(number) + "\"}\n")
            tx.write(strdata[0] + str(row[0]) + strdata[1] + str(row[1]) + strdata[2] + str(row[2]) + strdata[3]
                     + str(row[3]) + strdata[4] + str(row[4]) + strdata[5] + str(row[5]) + strdata[6] + str(row[6])
                     + "\"}\n")
            number = number + 1
        tx.close()
