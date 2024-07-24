<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {margin: 0; padding: 0; text-decoration:none; color:#000;}
ul, li {list-style: none;}

textarea{width:100%; resize:none; outline:0 none; border:none; margin-top:16px; padding:12px; box-sizing:border-box; border:1px solid #ddd; border-radius:10px;}
textarea.write_title {margin-bottom:16px;}
textarea.write_content {height:450px; overflow:auto;}

.main_container {width:560px; margin:0 auto; padding: 5rem 0;}
.main_container div > p{font-size:32px; font-weight:700;}

.login_util_box.one_btn_box {display: flex; justify-content: flex-end;}

button {color: #fff; margin-top:16px; padding: 11px 16px; background-color: #1b64da; border-radius: 7px; border: none; cursor: pointer;}
button:disabled{background: #ccc; cursor:initial;}

</style>

<script>
window.onload = function() {
	const contentTitlearea = document.querySelector("textarea.write_title");
	const contentTextarea = document.querySelector("textarea.write_content");
	
    const uploadButton = document.querySelector(".login_util_box button");

    contentTitlearea.addEventListener('input', function() {
        if (contentTextarea.value.trim().length > 0 && contentTitlearea.value.trim().length > 0) {
            uploadButton.disabled = false;
        } else {
            uploadButton.disabled = true;
        }
    });
    
    contentTextarea.addEventListener('input', function() {
        if (contentTextarea.value.trim().length > 0 && contentTitlearea.value.trim().length > 0) {
            uploadButton.disabled = false;
        } else {
            uploadButton.disabled = true;
        }
    });
};
</script>

<meta charset="UTF-8">
<title>일기 작성 페이지</title>
</head>
<body>
	<div class="main_container">
		<form method='post'>
			<div>
				<p>일기 제목</p>
				<textarea class="write_title" name="title" placeholder="일기 제목을 작성해주세요."><%
					String idParam = request.getParameter("id");
					if(idParam != null  && !idParam.isEmpty()){
						out.print((String)session.getAttribute("diaryTitle"));
					} 
					
				%></textarea>
			</div>
			<div>
				<p>일기 내용</p>
				<textarea class="write_content" name="content" placeholder="일기 내용을 작성해주세요."><%
					
					if(idParam != null  && !idParam.isEmpty()){
						out.print((String)session.getAttribute("diaryContent"));
					}
				%></textarea>
			</div>
			
			<div class="login_util_box one_btn_box"><button>업로드</button></div>
			
		</form>
	</div>
</body>
</html>