<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전공 수정</h1>
<form action="majorUpdate.go" method="post">
전공번호: <input type="number" name="major_id" value="${major.major_id}">
전공이름: <input type="text" name="major_title" value="${major.major_title}">
<input type="submit" value="수정하기">
</form>
</body>
</html>