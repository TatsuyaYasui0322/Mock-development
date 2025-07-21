CREATE TABLE IF NOT EXISTS Employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    birthplace VARCHAR(100) NOT NULL,
    work_location VARCHAR(100) NOT NULL,
    job_description VARCHAR(500) NOT NULL,
    programming_languages VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Book (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    book_title VARCHAR(255) NOT NULL,
    book_category VARCHAR(100) NOT NULL,
    book_summary VARCHAR(100) NOT NULL,
    book_author VARCHAR(100) NOT NULL,
    book_publisher VARCHAR(100) NOT NULL,
    publish_date DATE NOT NULL,
    is_reserved BOOLEAN NOT NULL DEFAULT FALSE,
    reserved_id INT DEFAULT NULL,
    FOREIGN KEY (reserved_id) REFERENCES Employee(employee_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS Loan (
    loan_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT NOT NULL,
    book_id INT NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES Book(book_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Seat (
    seat_id INT PRIMARY KEY AUTO_INCREMENT,
    seat_area VARCHAR(100) NOT NULL,
    seat_floor INT NOT NULL,
    is_occupied BOOLEAN NOT NULL DEFAULT FALSE,
    used_by INT DEFAULT NULL,
    end_time TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (used_by) REFERENCES Employee(employee_id) ON DELETE SET NULL
);
