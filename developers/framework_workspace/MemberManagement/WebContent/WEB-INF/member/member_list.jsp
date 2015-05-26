<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/menu.jsp"%>

	<h2>회원목록</h2>

	<table width="500" border='1'>
		<thead>
			<tr>
				<td>ID</td>
				<td>Password</td>
				<td>이름</td>
				<td>이메일</td>
				<td>가입일자</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${ requestScope.memberList }">
				<tr>
					<td>${ member.id }</td>
					<td>${ member.password }</td>
					<td>${ member.name }</td>
					<td>${ member.email }</td>
					<td><fmt:formatDate value="${ member.joinDate }" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>