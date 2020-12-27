 -- 회원
DROP TABLE member cascade constraint;

-- 알바 리스트
DROP TABLE parttimelist cascade constraint;

-- 알바 평가 게시판
DROP TABLE parttimeeval cascade constraint;

-- 기업
DROP TABLE company cascade constraint;

DROP SEQUENCE texteval_seq;


CREATE TABLE member (
       userid              VARCHAR2(20)  PRIMARY KEY,
       password            VARCHAR2(20) NOT NULL,
       username            VARCHAR2(20) NOT NULL,
       useremail           VARCHAR2(50) NOT NULL
);

CREATE TABLE parttimelist (
       textlist             NUMBER(10) PRIMARY KEY,
       userid               VARCHAR2(20) NOT NULL,
       enname               VARCHAR2(40) NOT NULL,
       reviewnum   			NUMBER(10) NOT NULL,
       reviewscore          NUMBER(10,1) NOT NULL,
       recruitstatus        VARCHAR2(40) NOT NULL,
       date   				VARCHAR2(50) NOT NULL,
       empperiod   			VARCHAR2(40) NOT NULL
);


CREATE TABLE parttimeeval (
	   texteval             NUMBER(10) PRIMARY KEY,
       textlist             VARCHAR2(50),
       userid      VARCHAR2(20) NOT NULL,
       proscons     VARCHAR2(20) NOT NULL,
       salary   			VARCHAR2(20) NOT NULL,
       environment          VARCHAR2(20) NOT NULL,
       incline        VARCHAR2(20) NOT NULL,
       workdif   VARCHAR2(20) NOT NULL,
       experience   VARCHAR2(50) NOT NULL
);

CREATE TABLE company (
	company_name	varchar2(20)	NOT NULL,
	company_story	CLOB	NULL,
	company_loc	varchar2(40)	NULL,
	company_num	varchar2(20)	NULL
);

CREATE SEQUENCE texteval_seq;

ALTER TABLE probono_project  ADD FOREIGN KEY (receive_id) REFERENCES recipient  (recipient_id);
ALTER TABLE probono_project ADD FOREIGN KEY (activist_id)  REFERENCES activist  (activist_id);
ALTER TABLE probono_project ADD FOREIGN KEY (probono_id) REFERENCES probono  (probono_id);