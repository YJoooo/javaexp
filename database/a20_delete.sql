/*
# 데이터의 삭제
1. delect 명령문은 테이블에 저장된 데이터 삭제를 위한 조작이다.
2. where 절을 생략하면 테이블의 모든 행이 삭제된다.
3. 기본형식
	delete
	from 테이블명
	where 조건
 */
SELECT *FROM EMP_CP100;
DELETE FROM EMP_CP100 ec 
WHERE empno =7782;
-- ex) 급여가 2000이상이고 부서가 30인 데이터를 삭제처리하세요
SELECT* FROM emp01;
CREATE TABLE emp01
AS SELECT * FROM emp;
DELETE FROM emp01
WHERE sal >=2000 AND deptno = 30;
/*
# 서브쿼리를 이용한 데이터 삭제
1. where절에서 서브쿼리 이용
2. 다른 테이블에 저장된 데이터를 검색하여 한꺼번에 여러행의 내용을 삭제함
3. where절의 컬럼 이름은 서브쿼리의 컬럼 이름과 달라도 됨
4. 데이터 타입과 컬럼 수는 일치
5. 기본 형식
	1) row인 경우
		delete from 테이블
		where (컬럼명1, 컬럼명2...) = (select ...from 테이블 where...)
	2) 다중의 row인 경우
		delete from 테이블
		where (컬럼명1, 컬럼명2...) in (select ...from 테이블 ...)
	cf) 다중 컬럼인 경우에 해당 컬럼 데이터가 1개 row에 같이 있을때, 삭제 된다.
	
 */
SELECT* FROM emp01;
-- 부서별 최고 급여자 삭제 
DELETE FROM emp01
WHERE (deptno,sal) in (
	SELECT deptno, max(sal) sal
	FROM emp01
	GROUP BY deptno
);

-- ex) 분기별 최저 급여자를 삭제하세요.
DELETE FROM emp01
WHERE (to_char(hiredate,'Q'),sal) IN (
	SELECT to_char(hiredate,'Q'), min(sal)
	FROM emp01
	GROUP BY to_char(hiredate,'Q'));
SELECT* FROM emp01;	