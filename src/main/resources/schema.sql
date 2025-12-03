-- テーブルが存在したら削除する
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS teachers;
DROP TABLE IF EXISTS tests;

--ログイン認証を格納するテーブル
CREATE TABLE teachers (
	--ID
	id INT AUTO_INCREMENT PRIMARY KEY,
	--学校名
    schoolname VARCHAR(25) NOT NULL,
	--メールアドレス
	email VARCHAR(60) NOT NULL,
	--パスワード
	password VARCHAR(255) NOT NULL,
	--学年クラス
	classname VARCHAR(10) NOT NULL,
	--先生の名前
	teachername VARCHAR(10) NOT NULL
);

CREATE TABLE tests (
	--ID
	id INT AUTO_INCREMENT PRIMARY KEY,
	--テスト名
    testname VARCHAR(25) NOT NULL,
	--開始日
	startday DATE,
	--終了日
	lastday DATE
	);

CREATE TABLE students (
	--ID
	id INT AUTO_INCREMENT PRIMARY KEY,
	--teachersテーブルのIDが外部キー
	teacher_id INT NOT NULL,
	--出席番号
	studentnumber VARCHAR(10) NOT NULL,
	--名前
	studentname VARCHAR(20) NOT NULL,
	--パスワード
	studentpassword VARCHAR(255) NOT NULL,
	--外部キーの設定
	FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);