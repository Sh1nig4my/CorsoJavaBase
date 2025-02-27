import { User } from "../entity/User";
import { CreateUserDTO, UpdateUserDTO, UserResponseDTO } from "../dto/UserDTO";
import { IUserRepository, UserRepository } from "../repositories/UserRepository";

// Interfaccia per il servizio
export interface IUserService {
    createUser(userData: CreateUserDTO): Promise<UserResponseDTO>;
    getUsers(): Promise<UserResponseDTO[]>;
    getUserById(id: string): Promise<UserResponseDTO | null>;
    updateUser(id: string, userData: UpdateUserDTO): Promise<UserResponseDTO | null>;
    deleteUser(id: string): Promise<boolean>;
}

// Implementazione concreta del servizio
export class UserService implements IUserService {
    private userRepository: IUserRepository;

    constructor(userRepository?: IUserRepository) {
        // Dependency Injection
        this.userRepository = userRepository || new UserRepository();
    }

    // Converte l'entità User in UserResponseDTO
    private mapToDTO(user: User): UserResponseDTO {
        return {
            id: user.id.toString(),
            name: user.name,
            email: user.email
        };
    }

    async createUser(userData: CreateUserDTO): Promise<UserResponseDTO> {
        try {
            // Delega la creazione dell'utente al repository
            const savedUser = await this.userRepository.create(userData);
            
            // Restituiamo i dati convertiti in DTO
            return this.mapToDTO(savedUser);
        } catch (error) {
            console.error("Errore durante la creazione dell'utente:", error);
            throw new Error("Impossibile creare l'utente");
        }
    }

    async getUsers(): Promise<UserResponseDTO[]> {
        try {
            const users = await this.userRepository.findAll();
            return users.map(user => this.mapToDTO(user));
        } catch (error) {
            console.error("Errore durante il recupero degli utenti:", error);
            throw new Error("Impossibile recuperare gli utenti");
        }
    }

    async getUserById(id: string): Promise<UserResponseDTO | null> {
        try {
            const user = await this.userRepository.findById(id);
            
            if (!user) {
                return null;
            }
            
            return this.mapToDTO(user);
        } catch (error) {
            console.error(`Errore durante il recupero dell'utente con ID ${id}:`, error);
            throw new Error("Impossibile recuperare l'utente specificato");
        }
    }

    async updateUser(id: string, userData: UpdateUserDTO): Promise<UserResponseDTO | null> {
        try {
            const updatedUser = await this.userRepository.updateById(id, userData);
            
            if (!updatedUser) {
                return null;
            }
            
            return this.mapToDTO(updatedUser);
        } catch (error) {
            console.error(`Errore durante l'aggiornamento dell'utente con ID ${id}:`, error);
            throw new Error("Impossibile aggiornare l'utente specificato");
        }
    }

    async deleteUser(id: string): Promise<boolean> {
        try {
            return await this.userRepository.delete(id);
        } catch (error) {
            console.error(`Errore durante l'eliminazione dell'utente con ID ${id}:`, error);
            throw new Error("Impossibile eliminare l'utente specificato");
        }
    }
}