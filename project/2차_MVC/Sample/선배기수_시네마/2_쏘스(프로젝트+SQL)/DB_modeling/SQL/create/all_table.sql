/*필수적인 아이들*/

/* 회원 */
CREATE TABLE MEMBER (
	EMAIL VARCHAR2(70) NOT NULL, /* 이메일 */
	NAME VARCHAR(50) NOT NULL, /* 이름 */
	PWD VARCHAR2(30) NOT NULL /* 비밀번호 */
);
ALTER TABLE MEMBER ADD CONSTRAINT PK_MEMBER PRIMARY KEY (EMAIL);

/* 장르 */
CREATE TABLE GENRE (
	GENRE_ID NUMBER(2) NOT NULL, /* 장르코드 */
	GENRE_NAME VARCHAR2(20) NOT NULL, /* 장르이름 */
	GENRE_PIC VARCHAR2(100)
);
ALTER TABLE GENRE ADD CONSTRAINT PK_GENRE PRIMARY KEY (GENRE_ID);
ALTER TABLE GENRE ADD CONSTRAINT UQ_GENRE UNIQUE (GENRE_NAME);
CREATE SEQUENCE GENRE_SEQ START WITH 0 MINVALUE 0 MAXVALUE 99 INCREMENT BY 1 NOCACHE;


/* 배우 */
CREATE TABLE ACTOR (
	ACTOR_ID NUMBER NOT NULL, /* 배우코드 */
	ACTOR_NAME VARCHAR2(80) NOT NULL, /* 배우이름 */
	ACTOR_PIC VARCHAR2(100) NOT NULL 
);
ALTER TABLE ACTOR ADD CONSTRAINT PK_ACTOR PRIMARY KEY (ACTOR_ID);
CREATE SEQUENCE ACTOR_SEQ START WITH 0 MINVALUE 0 INCREMENT BY 1 NOCACHE;

/* 감독 */
CREATE TABLE DIRECTOR (
	DIRECTOR_ID NUMBER NOT NULL, /* 감독코드 */
	DIRECTOR_NAME VARCHAR2(80) NOT NULL, /* 감독이름 */
	DIRECTOR_PIC VARCHAR2(100) NOT NULL
);
ALTER TABLE DIRECTOR ADD CONSTRAINT PK_DIRECTOR PRIMARY KEY (DIRECTOR_ID);
CREATE SEQUENCE DIRECTOR_SEQ START WITH 0 MINVALUE 0 INCREMENT BY 1 NOCACHE;

/* 소재 */
CREATE TABLE MATERIAL (
	MATERIAL_ID NUMBER(2) NOT NULL, /* 소재코드 */
	MATERIAL_NAME VARCHAR2(20) NOT NULL, /* 소재이름 */
	MATERIAL_PIC VARCHAR2(100)
);
ALTER TABLE MATERIAL ADD CONSTRAINT PK_MATERIAL	PRIMARY KEY (MATERIAL_ID);
ALTER TABLE MATERIAL ADD CONSTRAINT UQ_MATERIAL UNIQUE (MATERIAL_NAME);
CREATE SEQUENCE MATERIAL_SEQ START WITH 0 MINVALUE 0 MAXVALUE 99 INCREMENT BY 1 NOCACHE;

/* 영화 */
CREATE TABLE FILM (
	FILM_ID NUMBER NOT NULL, /* 영화코드 */
	FILM_TITLE VARCHAR2(80) NOT NULL, /* 영화제목 */
	FILM_TITLE_ENG VARCHAR2(80) NOT NULL,
	FILM_CONTENT VARCHAR2(3000) NOT NULL, /* 새 컬럼 */
	GENRE_ID NUMBER(2), /* 장르코드 */
	MATERIAL_ID NUMBER(2) , /* 소재코드 */
	DIRECTOR_ID NUMBER, /* 감독코드 */
	ACTOR_ID1 NUMBER, /* 배우코드 */
	ACTOR_ID2 NUMBER, /* 배우코드2 */
	ACTOR_ID3 NUMBER, /* 배우코드3 */
	FILM_POSTER VARCHAR2(100) constraint UQ_FILM2 UNIQUE, /* 포스터 */
	FILM_GRADE_NAVER NUMBER(3,1) DEFAULT 0 NOT NULL, /* 평점 */
	RUNNING_TIME NUMBER DEFAULT 0 NOT NULL,/* 러닝타임 */
	GENRE_NAME VARCHAR2(20 BYTE),
	MATERIAL_NAME VARCHAR2(20 BYTE),
	DIRECTOR_NAME VARCHAR2(80 BYTE),
	ACTOR_NAME1 VARCHAR2(80 BYTE),
	ACTOR_NAME2 VARCHAR2(80 BYTE),
	ACTOR_NAME3 VARCHAR2(80 BYTE)
);
ALTER TABLE FILM ADD CONSTRAINT PK_FILM PRIMARY KEY (FILM_ID);
ALTER TABLE FILM ADD CONSTRAINT UQ_FILM UNIQUE (FILM_TITLE);
CREATE SEQUENCE FILM_SEQ START WITH 0 MINVALUE 0 INCREMENT BY 1 NOCACHE;

