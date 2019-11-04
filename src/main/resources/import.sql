-- User
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test1', 'Test1@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test2', 'Test2@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test3', 'Test3@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test4', 'Test4@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test5', 'Test5@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test6', 'Test6@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test7', 'Test7@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test8', 'Test8@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test9', 'Test9@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test10', 'Test10@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test11', 'Test11@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test12', 'Test12@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test13', 'Test13@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test14', 'Test14@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test15', 'Test15@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test16', 'Test16@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test17', 'Test17@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test18', 'Test18@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test19', 'Test19@test.com', '010-1234-1234', NOW(), 'ADMIN');
INSERT INTO `user` (account, email, phone_number, created_at, created_by) VALUES ('Test20', 'Test20@test.com', '010-1234-1234', NOW(), 'ADMIN');

-- item
INSERT INTO `item` (name, price, content) VALUES ('노트북1', 100000, '노트북1 내용');
INSERT INTO `item` (name, price, content) VALUES ('노트북2', 200000, '노트북2 내용');
INSERT INTO `item` (name, price, content) VALUES ('노트북3', 300000, '노트북3 내용');
INSERT INTO `item` (name, price, content) VALUES ('노트북4', 400000, '노트북4 내용');
INSERT INTO `item` (name, price, content) VALUES ('노트북5', 500000, '노트북5 내용');
INSERT INTO `item` (name, price, content) VALUES ('노트북6', 600000, '노트북6 내용');
INSERT INTO `item` (name, price, content) VALUES ('노트북7', 700000, '노트북7 내용');
INSERT INTO `item` (name, price, content) VALUES ('노트북8', 800000, '노트북8 내용');
INSERT INTO `item` (name, price, content) VALUES ('노트북9', 900000, '노트북9 내용');
INSERT INTO `item` (name, price, content) VALUES ('노트북10', 1000000, '노트북10 내용');

-- order_detail
INSERT INTO `order_detail` (order_at, user_id, item_id) VALUES (NOW(), 1, 1);
INSERT INTO `order_detail` (order_at, user_id, item_id) VALUES (NOW(), 2, 2);
INSERT INTO `order_detail` (order_at, user_id, item_id) VALUES (NOW(), 3, 3);
INSERT INTO `order_detail` (order_at, user_id, item_id) VALUES (NOW(), 4, 4);
INSERT INTO `order_detail` (order_at, user_id, item_id) VALUES (NOW(), 5, 5);
INSERT INTO `order_detail` (order_at, user_id, item_id) VALUES (NOW(), 1, 2);
INSERT INTO `order_detail` (order_at, user_id, item_id) VALUES (NOW(), 1, 3);
INSERT INTO `order_detail` (order_at, user_id, item_id) VALUES (NOW(), 1, 4);
INSERT INTO `order_detail` (order_at, user_id, item_id) VALUES (NOW(), 1, 5);
