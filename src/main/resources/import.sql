-- User Create
INSERT INTO	`user` (account, password, status, email, phone_number, registered_at, created_at, created_by) VALUES ('Test01', 'Test01', 'REGISTERED', 'Test01@test.com', '010-0000-0001', NOW(), NOW(), 'AdminServer');
INSERT INTO	`user` (account, password, status, email, phone_number, registered_at, created_at, created_by) VALUES ('Test02', 'Test02', 'REGISTERED', 'Test02@test.com', '010-0000-0002', NOW(), NOW(), 'AdminServer');
INSERT INTO	`user` (account, password, status, email, phone_number, registered_at, created_at, created_by) VALUES ('Test03', 'Test03', 'REGISTERED', 'Test03@test.com', '010-0000-0003', NOW(), NOW(), 'AdminServer');
INSERT INTO	`user` (account, password, status, email, phone_number, registered_at, created_at, created_by) VALUES ('Test04', 'Test04', 'REGISTERED', 'Test04@test.com', '010-0000-0004', NOW(), NOW(), 'AdminServer');
INSERT INTO	`user` (account, password, status, email, phone_number, registered_at, created_at, created_by) VALUES ('Test05', 'Test05', 'REGISTERED', 'Test05@test.com', '010-0000-0005', NOW(), NOW(), 'AdminServer');
INSERT INTO	`user` (account, password, status, email, phone_number, registered_at, created_at, created_by) VALUES ('Test06', 'Test06', 'REGISTERED', 'Test06@test.com', '010-0000-0006', NOW(), NOW(), 'AdminServer');
INSERT INTO	`user` (account, password, status, email, phone_number, registered_at, created_at, created_by) VALUES ('Test07', 'Test07', 'REGISTERED', 'Test07@test.com', '010-0000-0007', NOW(), NOW(), 'AdminServer');
INSERT INTO	`user` (account, password, status, email, phone_number, registered_at, created_at, created_by) VALUES ('Test08', 'Test08', 'REGISTERED', 'Test08@test.com', '010-0000-0008', NOW(), NOW(), 'AdminServer');
INSERT INTO	`user` (account, password, status, email, phone_number, registered_at, created_at, created_by) VALUES ('Test09', 'Test09', 'REGISTERED', 'Test09@test.com', '010-0000-0009', NOW(), NOW(), 'AdminServer');

-- Category Create
INSERT INTO category (title, `type`, created_at, created_by) VALUES ('컴퓨터', 'COMPUTER', NOW(), 'AdminServer');
INSERT INTO category (title, `type`, created_at, created_by) VALUES ('음식', 'FOOD', NOW(), 'AdminServer');

-- Partner Create
INSERT INTO partner (`name`, status, partner_number, ceo_name, address, business_number, call_center, registered_at, created_by, category_id, created_at) VALUES ('컴퓨터 공장1', 'REGISTERED', '010-0000-0001', '김컴퓨터', '서울시 어딘가 살아요동 1-1', '123-12-12340', '070-0000-0001', NOW(), 'AdminServer', 1, NOW());
INSERT INTO partner (`name`, status, partner_number, ceo_name, address, business_number, call_center, registered_at, created_by, category_id, created_at) VALUES ('노트북 공장2', 'REGISTERED', '010-0000-0002', '박노트북', '서울시 어딘가 살아요동 1-2', '123-12-12341', '070-0000-0002', NOW(), 'AdminServer', 1, NOW());
INSERT INTO partner (`name`, status, partner_number, ceo_name, address, business_number, call_center, registered_at, created_by, category_id, created_at) VALUES ('떡볶이 공장1', 'REGISTERED', '010-0000-0011', '김떡볶이', '서울시 어딘가 살아요동 2-1', '123-12-12342', '070-0000-0011', NOW(), 'AdminServer', 2, NOW());
INSERT INTO partner (`name`, status, partner_number, ceo_name, address, business_number, call_center, registered_at, created_by, category_id, created_at) VALUES ('라볶이 공장2', 'REGISTERED', '010-0000-0012', '박라볶이', '서울시 어딘가 살아요동 2-2', '123-12-12343', '070-0000-0012', NOW(), 'AdminServer', 2, NOW());

-- Item Create
INSERT INTO item (brand_name, content, created_at, created_by, `name`, price, registered_at, status, title, partner_id) VALUES ('컴퓨터 공장1', '엄청난 컴퓨터1', NOW(), 'AdminServer', '컴퓨터1', 1000000, NOW(), 'REGISTERED', '진짜 짱 좋은 컴퓨터1', 1);
INSERT INTO item (brand_name, content, created_at, created_by, `name`, price, registered_at, status, title, partner_id) VALUES ('컴퓨터 공장1', '엄청난 컴퓨터2', NOW(), 'AdminServer', '컴퓨터2', 1000000, NOW(), 'REGISTERED', '진짜 짱 좋은 컴퓨터2', 1);
INSERT INTO item (brand_name, content, created_at, created_by, `name`, price, registered_at, status, title, partner_id) VALUES ('노트북 공장1', '대단한 노트북1', NOW(), 'AdminServer', '노트북1', 500000, NOW(), 'REGISTERED', '진짜 짱 좋은 노트북1', 2);
INSERT INTO item (brand_name, content, created_at, created_by, `name`, price, registered_at, status, title, partner_id) VALUES ('노트북 공장2', '대단한 노트북2', NOW(), 'AdminServer', '노트북2', 500000, NOW(), 'REGISTERED', '진짜 짱 좋은 노트북2', 2);
INSERT INTO item (brand_name, content, created_at, created_by, `name`, price, registered_at, status, title, partner_id) VALUES ('떡볶이 공장1', '맛있는 떡볶이1', NOW(), 'AdminServer', '떡볶이1', 5000, NOW(), 'REGISTERED', '진짜 짱 맛난 떡볶이1', 3);
INSERT INTO item (brand_name, content, created_at, created_by, `name`, price, registered_at, status, title, partner_id) VALUES ('떡볶이 공장1', '맛있는 떡볶이2', NOW(), 'AdminServer', '떡볶이2', 5000, NOW(), 'REGISTERED', '진짜 짱 맛난 떡볶이2', 3);
INSERT INTO item (brand_name, content, created_at, created_by, `name`, price, registered_at, status, title, partner_id) VALUES ('라볶이 공장2', '맛있는 라볶이1', NOW(), 'AdminServer', '라볶이1', 4500, NOW(), 'REGISTERED', '진짜 짱 맛난 라볶이1', 4);
INSERT INTO item (brand_name, content, created_at, created_by, `name`, price, registered_at, status, title, partner_id) VALUES ('라볶이 공장2', '맛있는 라볶이2', NOW(), 'AdminServer', '라볶이2', 4500, NOW(), 'REGISTERED', '진짜 짱 맛난 라볶이2', 4);

-- Admin User Create
INSERT INTO admin_user (account, created_at, created_by, last_login_at, login_fail_count, password, password_updated_at, registered_at, `role`, status) VALUES ('ADMIN01', NOW(), 'AdminServer', NOW(), 0, 'ADMIN01', NOW(), NOW(), 'SUPER_MANAGER', 'REGISTERED');
INSERT INTO admin_user (account, created_at, created_by, last_login_at, login_fail_count, password, password_updated_at, registered_at, `role`, status) VALUES ('ADMIN02', NOW(), 'AdminServer', NOW(), 0, 'ADMIN02', NOW(), NOW(), 'MANAGER', 'REGISTERED');