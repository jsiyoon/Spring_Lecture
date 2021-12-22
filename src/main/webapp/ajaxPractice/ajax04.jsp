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
			url : appRoot + "/cont14/met01",
			data : {
				name : "donald"
			}
		});
	});
	
	$("#btn02").click(function(){
		$.ajax({
			url : appRoot + "/cont14/met02",
			data:{
				city : "seoul"
			}
		});
	});
	
	$("#btn03").click(function(){
		$.ajax({
			url : appRoot + "/cont14/met03",
			data:{
				city : "busan",
				name : "trump"
			}
		});
	});
	
	$("#btn04").click(function(){
		const val = $("#input04").val();
		$.ajax({
			url : appRoot + "/cont14/met04",
			data : {
				data1 : val
			}
		});
	});
	
	$("#btn05").click(function(){
		const name = $("#input05").val();
		const address = $("#input05").val();
		$.ajax({
			url : appRoot + "/cont14/met05",
			data : {
				name : name,
				address : address
			}
		});
	});
});
</script>

</head>
<body>
<input type="text" placeholder="name" id="input05">
<input type="text" placeholder="address" id="input06">
<button id="btn05">/cont14/met05 ajax 요청 : 위 2개의 인풋요소 값이 전송 되도록, server에서 두값출력</button>

<hr>

<button id="btn01">/cont14/met01 요청</button><br>
<button id="btn02">/cont14/met02 요청, "city" request Param서버로 전송, 서버에서"city" request paramter 값 sysout으로 출력</button><br>
<button id="btn03">/cont14/met03 요청</button><br>
<button id="btn04">/cont14/met04 요청</button>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>