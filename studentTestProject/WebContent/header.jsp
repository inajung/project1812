<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!-- if문을 실제 사용하기 위해 태그라이브러리 사용 JSTL문법사용 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.emp==null}">
  <a href="${pageContext.request.contextPath}/login/sign.go">로그인</a>
</c:if>
<c:if test="${sessionScope.emp!=null}">
  ${sessionScope.emp.first_name}${sessionScope.emp.last_name}고객님
  <a href="${pageContext.request.contextPath}/login/signOut.go">로그아웃</a>
</c:if>	  

