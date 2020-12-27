 -- 회원
DROP TABLE member cascade constraint;

-- 알바 리스트
DROP TABLE parttimelist cascade constraint;

-- 알바 평가 게시판
DROP TABLE parttimeeval cascade constraint;

-- 기업
DROP TABLE company cascade constraint;


CREATE TABLE member (
       user_id              VARCHAR2(20)  PRIMARY KEY,
       user_pw            VARCHAR2(20) NOT NULL,
       user_name            VARCHAR2(20) NOT NULL,
       user_email           VARCHAR2(50) NOT NULL,
       company_name			VARCHAR2(20)
);

CREATE TABLE parttimelist (
       text_list             NUMBER(10) PRIMARY KEY,
       company_name               VARCHAR2(40) NOT NULL,
       user_id					VARCHAR2(20) NOT NULL,
       review_num   			NUMBER(10) NOT NULL,
       review_score          NUMBER(10,1) NOT NULL,
       recruit_status        VARCHAR2(40) NOT NULL,
       date   				VARCHAR2(50) NOT NULL,
       emp_period   			VARCHAR2(40) NOT NULL
);


CREATE TABLE parttimeeval (
	   text_eval             NUMBER(10) PRIMARY KEY,
       text_list             VARCHAR2(50) NOT NULL,
       user_id      		VARCHAR2(20) NOT NULL,
       company_name			VARCHAR2(20) NOT NULL,
       pros_cons     		VARCHAR2(20) NOT NULL,
       hourly_wage   		Number(10) NOT NULL,
       environment          VARCHAR2(20) NOT NULL,
       incline        		VARCHAR2(20) NOT NULL,
       work_dif   			VARCHAR2(20) NOT NULL,
       experience   		CLOB NOT NULL
);

CREATE TABLE company (
	company_name		varchar2(20)	NOT NULL,
	company_story		CLOB	NOT NULL,
	company_loc			varchar2(40)	NOT NULL,
	company_num			varchar2(20)	NOT NULL
);


ALTER TABLE member  ADD FOREIGN KEY (company_name) REFERENCES company  (company_name);
ALTER TABLE parttimelist ADD FOREIGN KEY (user_id)  REFERENCES member  (user_id);
ALTER TABLE parttimeeval ADD FOREIGN KEY (text_list) REFERENCES parttimelist  (text_list);
