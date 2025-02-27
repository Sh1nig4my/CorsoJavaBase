##PYTHON##

#TODO installazione python locale. (Possibilmente LTS).
https://www.python.org/downloads/

#Pacchetti da installare:
 
pip install fastapi 
#un framework web ad alte prestazioni per la creazione di API in Python.
#Il nostro Spring Boot in Java.

pip install uvicorn	
#un server ASGI (Asynchronous Server Gateway Interface) per Python, progettato per eseguire framework asincroni come FastAPI e Starlette.
#Simile a un server Tomcat ma più leggero.

pip install sqlalchemy
#una libreria ORM (Object-Relational Mapper) per Python che permette di interagire con database SQL in modo più semplice e astratto.
#Il nostro Hibernate/JPA.

pip install pymysql
#una libreria Python che permette di connettersi e interagire con un database MySQL o MariaDB utilizzando il protocollo MySQL.
#Il nostro JDBC.

pip install pydantic[email]
#una libreria Python per garantire che i dati ricevuti dalle API siano corretti, in questo caso la Email.
#In Java simile a Jakarta Validation, Spring Boot Validation o alcune annotazioni di Lombok come @Value o @Data

pip install passlib[bcrypt]
#una libreria Python per la gestione degli hash delle password. Supporta vari algoritmi di hashing, come bcrypt, PBKDF2, Argon2, e altri.
#In Java simile a JBCrypt o Argon2-JVM.

#Runnare il server
uvicorn main:app --reload  

#Troubleshooting
#Spesso abbiamo notato che mancano alcune componenti installate con i comandi pip, tra le più comuni la cryptography, usa questo comando per installarla:
pip install cryptography

#Swagger
http://127.0.0.1:8000/docs

#Architettura
project/
├── main.py
├── database.py         # Configurazione del DB (engine, session, get_db) 
├── models/
│   └── user.py         # Modello ORM (SQLAlchemy)
├── schemas/
│   └── user.py         # Schemi Pydantic (DTO) per input/output
├── repositories/
│   └── user_repository.py  # Funzioni per interagire con il DB
├── services/
│   └── auth_service.py     # Logica di business per l'autenticazione
└── routes/
    └── auth.py         # Endpoints/Controller per login, registrazione, logout



####EXTRA####
#Frontend

#Index
http://127.0.0.1:8000/static/index.html


project/
├── main.py
├── database.py         # Configurazione del DB (engine, session, get_db)
├── models/
│   └── user.py         # Modello ORM (SQLAlchemy)
├── schemas/
│   └── user.py         # Schemi Pydantic (DTO) per input/output
├── repositories/
│   └── user_repository.py  # Funzioni per interagire con il DB
├── services/
│   └── auth_service.py     # Logica di business per l'autenticazione
├── routes/
│   └── auth.py         # Endpoints/Controller per login, registrazione, logout
└── static/             # File statici per il frontend
    ├── index.html
    ├── css/
    │   └── styles.css
    └── js/
        └── script.js




