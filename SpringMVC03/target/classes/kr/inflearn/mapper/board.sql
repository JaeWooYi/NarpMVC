create table tb_board(
idx int not null auto_increment, -- 게시판 일련 번호(자동증가)
title varchar(100) not null,	-- 제목 
contents varchar(4000) not null,	-- 내용
count int,	-- 조회수 
writer varchar(30) not null,	-- 등록자 
indate datetime default now() not null, -- 작성일(등록일)
primary key(idx)
);

insert into tb_board(title, contents, count, writer)
values('create board', 'good board', 0, 'admin');

select * from tb_board;