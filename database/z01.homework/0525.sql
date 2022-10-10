--2022-05-25
--[1단계:개념] 1. DML이란 무엇인가 종류를 기술하세요..
/*
	insert : 새로운 데이터 입력 명령어
		- insert all : 다중 데이터 입력
		- first insert : 다중 데이터 입력 (조건절에 따라 입력)
	update : 기존 데이터 변경 수정
	delete : 기존 데이터 삭제
	merge : 두개의 테이블을 하나의 테이블로 병합
*/
--[1단계:확인] 2. emp테이블과 dept를 조인한 복사테이블로 emp_cp120만들어 
--      전체 데이터 입력과 특정 컬럼 입력을 처리하세요.
CREATE TABLE emp_cp120
AS SELECT *
FROM emp natural JOIN dept;
SELECT *
FROM emp_cp120;
-- 선생님 답
CREATE TABLE emp_cp121
AS SELECT e.*, dname, loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno;
-- 전체 테이블 컬럼 입력
INSERT INTO emp_cp121 values(8888,'홍길동','사원',7839,sysdate,3500,100,40,'','');
-- 부분 컬럼 입력
INSERT INTO emp_cp121(empno,ename, deptno, dname) values(9999,'마길동',50,'인사');
SELECT *FROM emp_cp121;

--[1단계:개념] 3. 명시적 null과 묵시적 null 데이터 입력의 차이점을 예제를 통해서 기술하세요.
SELECT *
from emp_cp100;
INSERT INTO emp_cp100(ename, job, sal) VALUES ('최길동', '사원', 1200); -- 묵시적 null
INSERT INTO emp_cp100 VALUES (7700,'최시원','대리', 7839,NULL, 2000,NULL,10); -- 명시적 null
SELECT *
from emp_cp100;
--[1단계:확인] 4. 현재 년도와 월을 기준으로 지정한 날짜와 시간(15일 오전 10:15)을 입력 처리하세요.
INSERT INTO emp_cp100(hiredate) VALUES 
	(to_char(sysdate,'YYYY"년"MM"월"')||'15일 오전 10:15');
-- 선생님 답
--	emp_cp120 사원명, 입사일 처리
SELECT sysdate, to_char(sysdate,'YYYYMM') d1,
	to_char(sysdate,'YYYYMM')||'15 AM 10:15' d2,
	to_date(to_char(sysdate,'YYYYMM')||'15 10:15','YYYYMMDD HH:MI') d3
FROM dual;
INSERT INTO emp_cp120(ename, hiredate) values('이영수',to_date(to_char(sysdate,'YYYYMM')||'15 10:15','YYYYMMDD HH:MI'));
SELECT *
from emp_cp120;
--[1단계:개념] 5. 단일 데이터 입력과 다중 데이터 입력의 차이를 예제를 통해 기술하세요.
--	insert ALL 다중 데이터 입력
INSERT INTO emp_cp100(ename, sal) VALUES ('김연주','5000'); -- 단일 데이터 입력
SELECT * FROM emp_cp100;
INSERT ALL
INTO EMP_CPy201(ename,job) VALUES (ename,job) -- 다중 데이터 입력
INTO EMP_CPy202(ename,job) VALUES (ename,job)
INTO EMP_CPy203(ename,job) VALUES (ename,job)
SELECT ename,job
FROM emp
WHERE job = 'MANAGER';
SELECT *FROM EMP_CPy201;
SELECT *FROM EMP_CPy202;
SELECT *FROM EMP_CPy203;


--[1단계:확인] 6. 직책별로 테이블을 만들어 사원정보를 한번에 입력 처리하세요.
SELECT * FROM emp;
-- CLERK, SALESMAN, MANAGER, PRESIDENT, ANALYST
CREATE TABLE CLERK AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE SALESMAN AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE MANAGER AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE PRESIDENT AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE ANALYST AS SELECT * FROM emp WHERE 1=0;
SELECT * from CLERK;
SELECT * from SALESMAN;
SELECT * from MANAGER;
SELECT * from PRESIDENT;
SELECT * from ANALYST;
INSERT ALL INTO CLERK
SELECT * FROM emp
WHERE job = 'CLERK';
INSERT ALL INTO SALESMAN
SELECT * FROM emp
WHERE job = 'SALESMAN';
INSERT ALL INTO MANAGER
SELECT * FROM emp
WHERE job = 'MANAGER';
INSERT ALL INTO PRESIDENT
SELECT * FROM emp
WHERE job = 'PRESIDENT';
INSERT ALL INTO ANALYST
SELECT * FROM emp
WHERE job = 'ANALYST';

--[1단계:개념] 7. 데이터의 수정기본형식을 기술하세요..

UPDATE 테이블명
SET 컬럼 = 수정할 데이터
WHERE 조건식;


--[1단계:확인] 8. 1사분기 최고 급여를 ALLEN의 급여로 수정 처리하세요

SELECT *
FROM EMP_CP101 ec ;

UPDATE EMP_CP101
	SET sal =(
	SELECT max(sal)
	FROM EMP_CP101
	WHERE to_char(HIREDATE,'Q')=1)
WHERE ename = 'ALLEN';