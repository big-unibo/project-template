import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

np.random.seed(3)
datasets = "../../../datasets/"
outputs = "../../../outputs/"
results = "../../../results/"

# #############################################################################
# A plot with random data
df = pd.read_csv(outputs + "geolife.csv") # read data
fig, ax = plt.subplots(figsize=(8, 4)) # create the figure
X = df["timestamp"] # X data
Y = np.random.rand(len(X.index)) # Y data
Z = np.random.rand(len(X.index)) # Z data
ax.set_xlabel("Time (s)") # X axis label
ax.set_ylabel("$\\alpha$") # Y axis label (latex math mode $$)
ax.plot(X, Y, label="Y", marker="s", ls="-") # Draw a line
ax.plot(X, Z, label="Z", marker="o", ls="--") # Draw the other line
ax.grid(True) # Draw the grid
ax.set_title("A plot with random data") # Set the title
ax.legend() # Draw the legend
plt.tight_layout() # Set the layout
plt.savefig(results + "dummy.pdf") # Save to pdf
# #############################################################################