<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
<head>
<style>
*{margin: 0; padding: 0; text-decoration:none; color:#000;}
ul, li {list-style: none;}

.main_container {width:560px; margin:0 auto; padding: 3rem 0;}
.main_container .top_box span{font-size:32px; font-weight:700;} 
.main_container .top_box p{font-size:36px; font-weight:700; margin-top:12px;}

.contents_area {margin-top:54px;}
.contents_area .contents_top_box{display:flex; justify-content:space-between; align-items:center;}
.contents_area .list_container {max-width:560px; min-height:500px; height:550px; box-shadow: 0 0 0 1px #e7e7e7, 0 1px 2px 0 rgba(0, 0, 0, .04); border-radius: 10px; overflow:auto; padding:12px; margin-top:16px;}
.contents_area .list_container li{border-bottom:1px solid #ddd; padding: 10px 0px 10px ;}
.contents_area .list_container li:hover span{color:skyblue;}
.contents_area .list_container li:last-child{border-bottom:none;}
.contents_area .list_container a{display:flex; flex-direction:column; padding:10px;}
.contents_area .list_container .list_title{font-size:16px; margin-bottom:6px; text-overflow: ellipsis; white-space: nowrap; overflow: hidden; }
.contents_area .list_container .list_date{font-size:12px; color:grey;}
</style>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
    <div class="main_container">
        <div class="top_box">
            <span><a href="userInfo">${sessionScope.username},</a></span>
            <p>오늘도 나는 일기를 쓴다... 👏</p>
        </div>

        <div class="contents_area">
            <div class="contents_top_box">
                <h3>내가 작성한 리스트</h3>
                <a href="write">일기 작성하기</a>
            </div>

                <ul class="list_container">
		            <c:forEach items="${sessionScope.allDiary}" var="diary">
	                    <li>
	                        <a href="/diary_project/detail?diaryId=${diary.id}"> 
	                            <span class="list_title">${diary.title}</span>
	                            <span class="list_date">${diary.date}</span>
	                        </a>
	                    </li>
            		</c:forEach>
                </ul>
        </div>
    </div>
</body>
</html>