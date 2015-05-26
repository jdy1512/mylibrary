테이블 명세서
고객_ID	id	varchar2(10)	primary key,
패스워드	password		varchar2(10)	not null,
고객이름	name	varchar2(50)	not null,
email		email			varchar2(50)	not null,
전화번호	phone_number	varchar2(15)	not null,
마일리지	mileage		number(7)		not null

drop table customer;
create table customer(
	id varchar2(10) primary key,
	password	   varchar2(10) not null,
	name	varchar2(50) not null,
	email	 varchar2(50) not null,
	phone_number varchar2(15) not null,
	mileage number(7)  not null
)

select * from customer

delete from customer