import json
import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.preprocessing import LabelEncoder
from sklearn.linear_model import LogisticRegression
import pickle
import os,sys

dir_path = os.path.dirname(os.path.realpath(__file__))
class Classifier:
    def generate_classifier(self):
        data = []
        with open('intents.json') as f:
            data = json.load(f)
        intent_data = []
        for intent in data['intents']:
            for pattern in intent['patterns']:
                intent_data.append({"text": pattern, "intent": intent['tag']})
        df = pd.DataFrame(intent_data)
        vectorizer = TfidfVectorizer(analyzer='char_wb', ngram_range=(2, 4), max_features=5000)
        X = vectorizer.fit_transform(df['text'])
        le = LabelEncoder()
        y = le.fit_transform(df['intent'])
        model = LogisticRegression(multi_class='multinomial', solver='lbfgs', max_iter=1000)
        model.fit(X, y)
        with open('intent_classifier.pkl', 'wb') as f:
            pickle.dump({
                'model': model,
                'vectorizer': vectorizer,
                'label_encoder': le
            }, f)
        print("Archivo generado exitosamente.")
    
    def predict_Intent(self,text):
        data = []
        with open(os.path.join(dir_path, 'intent_classifier.pkl'), 'rb') as f:
            data = pickle.load(f)
        X = data['vectorizer'].transform([text])
        intent_idx = data['model'].predict(X)[0]
        intent = data['label_encoder'].inverse_transform([intent_idx])[0]
        proba = data['model'].predict_proba(X).max()
        print(f"{intent}, {proba:.2f}")


if __name__ == "__main__":
    import sys
    config = sys.argv[1] if len(sys.argv) > 1 else ""
    datos = sys.stdin.read()
    instancia = Classifier()
    instancia.predict_Intent(datos.replace("+"," "))
