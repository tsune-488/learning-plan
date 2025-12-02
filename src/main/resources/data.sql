--登録ダミーデータの追加
INSERT INTO teachers (schoolname, email, password, classname, teachername )
VALUES
('一中', 'tune@email', 'pass', '1A', '恒');

--テストダミーデータの追加
INSERT INTO tests (testname, startday, lastday) VALUES ('期末テスト',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

--テストダミーデータの追加
INSERT INTO students (studentnumber, studentname, studentpassword) VALUES ('11',"太郎　花子", "pass");
