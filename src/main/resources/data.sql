--登録ダミーデータの追加
INSERT INTO teachers (schoolname, email, password, class, teachername )
VALUES
('一中', 'tune@email', 'pass', '1A', '恒');

--テストダミーデータの追加
-- password : adminpass
INSERT INTO test (testname, startday, lastday) VALUES ('期末テスト',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)