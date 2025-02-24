# README - Guida all'Esecuzione dell'Applicativo

Questo documento fornisce istruzioni passo dopo passo per configurare, avviare ed eseguire l'applicazione Spring Boot con JPA e Hibernate.

## **Prerequisiti**

Prima di iniziare, assicurati di avere i seguenti strumenti installati sul tuo sistema:

- **Java 17+** (JDK 17 o superiore)
- **Maven** (per la gestione delle dipendenze)
- **MySQL** (per il database)
- **DBeaver** (opzionale, per la gestione visuale del database)
- **Postman** o un tool equivalente per testare le API

---

## **1. Clonare il Progetto**

Se il progetto è disponibile su un repository GitHub, puoi clonarlo con il seguente comando:

```bash
git clone https://github.com/tuo-utente/tuo-repository.git
cd tuo-repository
```

Se il progetto è in una cartella locale, assicurati di accedere alla directory corretta.

---

## **2. Configurare il Database MySQL**

1. Apri **DBeaver** o MySQL Workbench.
2. Crea una nuova connessione con i seguenti parametri:
    - **Host:** `localhost`
    - **Porta:** `3306`
    - **Database:** `servertemplate`
    - **Username:** `root`
    - **Password:** `password` (o la password configurata per MySQL)
3. Apri una console SQL ed esegui il comando per creare il database:

```sql
CREATE DATABASE servertemplate;
```

4. Verifica che il database sia stato creato correttamente eseguendo:

```sql
SHOW DATABASES;
```

---

## **3. Configurare l'Applicazione**

Apri il file `src/main/resources/application.yaml` e verifica che contenga le seguenti impostazioni:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/servertemplate?allowPublicKeyRetrieval=true&useSSL=false
    username: root
    password: root
  jpa:
    database-platform: org.hibernate.dialect.MySQL8Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
```

Se necessario, modifica i parametri `username` e `password` in base alla tua configurazione MySQL.

---

## **4. Compilare ed Eseguire il Progetto**

Per eseguire il progetto, utilizza Maven per scaricare le dipendenze e avviare l'applicazione.

Apri un terminale nella directory del progetto ed esegui:

```bash
mvn clean install
mvn spring-boot:run
```

Se l'applicazione è avviata correttamente, vedrai un output simile:

```plaintext
Tomcat started on port(s): 8080 (http)
Started Application in X.XX seconds (JVM running for X.XX)
```

L'API sarà accessibile su **http://localhost:8080**.

---

## **5. Testare le API**

Puoi testare le API utilizzando **Postman** o il comando `curl`.

### **Creare un Nuovo Utente**
```bash
curl -X POST http://localhost:8080/api/users \
     -H "Content-Type: application/json" \
     -d '{"nome":"Mario Rossi", "email":"mario.rossi@example.com", "password":"password123"}'
```

### **Ottenere Tutti gli Utenti**
```bash
curl -X GET http://localhost:8080/api/users
```

### **Ottenere un Utente per ID**
```bash
curl -X GET http://localhost:8080/api/users/1
```

### **Ottenere un Utente per Email**
```bash
curl -X GET http://localhost:8080/api/users/email/mario.rossi@example.com
```

### **Aggiornare un Utente**
```bash
curl -X PUT http://localhost:8080/api/users/1 \
     -H "Content-Type: application/json" \
     -d '{"nome":"Mario Rossi", "email":"mario.rossi@example.com", "password":"newpassword123"}'
```

### **Eliminare un Utente**
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

---

## **6. Risoluzione Problemi Comuni**

### **Errore: "Public Key Retrieval is not allowed"**
Se ottieni questo errore durante la connessione a MySQL, aggiungi `allowPublicKeyRetrieval=true` nella stringa JDBC nel file `application.yaml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/servertemplate?allowPublicKeyRetrieval=true&useSSL=false
```

### **Errore: Porta 8080 già in uso**
Se un altro processo sta utilizzando la porta **8080**, puoi modificarla nel file `application.yaml`:

```yaml
server:
  port: 8081
```

Oppure, individua e termina il processo che utilizza la porta con:

```bash
lsof -i :8080
kill -9 <PID>
```

---

## **7. Conclusione**

Ora l'applicazione è configurata e funzionante! Puoi personalizzarla ulteriormente e integrarla in progetti più avanzati.

Se hai domande o problemi, consulta la documentazione ufficiale di **Spring Boot** e **Hibernate**:
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Hibernate Documentation](https://hibernate.org/orm/documentation/)

Buon coding! 🚀

