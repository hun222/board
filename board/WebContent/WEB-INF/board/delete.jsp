<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 삭제</title>
<script type="text/javascript" src="script.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<form method="post" action="">
		<input type="hidden" name="boardReplyNumber" value=""/>
		<input type="hidden" name="pageNumber" value=""/>
		<table border="1" width="300" cellpadding="2" cellspacing="0" align="center">
			<tr>
				<td align="center" bgcolor="D1DBDB">
					비밀번호 입력해주세요.
				</td>
			</tr>
			
			<tr>
				<td align="center">비밀번호
					<input type="password" name="password" size="8" maxlength="12"/>
				</td>
			</tr>
			
			<tr>
				<td align="center">
					<input type="submit" value="글삭제"/>
					<input type="button" value="목록보기" onclick=" ">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>