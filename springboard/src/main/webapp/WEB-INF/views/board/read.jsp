<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>kyungmin 게시판</title>
<!-- 제이쿼리 -->
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>

	<div id="root">
		<header>
			<h1>kyungmin 게시판</h1>
		</header>

		<hr />

		<nav>처음화면 - 글쓰기 - 로그인</nav>

		<hr />

		<section id="container">

			<form role="form" method="post" autocomplete="off">

				<p>
					<label for="bno">글 번호</label><input type="text" id="bno" name="bno"
						value="${read.bno}" readonly="readonly" />
				</p>
				
				</form>

				<p>
					<label for="title">글 제목</label><input type="text" id="title"
						name="title" value="${read.title}" readonly="readonly" />
				</p>
				<p>
					<label for="content">글 내용</label>
					<textarea id="content" name="content" readonly="readonly">${read.content}</textarea>
				</p>
				<p>
					<label for="writer">작성자</label><input type="text" id="writer"
						name="writer" value="${read.writer}" readonly="readonly" /><br />
					<label>작성 날짜</label> <span><fmt:formatDate
							value="${read.regDate}" pattern="yyyy-MM-dd" /></span>
				</p>
				<p>

					<button id="modity_btn">수정</button>
					<button id="delete_btn">삭제</button>

					<script>
 
					 // 폼을 변수에 저장
					 var formObj = $("form[role='form']");
					 
					 // 수정 버튼 클릭
					 $("#modity_btn").click(function(){
					  
					  formObj.attr("action", "/board/modify");
					  formObj.attr("method", "get");  
					  formObj.submit();     
					  
					 });
					 
					 
					 // 삭제 버튼 클릭
					 $("#delete_btn").click(function(){
					  
					  formObj.attr("action", "/board/delete");
					  formObj.attr("method", "get");  
					  formObj.submit();
					  
					 });
					 </script>
				</p>


			

		</section>

		<hr />

		<footer>
			<p>만든이 : kyungmin</p>
		</footer>

	</div>

</body>
</html>