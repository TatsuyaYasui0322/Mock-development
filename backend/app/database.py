from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
import os

# データベース接続URL
# 環境変数から取得、なければデフォルト値を使用
DATABASE_URL = os.getenv(
    "DATABASE_URL", "mysql+pymysql://root:mockpassword@localhost:3307/mock_db"
)

# SQLAlchemyエンジンの作成
engine = create_engine(
    DATABASE_URL,
    echo=True,  # SQLクエリをログに出力（開発時のみ）
    pool_pre_ping=True,  # 接続チェック
    pool_recycle=3600,  # 1時間でコネクションをリサイクル
)

# セッションメーカーの作成
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

# ベースクラスの作成
Base = declarative_base()


# データベースセッション用の依存関数
def get_db():
    """
    データベースセッションを取得する関数
    Fast APIの依存性注入で使用
    """
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()


# データベース初期化関数
def create_tables():
    """
    テーブルを作成する関数
    アプリケーション起動時に実行
    """
    Base.metadata.create_all(bind=engine)
