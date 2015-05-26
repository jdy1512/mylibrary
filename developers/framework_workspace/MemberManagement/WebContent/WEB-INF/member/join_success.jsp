<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/menu.jsp" %>

	<h2>가입 환영합니다.</h2>
	<h3>가입 시 입력하신 정보입니다.</h3>
	<table border='1' width="500px">
		<tr>
			<th width="100px" align="left">ID</th>
			<td>${ requestScope.id }</td>
		</tr>
		<tr>
			<th align="left">패스워드</th>
			<td>${ requestScope.password }</td>
		</tr>
		<tr>
			<th align="left">이름</th>
			<td>${ requestScope.name }</td>
		</tr>
		<tr>
			<th align="left">이메일</th>
			<td>${ requestScope.email }</td>
		</tr>
		<tr>
			<th align="left">가입일</th>
			<td>${ requestScope.joinDate }</td>
		</tr>
	</table>
</body>
</html>