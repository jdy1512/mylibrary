create table publisher(
	publisher_no number primary key,
	publisher_name varchar2(50) not null,
	publisher_address varchar2(100) not null,
	publisher_tel varchar2(20) not null
)

create table book(
	isbn varchar2(13) primary key,
	title varchar2(50) not null,
	author varchar2(50) not null,
	page number(4) not null,
	price number not null,
	publish_date date not null,
	publisher_no number not null,
	constraint publisher_no_fk foreign key(publisher_no) references publisher(publisher_no) on delete cascade
)

create sequence publisher_no_seq

select publisher_no, publisher_name, publisher_address, publisher_tel from publisher

select * from publisher

delete from publisher

select publisher_no_seq.nextval from dual

select isbn, title, author, page, price, publish_date, b.publisher_no, p.publisher_no, p.publisher_name, p.publisher_address, p.publisher_tel from book b, publisher p
	    where b.publisher_no=p.publisher_no and isbn='89-239-3'
	    
select p.publisher_no, p.publisher_name, p.publisher_address, p.publisher_tel, isbn, title, author, page, price, publish_date, b.publisher_no from book b, publisher p
	    where b.publisher_no=p.publisher_no and b.publisher_no=238