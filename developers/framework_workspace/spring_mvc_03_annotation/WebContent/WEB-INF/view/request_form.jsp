<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>@RequestParam을 이용한 요청파라미터 처리</h2>
	<h4>로그인</h4>
	<form action="/spring_mvc_03_annotation/param/login.do" method="post">
		ID : <input type="text" name="login_id"><br/>
		패스워드 : <input type="password" name="password"><br/>
		<input type="submit" value="전송">
	</form><br/>

	<h4>다양한 타입의 요청파라미터 처리</h4>
	<form action="/spring_mvc_03_annotation/param/variousType.do">
		정수 - 나이 :<input type="text" name="age"><br/>
		실수 - 키 :<input type="text" name="tall"><br>
		boolean - 메일 수신여부 : 
		받기 - <input type="radio" value="true" name="mailing"> 
		안받기 - <input type="radio" value="false" name="mailing"><br>
	</form><br/>

	<h4>같은 이름으로 여러개의 요청파라미터 값들 전송 처리</h4>
	<form action="/spring_mvc_03_annotation/param/manyParams.do" method="post">
		<input type="text" name="txt"><br/>
		<input type="text" name="txt"><br/>
		<input type="text" name="txt"><br/>
		<input type="text" name="txt"><br/>
		<input type="text" name="txt"><br/>
		<input type="text" name="txt"><br/>
		<input type="submit" value="전송"><br/>
	</form>
</body>
</html>