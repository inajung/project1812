<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<table border="1">
		<tr>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>전공번호</td>
			<td>취미</td>
		</tr>
		<c:forEach items="${studentlist}" var="student">
			<tr>
				<td>${student.studentID}</td>
				<td>${student.name}</td>
				<td>${student.major_id}</td>
				<td>${student.hobby}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>