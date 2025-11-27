-- テーブルが存在したら削除する
DROP TABLE IF EXISTS teachers;
DROP TABLE IF EXISTS test;

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
	class VARCHAR(10) NOT NULL,
	--先生の名前
	teachername VARCHAR(10) NOT NULL,
);

CREATE TABLE test (
	--ID
	id INT AUTO_INCREMENT PRIMARY KEY,
	--学校名
    schoolname VARCHAR(25) NOT NULL,
	--メールアドレス
	email VARCHAR(60) NOT NULL,
	--パスワード
	password VARCHAR(255) NOT NULL,
	--学年クラス
	class VARCHAR(10) NOT NULL,
	--先生の名前
	teachername VARCHAR(10) NOT NULL,
);
