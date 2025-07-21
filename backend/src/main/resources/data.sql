INSERT INTO Employee (employee_id, name, age, birthplace, work_location, job_description, programming_languages) VALUES
(1, 'テスト サンプル', 30, '神保町', '神保町', 'テスト用のサンプルデータです。', 'Java, Python');

INSERT INTO Book (book_id, book_title, book_category, book_summary, book_author, book_publisher, publish_date, is_reserved, reserved_id) VALUES
(1, 'テスト書籍', 'テストカテゴリ', 'これはテスト用の書籍です。', 'サンプル 著者', 'サンプル 出版社', '2023-01-01', false, NULL);

INSERT INTO Loan (loan_id, employee_id, book_id, loan_date, return_date) VALUES
(1, 1, 1, '2023-01-01', '2023-01-15');

INSERT INTO Seat (seat_id, seat_area, seat_floor, is_occupied, used_by, end_time) VALUES
(1, 'テストエリア', 1, false, NULL, NULL);
