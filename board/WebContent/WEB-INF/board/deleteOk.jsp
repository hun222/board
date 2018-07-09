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
	<c:if test="${chk > 0 }">
	<script>
		alert("삭제되었습니다.");
		location.href="${root }/board/list.do?pageNumber=${pageNumber }";
		</script>
	</c:if>
	
	<c:if test="${chk == 0 }">
	<script>
		alert("삭제실패, 비밀번호 확인하세요");
		location.href="${root}/board/list.do?pageNumber=${pageNumber}";
	</script>
	</c:if>
</body>
</html>