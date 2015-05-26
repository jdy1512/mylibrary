<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="calc.do" method="post">
		<input type="hidden" name="command" value="plus">
		<input type="number" name="op1"> + <input type="number" name="op2">
		<input type="submit" value="덧셈계산">
	</form>
	
	<form action="calc.do" method="post">
		<input type="hidden" name="command" value="minus">
		<input type="number" name="op1"> - <input type="number" name="op2">
		<input type="submit" value="뺄셈계산">
	</form>
</body>
</html>