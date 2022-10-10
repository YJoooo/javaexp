/*
# 데이터 무결성 제약조건
1. 개념 
	1) 데이터의 정확성과 일관성을 보장
	2) 데이터의 정확성을 유지하여 다양한 종류의 업무규칙 고려한 예
		- student 테이블에서 학년 데이터는 1,2,3,4 중의 하나의 값만 입력
		- 모든 학번은 유일
		- student 테이블의 지도교수 번호는 professor테이블의 교수 번호 중의 하나와 반드시 일치
2. 장점
	1) 테이블 생성시 무결성 제약조건을 정의 가능
	2) 테이블에 대한 정의, 데이터 딕셔너리에 저장되므로 응용 프로그램에서 입력된 모든 데이터에 대해 동일하게 적용
	3) 제약조건을 활성화, 비활성화 할 수 있는 융통성
3. 무결성 제약조건의 종류
	# 제약조건의 이름을 붙일 때는 constraint 제약명
		컬럼명 데이터유형 [constraint 제약명] 제약조건 keyword
		ex) studno number constraint student_no_primary
	1) not null : 열이 null을 포함할 수 없음
	2) 고유키(unique key) : 테이블의 모든 행에서 고유한 값을 갖는 열 또는 열조합을 지정
	3) 기본키(primary key) : 해당 칼럼 값은 반드시 존재해야 하면 유일해야 함
		unique not null 제약조건을 결합한 형태
	4) 참조키(foreign key) : 한열과 참조된 테이블의 열간에 외래 키 관계를 설정하고 시행합니다.
	5) check : 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건 지정.
		- 기본형식
			컬럼명 데이터유형 constraint 제약명 check(컬럼명 in(데이터1,데이터2))	
			cf) check(조건문의 구문)
 */
-- 1. 기본키 생성 예제 : 동일한 데이터 입력 불가, null 입력도 불가
CREATE TABLE sudent01(
	studno char(5) PRIMARY key
);
SELECT * FROM sudent01;
INSERT INTO sudent01 values('10001');
INSERT INTO sudent01 values(null);
-- ex) student02 학생번호, 이름 설정하고, 학생번호는 primary key로 설정하여
--		이름과 함께 데이터를 삽입하세요.
CREATE TABLE student02(
	studno char(5) PRIMARY KEY,
	name char(10)
);
INSERT INTO student02 values('3','홍길동');
SELECT * FROM student02;
--	not null
DROP TABLE 테이블명; -- 테이블 삭제
CREATE TABLE student03(
	studno NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL -- 이름을 NOT null로 설정
);	
SELECT * FROM student03;
INSERT INTO student03 values(1000,'홍길동');
INSERT INTO student03 values(1001,'김길동');
INSERT INTO student03 values(1002,'홍길동');
INSERT INTO student03 values(1003, null); -- 동일한 이름은 가능하나 이름을 꼭 넣어야함
-- ex) student04 테이블에 이름과 국어 점수를 설정하되, 이름과 점수를 not null로 설정하고 데이터 입력을 확인하세요.
CREATE TABLE student04(
	sname varchar2(50) NOT NULL,
	kor NUMBER NOT NULL
);
SELECT * FROM student04;
INSERT INTO student04 values('홍길동',20);
INSERT INTO student04 values(null,20); -- 데이터 없어서 불가
INSERT INTO student04 values('홍길동',null); -- 데이터 없어서 불가
INSERT INTO student04 values('김길동',20);
INSERT INTO student04 values('홍길동',90); -- 같은 데이터는 가능
--	unique : 중복데이터 입력 불가 처리, 단 null은 중복이 가능하다.
CREATE TABLE student05(
	NO NUMBER PRIMARY KEY,
	name varchar(50) NOT NULL,
	civilnumber char(14) unique
);
SELECT * FROM student05;
INSERT INTO student05 values(1000,'홍길동','921212-2801727');
INSERT INTO student05 values(1001,'김길동','931212-2801727');
INSERT INTO student05 values(1002,'신길동','921212-2801727'); -- unique값은 중복이 불가
INSERT INTO student05 values(1003,'오길동',null);
INSERT INTO student05 values(1004,'하길동',null); -- 하지만 null은 중복 가능
INSERT INTO student05 values(1005,'신길동',null);



-- 학생번호 학생명 남녀구분
CREATE TABLE student06(
	NO NUMBER,
	name varchar2(50),
	gender char(1) CONSTRAINT student06_gender_ck check(gender IN('M','F'))
);
INSERT INTO student06 values(1000,'홍길동','M');
INSERT INTO student06 values(1001,'신길동','M');
INSERT INTO student06 values(1002,'홍영자','F');
INSERT INTO student06 values(1003,'하길동',null); -- NULL 입력 가능
INSERT INTO student06 values(1004,'마길동','K'); -- null과 지정된 문자열에서만 가능
SELECT * FROM student06;
-- ex) product22 테이블에 물건번호, 물건명, 등급을 설정하되 등급은 A~C까지만 입력이 가능하도록 한다.
CREATE TABLE product22(
	prono NUMBER PRIMARY KEY,
	pname varchar2(50),
	price NUMBER check(price>=1) -- check(조건문으로 제약설정)
	grade char(1) CONSTRAINT product22_grade_ck check(grade IN('A','B','C'))
);
INSERT INTO product22 values(1,'연필','A');
INSERT INTO product22 values(2,'볼펜','B');
INSERT INTO product22 values(2,'샤프','C'); -- x / PRIMARY KEY 중복 안됨
INSERT INTO product22 values(3,'연필','A');
INSERT INTO product22 values(4,null,'A'); -- 아무것도 제약명 없는경우 NULL 가능, 중복도 가능
INSERT INTO product22 values(4,'지우개',null); -- x / PRIMARY KEY 중복 안됨
INSERT INTO product22 values(5,'연필',null); -- check는 null값 가능
INSERT INTO product22 values(null,'연필',null); -- x / PRIMARY KEY NULL 값 입력 안됨
SELECT * FROM product22;
-- foreign key : 외래키 관계 설정.. - 다른 테이블에 있는 특정 컬럼의 데이터만 입력가능하게 설정 할때, 활용된다.
--	ex) 사원정보의 부서번호는 부서 테이블의 부서번호만 입력이 가능하다.
DROP TABLE professor;
CREATE TABLE professor(
	NO NUMBER PRIMARY key,
	name varchar2(50)
);
INSERT INTO professor values(10,'홍길동');
INSERT INTO professor values(20,'김길동');
INSERT INTO professor values(30,'신길동');
SELECT * FROM professor;
CREATE TABLE student07(
	NO NUMBER,
	name varchar2(50),
	adno NUMBER REFERENCES professor(no)
);
SELECT * FROM student07;
INSERT INTO student07 values(1000,'김영수',10);
INSERT INTO student07 values(1002,'오영수',20);
INSERT INTO student07 values(1003,'한영수',40); -- professor 데이터 중 하나여야 함
