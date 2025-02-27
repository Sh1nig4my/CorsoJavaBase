import { Router } from "express";
import { UserController } from "../controllers/userController";

const userRoutes = Router();
const userController = new UserController();

// Rotte per le operazioni utente
userRoutes.post("/users", (req, res) => userController.createUser(req, res));
userRoutes.get("/users", (req, res) => userController.getAllUsers(req, res));
userRoutes.get("/users/:id", (req, res) => userController.getUserById(req, res));
userRoutes.put("/users/:id", (req, res) => userController.updateUser(req, res));
userRoutes.delete("/users/:id", (req, res) => userController.deleteUser(req, res));


export default userRoutes;