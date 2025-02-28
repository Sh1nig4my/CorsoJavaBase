CREATE DATABASE biblioteca;
USE biblioteca;

-- Tabella User (utenti della biblioteca)
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Tabella Book (libri disponibili)
CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titolo VARCHAR(255) NOT NULL,
    autore VARCHAR(255) NOT NULL,
    anno_pubblicazione INT NOT NULL
);

-- Tabella Loan (prestiti di libri, relazione ManyToMany tra User e Book)
CREATE TABLE loans (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    data_prestito DATE NOT NULL,
    data_restituzione DATE DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);

-- Dati di esempio per utenti
INSERT INTO users (nome, email, password) VALUES
('Mario Rossi', 'mario.rossi@example.com', 'password123'),
('Laura Bianchi', 'laura.bianchi@example.com', 'password123'),
('Giovanni Verdi', 'giovanni.verdi@example.com', 'password123');

-- Dati di esempio per libri
INSERT INTO books (titolo, autore, anno_pubblicazione) VALUES
('Il Signore degli Anelli', 'J.R.R. Tolkien', 1954),
('1984', 'George Orwell', 1949),
('Il Nome della Rosa', 'Umberto Eco', 1980),
('Harry Potter e la Pietra Filosofale', 'J.K. Rowling', 1997),
('Cronache del Ghiaccio e del Fuoco', 'George R.R. Martin', 1996);

-- Dati di esempio per prestiti di libri
INSERT INTO loans (user_id, book_id, data_prestito) VALUES
(1, 1, '2024-01-10'),
(1, 3, '2024-02-01'),
(2, 2, '2024-02-15'),
(2, 4, '2024-02-20'),
(3, 5, '2024-03-01');
