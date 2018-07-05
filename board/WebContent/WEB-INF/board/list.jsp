<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록보기</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<table width="530" align="center">
		<tr>
			<td align="right" bgcolor="D1DBDB">글쓰기</td>
		</tr>
	</table>
	
	
	<table border="1" width="530" cellpadding="2" cellspacing="0" align="center">
		<tr>
			<td align="center">게시판에 저장된 글이 없습니다.</td>
		</tr>
	</table>

	
	<table border="1" width="530" cellpadding="2" cellspacing="0" align="center">
		<tr> 
			<td align="center" width="30">번호</td>
			<td align="center" width="250">제목</td>
			<td align="center" width="70">작성자</td>
			<td align="center" width="100">작성일</td>
			<td align="center" width="50">조회수</td>
			<td align="center" width="50">IP</td>
		</tr>
		
		<!-- Board List -->
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td> 
		</tr>
	</table>
	<br/>
	
	<!-- 페이지 번호 -->
	<center></center>
</body>
</html>