/* 부서 */
CREATE TABLE DEPT (
	DEPTNO NUMBER(2) NOT NULL, /* 부서번호 */
	DNAME VARCHAR2(14), /* 부서이름 */
	LOC VARCHAR2(13) /* 지역 */
);

COMMENT ON TABLE DEPT IS '부서';

COMMENT ON COLUMN DEPT.DEPTNO IS '부서번호';

COMMENT ON COLUMN DEPT.DNAME IS '부서이름';

COMMENT ON COLUMN DEPT.LOC IS '지역';

CREATE UNIQUE INDEX PK_DEPT
	ON DEPT (
		DEPTNO ASC
	);

ALTER TABLE DEPT
	ADD
		CONSTRAINT PK_DEPT
		PRIMARY KEY (
			DEPTNO
		);

/* 사원 */
CREATE TABLE EMP (
	EMPNO NUMBER(4) NOT NULL, /* 사원번호 */
	ENAME VARCHAR2(10), /* 사원이름 */
	JOB VARCHAR2(9), /* 직업 */
	MGR NUMBER(4), /* 관리자 */
	HIREDATE DATE, /* 입사일 */
	SAL NUMBER(7,2), /* 급여 */
	COMM NUMBER(7,2), /* 커미션 */
	DEPTNO NUMBER(2) /* 부서번호 */
);

COMMENT ON TABLE EMP IS '사원';

COMMENT ON COLUMN EMP.EMPNO IS '사번';

COMMENT ON COLUMN EMP.ENAME IS '이름';

COMMENT ON COLUMN EMP.JOB IS '직업';

COMMENT ON COLUMN EMP.MGR IS '관리자';

COMMENT ON COLUMN EMP.HIREDATE IS '입사일';

COMMENT ON COLUMN EMP.SAL IS '급여';

COMMENT ON COLUMN EMP.COMM IS '커미션';

COMMENT ON COLUMN EMP.DEPTNO IS '부서번호';

CREATE UNIQUE INDEX PK_EMP
	ON EMP (
		EMPNO ASC
	);

ALTER TABLE EMP
	ADD
		CONSTRAINT PK_EMP
		PRIMARY KEY (
			EMPNO
		);

ALTER TABLE EMP
	ADD
		CONSTRAINT FK_DEPT_TO_EMP
		FOREIGN KEY (
			DEPTNO
		)
		REFERENCES DEPT (
			DEPTNO
		);