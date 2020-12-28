<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>로그인 성공 화면</title>
</head>
<body>
<br><br><br>

		<center>
		성공적으로 로그인되었습니다. <br>
		
		
 		안녕하세요^^  ${sessionScope.Member.username} 님!
 	
		
		<input type="button" value="메인으로 이동" Onclick="location.href='index.html'">
		<input type="button" value="비밀번호 수정" Onclick="location.href='myinfoUpdate.jsp'">
		<button onclick="location.href='${pageContext.request.contextPath}/workman?id=${Memberlist.Userid}&command=delete'">
				탈퇴하기</button>
		</center>
		

		