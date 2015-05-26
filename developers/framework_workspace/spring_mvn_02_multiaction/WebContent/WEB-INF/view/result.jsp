<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계산 결과</h2><br/>
	${ requestScope.result }
	
	<a href="calc.do?command=calcForm">계산 폼</a>
	<a href="calc.do?command=index">index</a>
</body>
</html>