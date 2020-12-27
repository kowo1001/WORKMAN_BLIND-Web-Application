 -- ȸ��
DROP TABLE member cascade constraint;

-- �˹� ����Ʈ
DROP TABLE parttimelist cascade constraint;

-- �˹� �� �Խ���
DROP TABLE parttimeeval cascade constraint;

-- ���
DROP TABLE enterprise cascade constraint;

DROP SEQUENCE texteval_seq;


CREATE TABLE member (
       userid             VARCHAR2(20)  PRIMARY KEY,
       password                  VARCHAR2(20) NOT NULL,
       username            VARCHAR2(20) NOT NULL,
       useremail                   VARCHAR2(50) NOT NULL
);

CREATE TABLE parttimelist (
       textlist              number(10) PRIMARY KEY,
       userid               VARCHAR2(20) NOT NULL,
       enname               VARCHAR2(40) NOT NULL,
       reviewnum   			NUMBER(10) NOT NULL,
       reviewscore          NUMBER(10,1) NOT NULL,
       recruitstatus        VARCHAR2(40) NOT NULL,
       date   VARCHAR2(50) NOT NULL,
       empperiod   VARCHAR2(40) NOT NULL
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

CREATE SEQUENCE texteval_seq;


ALTER TABLE probono_project  ADD FOREIGN KEY (receive_id) REFERENCES recipient  (recipient_id);
ALTER TABLE probono_project ADD FOREIGN KEY (activist_id)  REFERENCES activist  (activist_id);
ALTER TABLE probono_project ADD FOREIGN KEY (probono_id) REFERENCES probono  (probono_id);