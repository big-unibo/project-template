import pandas as pd
import numpy as np

datasets = "../../../datasets/"
outputs = "../../../outputs/"

df = pd.read_csv(datasets + "geolife.csv")
df = df[["userid", "trajectoryid", "latitude", "longitude", "date", "time"]]
df["latitude"] = np.round(df["latitude"], 8)
df["longitude"] = np.round(df["longitude"], 8)
df.to_csv(outputs + "geolife.csv", index=False)