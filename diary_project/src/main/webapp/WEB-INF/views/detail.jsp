<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
*{margin: 0; padding: 0; text-decoration:none; color:#000; box-sizing:border-box;}
ul, li {list-style: none;}

.main_container {width:560px; margin:0 auto; padding: 3rem 0;}
.main_container div > p{margin-bottom:12px; font-size:32px; font-weight:700;}

.write_wrap{border:1px solid #ddd; border-radius:10px; overflow:hidden;}

.wirte_box{padding:24px;}
.write_top_box{border-bottom: 1px solid #ddd;}
.write_top_box h3{margin-bottom:12px;}
.write_bot_box{min-height:500px;}

.login_util_box {display: flex; justify-content: flex-end; gap:10px;}
.login_util_box a {color:#fff;}

button {color: #fff; margin-top:16px; padding: 11px 16px; background-color: #1b64da; border-radius: 7px; border: none; cursor: pointer;}
button:disabled{background: #ccc; cursor:initial;}
button.red_bg{background:#ff4444;}
</style>

<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>
    <div class="main_container write_container">
    	<form method="post">
    		<div class="write_wrap">
	            <div class="wirte_box write_top_box">
	                <!-- <p>일기 제목</p> -->
	                <div class="write_title" name="title" placeholder="일기 제목을 작성해주세요."><h3>${diaryTitle}</h3></div>
	                <div class="write_date" name="date" placeholder="일기 제목을 작성해주세요.">${diaryDate}</div>
	            </div>
	            <div class="wirte_box write_bot_box">
	                <!-- <p>일기 내용</p> -->
	                <div class="write_content" name="content" placeholder="일기 내용을 작성해주세요.">${diaryContent}</div>
	            </div>
			</div>
			
            <div class="login_util_box">
            	<button class="red_bg" name="action" value="delete">삭제하기</button>
            	<button name="action" value="update" ><a href="/diary_project/write?id=${diaryId}">수정하기</a></button>
           	</div>
         </form>
    </div>
</body>
</html>