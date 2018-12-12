<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생 수정</h1>
<form action="myInfoUpdate.go" method="post">
학생ID: <input type="number" name="student_id" value="${major.major_id}">
학생이름: <input type="text" name="name">
전공ID:  <input type="number" name="major_id">
전화번호: <input type="text" name="phone">
주소: <input type="text" name="address">
취미: <input type="text" name="hobby">
스킬: <input type="text" name="skill">
			
<input type="submit" value="수정하기">
</form>
</body>
</html>
