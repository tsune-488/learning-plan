--登録ダミーデータの追加
INSERT INTO teachers (schoolname, email, password, classname, teachername )
VALUES
('一中', 'tune@email', 'pass', '1A', '恒');

--テストダミーデータの追加
INSERT INTO tests (testname, startday, lastday) 
VALUES ('期末テスト','2025-12-01', CURRENT_TIMESTAMP);

--生徒ダミーデータの追加
INSERT INTO students (teacher_id, test_id, studentnumber, studentname, studentpassword) 
VALUES (1,1,'11','太郎　花子', 'pass');

--計画ダミーデータの追加
INSERT INTO learning_records (student_id, test_id, learn_day, plan, record)
VALUES (1,1,'2025-12-01','国語：漢字ノート、数学：ワーク３ページ', '英語：単語ワーク、社会：アメリカ');