from pydantic import BaseModel, EmailStr

# Schema per la creazione di un utente (input)
class UserCreate(BaseModel):
    email: EmailStr
    username: str
    password: str

class LoginRequest(BaseModel):
    email: EmailStr
    password: str

# Schema per la visualizzazione di un utente (output)
class UserResponse(BaseModel):
    id: int
    email: EmailStr
    username: str

    class Config:
        orm_mode = True

