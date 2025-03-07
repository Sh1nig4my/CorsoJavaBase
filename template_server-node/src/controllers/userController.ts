import { Request, Response } from "express";
import { IUserService, UserService } from "../services/UserService";
import { CreateUserDTO, UpdateUserDTO } from "../dto/UserDTO";

// Controller per le operazioni relative agli utenti
export class UserController {
    private userService: IUserService;

    constructor() {
        // Dependency Injection (seguendo il principio di inversione delle dipendenze)
        this.userService = new UserService();
    }

    // Crea un nuovo utente
    async createUser(req: Request, res: Response): Promise<void> {
        
        try {
            const userData: CreateUserDTO = req.body;
            
            // Validazione di base
            if (!userData.name || !userData.email || !userData.password) {
                res.status(400).json({ error: "Nome, email e password sono campi obbligatori" });
                return;
            }
            
            const newUser = await this.userService.createUser(userData);
            res.status(201).json(newUser);
        } catch (error) {
            console.error("Errore nel controller durante la creazione dell'utente:", error);
            res.status(500).json({ error: "Errore interno del server" });
        }
    }

    // Recupera tutti gli utenti
    async getAllUsers(req: Request, res: Response): Promise<void> {
        try {
            const users = await this.userService.getUsers();
            res.json(users);
        } catch (error) {
            console.error("Errore nel controller durante il recupero degli utenti:", error);
            res.status(500).json({ error: "Errore interno del server" });
        }
    }

    // Recupera un utente specifico per ID
    async getUserById(req: Request, res: Response): Promise<void> {
        try {
            const userId = req.params.id;
           
            if (!userId) {
                res.status(400).json({ error: "ID utente non specificato" });
                return;
            }
            
            const user = await this.userService.getUserById(userId);
            
            if (!user) {
                res.status(404).json({ error: "Utente non trovato" });
                return;
            }
            
            res.json(user);
        } catch (error) {
            console.error("Errore nel controller durante il recupero dell'utente:", error);
            res.status(500).json({ error: "Errore interno del server" });
        }
    }

    // Aggiorna un utente specifico per ID
    async updateUser(req: Request, res: Response): Promise<void> {
        try {
            const userId = req.params.id;
            const userData: UpdateUserDTO = req.body;
           
            
            if (!userId) {
                res.status(400).json({ error: "ID utente non specificato" });
                return;
            }
            
            // Verifica se è stato fornito almeno un campo da aggiornare
            if (Object.keys(userData).length === 0) {
                res.status(400).json({ error: "Nessun dato fornito per l'aggiornamento" });
                return;
            }
            
            const updatedUser = await this.userService.updateUser(userId, userData);
            
            if (!updatedUser) {
                res.status(404).json({ error: "Utente non trovato" });
                return;
            }
            
            res.json(updatedUser);
        } catch (error) {
            console.error("Errore nel controller durante l'aggiornamento dell'utente:", error);
            res.status(500).json({ error: "Errore interno del server" });
        }
    }

    // Elimina un utente specifico per ID
    async deleteUser(req: Request, res: Response): Promise<void> {
        try {
            const userId = req.params.id;
            
            if (!userId) {
                res.status(400).json({ error: "ID utente non specificato" });
                return;
            }
            
            const success = await this.userService.deleteUser(userId);
            
            if (!success) {
                res.status(404).json({ error: "Utente non trovato o già eliminato" });
                return;
            }
            
            res.status(204).send();
        } catch (error) {
            console.error("Errore nel controller durante l'eliminazione dell'utente:", error);
            res.status(500).json({ error: "Errore interno del server" });
        }
    }
}