<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<%@ page import="java.io.PrintWriter"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 뷰포트 -->

<meta name="viewport" content="width=device-width" initial-scale="1">

<!-- 스타일시트 참조  -->

<link rel="stylesheet" href="css/bootstrap.css">

<title>알바평가게시글 작성</title>
<link href="${pageContext.request.contextPath}/css/textwrite.css" rel="stylesheet">

</head>

<body>
<br><br><br>
<center>
<h3>알바 평가게시글 작성</h3>
	<hr><p>

	<form action="workman" method="post">
		<input type="hidden" name="command" value="PtEvalInsert">
		<table border="1">
			<tr>
				<td>평가글번호</td><td><input type="text" name="Textval"></td>
			</tr>
			<tr>
				<td>글번호</td><td><input type="text" name="Textlist"></td>
			</tr>
			<tr>
				<td>아이디</td><td><input type="text" name="Userid"></td>
			</tr>
			<tr>
				<td>기업명</td><td><input type="text" name="Companyname"></td>
			</tr>
			<tr>
				<td>장단점</td><td><input type="text" name="Proscons"></td>
			</tr>
			<tr>
		 		<td>급여</td><td><input type="text" name="Wage"></td>
			</tr>
			<tr>	
				<td>근무환경</td><td><input type="text" name="Environment"></td>
		 	</tr>
		 	<tr>
		 		<td>관리자성향</td><td><input type="text" name="Incline"></td>
		 	</tr>
		 	<tr>
		 		<td>근무난이도</td><td><input type="text" name="Workdif"></td>
		 	</tr>
		 	<tr>
		 		<td>경험내용</td><td><input type="text" name="Experience"></td>
		 	</tr>
		 	<tr>
		 		<td class="registerbox" colspan="2"><input type="submit" value="글등록">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소"></td>
		 	</tr>  
		</table>
	</form>
	<br><br><br>
	<a href="index.html">메인 화면 이동</a>

</center>
</body>

</html>




<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>test</title>
<link href="${pageContext.request.contextPath}/css/test.css" rel="stylesheet">
</head>
<body>
	
	<div id="Container" class="on">
		<!-- location -->
		<div id="Location">
			<a href="/">홈</a> &gt; <a href="/story/">알바스토리</a> &gt; <strong>알바리뷰</strong>
		</div>
		<!-- //location -->
	
		<!-- 스토리 헤딩 -->
		<div class="head">
			
			<div class="heading albaRepute">
				
			</div>
	
		
		</div>
		<!-- 스토리 헤딩 -->
	
		<div class="reputeDetail on">
			<div class="reputeDetailCompany">
				
	<div class="reputeDetailCompany-name">
		<span class="logoUrl"><img src="//image-logo.alba.kr/%2Fdata%5Fimage2%2Flogo%2Fbrand%2F2017112412030783670%5F1%2Egif" alt=""></span>
		<span class="workcomnm">CU 충정로프랑스점</span>
		<span class="gbnRepute">
			<span class="cntRepute"><span class="icon"></span> 리뷰수 총 <em>1</em>건</span>
			<span class="scoreRepute"><span class="icon" onmouseover="$(this).siblings('.markReputeHelp').show()" onmouseout="$(this).siblings('.markReputeHelp').hide()"></span> 리뷰점수  평균 <em>6</em>점 <span class="markReputeHelp" style="display: none;">작성된 리뷰의 좋아요 수를<br> <strong>10점 만점</strong>으로 표시한 점수입니다.<span></span></span></span>
		</span>
	</div>
	<div class="reputeDetailCompany-state no-data"><span></span>채용중</div>
			</div>
	
			<!-- 평판 리스트 -->
			<div id="ReputeDetailList" class="reputeDetailList">
			<ul class="reputeDetailList-list">
				<li id="ReputeDetailList0">
					<div class="reputeDetailList-list-head">
						<span class="workCareer"><strong>2개월</strong> 근무 경험자 작성</span>
						<span class="regDt">17시간전</span>
					</div>
					<div class="reputeDetailList-list-content">
						<dl class="reputeDetailList-list-dl"><dt><span>•</span> 장단점</dt><dd><em class="positive">근로계약서 작성</em><em class="positive">칼퇴근 가능</em><em class="negative">서있는시간 많음</em></dd><dt><span>•</span> 급여</dt><dd><em class="positive">급여일 준수</em><em class="positive">약속된 급여준수</em></dd><dt><span>•</span> 근무환경</dt><dd><em class="positive">쾌적한 화장실</em></dd><dt><span>•</span> 관리자성향</dt><dd><em class="positive">신뢰할 수 있는</em></dd></dl>
						<ul class="reputeDetailList-list-ul">
							<li class="likecnt"><em>6</em> <span>좋아요</span></li>
							<li class="recomcnt"><a href="#" class="on" onclick="ReputeCLS.setRecomRepute(352060);return false;"><span class="text">도움이 되었나요?</span> <span class="icon"></span><em id="recomcnt_352060">1</em></a></li>
			</ul>
		</div>
	</li>
</ul>
	
	
	<div class="reputeListBtn">
		<a href="/story/repute/ReputeList.asp" class="btn listViewBtn">목록</a>
	</div>
	
	<!-- 채용공고 리스트 -->
	<div id="ReputeJobListLayer" class="displayNone"></div>
	<!-- //채용공고 리스트 -->
	<!-- 평판작성가능기업 리스트 -->
	<div id="ReputeCareerList" class="displayNone"></div>
	<!-- //평판작성가능기업 리스트 -->
	<!-- 포인트사용 -->
	<div id="ReputePointUseLayer" class="displayNone"></div>
	<!-- //포인트사용 --></div>
			<script type="text/javascript">
				ReputeCLS.WORKCOMNM = "CU+%C3%E6%C1%A4%B7%CE%C7%C1%B6%FB%BD%BA%C1%A1";
				ReputeCLS.viewReputeDetailList(1);
			</script>
			<!-- //평판 리스트 -->
		</div>
	</div>
</body>
</html> --%>
