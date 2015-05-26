<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${ empty sessionScope.login_info }">
	<a href="/MemberManagement/index.jsp">메인페이지</a>&nbsp;&nbsp;
	<a href="/MemberManagement/controller?command=link&href=/WEB-INF/member/join_form.jsp">회원가입</a>&nbsp;&nbsp;
	<a href="/MemberManagement/controller?command=link&href=/WEB-INF/member/login_form.jsp">로그인</a>&nbsp;&nbsp;
	<a href="/MemberManagement/controller?command=memberList">전체 회원정보 조회</a>&nbsp;&nbsp;
</c:if>
<c:if test="${ not empty sessionScope.login_info }">
	<a href="/MemberManagement/index.jsp">메인페이지</a>&nbsp;&nbsp;
	<a href="/MemberManagement/controller?command=logout">로그아웃</a>&nbsp;&nbsp;
	<a href="/MemberManagement/controller?command=getMemberInfo">본인정보조회</a>&nbsp;&nbsp;
	<a href="/MemberManagement/controller?command=modifyForm">회원정보 수정</a>&nbsp;&nbsp;
	<a href="/MemberManagement/controller?command=removeMember">회원 탈퇴</a>&nbsp;&nbsp;
	<a href="/MemberManagement/controller?command=memberList">전체 회원정보 조회</a>&nbsp;&nbsp;
</c:if>
<hr width="700" align="left" noshade="noshade">