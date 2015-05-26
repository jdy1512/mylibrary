<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="${ initParam.rootPath }/upload/singleup.do">
		제목 : <input type="text" name="title"><br/>
		이미지 : <input type="file" name="upfile"><br/>
		설명 <br/>
		<textarea name="info" cols="50" rows="5"></textarea><br/>
		
		<input type="submit" value="전송">
	</form>
</body>
</html>