<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function retrieve(){
	var student = document.getElementById("studentID").value;
	var major = document.getElementById("major_id").value;
	var param = "studentID="+student+"&majorid="+major;
	var xhttp = new XMLHttpRequest();
	 xhttp.onreadystatechange = function() { // 서버다녀온 후  해야 할 일. call back함수로 써둔다. result2의 결과가 문자로 온다 
		    if (this.readyState == 4 && this.status == 200) { //4도착했음 200정상적으로 --> 정상적으로 다 끝났음
		      document.getElementById("here").innerHTML = this.responseText;
		    }
		  };
		  xhttp.open("GET", "infolist2.go?"+param); //서버로 출발 준비
		  xhttp.send(); //출발
}

</script>

</head>
<body>
	<hr>
	학생이름:
	<select id="studentID" name="studentID">
		<option value="0">학생전체</option>
		<c:forEach var="student" items="${studentlist}">
			<option value=${student.studentID}>${student.name}</option>
		</c:forEach>
	</select> 전공이름:
	<select id="major_id" name="major_id">
		<option value="0">전공전체</option>
		<c:forEach var="major" items="${majorlist}">
			<option value=${major.major_id}>${major.major_title}</option>
		</c:forEach>
	</select>
	<button onclick="retrieve();">조회</button>
	
	<hr>
	<h1>학생 목록</h1>
	<div id="here">
		<table border="1">
			<tr class="head">
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
	</div>
</body>
</html>