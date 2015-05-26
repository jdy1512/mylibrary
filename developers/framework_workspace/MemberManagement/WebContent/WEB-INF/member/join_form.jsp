<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/menu.jsp" %>
	
	<h2>가입양식</h2>
	<form method="post" action="/MemberManagement/controller">
		<input type="hidden" name="command" value="joinMember">

		<table width='500'>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="" id="id"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" id="email"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="가입"> <input type="reset" value="다시작성"></td>
			</tr>
		</table>
	</form>
</body>
</html>