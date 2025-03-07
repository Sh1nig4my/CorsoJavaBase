from sqlalchemy import Column, BigInteger, String
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()

class User(Base):
    __tablename__ = 'user' #nome della tabella

    id = Column(BigInteger, primary_key=True, autoincrement=True)
    email = Column(String(255), nullable=False, unique=True)
    username = Column(String(100), nullable=False)
    password = Column(String(100), nullable=False)

    def __repr__(self):
        return f"<User(id={self.id}, email='{self.email}', username='{self.username}')>"