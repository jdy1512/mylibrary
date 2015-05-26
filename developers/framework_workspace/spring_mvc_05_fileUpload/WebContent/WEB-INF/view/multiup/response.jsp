<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>응답 페이지</h2>
	제목 : ${ requestScope.title }<p/>
	파일 다운로드 <br/>
	<c:forEach items="${ requestScope.fileNames }" var="name">
		<a href="${ initParam.rootPath }/upload/${ name }">${ name }</a><br/>
	</c:forEach>
	
	<p/>
	DownloadView를 이용한 다운로드 처리<br/>
	<c:forEach items="${ requestScope.fileNames }" var="name">
		<a href="${ initParam.rootPath }/upload/download.do?filename=${ name }">${ name }</a><br/>
	</c:forEach>
</body>
</html>