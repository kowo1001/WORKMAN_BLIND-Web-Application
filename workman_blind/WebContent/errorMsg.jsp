<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Error Message</title>
</head>
<body>

	<br><br><br>

	<center>
		<h3>${requestScope.errorMsg}</h3>
			
		<br><br><br>
		<a href="${pageContext.request.contextPath}/index.html">���� ȭ������ �̵��ϱ�</a>
	</center>
	
</body>
</html>

