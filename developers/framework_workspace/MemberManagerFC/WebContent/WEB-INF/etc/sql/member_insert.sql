


--1page 5
--ceil(rownum/한페이지에보여질데이터수) -> 페이지 번호

select page, id, password, name, email, join_date
from (
	select ceil(rownum/5) page, id, password, name, email, join_date
	from member
	)
where page = 2

select id, password, name, email, join_date
from (
	select ceil(rownum/5) page, id, password, name, email, join_date
	from (
		select  id, password, name, email, join_date 
		from member
		order by join_date
	)
)
where page = 2

select -> order by(가장마지막에 )
	





























insert into member values ('id-11', '1111', '회원11', 'm11@abc.com', '20150207');
insert into member values ('id-12', '1111', '회원12', 'm12@abc.com', '20150317');
insert into member values ('id-13', '1111', '회원13', 'm13@abc.com', '20150402');
insert into member values ('id-14', '1111', '회원14', 'm14@abc.com', '20150107');
insert into member values ('id-15', '1111', '회원15', 'm15@abc.com', '20150207');
insert into member values ('id-16', '1111', '회원16', 'm16@abc.com', '20150122');
insert into member values ('id-17', '1111', '회원17', 'm17@abc.com', '20150207');
insert into member values ('id-18', '1111', '회원18', 'm18@abc.com', '20150228');
insert into member values ('id-19', '1111', '회원19', 'm19@abc.com', '20150207');
insert into member values ('id-20', '1111', '회원20', 'm20@abc.com', '20150207');
insert into member values ('id-21', '1111', '회원21', 'm201@abc.com', '20150107');
insert into member values ('id-22', '1111', '회원22', 'm22@abc.com', '20150207');
insert into member values ('id-23', '1111', '회원23', 'm23@abc.com', '20150307');
insert into member values ('id-24', '1111', '회원24', 'm24@abc.com', '20150208');
insert into member values ('id-25', '1111', '회원25', 'm25@abc.com', '20150207');
insert into member values ('id-26', '1111', '회원26', 'm26@abc.com', '20150207');
insert into member values ('id-27', '1111', '회원27', 'm27@abc.com', '20150217');
insert into member values ('id-28', '1111', '회원28', 'm28@abc.com', '20150207');
insert into member values ('id-29', '1111', '회원29', 'm29@abc.com', '20150207');
insert into member values ('id-30', '1111', '회원30', 'm30@abc.com', '20150227');
insert into member values ('id-31', '1111', '회원31', 'm31@abc.com', '20150116');
insert into member values ('id-32', '1111', '회원32', 'm32@abc.com', '20140803');
insert into member values ('id-33', '1111', '회원33', 'm33@abc.com', '20121013');
insert into member values ('id-34', '1111', '회원34', 'm34@abc.com', '20140505');
insert into member values ('id-35', '1111', '회원35', 'm35@abc.com', '20140815');

insert into member values ('id-41', '1111', '회원41', 'm41@abc.com', '20150507');
insert into member values ('id-42', '1111', '회원42', 'm42@abc.com', '20150617');
insert into member values ('id-43', '1111', '회원43', 'm43@abc.com', '20120105');
insert into member values ('id-44', '1111', '회원44', 'm44@abc.com', '20120107');
insert into member values ('id-45', '1111', '회원45', 'm45@abc.com', '20150507');
insert into member values ('id-46', '1111', '회원46', 'm46@abc.com', '20120125');
insert into member values ('id-47', '1111', '회원47', 'm47@abc.com', '20150507');
insert into member values ('id-48', '1111', '회원48', 'm48@abc.com', '20150518');
insert into member values ('id-49', '1111', '회원49', 'm49@abc.com', '20150507');
insert into member values ('id-50', '1111', '회원50', 'm50@abc.com', '20150507');
insert into member values ('id-51', '1111', '회원51', 'm51@abc.com', '20120107');
insert into member values ('id-52', '1111', '회원52', 'm52@abc.com', '20150507');
insert into member values ('id-53', '1111', '회원53', 'm53@abc.com', '20150607');
insert into member values ('id-54', '1111', '회원54', 'm54@abc.com', '20150508');
insert into member values ('id-55', '1111', '회원55', 'm55@abc.com', '20150507');
insert into member values ('id-56', '1111', '회원56', 'm56@abc.com', '20150507');
insert into member values ('id-57', '1111', '회원57', 'm57@abc.com', '20150517');
insert into member values ('id-58', '1111', '회원58', 'm58@abc.com', '20150502');
insert into member values ('id-59', '1111', '회원59', 'm59@abc.com', '20150507');
insert into member values ('id-60', '1111', '회원60', 'm60@abc.com', '20150507');
insert into member values ('id-61', '1111', '회원61', 'm61@abc.com', '20120116');


insert into member values ('id-62', '1111', '회원62', 'm62@abc.com', '20140806');
insert into member values ('id-63', '1111', '회원63', 'm63@abc.com', '20150216');
insert into member values ('id-64', '1111', '회원64', 'm65@abc.com', '20140505');
insert into member values ('id-65', '1111', '회원65', 'm65@abc.com', '20140812');