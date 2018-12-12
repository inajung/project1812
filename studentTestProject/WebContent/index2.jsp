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

<h1>학생관리</h1>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<ol>
<li><a href="${path}/admin/DbUpload.go">csv파일을 DB에 저장</a></li>
<li><a href="${path}/admin/mjrManage.go">major 조회하기...상세보기를 통해 수정과 삭제도 가능  </a></li>
<li><a href="${path}/admin/mjrEnroll.go">major 등록하기</a></li>
<li><a href="${path}/admin/stdManage.go">student 조회하기...상세보기를 통해 수정과 삭제도 가능</a></li>
<li><a href="${path}/admin/stdEnroll.go">student 등록하기</a></li>
</ol>


</body>
</html>


