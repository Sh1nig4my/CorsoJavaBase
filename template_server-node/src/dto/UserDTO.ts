// DTOs per le operazioni relative agli utenti
export class CreateUserDTO {
    name: string;
    email: string;
    password: string;
}

export class UpdateUserDTO {

    name?: string;
    email?: string;
    password?: string;
}

export class UserResponseDTO {
    id: string;
    name: string;
    email: string;
    // Escludiamo la password dalla risposta per motivi di sicurezza
}