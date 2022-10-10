--2022-05-24
--[1단계:개념] 1. natural join의 기능을 기술하고, 일반 equi 조인과의 차이점을 기술하세요.
-- natural join
--	where절을 사용하지 않고 natural join 키워드 사용하여 자동적으로 테이블의 모든 컬럼을 대상으로 공통 컬럼을 조사 후, 내부적으로 조인문 생성
--	select 테이블1.컬럼명, 데이블2.컬럼명
--	from 테이블1 natural join 테이블2	
SELECT ename
FROM emp200 NATURAL JOIN dept200;
-- equi join
--	조인 대상 테이블에서 공통 컬럼을 '='(equal) 비교를 통해 같은 값을 가지는 행을 연결하여 결과를 생성하는 조인 방법
--	select 테이블1.컬럼명, 테이블2.컬럼명
--	form 데이블1, 테이블2
--	where 테이블1.컬럼명 = 테이블2.컬럼명
SELECT e.*, d.*
FROM emp200 e, dept200 d
WHERE e.deptno = d.deptno;

--[1단계:개념] 2. not equi join이란 무엇인가 기본예제를 통해서 설명하세요.
-- <, between a and b와 같이 범위를 지정하여 조인하는 경우를 말한다.
SELECT *
FROM SALGRADE02;
SELECT e.ename, e.sal, s.GRADE -- 보여줄 행
FROM emp e, SALGRADE02 s -- 조인 테이블
WHERE sal BETWEEN losal AND hisal -- 범위지정
ORDER BY grade; -- grade 순서대로 정렬

--[1단계:확인] 3. 사원번호를 기준으로 4개의 임의 범위를 정하여 복사테이블을 만들어 저장하고(salgrade를 복사한 복사테이블(part)),
--            사원번호를 통한 출장소 지정 1분위 : 서울 2분위 : 부산 3분위 : 제주  4분위 : LA 처리하여 테이블의 데이터를 수정하고, 
--            no equi join 처리하세요.
--            grade hisal rsal ==> loc hiempno rempno
--                                 서울 7001     7500
--                                 부산 7501     7600
--                         ..

--[1단계:개념] 4. outer join이란 무엇인가? 기본예제를 통하여 개념을 설명하세요.
-- equi join에서 양측 컬럼 값중의 하나가 null이지만 조인 결과로 출력할 필요가 있는 경우 outer join을 사용
--	select 테이블.컬럼, 테이블2.컬럼
--	from 테이블1, 테이블2
--	where null이 출력되는 테이블1.컬럼(+) = 테이블2.컬럼
SELECT s.hiempno, e.EMPNO
FROM emp e, SALGRADE_PART s
WHERE s.hiempno(+) e.EMPNO ;
--[1단계:확인] 5. emp_cp100에 부서정보를 할당하지 않고, 신규 사원정보를 추가한 후, emp_cp100기준으로 부서정보와
--            outer조인된 데이터를 출력하세요.
SELECT *
FROM emp_cp100;
SELECT *
FROM emp e, EMP_CP100 ec 
WHERE e.empno = ec.empno(+);
--[1단계:개념] 6. self join에 대하여 기본예제로 기술하세요.
--	하나의 테이블 내에 있는 컬럼끼리 연결하는 조인이 필요한 경우에 사용된다.
--	select *
--	from 테이블 상위, 테이블 하위
--	where 상위.상위컬럼 = 하위.하위컬럼
CREATE TABLE emp_family2
AS SELECT * FROM emp_family;
SELECT *
FROM emp_family;
SELECT *
FROM emp_family2;
SELECT f.name||'은 '||e.name||'의 자식'
FROM emp_family2 e, emp_family2 f
WHERE e.NO = f.refno;

--[1단계:개념] 7. subquery란 무엇인가 기본예제와 함께 개념을 설명하세요.
-- 두개 이상의 sql명령문을 하나의 sql명령문으로 연결하여 처리하는 방법
SELECT ename, sal, job
FROM emp
WHERE sal>(
	SELECT avg(sal)
	FROM emp);
--[1단계:확인] 8. 관리자가 'MANAGER'인 사원의 최저 급여보다 적은 사원들 출력하세요.
SELECT * FROM emp;
SELECT *
FROM emp
WHERE sal<(
	SELECT min(sal)
	FROM emp
	WHERE mgr = 7566);

-- 선생님 답
-- 1) 직책이 MANAGER인 사람의 사원번호
SELECT empno
FROM emp
WHERE job = 'MANAGER';
-- 2) 위에 있는 MANAGER를 관리자로 되어있는 사원 mrg
SELECT empno, ename, mgr
FROM emp
WHERE mgr in(
	SELECT empno
	FROM emp
	WHERE job = 'MANAGER');
-- 3) 최저급여
SELECT min(sal)
FROM emp
WHERE mgr in(
	SELECT empno
	FROM emp
	WHERE job = 'MANAGER');
-- 4) 위 금액의 이하인 사원
SELECT *
FROM emp
WHERE sal < (
	SELECT min(sal)
	FROM emp
	WHERE mgr in(
		SELECT empno
		FROM emp
		WHERE job = 'MANAGER'));

--[1단계:확인] 9. emp, salgrade테이블과 조인하여, 등급이 1~2등급인 사원의 최고 급여보다 많은 사원을 출력하세요.
SELECT *
FROM salgrade;
SELECT ename, sal
FROM EMP 
WHERE sal<(
	SELECT avg(sal)
	FROM emp NATURAL JOIN salgrade
	WHERE grade <=2);
-- 선생님 답
SELECT s.*, e.*
FROM emp e, salgrade s
WHERE sal BETWEEN losal AND hisal;

SELECT max(sal)
FROM emp e, salgrade s
WHERE sal BETWEEN losal AND hisal
AND grade IN ('1','2');

SELECT * FROM emp
WHERE sal >(
	SELECT max(sal)
	FROM emp e, salgrade s
	WHERE sal BETWEEN losal AND hisal
	AND grade IN ('1','2')); -- 1300보다 많은 직원

	
