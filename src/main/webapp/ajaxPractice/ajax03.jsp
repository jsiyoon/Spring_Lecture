<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath()%>/resource/css/icon/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<title>Insert title here</title>

<script>
const appRoot = '${pageContext.request.contextPath}';

$(document).ready(function(){
	$("#btn01").click(function(){
		$.ajax({
			url : appRoot + "/cont13/met02"
		});
	});
	
	$("#btn02").click(function(){
		$.ajax({
			url : appRoot + "/cont13/met03"
		});
	});
	
	$("#btn03").click(function(){
		$.ajax({
			url : appRoot + "/cont13/met04"
		});
	});
	
	$("#btn04").click(function(){
		$.ajax({
			url : appRoot + "/cont13/metaa",
			error : function(){
				console.log("/cont13/metaa 요청 실패!");
			}
		});
	});

	$("#btn05").click(function(){
		$.ajax({
			url : appRoot + "/cont13/metbb",
			error : function(){
				console.log("/cont13/metbb 요청 실패!");
			}
		});
	});
	
	$("#btn06").click(function(){
		$.ajax({
			url : appRoot + "/cont13/met05",
			success : function(){
				console.log("요청성공");
			}
		});
	});

	$("#btn07").click(function(){
		$.ajax({
			url : appRoot + "/cont13/met06",
			success : function(data){
				console.log(data);
			}
		});
	});
	
	$("#btn08").click(function(){
		$.ajax({
			url : appRoot + "/cont13/met07",
			success : function(data){
				$("#result08").html(data);
			}
		});
	});
	
	$("#btn09").click(function(){
		$.ajax({
			url : appRoot + "/cont13/met08",
			complete : function(){
				console.log("요청 끝남");
			}
		});
	});
	
	$("#btn10").click(function(){
		$.ajax({
			url : appRoot + "/cont13/met09",
			success : function(){
				console.log("요청성공");
			},
			error : function(){
				console.log("요청 실패");
			},
			complete : function(){
				console.log("요청 끝남");
			}
		});
	});
});

</script>
</head>
<body>

<button id="btn01">/cont13/met02</button> <br>
<button id="btn02">/con13/met03 응답있음 JSP페이지 전체</button> <br>
<button id="btn03">/cont13/met04 응답있음 단순데이터</button><br>
<button id="btn04">/cont13/metaa 존재하지 않는 경로</button><br>
<button id="btn05">/cont13/metbb 존재하지 않는 경로 요청 보냈을 때 alert ("요청 실패")</button><br>
<button id="btn06">/cont13/met05 응답 성공시 log </button><br>
<button id="btn07">/cont13/met06 응답받은 데이터 콘솔에 출력 </button><br>
<button id="btn08">/cont13/met07 응답받은 데이터를 #result08요소에 content로 작성</button><br>
<p id="result08"></p>
<button id="btn09">/cont13/met08 요청완료시 complete실행</button>
<button id="btn10">/cont13/met09 요청완료시 success/error AND complete실행</button>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>