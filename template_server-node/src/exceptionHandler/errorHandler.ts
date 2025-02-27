import { Request, Response, NextFunction } from "express";

// Middleware per la gestione centralizzata degli errori
export function errorHandler(err: Error, req: Request, res: Response, next: NextFunction) {
    console.error("Errore nell'applicazione:", err);
    
    // Invia una risposta generica di errore
    res.status(500).json({
        error: "Si è verificato un errore interno del server",
        message: process.env.NODE_ENV === "development" ? err.message : undefined
    });
}

// Middleware per gestire gli errori di richieste a percorsi non esistenti
export function notFoundHandler(req: Request, res: Response) {
    res.status(404).json({
        error: "Percorso non trovato",
        path: req.originalUrl
    });
}