---------------------------------------------------------------------------------------
/*취향들*/
/* 취향장르 */
CREATE TABLE GENRE_FAVOR (
	EMAIL VARCHAR2(70) NOT NULL, /* 이메일 */
	NO_1 NUMBER(2), /* 첫째 */
	NO_2 NUMBER(2), /* 둘째 */
	NO_3 NUMBER(2) /* 셋째 */
);
ALTER TABLE GENRE_FAVOR	ADD CONSTRAINT PK_GENRE_FAVOR PRIMARY KEY (EMAIL);

/* 취향배우 */
CREATE TABLE ACTOR_FAVOR (
	EMAIL VARCHAR2(70) NOT NULL, /* 이메일 */
	NO_1 NUMBER, /* 배우코드 */
	NO_2 NUMBER, /* 배우코드2 */
	NO_3 NUMBER /* 배우코드3 */
);
ALTER TABLE ACTOR_FAVOR ADD CONSTRAINT PK_ACTOR_FAVOR PRIMARY KEY (EMAIL);

/* 취향감독 */
CREATE TABLE DIRECTOR_FAVOR (
	EMAIL VARCHAR2(70) NOT NULL, /* 이메일 */
	NO_1 NUMBER, /* 감독코드 */
	NO_2 NUMBER, /* 감독코드2 */
	NO_3 NUMBER /* 감독코드3 */
);
ALTER TABLE DIRECTOR_FAVOR ADD CONSTRAINT PK_DIRECTOR_FAVOR PRIMARY KEY (EMAIL);

/* 취향소재 */
CREATE TABLE MATERIAL_FAVOR (
	EMAIL VARCHAR2(70) NOT NULL, /* 이메일 */
	NO_1 NUMBER(2), /* 소재코드 */
	NO_2 NUMBER(2), /* 소재코드2 */
	NO_3 NUMBER(2) /* 소재코드3 */
);
ALTER TABLE MATERIAL_FAVOR ADD CONSTRAINT PK_MATERIAL_FAVOR PRIMARY KEY (EMAIL);
--------------------------------------------------------------------------------------

/*게시판들*/

/* 영화평 */
CREATE TABLE FILM_REVIEW (
	FILM_ID NUMBER NOT NULL, /* 영화코드 */
	REVIEW_WRITER VARCHAR2(70) NOT NULL,/* 이메일 */
	REVIEW_CONTENT VARCHAR2(3000) NOT NULL, /* 댓글내용 */
	WRITEDATE TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL, /* 작성시간 */
	REVIEW_GRADE NUMBER(3,1) DEFAULT 0 NOT NULL/* 평점 */
);
ALTER TABLE FILM_REVIEW ADD CONSTRAINT PK_FILM_REVIEW PRIMARY KEY (FILM_ID,REVIEW_WRITER);
CREATE SEQUENCE REVIEW_SEQ START WITH 0 MINVALUE 0 INCREMENT BY 1 NOCACHE;

/* 게시판_큐레이팅 */
CREATE TABLE CURATING_BOARD (
	NO NUMBER NOT NULL, /* 글번호 */
	SUBJECT VARCHAR2(200) NOT NULL, /* 글제목 */
	CONTENT VARCHAR2(3000) NOT NULL, /* 글내용 */
	WRITEDATE DATE DEFAULT SYSDATE NOT NULL, /* 작성시간 */
	YOUTUBEURL VARCHAR2(300) NOT NULL
);
ALTER TABLE CURATING_BOARD ADD CONSTRAINT PK_CURATING_BOARD PRIMARY KEY (NO);
CREATE SEQUENCE CURATING_SEQ START WITH 0 MINVALUE 0 INCREMENT BY 1 NOCACHE;

-------------------------------------------------------------------------------------

/*foregin key들*/
ALTER TABLE GENRE_FAVOR	ADD CONSTRAINT FK_GENRE_FAVOR FOREIGN KEY (EMAIL)
	REFERENCES MEMBER (EMAIL) ON DELETE CASCADE;

ALTER TABLE GENRE_FAVOR	ADD CONSTRAINT FK_GENRE_FAVOR2
		FOREIGN KEY (NO_1) REFERENCES GENRE (GENRE_ID) ON DELETE CASCADE;

ALTER TABLE GENRE_FAVOR	ADD CONSTRAINT FK_GENRE_FAVOR3
		FOREIGN KEY (NO_2) REFERENCES GENRE (GENRE_ID) ON DELETE CASCADE;

ALTER TABLE GENRE_FAVOR	ADD CONSTRAINT FK_GENRE_FAVOR4
		FOREIGN KEY (NO_3) REFERENCES GENRE (GENRE_ID) ON DELETE CASCADE;

