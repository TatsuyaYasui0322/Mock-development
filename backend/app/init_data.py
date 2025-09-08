from sqlalchemy.orm import Session
from database import SessionLocal, engine
from models import Employee, Book, Loan, Seat, Base
from datetime import date, datetime


def create_initial_data():
    """初期データを投入する関数"""

    # テーブル作成
    Base.metadata.create_all(bind=engine)

    # セッション作成
    db: Session = SessionLocal()

    try:
        # 既存データがあるかチェック
        if db.query(Employee).first():
            print("初期データは既に存在します。")
            return

        # 従業員データの投入
        employees = [
            Employee(
                employee_id=1,
                name="テスト サンプル",
                age=30,
                birthplace="神保町",
                work_location="神保町",
                job_description="テスト用のサンプルデータです。",
                programming_languages="Java, Python",
                username="testuser",
                email="test@example.com",
                password="$2a$10$KZpk6GnRwIGYzNsVsOHUFeSefCg65QAKsTSomO0b7pbdWN0YzE.OG",
                role="EMPLOYEE",
            ),
            Employee(
                employee_id=2,
                name="管理者 ユーザー",
                age=35,
                birthplace="東京",
                work_location="東京",
                job_description="システム管理者",
                programming_languages="Java, Spring Boot",
                username="admin",
                email="admin@example.com",
                password="$2a$10$SydkmAM7ZXOyvtxX3Yinl..LJaaCQKa5zW98Fp3gN0aVfqTjpCx.C",
                role="ADMIN",
            ),
            Employee(
                employee_id=3,
                name="開発者 テスト",
                age=28,
                birthplace="渋谷",
                work_location="渋谷",
                job_description="フロントエンド開発者",
                programming_languages="JavaScript, React",
                username="developer",
                email="dev@example.com",
                password="$2a$10$SU/U4oh6eJrOzGCKGGln6.cwFT41WIle3/Q6GRedV4PKb5u7WfF52",
                role="EMPLOYEE",
            ),
        ]

        # 書籍データの投入
        books = [
            Book(
                book_id=1,
                book_title="テスト書籍",
                book_category="テストカテゴリ",
                book_summary="これはテスト用の書籍です。",
                book_author="サンプル 著者",
                book_publisher="サンプル 出版社",
                publish_date=date(2023, 1, 1),
                is_reserved=False,
                reserved_id=None,
            ),
            Book(
                book_id=2,
                book_title="Spring Boot実践ガイド",
                book_category="プログラミング",
                book_summary="Spring Bootの実践的な使い方を学ぶ本です。",
                book_author="技術太郎",
                book_publisher="テック出版",
                publish_date=date(2024, 1, 15),
                is_reserved=False,
                reserved_id=None,
            ),
            Book(
                book_id=3,
                book_title="React入門",
                book_category="プログラミング",
                book_summary="Reactの基礎から応用まで学べる入門書です。",
                book_author="フロント花子",
                book_publisher="Web技術社",
                publish_date=date(2024, 2, 20),
                is_reserved=True,
                reserved_id=3,
            ),
        ]

        # 貸出データの投入
        loans = [
            Loan(
                loan_id=1,
                employee_id=1,
                book_id=1,
                loan_date=date(2023, 1, 1),
                return_date=date(2023, 1, 15),
            ),
            Loan(
                loan_id=2,
                employee_id=2,
                book_id=2,
                loan_date=date(2024, 1, 20),
                return_date=None,
            ),
            Loan(
                loan_id=3,
                employee_id=3,
                book_id=3,
                loan_date=date(2024, 2, 25),
                return_date=None,
            ),
        ]

        # 座席データの投入
        seats = [
            Seat(
                seat_id=1,
                seat_area="テストエリア",
                seat_floor=1,
                is_occupied=False,
                used_by=None,
                end_time=None,
            ),
            Seat(
                seat_id=2,
                seat_area="開発エリアA",
                seat_floor=2,
                is_occupied=True,
                used_by=1,
                end_time=datetime(2024, 12, 31, 18, 0, 0),
            ),
            Seat(
                seat_id=3,
                seat_area="開発エリアB",
                seat_floor=2,
                is_occupied=True,
                used_by=3,
                end_time=datetime(2024, 12, 31, 17, 30, 0),
            ),
            Seat(
                seat_id=4,
                seat_area="会議室A",
                seat_floor=3,
                is_occupied=False,
                used_by=None,
                end_time=None,
            ),
        ]

        # データベースに追加
        db.add_all(employees)
        db.add_all(books)
        db.add_all(loans)
        db.add_all(seats)

        # コミット
        db.commit()
        print("初期データの投入が完了しました。")

    except Exception as e:
        print(f"エラーが発生しました: {e}")
        db.rollback()
    finally:
        db.close()


if __name__ == "__main__":
    create_initial_data()
