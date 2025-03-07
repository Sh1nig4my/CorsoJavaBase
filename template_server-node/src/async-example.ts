// Correzione riga 117: Importa ObjectId all'inizio del file
import "reflect-metadata";
import { AppDataSource } from "./data-source";
import { User } from "./entity/User";
import { UserRepository } from "./repositories/UserRepository";
import { UserService } from "./services/UserService";
import { ObjectId } from "mongodb"; // Importazione corretta di ObjectId

/**
 * Esempio pratico di asincronia nel progetto
 * Dimostra come la creazione di un utente avviene in modo asincrono
 * mentre altre operazioni possono continuare in parallelo
 */
async function asyncDemo() {
  console.log("--- INIZIO DIMOSTRAZIONE ASINCRONIA ---");
  console.log("Timestamp:", new Date().toISOString());
  
  // Inizializzazione della connessione al database
  try {
    console.log("Inizializzazione connessione al database...");
    await AppDataSource.initialize();
    console.log("✅ Connessione al database inizializzata con successo!");
    
    // Creiamo le istanze necessarie
    const userRepository = new UserRepository();
    const userService = new UserService(userRepository);
    
    // Creiamo un contatore per simulare altre operazioni
    let counter = 0;
    
    // Funzione per incrementare il contatore mentre aspettiamo
    const intervalId = setInterval(() => {
      counter++;
      console.log(`⏱️ Altre operazioni in corso... (${counter})`);
      
      // Simuliamo altre operazioni sul database che possono avvenire in parallelo
      if (counter % 3 === 0) {
        console.log("🔍 Esecuzione query di lettura in parallelo...");
      }
    }, 1000);
    
    console.log("\n🚀 AVVIO CREAZIONE UTENTE (operazione asincrona)");
    console.log("Timestamp inizio:", new Date().toISOString());
    
    // Misuriamo il tempo di esecuzione
    const startTime = Date.now();
    
    // Creiamo un utente (questa operazione avverrà in modo asincrono)
    const userData = {
      name: "Mario Rossi",
      email: "mario.rossi@example.com",
      password: "Password123!"
    };
    
    // La chiamata è asincrona, quindi il codice dopo questa riga
    // verrà eseguito immediatamente, senza aspettare la risposta
    const userPromise = userService.createUser(userData)
      .then(newUser => {
        const endTime = Date.now();
        const duration = (endTime - startTime) / 1000;
        
        console.log("\n✅ UTENTE CREATO CON SUCCESSO dopo", duration, "secondi");
        console.log("Timestamp completamento:", new Date().toISOString());
        console.log("Dati utente creato:", newUser);
        
        // Fermiamo il contatore
        clearInterval(intervalId);
        
        // Chiudiamo la connessione al database
        return AppDataSource.destroy();
      })
      .then(() => {
        console.log("\n✅ Connessione al database chiusa");
        console.log("--- FINE DIMOSTRAZIONE ASINCRONIA ---");
      })
      .catch(error => {
        console.error("\n❌ ERRORE:", error);
        clearInterval(intervalId);
        return AppDataSource.destroy();
      });
    
    // Questo codice viene eseguito immediatamente, senza aspettare la creazione dell'utente
    console.log("\n➡️ La promessa di creazione utente è stata avviata");
    console.log("➡️ Il codice continua l'esecuzione senza bloccarsi");
    console.log("➡️ Altre operazioni possono essere eseguite mentre aspettiamo...");
    
    // Simuliamo altre operazioni immediate
    for (let i = 1; i <= 3; i++) {
      console.log(`📊 Esecuzione operazione immediata ${i}...`);
    }
    
    // Possiamo anche aspettare esplicitamente la promessa se necessario
    console.log("\n⏳ In attesa del completamento di tutte le operazioni asincrone...");
    await userPromise;
    
  } catch (error) {
    console.error("❌ Errore durante la dimostrazione:", error);
    // Assicuriamoci di chiudere la connessione in caso di errore
    try {
      await AppDataSource.destroy();
    } catch {
      // Ignoriamo errori durante la chiusura
    }
  }
}

// Sostituiamo l'implementazione del repository per simulare
// un ritardo nella creazione dell'utente (a scopo dimostrativo)
UserRepository.prototype.create = function(userData: Partial<User>): Promise<User> {
  console.log("📝 Repository: Iniziata creazione utente nel database...");
  
  // Simuliamo un'operazione di database che richiede tempo (5 secondi)
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log("💾 Repository: Database ha completato l'operazione");
      
      // Creiamo un finto oggetto User con un ID simulato
      const user = new User();
      user.id = new ObjectId(); // Correzione: Usa l'ObjectId importato
      user.name = userData.name;
      user.email = userData.email;
      user.password = userData.password;
      
      resolve(user);
    }, 5000); // Ritardo simulato di 5 secondi
  });
};

// Eseguiamo la dimostrazione
asyncDemo();