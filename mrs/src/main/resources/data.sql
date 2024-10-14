-- ユーザーの挿入
INSERT INTO usr (user_id, first_name, last_name, role_name, password) VALUES
('taro-yamada', '太郎', '山田', 'USER', 'password1'),
('aaaa', 'Aaa', 'Aaa', 'USER', 'password2'),
('bbbb', 'Bbb', 'Bbb', 'USER', 'password3'),
('cccc', 'Ccc', 'Ccc', 'ADMIN', 'adminpassword');

-- 会議室の挿入
INSERT INTO meeting_room (room_name) VALUES
('新木場'),
('辰巳'),
('豊洲'),
('月島'),
('新富町'),
('銀座一丁目'),
('有楽町');
