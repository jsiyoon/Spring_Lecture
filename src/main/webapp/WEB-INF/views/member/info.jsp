<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="b" tagdir="/WEB-INF/tags/board" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath()%>/resource/css/icon/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<title>Insert title here</title>
</head>
<body>
<b:navbar></b:navbar>
<div class="container">
	<div class="row">
		<div class="col">
			<h1 style="text-align: center;">회원 정보</h1>
			<form method="post" id="infoForm">
				<div class="form-group">
					<label for="input1">아이디</label>
					<input type="text" required id="input1" class="form-control" name="id" value="${sessionScope.loggedInMember.id }" readonly>
				</div>
				<div class="form-group">
					<label for="input2">닉네임</label>
					<div class="input-group">
						<input type="text" required id="input2" class="form-control" name="nickName" value="${sessionScope.loggedInMember.nickName }">
						<div class="input-group-append">
							<button class="btn btn-secondary" id="nickNameCheckButton" type="button">중복확인</button>
						</div>
					</div>
					<small class="form-text" id="nickNameCheckMessage"></small>
				</div>
				<div class="form-group">
					<label for="input3">비밀번호</label>
					<input type="text" required id="input3" class="form-control" name="password" value="${sessionScope.loggedInMember.password }">
				</div>
				<div class="form-group">
					<label for="input4">비밀번호 확인</label>
					<input type="text" required id="input4" class="form-control">
				</div>
				<div class="form-group">
					<label for="input5">이메일</label>
					<input type="text" required id="input5" class="form-control" name="email" value="${sessionScope.loggedInMember.email }">
				</div>
				<div class="form-group">
					<label for="input6">주소</label>
					<input type="text" required id="input6" class="form-control" name="address" value="${sessionScope.loggedInMember.address }">
				</div>
				
				<button class="btn btn-outline-secondary" id="modifyButton">수정</button>
				<button class="btn btn-outline-danger" id="removeButton">삭제</button>
			</form>
		</div>
	</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

<script>
	$(document).ready(function() {
		const oldNickName = $("#input2").val();
		const appRoot = "${pageContext.request.contextPath}"
		const infoForm = $("#infoForm");
		const modifyButton = $("#modifyButton");
		const removeButton = $("#removeButton");
	
		let nickNameAble = true;
		let passwordCheck = false;
		
		//닉네임이 기존과 같지않을 때만 중복확인버튼 활성화
		$("#nickNameCheckButton").attr("disabled", true);
		$("#input2").keyup(function(){
			const typed = $("#input2").val();
			if(oldNickName === typed){ //비활성화
				$("#nickNameCheckButton").attr("disabled", true);
				nickNameAble = true;
			}else{ //활성화
				$("#nickNameCheckButton").removeAttr("disabled");
				nickNameAble = false;
			}
			enableSubmit();
		});
		
		//패스워드 확인과 닉네임 중복확인이 완료되었을 떄만 수정버튼 활성화
		const enableSubmit = function(){
			if(passwordCheck && nickNameAble){
				modifyButton.removeAttr("disabled");
			}else{
				modifyButton.attr("disaled", true);
			}
		}
		
		//nickNameCheckButton클릭시
		// /member/nickNameCheck로 작성한 nickName전송해
		//받은 결과에 따라 수정버튼 활성화/비활성화 AND 적절한 메시지 출력
		$("#nickNameCheckButton").click(function(){
		$("#nickNameCheckButton").attr("disabled", true);
		const nickName = $("#input2").val().trim();
		
		if(nickName === ""){
			$("#nickNameCheckMessage")
				.text("닉네임을 입력해주세요.")
				.removeClass("text-primary text-danger")
				.addClass("text-warning")
			$("#nickNameCheckButton").removeAttr("disabled");
			return;
		}
		
		$.ajax({
			url : appRoot + "/member/nickNameCheck",
			data : {
				nickName : nickName
			},
			success : function(data){
				switch (data) {
				case "able": 
					//사용가능할 때
					$("#nickNameCheckMessage")
						.text("사용 가능한 닉네임입니다.")
						.removeClass("text-warning text-danger")
						.addClass("text-primary");
					$("#input2").attr("readonly", true);
					nickNameAble = true;
					break;

				case "unable": 
					//사용불가능 할때
					$("#nickNameCheckMessage")
						.text("이미 사용중인 닉네임입니다.")
						.removeClass("text-primary text-warning")
						.addClass("text-danger");
				
					nickNameAble = false;
					break;
				default:
					break;
				}
			},
			complete : function(){
				enableSubmit();
				$("#nickNameCheckButton").removeAttr("disabled");
			}
		});
	});
		
		//수정버튼/삭제버튼 클릭 시 form의 action속성값 변경
		modifyButton.click(function(e) {
			e.preventDefault();
			if(confirm("수정하시겠습니까?")){
				infoForm.attr("action", "");
				infoForm.submit();
ㄴ			}
		});
		
		removeButton.click(function(e) {
			e.preventDefault();
			if(confirm("탈퇴하시겠습니까?")){
				infoForm.attr("action", "remove");
				infoForm.submit();
			}
		});
				
		//패스워드, 패스워드확인 인풋요소 값 일치할 때만 수정버튼 활성화
		const passwordInput = $("#input3");
		const passwordConfirmInput = $("#input4");
		const confirmFunction = function() {
			const passwordValue = passwordInput.val();
			const passwordConfirmValue = passwordConfirmInput.val();
			
			if(passwordValue === passwordConfirmValue){
				passwordCheck = true;
				// modifyButton.removeAttr("disabled");
			}else{
				passwordCheck = false;
				// modifyButton.attr("disabled", true);
			}
			enableSubmit();
		}
		
		modifyButton.attr("disabled", true); //수정버튼 비활성화
		
		passwordInput.keyup(confirmFunction);
		passwordConfirmInput.keyup(confirmFunction);
	});
</script>
</body>
</html>