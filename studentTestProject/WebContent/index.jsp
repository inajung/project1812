<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>내 정보관리</h1>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<ol>
<li><a href="${path}/student/InfoView.go">학생정보조회</a></li>
<li><a href="${path}/student/myInfoUpdate.go">내 정보수정 </a></li>
</ol>

</body>
</html>