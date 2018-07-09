<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<c:if test="${count>0 }">
<script>
	alert("수정완료");
	location.href="${root}/board/read.do?pageNumber=${pageNumber}&boardNumber=${boardNumber}";
</script>
</c:if>

<c:set var="root" value="${pageContext.request.contextPath }"/>
<c:if test="${count==0 }">
<script>
	alert("수정실패");
	location.href="${root}/board/read.do?pageNumber=${pageNumber}&boardNumber=${boardNumber}";
</script>
</c:if>
</body>
</html>