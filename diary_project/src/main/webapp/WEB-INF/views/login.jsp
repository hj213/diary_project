<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<style>
*{margin: 0; padding: 0; text-decoration: none; color:#000;}

input {padding: 10px; margin: 10px 0 30px; width: 100%; border: 1px solid #ddd; border-radius: 5px; transition: border-color 0.3s; box-sizing: border-box;} 
input:focus {outline: none; border-color: #1b64da;}

.page_title{margin:30px 0 50px; padding-left:21px; font-size:24px; font-weight:700; color: #4e5968;}

.login_form { width: 450px; margin: 0 auto; padding:3rem 0;}
form{border:1px solid #ddd; border-radius:8px; overflow:hidden; padding:20px;}
label {font-size: 15px; font-weigth: 500; color: #4e5968;}

.login_util_box {display: flex; justify-content: space-between; align-items:center;}
.login_util_box button {color: #fff; padding: 11px 16px; background-color: #1b64da; border-radius: 7px; border: none; cursor: pointer;}
</style>
<script>
	window.onload = function() {
  		document.getElementById("userId").focus();
	
	    document.querySelector(".login_btn").addEventListener('click', () => {
	        const userId = document.getElementById("userId");
	        const userPw = document.getElementById("userPw");
	
	        if (userId.value === "") {
	            alert("아이디를 입력해주세요");
	            userId.focus();
	            return;
	        }
	
	        if (userPw.value === "") {
	            alert("비밀번호를 입력해주세요");
	            userPw.focus();
	            return;
	        }
	        
	        document.querySelector("form").submit();
	    });
	};
</script>

<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div class="login_form">
		<h1 class=page_title>로그인</h1>
		<form method="post">
			<div>
				<label for="userId">아이디</label> <input id="userId" name="userId">
			</div>
			<div>
				<label for="password">비밀번호</label> <input id="userPw"
					name="password" type="password">
			</div>

			<div class="login_util_box">
				<a href="register">회원가입</a>
				<button type="button" class="login_btn">로그인</button>
			</div>
		</form>
	</div>
</body>
</html>