create table member(
	id varchar2(32) primary key,
	password varchar2(64) not null,
	name varchar2(128) not null,
	email varchar2(128) not null,
	join_date date not null
)


select * from member

delete from member