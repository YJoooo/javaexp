/*
# 데이터 수정
1. 개요
	update 명령문은 테이블에 저장된 데이터 수정을 위한 조작어이다.
	where 절을 생략하면 테이블의 모든 행을 수정한다.
2. 기본형식
	update 테이블
	set 컬럼 = 수정데이터,
		컬럼2 = 수정데이터2,
		..	
	where 조건문	
	
# 등록/수정/삭제 시, emp테이블에 대한 직접적으로 처리 주의하세요.	
 */
SELECT *FROM emp_cp100;
UPDATE EMP_CP100 
	SET ename = '이현규',
		job = '대리'
	WHERE empno = 7782;	
-- ex) 부서번호가 10인 사원정보의 입사일을 오늘로 변경, sal은 10% 인상금액으로 처리
UPDATE EMP_CP100 
	SET hiredate = sysdate,
		sal = round(sal*1.1)
	WHERE deptno = 10;	
SELECT *FROM emp_cp100
WHERE deptno = 10;
/*
# subquery를 통한 수정 처리
1. update명령문에 set부분이나 where 조건절에 subquery를 이용하여 수정처리하는 것을 말한다.
2. 다른 테이블이나 현재 테이블에 정보를 변경할 때, 일단 query를 수행한 결과로 해당 데이터를 수정 처리하는 것을 말한다.
3. 변경할 컬럼의 타입과 갯수는 반드시 일치 하여야 한다.
4. 유형
	1) set부분 subquery 활용
		- 한개의 컬럼 : set 컬럼명 = (결과가 1개인 컬럼데이터)
		- 두개이상의 컬럼 : set (컬럼명1, 컬럼명2...) = (결과가 2개 이상인 컬럼데이터)
		
 */
-- 부서번호가 10인 사원정보의 급여를 부서번호 20인 사원의 최고 급여로 변경처리
SELECT ename, sal
FROM emp_cp101
WHERE deptno = 10;
SELECT max(sal)
FROM EMP_CP101
WHERE deptno = 20;
CREATE TABLE emp_cp101
AS SELECT * FROM emp; 
UPDATE EMP_CP101
	SET sal = (
		SELECT max(sal)
		FROM emp_cp101
		WHERE deptno = 20	
	)
WHERE deptno = 10;
SELECT *FROM emp_cp101
WHERE empno = 7499;
-- ex) 직책이 SALESMAN 인 사원 평균급여를 사원번호 7499에 급여로 수정처리하세요.

UPDATE emp_cp101
	SET sal =(
		SELECT avg(sal)
		FROM emp_cp101
		WHERE job = 'SALESMAN'
	)
WHERE empno = 7499;
-- 두개 열에 대한 suvquery 처리
-- 부서별 최고 급여중에 최고 급여가 3000미만 부서번화와 급여를 사원번호 7369에 변경처리
SELECT deptno, max(sal)
FROM EMP_CP101
GROUP BY deptno
HAVING max(sal)<3000;
UPDATE emp_cp101
	SET (deptno,sal) = (
		SELECT deptno, max(sal)
		FROM EMP_CP101
		GROUP BY deptno
		HAVING max(sal)<3000
	)
WHERE empno = 7369;
SELECT *
FROM emp_cp101;
-- ex) 직책별로 최고 급여자 중에 SALESMAN을 직책과 급여를 사원번호 7782로 변경처리
SELECT job, max(sal)
FROM emp_cp101
WHERE job = 'SALESMAN'
GROUP BY job;
UPDATE emp_cp101
	SET (job, sal) = (
		SELECT job, max(sal)
		FROM emp_cp101
		WHERE job = 'SALESMAN'
		GROUP BY job
	)
WHERE empno = 7782;
SELECT *FROM emp_cp101
WHERE empno = 7782;
	