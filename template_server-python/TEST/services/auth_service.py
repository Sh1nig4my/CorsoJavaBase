from sqlalchemy.orm import Session
from repositories.user_repository import get_user_by_email, create_user
from schemas.user import UserCreate
from utils.security import verify_password

def register_user(db: Session, user_data: UserCreate):
    if get_user_by_email(db, user_data.email):
        raise Exception("Utente già registrato")
    return create_user(db, user_data)

def authenticate_user(db: Session, email: str, password: str):
    user = get_user_by_email(db, email)
    if not user:
        return None
    if not verify_password(password, user.password):
        return None
    return user
