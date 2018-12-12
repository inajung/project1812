<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function call(studentID){
	ret = confirm("삭제하시겠습니까?");
	if(ret)
	location.href='studentDelete.go?studentID='+studentID;
}

function call2(studentID){
	ret = confirm("수정하시겠습니까?");
	if(ret)
	location.href='studentUpdate.go?studentID='+studentID;
}

</script>
</head>
<body>
	<h1>학생조회결과</h1>
	<h1>학생목록</h1>
	<table border="1">
		<tr>
			<td>학생ID</td>
			<td>학생이름</td>
			<td>전공ID</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>취미</td>
			<td>스킬</td>
			<td>삭제</td>
		 	<td>수정</td>
		</tr>
		<c:forEach items="${studentlist}" var="student">
		<tr>
			<td>${student.studentID}</td> 
			<td>${student.name}</td> 
			<td>${student.major_id}</td>
			<td>${student.phone}</td>
			<td>${student.address}</td>
			<td>${student.hobby}</td>
			<td>${student.skill}</td>
			<td><button onclick="call(${student.studentID});">삭제</button></td>
			<td><button onclick="call2(${student.studentID});">수정</button></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>