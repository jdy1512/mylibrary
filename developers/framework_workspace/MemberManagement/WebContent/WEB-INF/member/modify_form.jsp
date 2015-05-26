<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/menu.jsp" %>

	<h2>회원정보 수정 폼</h2>

	<form method="post" action="/MemberManagement/controller"">
		<input type="hidden" name="command" value="modifyMember"> <input type="hidden" name="id" value="${ sessionScope.login_info }">

		<table width='500'>
			<tr>
				<td>ID</td>
				<td>${ sessionScope.login_info }</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정"> <input type="reset" value="다시작성"></td>
			</tr>
		</table>
	</form>

</body>
</html>