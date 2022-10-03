import csv
import json


# CSV to JSON method by https://pythonexamples.org/python-csv-to-json/
# --------------------------------------------------------------------

def csv_to_json(csvFilePath, jsonFilePath):
    jsonArray = []

    # read csv file
    with open(csvFilePath, encoding='utf-8') as csvf:
        # load csv file data using csv library's dictionary reader
        csvReader = csv.DictReader(csvf)

        # convert each csv row into python dict
        for row in csvReader:
            # add this python dict to json array
            jsonArray.append(row)

    # convert python jsonArray to JSON String and write to file
    with open(jsonFilePath, 'w', encoding='utf-8') as jsonf:
        jsonString = json.dumps(jsonArray, indent=4)
        jsonf.write(jsonString)


# csvFilePath = r'C:\\Users\\anurd\\Desktop\\dataset\\papers-data.csv'
# jsonFilePath = r'papers-data.json'
# csv_to_json(csvFilePath, jsonFilePath)


# CSV to JSON

# ------------------WoS Journals--------------------------

with open("C:\\Users\\anurd\\Desktop\\dataset\\wos-engineering.csv", "r") as f:
    reader = csv.reader(f)
    next(reader)
    data = []
    for row in reader:
        data.append({"Journal_Name": row[0].replace('"', "'"),
                     "Publisher": row[1].replace('"', "'"),
                     "ISSN_eISSN": row[2].replace('"', "'"),
                     "Web_of_Science_Core_Collection": row[3].replace('"', "'"),
                     "Additional_Web_of_Science_Indexes": row[4].replace('"', "'"),
                     "Journal_Website": row[5].replace('"', "'"),
                     "Publication_Frequency": row[6].replace('"', "'"),
                     "Aims_and_Scope": row[7].replace('"', "'"),
                     "Indexing_and_Abstracting": row[8].replace('"', "'")})

with open("wos-journals.json", 'w', encoding='utf-8') as f:
    jsonFile = json.dumps(data, indent=4)
    f.write(jsonFile)

# --------------Google Play Reviews------------------------------

with open("C:\\Users\\anurd\\Desktop\\dataset\\googleplaystore_user_reviews.csv", "r") as f:
    reader = csv.reader(f)
    next(reader)
    data = []
    for row in reader:
        data.append({"App": row[0].replace('"', "'"),
                     "Translated_Review": row[1].replace('"', "'"),
                     "Sentiment": row[2].replace('"', "'"),
                     "Sentiment_Polarity": row[3].replace('"', "'"),
                     "Sentiment_Subjectivity": row[4].replace('"', "'")})

with open("googleplay_reviews.json", 'w', encoding='utf-8') as f:
    jsonFile = json.dumps(data, indent=4)
    f.write(jsonFile)

# ------------------WoS Papers--------------------------

with open("C:\\Users\\anurd\\Desktop\\dataset\\papers-data.csv", "r") as f:
    reader = csv.reader(f)
    next(reader)
    data = []
    for row in reader:
        data.append({"Y": row[0].replace('"', "'"),
                     "Y2": row[1].replace('"', "'"),
                     "Y1": row[2].replace('"', "'"),
                     "Domain": row[3].replace('"', "'"),
                     "Area": row[4].replace('"', "'"),
                     "Keywords": row[5].replace('"', "'"),
                     "Abstract": row[6].replace('"', "'")})

with open("wos-papers.json", 'w', encoding='utf-8') as f:
    jsonFile = json.dumps(data, indent=4)
    f.write(jsonFile)

    
# ------------------customers_reviews--------------------------

with open("C:\\Users\\mehdi\\OneDrive\\Masaüstü\\dataset\\archive\\Reviews.csv", "r", encoding='utf-8') as f:
    reader = csv.reader(f)
    next(reader)
    data = []
    for row in reader:
        data.append({"Id": row[0].replace('"', "'"),
                     "ProductId": row[1].replace('"', "'"),
                     "UserId": row[2].replace('"', "'"),
                     "ProfileName": row[3].replace('"', "'"),
                     "HelpfulnessNumerator": row[4].replace('"', "'"),
                     "HelpfulnessDenominator": row[5].replace('"', "'"),
                     "Score": row[6].replace('"', "'"),
                     "Time": row[7].replace('"', "'"),
                     "Summary": row[8].replace('"', "'"),
                     "Text": row[9].replace('"', "'")})

with open("customers_reviews.json", 'w', encoding='utf-8') as f:
    jsonFile = json.dumps(data, indent=4)
    f.write(jsonFile)
    

with open("C:\\Users\\mehdi\\OneDrive\\Masaüstü\\dataset\\player\\archive\\teamfights_players.csv", "r") as f:
    reader = csv.reader(f)
    next(reader)
    data = []
    for row in reader:
        data.append({"match_id": row[0].replace('"', "'"),
                     "player_slot": row[1].replace('"', "'"),
                     "buybacks": row[2].replace('"', "'"),
                     "damage": row[3].replace('"', "'"),
                     "deaths": row[4].replace('"', "'"),
                     "gold_delta": row[5].replace('"', "'"),
                     "xp_end": row[6].replace('"', "'"),
                     "xp_start": row[7].replace('"', "'")})

with open("wos_papers.json", 'w', encoding='utf-8') as f:
    jsonFile = json.dumps(data, indent=4)
    f.write(jsonFile)
    
    
#
# with open("C:\\Users\\anurd\\Desktop\\dataset\\wos-engineering.csv", "r") as f:
#     reader = csv.reader(f)
#     next(reader)
#     data = []
#     with open("text.csv", "w", encoding='UTF8', newline='') as fi:
#         writer = csv.writer(fi)
#         for row in reader:
#             row[7] = row[7].strip()
#             line = row[7].replace(".\n\n", ". ")
#             line = line.replace("\n\n", ", ")
#             line = line.replace("\n", ", ")
#             line = line.replace(":\n", ", ")
#             line = line.replace('"', "'")
#             data.append(line)
#
#         writer.writerow(data)
