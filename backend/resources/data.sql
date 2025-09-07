-- Employeeデータ（認証情報含む）
INSERT INTO Employee (employee_id, name, age, birthplace, work_location, job_description, programming_languages, username, email, password, role) VALUES
(1, 'テスト サンプル', 30, '神保町', '神保町', 'テスト用のサンプルデータです。', 'Java, Python', 'testuser', 'test@example.com', '$2a$10$KZpk6GnRwIGYzNsVsOHUFeSefCg65QAKsTSomO0b7pbdWN0YzE.OG', 'EMPLOYEE'),
(2, '管理者 ユーザー', 35, '東京', '東京', 'システム管理者', 'Java, Spring Boot', 'admin', 'admin@example.com', '$2a$10$SydkmAM7ZXOyvtxX3Yinl..LJaaCQKa5zW98Fp3gN0aVfqTjpCx.C', 'ADMIN'),
(3, '開発者 テスト', 28, '渋谷', '渋谷', 'フロントエンド開発者', 'JavaScript, React', 'developer', 'dev@example.com', '$2a$10$SU/U4oh6eJrOzGCKGGln6.cwFT41WIle3/Q6GRedV4PKb5u7WfF52', 'EMPLOYEE');

-- Bookデータ
INSERT INTO Book (book_id, book_title, book_category, book_summary, book_author, book_publisher, publish_date, is_reserved, reserved_id) VALUES
(1, 'テスト書籍', 'テストカテゴリ', 'これはテスト用の書籍です。', 'サンプル 著者', 'サンプル 出版社', '2023-01-01', false, NULL),
(2, 'Spring Boot実践ガイド', 'プログラミング', 'Spring Bootの実践的な使い方を学ぶ本です。', '技術太郎', 'テック出版', '2024-01-15', false, NULL),
(3, 'React入門', 'プログラミング', 'Reactの基礎から応用まで学べる入門書です。', 'フロント花子', 'Web技術社', '2024-02-20', true, 3);

-- Loanデータ
INSERT INTO Loan (loan_id, employee_id, book_id, loan_date, return_date) VALUES
(1, 1, 1, '2023-01-01', '2023-01-15'),
(2, 2, 2, '2024-01-20', NULL),
(3, 3, 3, '2024-02-25', NULL);

-- Seatデータ
INSERT INTO Seat (seat_id, seat_area, seat_floor, is_occupied, used_by, end_time) VALUES
(1, 'テストエリア', 1, false, NULL, NULL),
(2, '開発エリアA', 2, true, 1, '2024-12-31 18:00:00'),
(3, '開発エリアB', 2, true, 3, '2024-12-31 17:30:00'),
(4, '会議室A', 3, false, NULL, NULL);
