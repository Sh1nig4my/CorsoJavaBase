import "reflect-metadata";
import { AppDataSource } from "./data-source";
import express from "express";
import * as dotenv from "dotenv";
import userRoutes from "./routes/userRoutes";
import { errorHandler, notFoundHandler } from "./exceptionHandler/errorHandler";

dotenv.config();

const app = express();
app.use(express.json());

// Inizializza la connessione al database
AppDataSource.initialize()
    .then(() => {
        console.log("Connessione al database inizializzata con successo");
        
        // Registrazione delle rotte
        app.use('/api', userRoutes);
        
        // Middleware per gestire i percorsi non trovati
        app.use(notFoundHandler);
        
        // Middleware per la gestione degli errori (deve essere ultimo)
        app.use(errorHandler);
        
        const PORT = process.env.PORT || 3000;
        app.listen(PORT, () => {
            console.log(`Server in esecuzione su http://localhost:${PORT}`);
        });
    })
    .catch((error) => {
        console.error("Errore durante l'inizializzazione della connessione al database:", error);
    });