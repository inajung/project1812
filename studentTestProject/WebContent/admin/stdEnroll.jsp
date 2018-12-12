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

<h1>신규 학생 등록</h1>
<form action="stdEnroll.go" method="post">
학생번호: <input type="number" name="student_id">
학생이름: <input type="text" name="name">
전공번호: 
<select name="major_id"> 
	<c:forEach var="major" items="${majorlist}"> 
		<option value=${major.major_id}> ${major.major_title}</option>
	</c:forEach>	
</select>
전화번호: <input type="text" name="phone">
주소: <input type="text" name="address">
취미: <input type="text" name="hobby">
스킬: <input type="text" name="skill">
<input type="submit" value="등록하기">

</form>
</body>
</html>