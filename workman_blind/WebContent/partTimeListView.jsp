<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알바리스트</title>
<link href="${pageContext.request.contextPath}/css/listview.css" rel="stylesheet">
</head>

<body>
	<header>
        <nav>
            <ul>
                <li>알바스토리</li>
                <li>기업스토리</li>
                <li>알바리뷰</li>
                <li>이력서 등록/관리</li>
                <li>지원관리</li>
            </ul>
        </nav>
    </header>
   
	<main>
		<h3>알바 리스트</h3>
			<section>
				<div>기업명 &nbsp;&nbsp;<input type="text" name="companyname"></div>
				<center>					
				<table border="1">
					<tr>
						<th>글번호</th><th>기업명</th><th>리뷰수</th><th>리뷰점수</th><th>채용공고 상태</th><th>날짜</th><th>근무기간</th>
					</tr>
					
					 	
					<c:forEach items="${sessionScope.allPartTimeList}" var="list">
					<tr>
						<td>${list.textlist}</td>
						<td>${list.companyname}</td>
						<td>${list.reviewnum}</td>
				 		<td>${list.reviewscore}</td>
				 		<td>${list.recruitstatus}</td>
				 		<td>${list.date}</td>
				 		<td>${list.empperiod}</td>
				 	</tr>
				 	</c:forEach>
				</table>
				&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">메인 화면 이동</a>
				</center>
			</section>
	</main>

	<footer>
        <address>
            <a href="mailto:thesecon@gmail.com">kowo1001@gmail.com</a>
            <a href="tel:+821012345678">010-1234-5678</a>
        </address>
    </footer>
</body>
</html>
