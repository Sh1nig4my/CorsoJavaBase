# database.py
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

# Stringa connessione
SQLALCHEMY_DATABASE_URL = "mysql+pymysql://root:Deryltwd9@localhost:3306/loginpython"

# Crea il motore (engine)
engine = create_engine(SQLALCHEMY_DATABASE_URL)

# Crea una session factory per interagire con il DB
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

# Funzione di dependency injection per FastAPI
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()
