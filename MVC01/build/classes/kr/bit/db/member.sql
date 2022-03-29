-- meber(회원) table을 만들어보자
create table member(
num int primary key auto_increment,
id varchar(20) not null,
pass varchar(20) not null,
name varchar(30) not null,
age int not null,
email varchar(30) not null,
phone varchar(30) not null
);

-- SQL(CRUD), JDBC
-- select(검색)
select * from member;

-- insert(저장)
insert into member(id, pass, name, age, email, phone) values('admin', 'admin', 'YJW', 30, 'admin@admin.com', '02-0000-0000');

-- ubdate(수정)
update member set age = 29, phone = '010-111-1111' where id='admin';

-- delete(삭제)
delete from member;
-- or
delete frml member where id="admin";