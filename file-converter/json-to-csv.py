import pandas as pd

path = "G:\\Solr-Elastic\\dataset\\json\\wos-papers.json"

df = pd.read_json(path)
df.to_csv('wos_papers.csv')