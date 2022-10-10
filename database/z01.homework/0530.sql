--2022-05-30
--[1단계:개념] 1. sequence를 사용하는 이유와 기본형식을 예제를 통해서 기술하세요.
 CREATE SEQUENCE sqe10
 INCREMENT BY 1
 START WITH 1
 nomaxvalue -- 최대값 무한대
 MINVALUE 1;
 SELECT sqe10.nextval FROM dual; -- 규칙에따라 키값 자동 생성
--[1단계:확인] 2. 회원테이블은 만들고, 회원번호가 'N'(일반), 'S'(수퍼고객), 'A'(관리자)
--      가 붙어서 N1000, S1001, A1002 형식으로 시퀀스와 조합해서 만들어 진다고 한다.
--      회원번호, 회원아이디, 회원명, 회원패스워드로 구성된 테이블과 각각
--      권한에 따를 번호를 입력하세요.
 DROP SEQUENCE member1;
 CREATE SEQUENCE member1
 INCREMENT BY 1
 START WITH 1000
 nomaxvalue
 MINVALUE 1000;
DROP TABLE member11;
CREATE TABLE member11(
	mno char(5) PRIMARY KEY,
	mid varchar2(50),
	mname varchar2(20),
	mpass varchar2(50)
);
INSERT INTO member11 VALUES('N'||member1.nextval, 'hong012','홍길동','hong002');
INSERT INTO member11 VALUES('S'||member1.nextval, 'kim012','김길동','kim002');
INSERT INTO member11 VALUES('A'||member1.nextval, 'an012','안길동','an002');
SELECT *
FROM member11;

--[1단계:개념] 3. sequence 수정의 한계를 기술하고, 이를 보완하는 방법을 예제를 통해서 기술하세요
 CREATE SEQUENCE member2
 INCREMENT BY 1
 START WITH 1000
 nomaxvalue
 MINVALUE 1000;
-- 수정
ALTER SEQUENCE member2
INCREMENT BY 2
-- START WITH 1  변경 불가 / 변경시 시퀀스 삭제후 재설정
MINVALUE 1;
-- 삭제
DROP SEQUENCE member2;
-- 수정
CREATE SEQUENCE member2
INCREMENT BY 2
START WITH 1
nomaxvalue
MINVALUE 1;

--[1단계:개념] 4. 복사테이블의 유형을 예제를 통해서 기술하세요.
-- 컬럼 구조 + 데이터복사
CREATE TABLE emp_c01
AS SELECT * FROM emp;
SELECT * FROM emp_c01;
-- 컬럼 구조만 복사
CREATE TABLE emp_c02
AS SELECT * FROM emp WHERE 0=1;
-- 컬럼명 변경 복사
CREATE TABLE emp_03
AS SELECT ename name, hiredate startwork, sal salary
FROM emp;
-- 유형 변경 복사
CREATE TABLE emp_04
AS SELECT decode(job,'SALESMAN','판매원','CLERK','사무원','MANAGER','매니저','PRESIDENT','대통령','ANALYST','분석가') job, 
	to_char(hiredate,'YY/MM/DD') hiredate
FROM emp; -- 별칭 설정 필수!

--**[1단계:확인] 5. 부서별 최고급여자의 사원정보컬럼전체가 들어가는 복사테이블 emp200을 만드세요.
CREATE TABLE emp203
AS SELECT *
	FROM emp
	WHERE (deptno,sal) in(
		SELECT deptno, max(sal) sal
		FROM EMP
		GROUP BY deptno);
SELECT * FROM emp203;
--[1단계:개념] 6. 테이블의 구조 변경의 원칙을 예제를 통해서 기술하세요.
-- 컬럼 추가
ALTER TABLE emp_c01
ADD loc varchar(50) DEFAULT '대한민국'; -- 테이블 가장 마지막에 생성, 기본값 지정 가능
SELECT * FROM emp_c01;
-- 컬럼 삭제
ALTER TABLE emp_c01
DROP COLUMN loc;
SELECT * FROM emp;
SELECT * FROM dept;

--[1단계:확인] 7. 부서테이블과 사원테이블을 결합한 복사테이블을 만들고, 부서번호 컬럼 삭제
--              문자열 컬럼은  최대크기로 컬럼을 변경하고, 컬럼명도 empno ==> no,
--         ename ==> name, sal ==> salary로 변경 하세요.
CREATE TABLE empdept01
AS SELECT *
from(
	SELECT e.* dname, loc
	FROM emp e, dept d
	WHERE e.deptno = d.deptno);
SELECT * FROM empdept01;
-- 부서번호 컬럼 삭제
ALTER TABLE empdept01
DROP COLUMN deptno;
-- 문자열 컬럼 최대크기 컬럼으로 변경
SELECT max(LENGTHB(ename)),max(LENGTHB(job)), max(LENGTHB(dname)), max(LENGTHB(loc))
FROM empdept01;
ALTER TABLE empdept01
MODIFY (ename varchar(6),job varchar(9),dname varchar(10),loc varchar(8));
-- 컬럼명도 empno ==> no, ename ==> name, sal ==> salary로 변경
ALTER TABLE empdept01 RENAME COLUMN empno TO NO;
ALTER TABLE empdept01 RENAME COLUMN ename TO name;
ALTER TABLE empdept01 RENAME COLUMN sal TO salary;


