import sys
from sentence_transformers import SentenceTransformer
import json

modelo = SentenceTransformer("all-MiniLM-L6-v2")
texto = sys.stdin.read()
embedding = modelo.encode(texto).tolist()
print(json.dumps(embedding))
