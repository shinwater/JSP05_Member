--member1 테이블 생성

create table member1(

	id varchar2(20) primary key,	
	name varchar2(20) not null,
	pwd varchar2(20) not null,
	tel varchar2(20),
	addr varchar2(200),
	email varchar2(50),
	age number(3),
	reg_date date

);
