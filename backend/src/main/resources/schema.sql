-- Employeeテーブル（認証用フィールド追加）
CREATE TABLE IF NOT EXISTS Employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    birthplace VARCHAR(100) NOT NULL,
    work_location VARCHAR(100) NOT NULL,
    job_description VARCHAR(500) NOT NULL,
    programming_languages VARCHAR(100) NOT NULL,
    -- 認証用フィールド（カンマを追加）
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'EMPLOYEE',
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Bookテーブル
CREATE TABLE IF NOT EXISTS Book (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    book_title VARCHAR(255) NOT NULL,
    book_category VARCHAR(100) NOT NULL,
    book_summary TEXT,
    book_author VARCHAR(255) NOT NULL,
    book_publisher VARCHAR(255) NOT NULL,
    publish_date DATE NOT NULL,
    is_reserved BOOLEAN DEFAULT FALSE,
    reserved_id INT,
    FOREIGN KEY (reserved_id) REFERENCES Employee(employee_id)
);

-- Loanテーブル
CREATE TABLE IF NOT EXISTS Loan (
    loan_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT NOT NULL,
    book_id INT NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),
    FOREIGN KEY (book_id) REFERENCES Book(book_id)
);

-- Seatテーブル
CREATE TABLE IF NOT EXISTS Seat (
    seat_id INT PRIMARY KEY AUTO_INCREMENT,
    seat_area VARCHAR(100) NOT NULL,
    seat_floor INT NOT NULL,
    is_occupied BOOLEAN DEFAULT FALSE,
    used_by INT,
    end_time TIMESTAMP,
    FOREIGN KEY (used_by) REFERENCES Employee(employee_id)
);
