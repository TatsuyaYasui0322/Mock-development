from fastapi import FastAPI, Depends, HTTPException
from sqlalchemy.orm import Session
from typing import List

# 自作モジュールのインポート
from database import get_db, create_tables
from models import Employee, Book, Loan, Seat
from schemas import EmployeeResponse, BookResponse, LoanResponse, SeatResponse
from init_data import create_initial_data

# FastAPIアプリケーションの作成
app = FastAPI(
    title="Mock Development API", description="社内管理システムのAPI", version="1.0.0"
)


# アプリケーション起動時の処理
@app.on_event("startup")
def startup_event():
    """アプリケーション起動時にテーブル作成と初期データ投入"""
    create_tables()
    create_initial_data()


# ルートエンドポイント
@app.get("/")
def read_root():
    return {"message": "Mock Development API", "version": "1.0.0", "status": "running"}


# 従業員関連エンドポイント
@app.get("/employees", response_model=List[EmployeeResponse])
def get_employees(db: Session = Depends(get_db)):
    """全従業員を取得"""
    employees = db.query(Employee).all()
    return employees


@app.get("/employees/{employee_id}", response_model=EmployeeResponse)
def get_employee(employee_id: int, db: Session = Depends(get_db)):
    """指定された従業員を取得"""
    employee = db.query(Employee).filter(Employee.employee_id == employee_id).first()
    if employee is None:
        raise HTTPException(status_code=404, detail="従業員が見つかりません")
    return employee


# 書籍関連エンドポイント
@app.get("/books", response_model=List[BookResponse])
def get_books(db: Session = Depends(get_db)):
    """全書籍を取得"""
    books = db.query(Book).all()
    return books


@app.get("/books/{book_id}", response_model=BookResponse)
def get_book(book_id: int, db: Session = Depends(get_db)):
    """指定された書籍を取得"""
    book = db.query(Book).filter(Book.book_id == book_id).first()
    if book is None:
        raise HTTPException(status_code=404, detail="書籍が見つかりません")
    return book


# 貸出関連エンドポイント
@app.get("/loans", response_model=List[LoanResponse])
def get_loans(db: Session = Depends(get_db)):
    """全貸出記録を取得"""
    loans = db.query(Loan).all()
    return loans


@app.get("/loans/employee/{employee_id}", response_model=List[LoanResponse])
def get_loans_by_employee(employee_id: int, db: Session = Depends(get_db)):
    """指定された従業員の貸出記録を取得"""
    loans = db.query(Loan).filter(Loan.employee_id == employee_id).all()
    return loans


# 座席関連エンドポイント
@app.get("/seats", response_model=List[SeatResponse])
def get_seats(db: Session = Depends(get_db)):
    """全座席を取得"""
    seats = db.query(Seat).all()
    return seats


@app.get("/seats/available", response_model=List[SeatResponse])
def get_available_seats(db: Session = Depends(get_db)):
    """利用可能な座席を取得"""
    seats = db.query(Seat).filter(Seat.is_occupied == False).all()
    return seats


# ヘルスチェック
@app.get("/health")
def health_check():
    return {"status": "healthy"}