ALTER TABLE ACTOR_FAVOR	ADD CONSTRAINT FK_ACTOR_FAVOR
		FOREIGN KEY (EMAIL) REFERENCES MEMBER (EMAIL) ON DELETE CASCADE;

ALTER TABLE ACTOR_FAVOR ADD CONSTRAINT FK_ACTOR_FAVOR2
		FOREIGN KEY (NO_1) REFERENCES ACTOR (ACTOR_ID) ON DELETE CASCADE;

ALTER TABLE ACTOR_FAVOR	ADD CONSTRAINT FK_ACTOR_FAVOR3
		FOREIGN KEY (NO_2) REFERENCES ACTOR (ACTOR_ID) ON DELETE CASCADE;

ALTER TABLE ACTOR_FAVOR	ADD CONSTRAINT FK_ACTOR_FAVOR4
		FOREIGN KEY (NO_3) REFERENCES ACTOR (ACTOR_ID) ON DELETE CASCADE;

ALTER TABLE DIRECTOR_FAVOR ADD CONSTRAINT FK_DIRECTOR_FAVOR
		FOREIGN KEY (EMAIL) REFERENCES MEMBER (EMAIL) ON DELETE CASCADE;

ALTER TABLE DIRECTOR_FAVOR ADD CONSTRAINT FK_DIRECTOR_FAVOR2
		FOREIGN KEY (NO_1) REFERENCES DIRECTOR (DIRECTOR_ID) ON DELETE CASCADE;

ALTER TABLE DIRECTOR_FAVOR ADD CONSTRAINT FK_DIRECTOR_FAVOR3
		FOREIGN KEY (NO_2) REFERENCES DIRECTOR (DIRECTOR_ID) ON DELETE CASCADE;

ALTER TABLE DIRECTOR_FAVOR ADD CONSTRAINT FK_DIRECTOR_FAVOR4
		FOREIGN KEY (NO_3) REFERENCES DIRECTOR (DIRECTOR_ID) ON DELETE CASCADE;

ALTER TABLE MATERIAL_FAVOR ADD CONSTRAINT FK_MATERIAL_FAVOR
		FOREIGN KEY (EMAIL) REFERENCES MEMBER (EMAIL) ON DELETE CASCADE;

ALTER TABLE MATERIAL_FAVOR ADD CONSTRAINT FK_MATERIAL_FAVOR2
		FOREIGN KEY (NO_1) REFERENCES MATERIAL (MATERIAL_ID) ON DELETE CASCADE;

ALTER TABLE MATERIAL_FAVOR ADD CONSTRAINT FK_MATERIAL_FAVOR3
		FOREIGN KEY (NO_2) REFERENCES MATERIAL (MATERIAL_ID) ON DELETE CASCADE;

ALTER TABLE MATERIAL_FAVOR ADD CONSTRAINT FK_MATERIAL_FAVOR4
		FOREIGN KEY (NO_3) REFERENCES MATERIAL (MATERIAL_ID) ON DELETE CASCADE;

ALTER TABLE FILM ADD CONSTRAINT FK_FILM FOREIGN KEY (GENRE_ID)
		REFERENCES GENRE (GENRE_ID) ON DELETE CASCADE;

ALTER TABLE FILM ADD CONSTRAINT FK_FILM2 FOREIGN KEY (ACTOR_ID1)
		REFERENCES ACTOR (ACTOR_ID) ON DELETE CASCADE;

ALTER TABLE FILM ADD CONSTRAINT FK_FILM3 FOREIGN KEY (ACTOR_ID2)
		REFERENCES ACTOR (ACTOR_ID) ON DELETE CASCADE;

ALTER TABLE FILM ADD CONSTRAINT FK_FILM4 FOREIGN KEY (ACTOR_ID3)
		REFERENCES ACTOR (ACTOR_ID) ON DELETE CASCADE;

ALTER TABLE FILM ADD CONSTRAINT FK_FILM5 FOREIGN KEY (DIRECTOR_ID)
		REFERENCES DIRECTOR (DIRECTOR_ID) ON DELETE CASCADE;

ALTER TABLE FILM ADD CONSTRAINT FK_FILM6 FOREIGN KEY (MATERIAL_ID)
		REFERENCES MATERIAL (MATERIAL_ID) ON DELETE CASCADE;

ALTER TABLE FILM_REVIEW	ADD CONSTRAINT FK_FILM_REVIEW FOREIGN KEY (FILM_ID)
		REFERENCES FILM (FILM_ID) ON DELETE CASCADE;

ALTER TABLE FILM_REVIEW ADD CONSTRAINT FK_FILM_REVIEW2 
		FOREIGN KEY (REVIEW_WRITER) REFERENCES MEMBER (EMAIL) ON DELETE CASCADE;

commit;