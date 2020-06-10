import pandas as pd
import numpy as np
import time
from datetime import date, timedelta, datetime
import pytz
tz = pytz.timezone('Europe/Rome')

datasets = "../../../datasets/"
outputs = "../../../outputs/"
date_format     = '%Y-%m-%d'
datetime_format_notz = '%Y-%m-%d %H:%M:%S'
datetime_format = '%Y-%m-%d %H:%M:%S %Z'

df = pd.read_csv(datasets + "geolife.csv")
df = df[["userid", "trajectoryid", "latitude", "longitude", "date", "time"]]
df["latitude"] = np.round(df["latitude"], 8)
df["longitude"] = np.round(df["longitude"], 8)
df["timestamp"] = (df['date'].astype(str) + " " + df['time'].astype(str)).apply(lambda x: time.mktime(datetime.strptime(x, datetime_format_notz).astimezone(tz).timetuple())).astype(int)
    
df.to_csv(outputs + "geolife.csv", index=False)