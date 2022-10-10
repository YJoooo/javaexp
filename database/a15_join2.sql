/*
# outer join
1. 개요
	1) equi join의 조인 조건에서 양측 컬럼 값 중, 어느 하나라도 null이면 '='비교
		결과가 거짓이 되어 null값을 가진 행은 조인 결과로 출력이 불가
		null에 대하여 어떠한 연산을 적용하더라도 연산 결과는 null
		ex) 
	2) 일반적인 equi join의 예
		학생 테이블의 학과번호 컬럼과 부서 테이블의 부서번호 컬럼에 대한 equi join 한 경우 학생 테이블의 deptno 컬럼이 null인 경우 해당 학생은 결과로 출력되지 않은
		ex) 사원정보에서 해당 부서40이 없는 경우, 40부서 정보가 출력되지 않음.	
	3) equi join에서 양측 컬럼 값중의 하나가 null이지만 조인 결과로 출력할 필요가 있는 경우 outer join을 사용
	4) outer join의 예
		- 힉셍 테이블과 교수 테이블ㅇㄹ equi join하여 학생의 지도 교수 이름 출력
		- 조건 : 지도 학생을 한 명도 배정받지 못한 교수 이름도 반드시 함께 출력
		ex) 부서정보에서 사원 정보가 하나도 없는 부서도 함께 출력
2. 기본 형식
	(+) 기호를 사용한 outer join
	- where절의 조인 조건에서 outer join연산인 (+)기호 사용
	- 조인 조건문에서 null이 출력되는 테이블의 컬럼에 (+) 기호 추가 (주의)
	select 테이블.컬럼, 테이블2.컬럼
	from 테이블1, 테이블2
	where 테이블1.컬럼(+) = 테이블2.컬럼
	또는	  테이블1.컬럼 = 테이블2.컬럼(+)		 	
 */



SELECT ename, deptno
FROM emp;
SELECT DISTINCT deptno
FROM emp;
SELECT * 
FROM dept;
-- 부서정보 중에 40인 operations는 사원이 등록되지 않는 것을 볼수 있다.
-- 부서별로 사원 현황
SELECT dname, count(*) 인원
FROM emp e, dept d
WHERE e.deptno(+) = d.DEPTNO 
GROUP BY dname;
-- outer join을 통해서 기준이 되는 테이블에 연결되는 데이터가 없더라도 표현할 수 있게 한다.
SELECT e.*, dname, loc
FROM emp e, dept d
WHERE e.deptno(+) = d.DEPTNO;
SELECT * FROM EMP_CP100;
-- ex) EMP_CP100와 dept테이블을 outer 조인하여 부서번호 부서명 사원명 급여를 출력하세요.
SELECT d.deptno,dname, ename, sal
FROM emp_cp100 e, dept d
WHERE e.deptno(+) = d.deptno;
-- 사원 정보를 기준으로 매칭된 부서정보를 출력.
SELECT *
FROM EMP_CP100;
SELECT empno, ename, dname, loc
FROM EMP_CP100 e, dept d
WHERE e.deptno = d.deptno(+);
/*
# self join
1. 개요
	1) 하나의 테이블 내에 있는 컬럼끼리 연결하는 조인이 필요한 경우에 사용된다.
	2) 조인 대상 테이블이 자신 하나라는 것 외에는 equi join과 동일하다.
2. where절을 사용한 self join
	1) 한 테이블에서 두개의 컬럼을 연결하여 equi join
	2) from절에서 하나의 테이블에 테이블 별명 지정
	예) 부서테이블에 where 절을 사용하여 self join 처리
3. 기본 형식
	1) select *
		from 테이블 상위, 테이블 하위
		where 상위.상위컬럼 = 하위.하위컬럼
				
 */
SELECT *
FROM emp;

SELECT e.empno, e.ename, e.mgr, m.empno, m.ename
FROM emp e, emp m
WHERE e.mgr=m.empno;

SELECT e.ename||'의 관리자는 '|| m.ename||'입니다!' show
FROM emp e, emp m
WHERE e.mgr = m.empno;

CREATE TABLE emp_family
AS
SELECT empno NO, mgr refno, ename name, job role01 FROM emp;
SELECT *
FROM emp_family;
-- ex) emp_family를 통해, self join으로 @@@(하위 name)은 @@(상위name)의 자식입니다!
SELECT m.name||'은 '||e.name||'의 자식입니다.'
FROM emp_family e, emp_family m
WHERE e.NO = m.refno;

-- 선생님 답
SELECT s.name||'('||s.role01||')는'||p.name||'('||p.role01||')의 자식입니다!' 우리친척들
FROM EMP_FAMILY s, EMP_FAMILY p
WHERE s.refno = p.NO;