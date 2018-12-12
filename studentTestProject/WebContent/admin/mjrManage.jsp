<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function call(major_id){
	ret = confirm("삭제하시겠습니까?");
	if(ret)
	location.href='majorDelete.go?major_id='+major_id;
}

function call2(major_id){
	ret = confirm("수정하시겠습니까?");
	if(ret)
	location.href='majorUpdate.go?major_id='+major_id;
}

</script>

</head>
<body>
<h1>전공조회결과</h1>
	<table border="1">
		<tr>
		 <td>전공번호</td>
		 <td>전공이름</td>
		 <td>삭제</td>
		 <td>수정</td>
		</tr>
	<c:forEach items="${majorlist}" var="major">
		<tr>
			<td>${major.major_id}</td>
			<td>${major.major_title}</td>
			<td><button onclick="call(${major.major_id});">삭제</button></td>
			<td><button onclick="call2(${major.major_id});">수정</button></td>
		</tr>
	</c:forEach>
	</table>


</body>
</html>