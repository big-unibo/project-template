import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

np.random.seed(3)
datasets = "../../../datasets/"
outputs = "../../../outputs/"
results = "../../../results/"

# #############################################################################
# A plot with random data
df = pd.read_csv(outputs + "geolife.csv")
fig, ax = plt.subplots(figsize=(8, 4))
X = df["timestamp"]
Y = np.random.rand(len(X.index))
Z = np.random.rand(len(X.index))
ax.set_xlabel("$Time (s)$")
ax.set_ylabel("$\\alpha$")
ax.plot(X, Y, label="Y", marker="s", ls="-")
ax.plot(X, Z, label="Z", marker="o", ls="--")
ax.grid(True)
ax.set_title("A plot with random data")
ax.legend()
plt.tight_layout()
plt.savefig(results + "dummy.pdf")
# #############################################################################