from pydantic import BaseModel, EmailStr
from typing import Optional, List
from datetime import date, datetime


# Employee関連スキーマ
class EmployeeBase(BaseModel):
    """従業員の基本情報"""

    name: str
    age: int
    birthplace: str
    work_location: str
    job_description: str
    programming_languages: str
    username: str
    email: str
    role: str = "EMPLOYEE"


class EmployeeCreate(EmployeeBase):
    """従業員作成用スキーマ"""

    password: str


class EmployeeResponse(EmployeeBase):
    """従業員レスポンス用スキーマ"""

    employee_id: int
    created_at: datetime
    updated_at: datetime

    class Config:
        from_attributes = True  # SQLAlchemyモデルからの変換を許可


# Book関連スキーマ
class BookBase(BaseModel):
    """書籍の基本情報"""

    book_title: str
    book_category: str
    book_summary: Optional[str] = None
    book_author: str
    book_publisher: str
    publish_date: date


class BookCreate(BookBase):
    """書籍作成用スキーマ"""

    pass


class BookResponse(BookBase):
    """書籍レスポンス用スキーマ"""

    book_id: int
    is_reserved: bool
    reserved_id: Optional[int] = None

    class Config:
        from_attributes = True


# Loan関連スキーマ
class LoanBase(BaseModel):
    """貸出の基本情報"""

    employee_id: int
    book_id: int
    loan_date: date


class LoanCreate(LoanBase):
    """貸出作成用スキーマ"""

    pass


class LoanResponse(LoanBase):
    """貸出レスポンス用スキーマ"""

    loan_id: int
    return_date: Optional[date] = None

    class Config:
        from_attributes = True


# Seat関連スキーマ
class SeatBase(BaseModel):
    """座席の基本情報"""

    seat_area: str
    seat_floor: int


class SeatCreate(SeatBase):
    """座席作成用スキーマ"""

    pass


class SeatResponse(SeatBase):
    """座席レスポンス用スキーマ"""

    seat_id: int
    is_occupied: bool
    used_by: Optional[int] = None
    end_time: Optional[datetime] = None

    class Config:
        from_attributes = True
