<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write ok</title>
</head>
<body>
<c:set var="root" value = "${pageContext.request.contextPath }"/>
<h1>${root }</h1>
<c:if test="${chk>0 }">
	<script>
		alert("글쓰기를 성공하셨습니다.");
		location.href="${root}/board/write.do";
	</script>
</c:if>

<c:if test="${chk==0 }">
	<script>
		alert("글쓰기를 실패하셨습니다.");
		location.href="${root}/board/write.do";
	</script>
</c:if>
</body>
</html>