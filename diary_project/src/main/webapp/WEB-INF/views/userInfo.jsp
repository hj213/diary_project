<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
*{margin: 0; padding: 0; text-decoration: none;}

input {padding: 10px; margin: 10px 0 30px; width: 100%; border: 1px solid #ddd; border-radius: 5px; transition: border-color 0.3s; box-sizing: border-box; } 
input:focus {outline: none; border-color: #1b64da;}

.mypage_area { width: 450px; margin: 3rem auto 0; border:1px solid #ddd; border-radius:8px; overflow:hidden; padding:20px;}
.mypage_area form> div{margin-bottom:26px;}
.mypage_area form> div:last-child{margin-bottom:0;}
.page_title{margin:30px 0 50px; font-size:24px; font-weight:700; color: #4e5968;}
p {margin-bottom:12px; font-size: 14px; font-weight: 500; color: #4e5968;}

.login_util_box {display: flex; justify-content: flex-end; gap:10px;}
.login_util_box input{cursor:pointer;}
.login_util_box input.text_bg{color: #fff; background: #ff4444;}
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
<title>마이페이지</title>

</head>
<body>
	<div class="mypage_area">
		<h1 class=page_title>마이페이지</h1>
		<form method="post">
	        <div>
	            <p>이름</p>
	            <span>${sessionScope.username}</span>
	        </div>
	        <div>
	  	            <p>아이디</p>
	            <span>${userId}</span>
	        </div>
	        <div>
	  	            <p>비밀번호</p>
	            <span>********</span>
	        </div>
	        <div>
	  	            <p>이메일</p>
	            <span>${sessionScope.email}</span>
	        </div>
	        <div>
	  	            <p>전화번호</p>
	            <span>${sessionScope.phone}</span>
	        </div>
	        
   			<div class="login_util_box">
   				<input type="submit" name="action" value="로그아웃" />
                   <!-- <input type="submit" name="action" value="회원수정" /> -->
                  <input class="text_bg" type="submit" name="action" value="회원탈퇴" />
   				<!-- 
		        <button>로그아웃</button>
		        <button>회원수정</button>
		        <button>회원탈퇴</button> -->
			</div>
        </form>
    </div>
</body>
</html>