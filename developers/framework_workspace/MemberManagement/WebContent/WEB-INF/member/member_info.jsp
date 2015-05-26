<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/menu.jsp" %>
	
	<h2>회원 정보</h2>
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
			<th align="left">가입일자</th>
			<td>${ requestScope.joinDate }</td>
		</tr>
	</table>
	<p>
	<a href="/MemberManagement/controller?command=modifyForm">회원정보 수정</a> <a href="/MemberManagement/controller?command=removeMember">회원 탈퇴</a>
</body>
</html>