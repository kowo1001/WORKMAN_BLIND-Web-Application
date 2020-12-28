# WORKMAN_BLIND Project

---

## PARTTIME-JOB REVIEW

---

> 팀원 : 장종욱, 권희성, 장문희

---

### WORKMAN_BLIND의 탄생과정

안녕하세요! 다들 돈을 모으기 위해 야심차게 새로운 아르바이트를 구해 출근했다가 일주일도 안되어, 3일도 안되어, 혹은 반나절만에 탈주한 경험이 있으실겁니다. (저만 그런건 아니겠지요..?)

이유는 다양할거예요~ 일이 너무 힘들어서, 동료 혹은 사장님의 성격이 최악이라, 진상손님이 많아서..

이럴때 '거기 알바자리 최악이래!' 하고 친구가 알려주었더라면 우리의 소중한 시간과 노동력을 세이-브 할수 있었을텐데 말이에요..

저희 **WORKMAN_BLIND**는 바로 이런 서러운 알바몬들의 고충을 해결하기위해 탄생하였답니다!

아르바이트를 지원하기전에 미리 그 곳에서 근무해봤던 선배들의 후기를 **WORKMAN_BLIND**에서 빠르게 스캔한다음!

거를곳은 거르고! 꿀알바는 누구보다 빠르게 지원하고! 

우리의 신중한 초이스를 도와주는 멋진 친구가 되어드리겠습니다. 맡겨만 주세요!!


---

## Service 

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

## WORKMAN_BLIND 기능 설명

---

### Structure

<div>
    <img width="800" src="https://mail.naver.com/read/image/?mailSN=10689&attachIndex=2&contentType=image/png&offset=1383&size=243896&mimeSN=1609182268.742215.29085.55040&org=1&u=janghee234">
</div>

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
       company_name			   VARCHAR2(50)
);


CREATE TABLE parttimelist (
       text_list                NUMBER(10) PRIMARY KEY,
       company_name             VARCHAR2(50) NOT NULL,
       user_id			        VARCHAR2(50) NOT NULL,
       review_num   		    NUMBER(10) NOT NULL,
       review_score             NUMBER(10) NOT NULL,
       recruit_status           VARCHAR2(50) NOT NULL,
       regist_date   		    VARCHAR2(50) NOT NULL,
       emp_period   		    VARCHAR2(50) NOT NULL
);


CREATE TABLE parttimeeval (
	   text_eval                NUMBER(10) PRIMARY KEY,
       text_list                NUMBER(10) NOT NULL,
       user_id      	     	VARCHAR2(50) NOT NULL,
       company_name		    	VARCHAR2(50) NOT NULL,
       pros_cons     	    	VARCHAR2(50) NOT NULL,
       wage   		            Number(10) NOT NULL,
       environment              VARCHAR2(50) NOT NULL,
       incline          		VARCHAR2(50) NOT NULL,
       work_dif   		     	VARCHAR2(50) NOT NULL,
       experience   	    	VARCHAR2(4000) NOT NULL
);

CREATE TABLE company (
	company_name	    	VARCHAR2(50)	PRIMARY KEY,
	company_story	    	VARCHAR2(4000)	NOT NULL,
	company_loc		    	VARCHAR2(100)	NOT NULL,
	company_num		      	VARCHAR2(50)	NOT NULL
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

## ISSUE
<div> 


