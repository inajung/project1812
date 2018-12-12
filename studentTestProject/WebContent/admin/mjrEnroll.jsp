<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>신규 전공 등록</h1>
<form action="mjrEnroll.go" method="post">
전공번호: <input type="number" name="major_id">
전공이름: <input type="text" name="major_title">
<input type="submit" value="등록하기">
</form>
</body>
</html>