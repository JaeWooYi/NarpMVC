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

select * from member;
insert into member(id, pass, name, age, email, phone) values('admin', 'admin', '관리자', 30, 'admin@admin.com', '02-0000-0000');