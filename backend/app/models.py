from sqlalchemy import (
    Column,
    Integer,
    String,
    Text,
    Date,
    Boolean,
    TIMESTAMP,
    ForeignKey,
)
from sqlalchemy.orm import relationship
from sqlalchemy.sql import func
from database import Base


class Employee(Base):
    """従業員テーブル"""

    __tablename__ = "employee"

    employee_id = Column(Integer, primary_key=True, autoincrement=True)
    name = Column(String(100), nullable=False)
    age = Column(Integer, nullable=False)
    birthplace = Column(String(100), nullable=False)
    work_location = Column(String(100), nullable=False)
    job_description = Column(String(500), nullable=False)
    programming_languages = Column(String(100), nullable=False)

    # 認証用フィールド
    username = Column(String(50), unique=True, nullable=False)
    password = Column(String(255), nullable=False)
    role = Column(String(20), default="EMPLOYEE")
    email = Column(String(100), unique=True, nullable=False)
    created_at = Column(TIMESTAMP, server_default=func.now())
    updated_at = Column(TIMESTAMP, server_default=func.now(), onupdate=func.now())

    # リレーション定義
    loans = relationship("Loan", back_populates="employee")
    seats = relationship("Seat", back_populates="user")
    reserved_books = relationship("Book", back_populates="reserver")


class Book(Base):
    """書籍テーブル"""

    __tablename__ = "book"

    book_id = Column(Integer, primary_key=True, autoincrement=True)
    book_title = Column(String(255), nullable=False)
    book_category = Column(String(100), nullable=False)
    book_summary = Column(Text)
    book_author = Column(String(255), nullable=False)
    book_publisher = Column(String(255), nullable=False)
    publish_date = Column(Date, nullable=False)
    is_reserved = Column(Boolean, default=False)
    reserved_id = Column(Integer, ForeignKey("employee.employee_id"))

    # リレーション定義
    reserver = relationship("Employee", back_populates="reserved_books")
    loans = relationship("Loan", back_populates="book")


class Loan(Base):
    """貸出テーブル"""

    __tablename__ = "loan"

    loan_id = Column(Integer, primary_key=True, autoincrement=True)
    employee_id = Column(Integer, ForeignKey("employee.employee_id"), nullable=False)
    book_id = Column(Integer, ForeignKey("book.book_id"), nullable=False)
    loan_date = Column(Date, nullable=False)
    return_date = Column(Date)

    # リレーション定義
    employee = relationship("Employee", back_populates="loans")
    book = relationship("Book", back_populates="loans")


class Seat(Base):
    """座席テーブル"""

    __tablename__ = "seat"

    seat_id = Column(Integer, primary_key=True, autoincrement=True)
    seat_area = Column(String(100), nullable=False)
    seat_floor = Column(Integer, nullable=False)
    is_occupied = Column(Boolean, default=False)
    used_by = Column(Integer, ForeignKey("employee.employee_id"))
    end_time = Column(TIMESTAMP)

    # リレーション定義
    user = relationship("Employee", back_populates="seats")
