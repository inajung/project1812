<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="sign.go" method="post">
사용자이름:<input type="text" name="userid" required><br>
비밀번호: <input type="password" name="userpass" required><br>
<input type="submit" value="로그인하기">
</form>
${signMessage}

</body>
</html>