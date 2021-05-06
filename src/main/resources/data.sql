insert into orders (id, acnt_num, prod_id, svc_mgmt_num, svc_scrb_dt) values (1, 1234567890,'NA00000001', 1234567890,  '20210428');
insert into orders (id, acnt_num, prod_id, svc_mgmt_num, svc_scrb_dt) values (2, 6000000001,'NA00000002', 7000000002,  '20210430');
insert into orders (id, acnt_num, prod_id, svc_mgmt_num, svc_scrb_dt) values (3, 6000000001,'NA00000003', 7000000003,  '20210430');

insert into products (id, prod_id, prod_nm) values (11, 'NA00000001', '기본요금제');
insert into products (id, prod_id, prod_nm) values (12, 'NA00000002', '부가요금제');
insert into products (id, prod_id, prod_nm) values (13, 'NA00000003', '데이터요금제');

insert into customers (id, svc_mgmt_num, cust_num, cust_nm, gender_cd) values (11, 7234567890, '8000000001', '개똥이','1');
insert into customers (id, svc_mgmt_num, cust_num, cust_nm, gender_cd) values (12, 7234567891, '8000000002', '소똥이','1');
insert into customers (id, svc_mgmt_num, cust_num, cust_nm, gender_cd) values (13, 7234567892, '8000000003', '말숙이','2');

--select * from orders;

insert into ords_prods (prod_id, acnt_num1, svc_mgmt_num1, svc_scrb_dt1) values ('NA00000001', 1234567890, 1234567890,  '20210428');

insert into prods (prod_id, prod_nm) values ('NA00000001', '기본요금제');