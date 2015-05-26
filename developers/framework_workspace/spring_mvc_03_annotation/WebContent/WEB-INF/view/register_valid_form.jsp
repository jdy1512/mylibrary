<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	width: 700px;
}
table, td{
	border: 1px solid black;
	border-collapse: collapse;
	padding:2px;
}
</style>
</head>
<body>
<spring:hasBindErrors name="customer"></spring:hasBindErrors>
<form action="/spring_mvc_03_annotation/modelAttr/register_valid.do" method="post">
	<table>
		<tr>
			<td width="100px">ID</td>
			<td>
				<input type="text" name="id" value="${ customer.id }">
				<span class="error">
					<form:errors path="customer.id" delimiter=" | "/>
				</span>
			</td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td>
				<input type="password" name="password" value="1111">
				<span class="error">
					<form:errors path="customer.password" delimiter=" | "/>
				</span>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" value="김영수">
				<span class="error">
					<form:errors path="customer.name" delimiter=" | "/>
				</span>
			</td>
		</tr>
		<tr>
			<td>email주소</td>
			<td><input type="text" name="email" value="email@a.com"></td>
		</tr>
		<tr>
			<td>연봉</td>
			<td>
				<input type="text" name="salary" value="${ customer.salary }">
				<span class="error">
					<form:errors path="customer.salary"></form:errors>
				</span>			
			</td>
		</tr>
		<tr>
			<td>결혼 여부</td>
			<td>
				<label>기혼 : <input type="radio" name="marriage" value="true"></label>
				<label>미혼 : <input type="radio" name="marriage" value="false"></label>				
			</td>
		</tr>
		<tr>
			<td>취미선택</td>
			<td>
				<label>독서<input type="checkbox" name="hobby" value="독서"></label>
				<label>게임<input type="checkbox" name="hobby" value="게임"></label>
				<label>영화<input type="checkbox" name="hobby" value="영화"></label>
				<label>음악<input type="checkbox" name="hobby" value="음악"></label>
				<label>스포츠<input type="checkbox" name="hobby" value="스포츠"></label>
			</td>
		</tr>
		<tr>
			<td>관심분야</td>
			<td>
				<label>인문<input type="checkbox" name="interest" value="인문"></label>
				<label>자연과학<input type="checkbox" name="interest" value="자연과학"></label>
				<label>어학<input type="checkbox" name="interest" value="어학"></label>
				<label>자기개발<input type="checkbox" name="interest" value="자기개발"></label>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="등록"></td>
		</tr>
	</table>
</form>
<p>

</body>
</html>
