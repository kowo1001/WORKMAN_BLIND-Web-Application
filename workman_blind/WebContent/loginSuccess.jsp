

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<center>
		성공적으로 로그인되었습니다. <br>
		
		<!-- <a href="" >비밀번호 수정</a>
		<a href="" >회원탈퇴</a> -->
		<input type="button" value="메인으로 이동" Onclick="location.href='index.html'">
		<input type="button" value="비밀번호 수정" Onclick="location.href='myinfoUpdate.jsp'">
		<button onclick="location.href='${pageContext.request.contextPath}/workman?id=${Memberlist.Userid}&command=delete'">
				탈퇴하기</button>
		</center>
		

		