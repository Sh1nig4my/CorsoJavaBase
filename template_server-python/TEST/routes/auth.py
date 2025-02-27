from fastapi import APIRouter, Depends, HTTPException, status
from sqlalchemy.orm import Session
from schemas.user import UserCreate, UserResponse, LoginRequest
from services.auth_service import register_user, authenticate_user
from database import get_db
from repositories.user_repository import get_all_users

router = APIRouter()

@router.post("/register", response_model=UserResponse)
def register(user: UserCreate, db: Session = Depends(get_db)):
    try:
        new_user = register_user(db, user)
        return new_user
    except Exception as e:
        raise HTTPException(status_code=400, detail=str(e))

@router.post("/login", response_model=UserResponse)
def login(login_data: LoginRequest, db: Session = Depends(get_db)):
    user = authenticate_user(db, login_data.email, login_data.password)
    if not user:
        raise HTTPException(status_code=status.HTTP_401_UNAUTHORIZED, detail="Credenziali non valide")
    return user

@router.post("/logout")
def logout():
    return {"message": "Logout effettuato"}

@router.get("/users")
def read_users(db: Session = Depends(get_db)):
    return get_all_users(db)
