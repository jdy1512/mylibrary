<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/menu.jsp" %>
	
	<h1>회원관리</h1>
	<c:if test="${ empty sessionScope.login_info }">
		본인정보 조회, 정보수정, 탈퇴를 하려면 로그인을 먼저하세요.
	</c:if>
	<c:if test="${ not empty sessionScope.login_info }">
		${ sessionScope.login_info }님 환영합니다.
	</c:if>
</body>
</html>