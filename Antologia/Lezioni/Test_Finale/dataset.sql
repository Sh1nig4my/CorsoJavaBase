-- Inserimento dati nella tabella Utente
INSERT INTO Utente (nome, email) VALUES
('Mario Rossi', 'mario.rossi@example.com'),
('Luca Bianchi', 'luca.bianchi@example.com'),
('Giulia Verdi', 'giulia.verdi@example.com');

-- Inserimento dati nella tabella Prodotto
INSERT INTO Prodotto (nome, prezzo) VALUES
('Laptop', 1200.00),
('Mouse Wireless', 25.00),
('Tastiera Meccanica', 80.00),
('Monitor 24"', 200.00),
('Cuffie Bluetooth', 50.00);

-- Inserimento dati nella tabella Ordine
INSERT INTO Ordine (data, stato, totale, utente_id) VALUES
('2024-02-01', 'IN_ATTESA', 1225.00, 1),
('2024-02-03', 'SPEDITO', 80.00, 2),
('2024-02-05', 'CONSEGNATO', 250.00, 3),
('2024-02-07', 'CONSEGNATO', 200.00, 1),
('2024-02-09', 'IN_ATTESA', 1050.00, 2);

-- Inserimento dati nella tabella DettaglioOrdine
INSERT INTO DettaglioOrdine (quantita, prezzoTotale, ordine_id, prodotto_id) VALUES
(1, 1200.00, 1, 1),  -- Laptop per Mario Rossi
(1, 25.00, 1, 2),    -- Mouse Wireless per Mario Rossi
(1, 80.00, 2, 3),    -- Tastiera Meccanica per Luca Bianchi
(1, 200.00, 3, 4),   -- Monitor per Giulia Verdi
(1, 50.00, 3, 5),    -- Cuffie Bluetooth per Giulia Verdi
(1, 200.00, 4, 4),   -- Monitor per Mario Rossi
(1, 1000.00, 5, 1),  -- Laptop per Luca Bianchi
(1, 50.00, 5, 5);    -- Cuffie Bluetooth per Luca Bianchi
