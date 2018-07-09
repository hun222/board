<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 수정</title>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<script type="text/javascript" src="${root}/css_js/script.js"></script>
<link rel="stylesheet" type="text/css" href="${root}/css_js/style.css">
</head>
<body>
	<form action="${root}/board/updateOk.do" method="post" onsubmit="return checkForm()">
		<input type="hidden" name="boardNumber" value="${boardDTO.boardNumber}"/>
		<input type="hidden" name="pageNumber" value="${pageNumber}"/>
		
		<div style="width:598px; height:15px; border-width:2px; text-align:right; padding:15px 0px 0px 0px; border-bottom-width:0px;">
				<a href=" ">글목록</a>
		</div>
			
		<div class="line">
			<label class="title">작성자</label>
			<span class="content">
				<input type="text" name="writer" value="${boardDTO.writer }" disabled/>
			</span>
		</div>
		
		<div class="line">
			<label class="title">제목</label>
				<span class="content"><input type="text" size="50" name="subject"  value="${boardDTO.subject } "/></span>
		</div>
		
		<div class="line">
			<label class="title">이메일</label>
			<span class="content">
				<input type="text" size="50" name="email"  value="${boardDTO.email } "/>
			</span>
		</div>
		
		<div class="line" style="height:230px;">
			<label class="title" style="height:230px;">내용</label>
			<span class="content" style="height:230px;">
				<textarea rows="14" cols="58" name="content">${boardDTO.content }</textarea>
			</span>
		</div>
		
		<div class="line">
			<label class="title">비밀번호</label>
			<span class="content">
				<input type="password" name="password" value="${boardDTO.password }"/>
			</span>
		</div>
		
		<div class="line" style="width:598px; border-width:2px; text-align:center;">
			<input type="submit" value="글수정"/>
			<input type="reset" value="취소"/>
			<input type="button" value="목록보기" onclick=" ">
		</div>
	</form>
</body>
</html>