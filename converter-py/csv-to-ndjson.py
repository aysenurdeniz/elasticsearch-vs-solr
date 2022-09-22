import csv

with open("C:\\Users\\anurd\\Desktop\\dataset\\csv\\wos-journals.csv", "r") as f1:
    reader = csv.reader(f1)
    next(reader)
    data = []
    number = 1
    st = '{ \"create\": { \"_index\": \"wos\", \"_id\" : \"'
    strdata = ['{\"Journal_Name\":\"', '\", \"Publisher\":\"', '\", \"ISSN_eISSN\":\"',
               '\", \"WoS_Core_Collection\":\"', '\", \"Additional_WoS_Indexes\":\"',
               '\", \"Journal_Website\":\"', '\", \"Publication_Frequency\":\"', '\", \"Aims_and_Scope\":\"',
               '\", \"Indexing_and_Abstracting\":\"']
    with open("wos-journals.txt", "w") as tx:
        for row in reader:
            tx.write(st + str(number) + "\"}\n")
            tx.write(strdata[0] + str(row[0].replace('"', "'"))
                     + strdata[1] + str(row[1].replace('"', "'"))
                     + strdata[2] + str(row[2].replace('"', "'"))
                     + strdata[3] + str(row[3].replace('"', "'"))
                     + strdata[4] + str(row[4].replace('"', "'"))
                     + strdata[5] + str(row[5].replace('"', "'"))
                     + strdata[6] + str(row[6].replace('"', "'"))
                     + strdata[7] + str(row[7].replace('"', "'"))
                     + strdata[8] + str(row[8].replace('"', "'")) + "\"}\n")
            number = number + 1
        tx.close()

with open("C:\\Users\\anurd\\Desktop\\dataset\\csv\\googleplay-reviews.csv", "r") as f2:
    reader = csv.reader(f2)
    next(reader)
    data = []
    number = 1
    st = '{\"index\": {\"_index\": \"reviews\", \"_id\": \"'
    strdata = ['{\"App\":\"', '\", \"Translated_Review\":\"', '\", \"Sentiment\":\"', '\", \"Sentiment_Polarity\":\"',
               '\", \"Sentiment_Subjectivity\":\"']
    with open("googleplay-reviews.txt", "w") as tx:
        for row in reader:
            tx.write(st + str(number) + "\"}\n")
            tx.write(strdata[0] + str(row[0].replace('"', "'"))
                     + strdata[1] + str(row[1].replace('"', "'"))
                     + strdata[2] + str(row[2].replace('"', "'"))
                     + strdata[3] + str(row[3].replace('"', "'"))
                     + strdata[4] + str(row[4].replace('"', "'")) + "\"}\n")
            number = number + 1
        tx.close()

with open("C:\\Users\\anurd\\Desktop\\dataset\\csv\\wos-papers.csv", "r") as f3:
    reader = csv.reader(f3)
    next(reader)
    data = []
    number = 1
    st = '{ \"index\" : { \"_index\":\"papers\" , \"_id\":\"'
    strdata = ['{\"Y\":\"', '\", \"Y2\":\"', '\", \"Y1\":\"', '\", \"Domain\":\"', '\", \"Area\":\"',
               '\", \"Keywords\":\"', '\", \"Abstract\":\"']
    with open("wos-papers.txt", "w") as tx:
        for row in reader:
            tx.write(st + str(number) + "\" }\n")
            tx.write(strdata[0] + str(row[0].replace('"', "'"))
                     + strdata[1] + str(row[1].replace('"', "'"))
                     + strdata[2] + str(row[2].replace('"', "'"))
                     + strdata[3] + str(row[3].replace('"', "'"))
                     + strdata[4] + str(row[4].replace('"', "'"))
                     + strdata[5] + str(row[5].replace('"', "'"))
                     + strdata[6] + str(row[6].replace('"', "'"))
                     + "\"}\n")
            number = number + 1
        tx.close()
