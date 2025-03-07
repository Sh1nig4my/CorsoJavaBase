Node.js MongoDB REST API
Comandi per Creare la Struttura del Progetto
# Creare la struttura delle directory
mkdir -p src/{controllers,dto,entity,exceptionHandler,repositories,routes,services}

# Creare i file principali
touch src/index.ts
touch src/data-source.ts
touch src/controllers/UserController.ts
touch src/dto/UserDTO.ts
touch src/entity/User.ts
touch src/exceptionHandler/errorHandler.ts
touch src/repositories/UserRepository.ts
touch src/routes/userRoutes.ts
touch src/services/UserService.ts
touch tsconfig.json
touch package.json
Un'API REST completamente funzionale costruita con Node.js, Express, TypeScript e TypeORM per interagire con MongoDB Atlas.

Panoramica del Progetto
Questo progetto implementa un'API RESTful per la gestione degli utenti seguendo principi di architettura pulita e best practices di sviluppo, tra cui:

Architettura a livelli (Controller → Service → Repository)
Data Transfer Objects (DTO) per la validazione e la trasformazione dei dati
Pattern Repository per l'accesso al database
Gestione centralizzata degli errori
Connessione a MongoDB Atlas tramite TypeORM
Requisiti
Node.js (v16 o superiore)
npm (v7 o superiore)
Account MongoDB Atlas (o un'istanza MongoDB locale)
Struttura delle Directory
.
├── src/
│   ├── controllers/           # Gestione delle richieste HTTP
│   │   └── UserController.ts
│   ├── dto/                   # Data Transfer Objects
│   │   └── UserDTO.ts
│   ├── entity/                # Definizioni delle entità TypeORM
│   │   └── User.ts
│   ├── exceptionHandler/      # Gestione degli errori
│   │   └── errorHandler.ts
│   ├── repositories/          # Implementazione del pattern repository
│   │   └── UserRepository.ts
│   ├── routes/                # Definizione delle rotte
│   │   └── userRoutes.ts
│   ├── services/              # Logica di business
│   │   └── UserService.ts
│   ├── data-source.ts         # Configurazione TypeORM
│   └── index.ts               # Punto di ingresso dell'applicazione
├── .env                       # Variabili d'ambiente (da creare)
├── tsconfig.json              # Configurazione TypeScript
└── package.json               # Dipendenze e script npm
Guida all'Installazione
1. Clona il Repository
git clone https://github.com/yourusername/node-mongodb-rest-api.git
cd node-mongodb-rest-api
2. Installa le Dipendenze
npm install
3. Configura la Connessione al Database
Modifica il file src/data-source.ts con le tue credenziali MongoDB:

// Credenziali per MongoDB Atlas
const username = "TuoUsername";
const password = encodeURIComponent("TuaPassword"); 
const dbName = "NomeDatabase";

// URI di connessione per MongoDB Atlas
const mongoUri = `mongodb+srv://${username}:${password}@cluster0.vtyfd.mongodb.net/${dbName}?retryWrites=true&w=majority`;
Nota: Sostituisci i valori con le tue credenziali MongoDB Atlas.

4. Costruisci il Progetto
npm run build
5. Avvia il Server
# Per avviare con il codice compilato
npm start

# Per avviare in modalità sviluppo con hot-reload
npm run dev
6. Verifica l'Installazione
Il server dovrebbe avviarsi e mostrare un messaggio simile a:

Server in esecuzione su http://localhost:3000
Connessione al database inizializzata con successo
Utilizzo dell'API
L'API fornisce i seguenti endpoint per la gestione degli utenti:

Creare un Utente
Richiesta:

curl -X POST http://localhost:3000/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Mario Rossi","email":"mario@example.com","password":"password123"}'
Risposta:

{
  "id": "65f8a1c6e2c0bc25402a0123",
  "name": "Mario Rossi",
  "email": "mario@example.com"
}
Ottenere Tutti gli Utenti
Richiesta:

curl -X GET http://localhost:3000/api/users
Risposta:

[
  {
    "id": "65f8a1c6e2c0bc25402a0123",
    "name": "Mario Rossi",
    "email": "mario@example.com"
  },
  ...
]
Ottenere un Utente Specifico
Richiesta:

curl -X GET http://localhost:3000/api/users/65f8a1c6e2c0bc25402a0123
Risposta:

{
  "id": "65f8a1c6e2c0bc25402a0123",
  "name": "Mario Rossi",
  "email": "mario@example.com"
}
Aggiornare un Utente
Richiesta:

curl -X PUT http://localhost:3000/api/users/65f8a1c6e2c0bc25402a0123 \
  -H "Content-Type: application/json" \
  -d '{"name":"Mario Rossi Aggiornato"}'
Risposta:

{
  "id": "65f8a1c6e2c0bc25402a0123",
  "name": "Mario Rossi Aggiornato",
  "email": "mario@example.com"
}
Eliminare un Utente
Richiesta:

curl -X DELETE http://localhost:3000/api/users/65f8a1c6e2c0bc25402a0123
Risposta: Status 204 No Content

Comandi Disponibili
Il progetto include i seguenti comandi npm:

npm run build: Compila il codice TypeScript in JavaScript
npm start: Avvia il server compilato
npm run dev: Avvia il server in modalità sviluppo con hot-reload
npm run typeorm: Esegue comandi TypeORM (es. migrazioni)
Database
Il progetto utilizza MongoDB come database attraverso TypeORM. L'entità principale è User con i seguenti campi:

id: Identificatore unico (ObjectId di MongoDB)
name: Nome dell'utente
email: Email dell'utente
password: Password dell'utente (in produzione dovrebbe essere hashata)
Risoluzione dei Problemi
Problemi di Connessione al Database
Verifica che l'URI di MongoDB sia corretto nel file data-source.ts
Assicurati che l'IP del tuo client sia nella whitelist di MongoDB Atlas
Controlla se le credenziali sono corrette
Verifica che il nome del database sia corretto
Errori di Compilazione
Assicurati che TypeScript sia installato correttamente
Controlla la configurazione in tsconfig.json
Esegui npm install per assicurarti che tutte le dipendenze siano installate
Problemi con i Moduli
Se riscontri errori relativi ai moduli:

# Rimuovi la cartella node_modules e reinstalla
rm -rf node_modules
npm install
Best Practices di Sviluppo
Quando estendi questo progetto, considera le seguenti best practices:

Sicurezza:

Implementa autenticazione JWT
Hasha le password con bcrypt
Utilizza helmet per le intestazioni HTTP sicure
Validazione:

Aggiungi validazione più robusta con class-validator
Implementa sanitizzazione degli input
Testing:

Aggiungi test unitari con Jest
Implementa test di integrazione per le API
Logging:

Implementa un sistema di logging strutturato con Winston
Licenza
MIT

Contatti
Per domande o supporto, contattare [il tuo indirizzo email].