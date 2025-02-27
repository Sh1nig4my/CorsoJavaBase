import { DataSource, Repository } from "typeorm";
import { User } from "../entity/User";
import { ObjectId } from "mongodb";

// Assicurati che il percorso di importazione sia corretto
import { AppDataSource } from "../data-source";

// Interfaccia per il repository
export interface IUserRepository {
    findAll(): Promise<User[]>;
    findById(id: string): Promise<User | null>;
    create(user: Partial<User>): Promise<User>;
    updateById(id: string, userData: Partial<User>): Promise<User | null>;
    delete(id: string): Promise<boolean>;
}

// Implementazione concreta del repository
export class UserRepository implements IUserRepository {
    private repository: Repository<User>;

    constructor() {
        this.repository = AppDataSource.getRepository(User);
    }

    async findAll(): Promise<User[]> {
        return this.repository.find();
    }

    async findById(id: string): Promise<User | null> {
        try {
            if (!ObjectId.isValid(id)) {
                console.error(`ID non valido: ${id}`);
                return null;
            }
            
            console.log(`Cercando utente con ID: ${id}`);
            
            // Ottieni tutti gli utenti e trova quello con ID corrispondente
            const allUsers = await this.repository.find();
            console.log("Tutti gli utenti:", allUsers);
            
            // Cerca manualmente l'utente con l'ID corrispondente
            const user = allUsers.find(user => user.id.toString() === id);
            
            console.log(`Risultato ricerca manuale:`, user);
            return user || null;
        } catch (error) {
            console.error(`Errore nella ricerca dell'utente con ID ${id}:`, error);
            return null;
        }
    }

    async create(userData: Partial<User>): Promise<User> {
        const user = this.repository.create(userData);
        return this.repository.save(user);
    }

    async updateById(id: string, userData: Partial<User>): Promise<User | null> {
        try {
         
            // Prima verifichiamo se l'utente esiste
            const existingUser = await this.findById(id)
            console.log(existingUser)
            if (!existingUser) {
                return null;
            }
            
            // Aggiorniamo i campi dell'utente esistente
            Object.assign(existingUser, userData);
            const newUser = this.repository.create(existingUser)
            // Salviamo le modifiche
            return this.repository.save(existingUser);
        } catch (error) {
            console.error(`Errore durante l'aggiornamento dell'utente con ID ${id}:`, error);
            return null;
        }
    }

    async delete(id: string): Promise<boolean> {
        try {
            const objectId = new ObjectId(id);
            const result = await this.repository.delete({ 
                id: objectId as any 
            });
            return result.affected > 0;
        } catch (error) {
            console.error(`Errore durante l'eliminazione dell'utente con ID ${id}:`, error);
            return false;
        }
    }
}