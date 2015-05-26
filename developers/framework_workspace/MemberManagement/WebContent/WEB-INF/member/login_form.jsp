<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/menu.jsp" %>

	<fieldset style="width: 350px">
		<legend>로그인 폼</legend>
		<font size="2" color="red">${ requestScope.failMessage }</font>
		<form action="/MemberManagement/controller" method="post">
			<input type="hidden" name="command" value="login">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" size="20" autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="password" size="20"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="로그인" /> <input type="reset" value="초기화" /></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>