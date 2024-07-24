<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<style>
{margin: 0; padding: 0; text-decoration: none;}

input {padding: 10px; margin: 10px 0 30px; width: 100%; border: 1px solid #ddd; border-radius: 5px; transition: border-color 0.3s; box-sizing: border-box;} 
input:focus {outline: none; border-color: #1b64da;}

.page_title{margin:30px 0 50px; padding-left:21px; font-size:24px; font-weight:700; color: #4e5968;}

.login_form { width: 450px; margin: 0 auto; padding:3rem 0;}
form{border:1px solid #ddd; border-radius:8px; overflow:hidden; padding:20px;}
label {font-size: 15px; font-weigth: 500; color: #4e5968;}

.login_util_box.one_btn_box {display: flex; justify-content: flex-end;}
.login_util_box button {color: #fff; padding: 11px 16px; background-color: #1b64da; border-radius: 7px; border: none; cursor: pointer;}
</style>
<script>
	window.onload = function() {
  		document.getElementById("username").focus();
	
	    document.querySelector(".register_btn").addEventListener('click', () => {
	    	const userName = document.getElementById("username");
	    	const userId = document.getElementById("userId");
	    	const userPw = document.getElementById("password");
	    	const userEmail = document.getElementById("email");
	    	const userPhone = document.getElementById("phone");
	
	        if (userName.value === "") {
	            alert("이름을 입력해주세요");
	            userName.focus();
	            return;
	        }
	        
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

	        if (userEmail.value === "") {
	            alert("이메일을 입력해주세요");
	            userEmail.focus();
	            return;
	        }

	        if (userPhone.value === "") {
	            alert("전화번호를 입력해주세요");
	            userPhone.focus();
	            return;
	        }
	        
	        document.querySelector("form").submit();
	    });
	};
</script>

<meta charset="UTF-8">
<title>회원가입</title>

</head>
<body>
	<div class="login_form">
		<h1 class=page_title>회원가입</h1>
	    <form method="post">
	        <div>
	            <label for="username">이름</label>
	            <input name="username" id="username"> 
	        </div>
	        <div>
	            <label for="userId">아이디</label>
	            <input name="userId" id="userId"> 
	        </div>
	        <div>
	            <label for="password">비밀번호</label>
	            <input name="password" type="password" id="password"> 
	        </div>
	        <div>
	            <label for="email">이메일</label>
	            <input name="email" type="email" id="email"> 
	        </div>
	        <div>
	            <label for="phone">전화번호</label>
	            <input name="phone" type="tel" id="phone"> 
	        </div>
	        
	       	<div class="login_util_box one_btn_box">
	       		<button type="button" class="register_btn">회원가입</button>
	       	</div>
	    </form>
    </div>
</body>
</html>
