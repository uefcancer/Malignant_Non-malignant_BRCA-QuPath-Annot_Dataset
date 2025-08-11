import numpy as np
import pandas as pd
import shutil, time, os, requests, random, copy
import torch
from torchvision import datasets, transforms, models
import torch.nn as nn
import torch.nn.functional as tF
import matplotlib.pyplot as plt
from torch.utils.data import Dataset, DataLoader
from torch.optim.optimizer import Optimizer, required
import re
from PIL import Image
import os
from sklearn.manifold import TSNE
import glob
import torch.nn.functional as F
from sklearn.metrics import accuracy_score, roc_auc_score, roc_curve, f1_score, precision_score, recall_score
from sklearn.cluster import KMeans
from torch.utils.data import Subset
import torch.optim as optim
from sklearn.metrics import silhouette_score, adjusted_rand_score, normalized_mutual_info_score
from sklearn.cluster import KMeans
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
from sklearn.neighbors import KNeighborsClassifier
from tabulate import tabulate
from tiatoolbox.tools.stainnorm import MacenkoNormalizer  # add stain normalizationnnnnnnnnnnnnnnnnnn
from sklearn.svm import OneClassSVM
