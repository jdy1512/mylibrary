<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/menu.jsp" %>

	<h2>에러 페이지</h2>
	
	<p/>
	실행 도중 오류가 발생했습니다.<br/>
	<font color="red">${ requestScope.errorMessage }</font>
	<p/>
	
	<a href="/MemberManagement/index.jsp">메인페이지로 이동</a>
</body>
</html>