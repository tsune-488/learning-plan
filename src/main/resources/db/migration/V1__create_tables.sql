CREATE TABLE teachers (
	-- ID
	id INT AUTO_INCREMENT PRIMARY KEY,
	-- 学校名
    schoolname VARCHAR(25) NOT NULL,
	-- メールアドレス
	email VARCHAR(60) NOT NULL,
	-- パスワード
	password VARCHAR(255) NOT NULL,
	-- 学年クラス
	classname VARCHAR(10) NOT NULL,
	-- 先生の名前
	teachername VARCHAR(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tests (
	-- ID
	id INT AUTO_INCREMENT PRIMARY KEY,
	-- teacherID
	teacher_id INT NOT NULL,
	-- テスト名
    testname VARCHAR(25) NOT NULL,
	-- 開始日
	startday DATE NOT NULL,
	-- 終了日
	lastday DATE NOT NULL,
	-- 外部キーの設定
	CONSTRAINT fk_tests_teacher
		FOREIGN KEY (teacher_id)
		REFERENCES teachers(id)
		ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE students (
	-- ID
	id INT AUTO_INCREMENT PRIMARY KEY,
	-- teacherID
	teacher_id INT NOT NULL,
	-- testsテーブルのID
	test_id INT NOT NULL,
	-- 出席番号
	studentnumber VARCHAR(10) NOT NULL,
	-- 名前
	studentname VARCHAR(20) NOT NULL,
	-- パスワード
	studentpassword VARCHAR(255) NOT NULL,
	-- 生徒IDとテストIDの重複禁止
	UNIQUE KEY uk_student_login (studentnumber, test_id),
	-- 外部キー
	CONSTRAINT fk_students_teacher
		FOREIGN KEY (teacher_id)
		REFERENCES teachers(id)
		ON DELETE CASCADE,
	CONSTRAINT fk_students_test
		FOREIGN KEY (test_id)
		REFERENCES tests(id)
		ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE learning_records (
	-- ID
	id INT AUTO_INCREMENT PRIMARY KEY,
	-- studentsテーブルのIDが外部キー
	student_id INT NOT NULL,
	-- testsテーブルのIDが外部キー
	test_id INT NOT NULL,
	-- 日付
	learn_day DATE NOT NULL,
	-- 計画の内容
	plan VARCHAR(255),
	-- 実際の学習内容
	record VARCHAR(255),
	-- 重複防止
	UNIQUE KEY uk_learning_day (student_id, test_id, learn_day),
	-- 外部キーの設定
	CONSTRAINT fk_records_student
		FOREIGN KEY (student_id)
		REFERENCES students(id)
		ON DELETE CASCADE,
	CONSTRAINT fk_records_test
		FOREIGN KEY (test_id)
		REFERENCES tests(id)
		ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;