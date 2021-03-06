<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/partTimeEvalView2.css" rel="stylesheet">
</head>
<body id="ReputeList" class="story albaRepute scroll">

   <!-- Container -->
   <div id="Container">
      <!-- location -->
      <div id="Location">
         <a href="/">홈</a> &gt; <strong>알바리뷰</strong>
         <!-- <a href="/">홈</a> &gt; <a href="/story/">알바스토리</a> &gt; <strong>알바리뷰</strong> -->
      </div>
      <!-- //location -->
   
      <!-- 스토리 헤딩 -->
      <div class="head">
         
         <div class="heading albaRepute">
            
            
         </div>
   

      
      
      
      </div>
      <!-- 스토리 헤딩 -->
   
      <div class="reputeList">
         <!-- 작성가능한 리뷰기업목록 -->
         <div id="ReputeCareerList"></div>
         <script type="text/javascript">
         ReputeCLS.viewReputeCareerList();
         </script>
         <!-- //작성가능한 리뷰기업목록 -->
   
         <div class="repute-select">
            <h2 class="repute-select__h2">주요 태그별 리뷰 보기</h2>
            <ul class="repute-select__list">
               <li class="repute-select__list_all on"><a href="/story/repute/ReputeList.asp#ReputeCareerList"><em>전체<br> 리뷰 보기</em></a></li>
               <li><a href="/story/repute/ReputeList.asp?orderby=TAGGROUPCNT1#ReputeCareerList"><em>취업스펙</em><br> 도움 되는 곳</a></li>
               <li><a href="/story/repute/ReputeList.asp?orderby=TAGGROUPCNT2#ReputeCareerList"><em>사회경험</em><br> 쌓기 좋은 곳</a></li>
               <li><a href="/story/repute/ReputeList.asp?orderby=TAGGROUPCNT3#ReputeCareerList"><em>동료</em>들이<br> 좋은 곳</a></li>
               <li><a href="/story/repute/ReputeList.asp?orderby=TAGGROUPCNT4#ReputeCareerList"><em>칼퇴근</em><br> 가능한 곳</a></li>
               <li><a href="/story/repute/ReputeList.asp?orderby=TAGGROUPCNT5#ReputeCareerList"><em>충분한 교육</em><br> 제공하는 곳</a></li>
               
               <li><a href="/story/repute/ReputeList.asp?orderby=TAGGROUPCNT6#ReputeCareerList"><em>친구랑 함께</em><br> 가능한 곳</a></li>
               <li><a href="/story/repute/ReputeList.asp?orderby=TAGGROUPCNT7#ReputeCareerList"><em>편안한 식사</em><br> 보장되는 곳</a></li>
               <li><a href="/story/repute/ReputeList.asp?orderby=TAGGROUPCNT8#ReputeCareerList"><em>급여지급</em><br> 확실한 곳</a></li>
               <li><a href="/story/repute/ReputeList.asp?orderby=TAGGROUPCNT9#ReputeCareerList"><em>근무환경</em><br> 좋은 곳</a></li>
               <li><a href="/story/repute/ReputeList.asp?orderby=TAGGROUPCNT10#ReputeCareerList"><em>관리자가</em><br> 좋은 곳</a></li>
               <li class="repute-select__list_all2"><a href="/story/repute/ReputeList.asp?#ReputeCareerList"><em>전체<br> 리뷰 보기</em></a></li>
            </ul>
            <a href="#" class="repute-select-btn repute-select-prev"><span>이전</span></a>
            <a href="#" class="repute-select-btn repute-select-next"><span>다음</span></a>
         </div>
         <script type="text/javascript">
            if($(".repute-select__list li.on").length == 0){
               $(".repute-select__list_all").addClass("on");
            }
   
            $(".repute-select-next").click(function(e) {
               $(".repute-select__list").stop().animate({
                  marginLeft: "-=1002px"
               }, 500, function() {
                  $(".repute-select__list").css("margin-left","0").append($(".repute-select__list>li:lt(6)"));      
               });
               e.preventDefault();
            });
            $(".repute-select-prev").click(function(e) {
               $(".repute-select__list").prepend($(".repute-select__list>li:gt(5)")).css("margin-left","-1070px");
               $(".repute-select__list").stop().animate({
                  marginLeft: "+=1070px"
               }, 500);
               e.preventDefault();
            });
   
            var objLeft = $(".repute-select__list li.on").position().left;
            var objWidth = $(".repute-select__list").width()/2;
            
            if (objLeft > objWidth) {
               $(".repute-select__list").stop().animate({
                  marginLeft: "-=1002px"
               }, 50, function() {
                  $(".repute-select__list").css("margin-left","0").append($(".repute-select__list>li:lt(6)"));      
               });
            }
         </script>
   
         <form method="get" name="formSrchPublic" id="formSrchPublic" action="/story/repute/ReputeList.asp">
         <div class="searchBox">
            <span>기업명</span>&nbsp;<input type="text" title="기업명 입력" id="schtext" name="schtext" value="" maxlength="50">&nbsp;<input type="submit" class="searchBtn" title="검색" value="검색">
         </div>
         <div class="formList">
            <div class="listTop">
               <!--p class="total">총 <span></span>건</p-->
               <p class="total">
                  <!-- <span class="cntRepute"><span></span> 리뷰수 <em>341,481</em>건</span>
                  <span class="cntCompany"><span></span> 기업수 <em>208,662</em>개</span> 나중에-->
               </p>
            </div>
            <table summary="알바리뷰 기업목록으로 기업의 리뷰정보를 확인할 수 있습니다">
               <caption>알바리뷰 기업목록</caption>
               <thead>
                  <tr>
                     <th scope="col" class="cnt">글번호</th>
                     <th scope="col" class="workcomnm">기업명</th>
                     <th scope="col" class="repcnt"><a href="/story/repute/ReputeList.asp?orderby=REPCNT">리뷰수<img src="//image.alba.kr/story/btn_range_down.gif" alt="내림차순"></a></th>
                     <th scope="col" class="repscore">
                        <div class="wrap">
                           <span class="icon" onmouseover="$(this).siblings('.markReputeHelp').show()" onmouseout="$(this).siblings('.markReputeHelp').hide()"></span> <span class="markReputeHelp" style="display: none;">작성된 리뷰의 좋아요 수를<br> <strong>10점 만점</strong>으로 표시한 점수입니다.<span></span></span>
                           <!--a href="/story/repute/ReputeList.asp?orderby=REPCNT">리뷰점수<img src="//image.alba.kr/story/btn_range_down.gif" alt="내림차순" /></a-->
                           리뷰점수
                        </div>
                     </th>
                     <th scope="col" class="jobing"><a href="/story/repute/ReputeList.asp?orderby=JOBING">채용공고 상태<img src="//image.alba.kr/story/btn_range_down.gif" alt="내림차순"></a></th>
                     <th scope="col" class="lastregymd"><a href="/story/repute/ReputeList.asp?orderby=LASTREGYMD">날짜<img src="//image.alba.kr/story/btn_range_down.gif" alt="내림차순"></a></th>
                  </tr>
               </thead>
               <tbody>
                  <!-- 공지사항 -->
                  
   <!-- <tr class="notice">
      <td class="cnt"><span>공지</span></td>
      <td colspan="5" class="notice-tit"><a href="/story/albastory/Detail.asp?idx=2979"><strong>알바리뷰 작성 안내</strong></a></td>
   </tr> 나중에 -->
                  <!-- //공지사항 -->
                  <!-- 리뷰정보 기업리스트 -->  
   <c:forEach items="${sessionScope.Ptlistall}" var="parttimelist">
	<tr>
		<td class="cnt">${parttimelist.textlist}</td>
		<td class="workcomnm"><a href="partTimeEvalView2.jsp">${parttimelist.companyname.companyname}</td>
		<td class="repcnt"><span class="icon"></span> <span class="text">${parttimelist.reviewnum}</span></td>
		<td class="repscore">${parttimelist.reviewscore}</td>
		<td class="jobing">${parttimelist.recruitstatus}</td>
		<td class="lastregymd">${parttimelist.date}</td>
	</tr>
   </c:forEach>

                  <!-- //리뷰정보 기업리스트 -->
               </tbody>
            </table>
         </div>
         	<div class="writebox"><input type="submit" class="searchBtn" title="글 작성" value="글 작성"></div>
         </form>
         
   		
   
         <!-- 페이징 -->
         <script type="text/javascript">getPagingJob(1, 208662, 20, 10, "");</script><div class="pagenation img img4">
   <span class="page"><a href="?page=1&amp;pagesize=20" class="on">1</a><a href="?page=2&amp;pagesize=20">2</a><a href="?page=3&amp;pagesize=20">3</a><a href="?page=4&amp;pagesize=20">4</a><a href="?page=5&amp;pagesize=20">5</a><a href="?page=6&amp;pagesize=20">6</a><a href="?page=7&amp;pagesize=20">7</a><a href="?page=8&amp;pagesize=20">8</a><a href="?page=9&amp;pagesize=20">9</a><a href="?page=10&amp;pagesize=20">10</a></span><span class="total" onclick="$(this).toggleClass('oneBtn');"><span class="totalBtn"><span class="state">1 / 10434</span><a href="?page=1&amp;pagesize=20" class="first">맨 처음으로</a></span></span><span class="pageBtn"><a href="?page=11&amp;pagesize=20" class="next">&gt;</a>
   </span></div>
         <!-- //페이징 -->

</body>
</html>


