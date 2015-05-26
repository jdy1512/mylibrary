<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<style type="text/css">
table {
	width:700px;
    border-collapse: collapse;
}
table, td{
    border: 1px solid black;
}
td{
	padding: 5px;
}
thead{
	background-color: gray;
	color:white;
}
#paging a{
	cursor: pointer;
	text-decoration: none;
	color: black;
}
#paging{
	font-size: 19px;
}

</style>
</head>
<body>
<jsp:include page="/WEB-INF/view/menu.jsp"/>

<h2>회원목록</h2> 	

<c:if test="${fn:length(requestScope.member_list) != 0 }"><!-- 회원정보가 있으면 -->
	<table>
		<thead>
			<tr>
				<td width="80">ID</td>
				<td width="80">Password</td>
				<td width="130">이름</td>
				<td width="220">이메일</td>
				<td>가입일자</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.member_list }" var="member">
				<tr>
					<td>${member.id }</td>
					<td>${member.password}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.joinDate}</td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
	<p id="paging">
	<!-- paging처리 -->
	<!-- 이전 페이지 그룹으로 이동 링크 -->
	<c:choose>
		<c:when test="${requestScope.pagingBean.previousPageGroup }">
			<a href="/${initParam.rootPath }/controller?command=memberListPaging&page=${requestScope.pagingBean.startPageOfPageGroup-1}">◁</a>
		</c:when>
		<c:otherwise>◁</c:otherwise>
	</c:choose>
	<!-- 페이징 -->
	<c:forEach begin="${requestScope.pagingBean.startPageOfPageGroup }" end="${requestScope.pagingBean.endPageOfPageGroup }" var="page">
		<c:choose>
			<c:when test="${page != requestScope.pagingBean.currentPage }">
				<a href="/${initParam.rootPath }/controller?command=memberListPaging&page=${page}">
					&nbsp;${ page} &nbsp;
				</a>
			</c:when>
			<c:otherwise>&nbsp;<b><i>${ page}</i></b> &nbsp;</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<!-- 다음 페이지 그룹으로 이동 링크 -->
	<c:choose>
		<c:when test="${requestScope.pagingBean.nextPageGroup }">
			<a href="/${initParam.rootPath }/controller?command=memberListPaging&page=${requestScope.pagingBean.endPageOfPageGroup+1}">▷</a>
		</c:when>
		<c:otherwise>▷</c:otherwise>
	</c:choose>
	</p>
</c:if>
</body>
</html>