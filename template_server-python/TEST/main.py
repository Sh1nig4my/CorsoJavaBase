from fastapi import FastAPI
from models.user import Base  # Il modello User definito in models/user.py
from database import engine  # La configurazione del DB
from routes import auth  # I tuoi endpoint di autenticazione
from fastapi.staticfiles import StaticFiles


app = FastAPI()

# Crea le tabelle all'avvio (se non esistono già)
Base.metadata.create_all(bind=engine)

# Includi le route per l'autenticazione
app.include_router(auth.router)

#Frontend
app.mount("/static", StaticFiles(directory="static"), name="static")
