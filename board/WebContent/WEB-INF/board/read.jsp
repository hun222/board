<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 읽기</title>
<script>
function replyFunc(root, boardNumber, groupNumber, sequenceNumber, sequenceLevel){
	url = root+"/board/write.do?boardNumber="+boardNumber+"&groupNumber="+groupNumber
	+"&sequenceNumber="+sequenceNumber+"&sequenceLevel="+sequenceLevel;
	//alert(url);
	location.href = url;
}

function deleteFunc(root, boardNumber, pageNumber){
	url = root+"/board/delete.do?boardNumber="+boardNumber+"&pageNumber="+pageNumber;
	//alert(url);
	location.href = url;
}

function update(root, boardNumber, pageNumber){
	url = root+"/board/update.do?boardNumber="+boardNumber+"&pageNumber="+pageNumber;
	//alert(url);
	location.href = url;
}
</script>
</head>
<body>
	<table border="1" width="510" cellpadding="2"  cellspacing="0" align="center">
		<tr>
			<td align="center"  height="20" width="125">글번호</td>
			<td align="center"  height="20" width="125">${boardDTO.boardNumber }</td>
			
			<td align="center"  height="20" width="125">조회수</td>
			<td align="center"  height="20" width="125">${boardDTO.readCount }</td>
		</tr>
		
		<tr>
			<td align="center"  height="20" width="125">작성자</td>
			<td align="center"  height="20" width="125">${boardDTO.writer }</td>
			
			<td align="center"  height="20" width="125">작성일</td>
			<td align="center"  height="20" width="125">
				<fmt:formatDate value="${boardDTO.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		
		<tr>
			<td align="center"  height="200" width="125">글내용</td>
			<td valign="top"  height="200" colspan="3">${boardDTO.content }</td>
		</tr>
		<c:set var="root" value="${pageContext.request.contextPath }"/>
		<tr>
			<td height="30" colspan="4" align="center">
				<input type="button" value="글수정" onclick="update('${root}','${boardDTO.boardNumber }','${pageNumber }') " />
				<input type="button" value="글삭제" onclick="deleteFunc('${root}','${boardDTO.boardNumber }','${pageNumber }')"/>
				<input type="button" value="답글" onclick="replyFunc('${root}','${boardDTO.boardNumber }',
				'${boardDTO.groupNumber }','${boardDTO.sequenceNumber }','${boardDTO.sequenceLevel }') "/>
				<input type="button" value="글목록" onclick="location.href='${root}/board/list.do?pageNumber=${pageNumber }'"/> <!-- 목록 이동시 pageNumber 활용 -->
			</td>
		</tr>
	</table>
</body>
</html>