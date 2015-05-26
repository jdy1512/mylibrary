<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${ initParam.rootPath }/script/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#searchBtn").on("click", function(){
			$.ajax({
				url:"${initParam.rootPath}/ajax/findById.do", // 요청 url
				type:"POST",
				data:{id:$("#id").val()}, // 요청파라미터
				dataType:"text", // 응답 데이터 타입 - text(기본), json, jsonp, xml
				beforeSend:function() {
					// 전송 전에 호출할 함수 등록
					if($("#id").val() == "") {
						alert("조회할 ID를 입력하세요");
						return false;
					}
				},
				success:function(txt) {
					// 정상 응답이 왔을 경우 호출 될 함수.
					alert(txt);
				}
			});// end of ajax
		});// end of searchBtn

		$("#j_searchBtn").on("click", function(){
			$.ajax({
				url:"${initParam.rootPath}/ajax/findById_JSON.do", // 요청 url
				type:"POST",
				data:{id:$("#id").val()}, // 요청파라미터
				dataType:"text", // 응답 데이터 타입 - text(기본), json, jsonp, xml
				beforeSend:function() {
					// 전송 전에 호출할 함수 등록
					if($("#id").val() == "") {
						alert("조회할 ID를 입력하세요");
						return false;
					}
				},
				success:function(json) {
					// 정상 응답이 왔을 경우 호출 될 함수.
					var member = $.parseJSON(json);
					var str = "[ID : " + member.id + ", 이름 : " + member.name + ", 나이 : " + member.age + "]<br/>";
					$("#layer").html(str);
				}
			});// end of ajax
		});// end of searchBtn
		
		$("#listBtn").on("click", function(){
			$.ajax({
				url:"${initParam.rootPath}/ajax/memberList.do", // 요청 url
				type:"GET",
				dataType:"text", // 응답 데이터 타입 - text(기본), json, jsonp, xml
				success:function(json) {
					// 정상 응답이 왔을 경우 호출 될 함수.
					
					var memberList = $.parseJSON(json);
	                var memberListLen = memberList.length;
	                var str = "";
	                for (var i = 0; i < memberListLen; i++) {
	                    str += "[ID : " + memberList[i].id + ", 이름 : " + memberList[i].name + ", 나이 : " + memberList[i].age + "]<br/>";
	                }

					$("#layer").html(str);
				}
			});// end of ajax
		});// end of listBtn
	});// end of ready
</script>

</head>
<body>
<h2>Ajax 요청</h2>
ID : <input type="text" id="id">
<button id="searchBtn">ID로 조회</button>
<button id="j_searchBtn">ID로 조회 - JSON</button>
<div id="layer"></div>
<p>
<button id="listBtn">전체조회</button>

</body>
</html>