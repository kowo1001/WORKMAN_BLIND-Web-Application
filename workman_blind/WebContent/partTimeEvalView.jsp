<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알바평가</title>
<link href="${pageContext.request.contextPath}/css/evalview.css" rel="stylesheet">
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
				<section1>
					<box1>
						<div class="reputeDetatilCompany-name">
							<span class="logoURL">
								<img src="//image-logo.alba.kr/%2Fdata%5Fimage2%2Flogo%2Fbrand%2F2017112412030783670%5F1%2Egif" alt>
							</span>
							<span class="textarea">
								CU 충정로프랑스점
								${sessionScope.allPartTimeEval.companyname}
							</span>
						</div>
					</box1>
					<box2>
						<div class="reputeDetailCompany-state">채용중</div>
					</box2>
				</section1>
			<hr>
				<section2>
				<h2>3개월 근무 경험자 작성</h2>
				<div id="ReputeDetailList" class="reputeDetailList">
					<ul class="reputeDetailList-list">
						<li id="ReputeDetailList0">
							<div class="reputeDetailList-list-head">
								<span class="workCareer"><strong>2개월</strong> 근무 경험자 작성</span>
								<span class="regDt">13시간전</span>
							</div>
							<div class="reputeDetailList-list-content">
								<dl class="reputeDetailList-list-dl">
								<dt>
									<span>•</span> 장단점
								</dt>
								<dd>
									<em class="positive">${sessionScope.allPartTimeEval.proscons}</em>
								</dd>
								<dt>
									<span>•</span> 급여
								</dt>
								<dd>
									<em class="positive">${sessionScope.allPartTimeEval.wage}</em>
								</dd>
								<dt>
									<span>•</span> 근무환경
								</dt>
								<dd>
									<em class="positive">${sessionScope.allPartTimeEval.environment}</em>
								</dd>
									<dt><span>•</span> 관리자성향</dt>
								<dd>
									<em class="positive">${sessionScope.allPartTimeEval.incline}</em>
								</dd>
								</dl>
								<ul class="reputeDetailList-list-ul">
									<li class="likecnt"><em>6</em> <span>좋아요</span></li>
									<li class="recomcnt"><a href="#" class="" onclick="ReputeCLS.setRecomRepute(352060);return false;">
								<span class="text">도움이 되었나요?</span>
								<span class="icon"></span>
									<em id="recomcnt_352060">0</em>
								</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				</section2>
			<hr>
	</main>

	<footer>
        <address>
            <a href="mailto:thesecon@gmail.com">kowo1001@gmail.com</a>
            <a href="tel:+821012345678">010-1234-5678</a>
        </address>
    </footer>
</body>
</html>




