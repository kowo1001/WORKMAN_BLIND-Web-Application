# WORKMAN_BLIND Project

---

## PARTTIME-JOB REVIEW

---

> **팀원 : 장종욱, 권희성, 장문희**
>> 
:mag: [엑셀문서링크](https://docs.google.com/spreadsheets/d/19So7A99qJnlKGLl4MukpBJ5gDMmvVqs-dZwoCNEFR7c/edit#gid=0)

:mag: [ERDCLOUD 링크 ](https://www.erdcloud.com/d/4FcQJ7HKsogLmDyL9)

:mag: [카카오 오븐 페이지 설계](https://ovenapp.io/project/VAWmAEwLwYoCOj8CLJ8i0hJKVkupt41v#f5ld6)


---

### :star: WORKMAN_BLIND의 탄생과정
<br><br><br><br>
안녕하세요 알바몬 여러분:smile: 
<br><br><br><br>

다들 돈을 모으기 위해 야심차게 새로운 아르바이트를 구해 출근했다가 

일주일도 안되어, 3일도 안되어, 혹은 반나절만에 탈주한 경험이 있으실겁니다. (저만 그런건 아니겠지요..?:joy:)
<br><br><br><br>


이유는 다양! 

일이 너무 힘들어서:weary:

동료 혹은 사장님이 최악이라:scream:

진상손님이 많아서:rage:
<br><br><br><br>



이럴때 '거기 알바자리 최악이래!:grimacing:' 하고 미리 친구가 알려주었더라면 

우리의 소중한 시간과:clock4: 노동력을:muscle: 세이-브 할수 있었을텐데 말이에요..
<br><br><br><br>



저희 :fire:**WORKMAN_BLIND**:fire:는 바로 이런 서러운 알바몬들의 고충을 해결하기위해 탄생하였답니다!
<br><br><br><br>


아르바이트를 지원하기전에 미리 그 곳에서 근무해봤던 선배들의 후기를 **WORKMAN_BLIND**에서 빠르게 스캔한다음!:eyes::eyes::eyes:

거를곳은 거르고!:no_good: 꿀알바는 누구보다 빠르게 지원하고!:ok_woman:

우리의 신중한 초이스를 도와주는 멋진 친구:two_women_holding_hands:가 되어드리겠습니다. 
<br><br><br><br>

맡겨만 주세요!!:punch::punch::punch:
<br><br><br><br>

---

## :sunny: Service 

---

#### 1. 회원가입 및 로그인 - CREATE

---

1. 로그인 페이지에서 로그인

2. 로그인 성공 페이지 -> 회원정보수정/탈퇴

---

#### 2. 알바 평가게시판 작성 - CREATE

---

1. 회원가입 또는 로그인

2. 알바스토리 클릭 -> 알바리스트 페이지에서 평가 게시글 등록 버튼을 통해 작성

---

#### 3. 알바 검색- READ

---

1. 회원가입 또는 로그인

2. 메인 페이지에서 '알바리뷰' 클릭

3. 알바리스트 페이지로 넘어간다

4. (1-알바리스트페이지 ->알바평가게시판페이지) 지역 검색 -> 지역에 속한 기업 리스트 출력(알바리스트페이지) -> 기업명 클릭시 해당 기업 평가게시판으로 이동

   (2-알바리스트페이지 ->알바평가게시판페이지) 기업명 클릭 -> 기업에 해당하는 알바평가게시판으로 이동

---

#### 4. 알바 평가 게시글에서 내용 수정 - UPDATE

---

1. 회원가입 또는 로그인

2. 아이디로 평가 게시글 검색(본인이 작성한 글 검색) -> 알바 평가 게시판에서 수정하기 버튼 클릭 -> 수정 -> 수정완

---

#### 5. 로그인 성공 페이지에서 비밀번호 수정 - UPDATE

---

1. 회원가입 또는 로그인

2. 비밀번호 수정 버튼 클릭 -> 아이디로 회원 정보 가져오기(아이디, 비밀번호, 이름, 이메일) -> 비밀번호 수정 -> 수정완료

---

#### 6. 알바 평가 게시글 삭제 - DELETE

---

1. 회원가입 또는 로그인

2. 아이디로 평가 게시글 검색(본인이 작성한 글 검색) -> 알바 평가 게시판에서 삭제하기 버튼 클릭 -> 삭제 -> 삭제완료

---

#### 7. 회원 탈퇴 - DELETE

---

1. 회원가입 또는 로그인

2. 로그인 성공 페이지 -> 회원 탈퇴하기 버튼 클릭 -> 회원 탈퇴 완료

---

### :thumbsup: 구현 과정 - 깃허브 프로젝트 기능 이용

![todo](https://user-images.githubusercontent.com/73862504/103252477-74611500-49c0-11eb-9bda-f586027cfe8e.PNG)

---

## :speech_balloon: WORKMAN_BLIND 기능 설명

---

### Structure

![erd](https://user-images.githubusercontent.com/73862504/103251857-ff8cdb80-49bd-11eb-99ca-70a725b0e7a8.png)


---

## SQL TABLE

* DDL

```SQL
-- 회원
DROP TABLE member cascade constraint;

-- 알바 리스트
DROP TABLE parttimelist cascade constraint;

-- 알바 평가 게시판
DROP TABLE parttimeeval cascade constraint;

-- 기업
DROP TABLE company cascade constraint;


CREATE TABLE member (
       user_id                 VARCHAR2(50)  PRIMARY KEY,
       user_pw                 VARCHAR2(50) NOT NULL,
       user_name               VARCHAR2(50) NOT NULL,
       user_email              VARCHAR2(50) NOT NULL,
       company_name	       VARCHAR2(50)
);


CREATE TABLE parttimelist (
       text_list                NUMBER(10) PRIMARY KEY,
       company_name             VARCHAR2(50) NOT NULL,
       user_id		  	VARCHAR2(50) NOT NULL,
       review_num   		NUMBER(10) NOT NULL,
       review_score             NUMBER(10) NOT NULL,
       recruit_status           VARCHAR2(50) NOT NULL,
       regist_date   		VARCHAR2(50) NOT NULL,
       emp_period   		VARCHAR2(50) NOT NULL
);


CREATE TABLE parttimeeval (
	   text_eval            NUMBER(10) PRIMARY KEY,
       text_list                NUMBER(10) NOT NULL,
       user_id      	     	VARCHAR2(50) NOT NULL,
       company_name		VARCHAR2(50) NOT NULL,
       pros_cons     	    	VARCHAR2(50) NOT NULL,
       wage   		        Number(10) NOT NULL,
       environment              VARCHAR2(50) NOT NULL,
       incline          	VARCHAR2(50) NOT NULL,
       work_dif   		VARCHAR2(50) NOT NULL,
       experience   	    	VARCHAR2(4000) NOT NULL
);

CREATE TABLE company (
	company_name	    	VARCHAR2(50)	PRIMARY KEY,
	company_story	    	VARCHAR2(4000)	NOT NULL,
	company_loc		VARCHAR2(100)	NOT NULL,
	company_num		VARCHAR2(50)	NOT NULL
);


ALTER TABLE member  ADD FOREIGN KEY (company_name) REFERENCES company (company_name);
ALTER TABLE parttimelist ADD FOREIGN KEY (user_id)  REFERENCES member (user_id);
ALTER TABLE parttimeeval ADD FOREIGN KEY (text_list) REFERENCES parttimelist (text_list);
```

* DML

```sql
-- company 테이블 기업 저장
insert into company values('CU 충정로프랑스점','기업소개글1','부산광역시 금정구 장전2동 금강로279번길 81-14','010-9280-7637');
insert into company values('GS25대구역자이점','기업소개글2','대구광역시 중구 서성로 99 104동 상가 141호 대구역센트럴자이','010-8920-8402');
insert into company values('이마트 천안서북점 이니스프리','기업소개글3','서북구 삼성대로 20 천안서북점 이니스프리','010-5326-4292');

-- member 테이블 회원 저장
insert into member values('kwon0329','restplease00','권희성','kwon0329@naver.com','CU 충정로프랑스점');
insert into member values('wook999','chukchuk123','장종욱','wook999@gmail.com','GS25대구역자이점');
insert into member values('moon77','lovecat522','장문희','moon77@naver.com','이마트 천안서북점 이니스프리');

-- parttimelist 테이블 알바리스트 저장
insert into parttimelist values(208252,'CU 충정로프랑스점','kwon0329',1,9,'채용중','2시간전','단기');
insert into parttimelist values(208253,'GS25대구역자이점','wook999',2,5,'채용마감','3시간전','장기');
insert into parttimelist values(208254,'이마트 천안서북점 이니스프리','moon77',1,4,'채용중','3시간전','시간제');

-- parttimeeval 테이블 알바평가게시글 저장
insert into parttimeeval values(1,208252,'kwon0329','CU 충정로프랑스점','칼퇴가능','1000000','식사제공','깐깐해요','손님이많아요','경험1');
insert into parttimeeval values(2,208253,'wook999','GS25대구역자이점','근로계약서 작성','1200000','화장실 깨끗','친절해요','일 많아요','경험2');
insert into parttimeeval values(3,208254,'moon77','이마트 천안서북점 이니스프리','계속 서있어야함','900000','교통 편리','화가 많아요','힘쓰는일 많아요','경험3');

commit;
```

---

## :fire: ISSUE

---

#### 1. 일부 팀원에게만 나타나는 404오류

---

깃허브 데스크탑을 이용해 푸쉬한 같은 파일임에도 불구하고 일부 팀원에게만 404에러가 발생했다.

문제의 원인을 찾아보니 각자 탐캣의 경로가 미세하게 달랐던 탓이었고

C:\ITStudy\00.sw\04.WAS\apache-tomcat-8.5.61\lib

다음과 같은 경로로 모두 통일하고

 jsp-api.jar과 servlet-api.jar 의 경로 또한 통일함으로써 해결할 수 있었다. 

---

#### 2. @WebSevlet(/)과 httprequest에 엑박이 뜸

---

jsp-api.jar, servlet-api.jar를 추가헤 해결하였다.

---

#### 3. CSS파일 로드가 되지않음

---

이클립스 상의 탭이 아닌 크롬으로 창을 띄우니 해결되었다.

탭으로 띄울 경우, 업데이트가 반영되지 않거나 느리게 되는 경우가 많기 때문에

꼭 Window - Web browser - Chrome로 설정해 크롬으로 띄우는 것이 안전하다.


그 외에 css 파일 경로 출력해보기, URL 에 직접 css 파일 경로를 넣어보는 방법으로

CSS파일에 오류가 있어서 로드가 안되는건 아닌지 확인해보는 방법이 있다.

---

#### 4. VARCHAR2 vs CLOB 사용 여부

---
게시판 작성 기능을 두고 varchar2보다 더 큰 데이터 타입을 찾았고, 최대 4GB까지 작성가능한 CLOB이라는 걸 알게되었다.

하지만, 시스템상에서 문제가 생길 수 있다는 강사님의 조언에 따라 varchar2를 최대 크기인 4000바이트로 설정했다. -> varchar2(4000)

---

#### 5. JSP 파일 생성 직후 에러

---
- The superclass "javax.servlet.http.HttpServlet" was not found on the Java Build Path


이클립스에 tomcat8.5가 연동이 안되어서 생긴 문제

tomcat 8.5 서버를 이클립스에 연동해서 해결함

---

#### 6. 아쉬웠던 점

---

- **테이블 초기 관계 설정** : 복잡하게 짜여져 코드짤때 어려움이 많았다. 다음부턴 테이블이 서로 하나씩만 참조하도록 설정하면 좀 더 수월할 것이라 생각한다.

- **일관성있는 변수명설정** : 여러명이 각자 파트에서 변수명을 짓다보니 아무래도 일관성이 없어 참조할때 헷갈리는 일이 많았다. 처음부터 규칙을 확실히 정해둬야겠다.

- **DDL, DML** : entity와 순서가 다르게 되어있어 생성 및 추가 시 애를 먹었던 테이블도 있었고 구조가 자주 바뀐 점이 아쉬웠다. 그 과정에서 헷갈려하는 팀원들도 있고 오류도 다소 나온편이라 당연한 말이지만 초기에 확실하게 잡아놓는것이 중요하다고 느꼈다.

---

## ✍️ Author
 Team WORKMAN_BLIND
  - 권희성 [(HeeSeongKwon )](https://github.com/shiningcastle)
  - 장문희 [(MoonheeJang)](https://github.com/JANGMOONHEE)
  - 장종욱 [(JongwookJang)](https://github.com/kowo1001)
 


