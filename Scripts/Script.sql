SELECT * FROM emp;
SELECT * FROM salgrade;
	
	SELECT *
	FROM emp
	WHERE (deptno,sal) in(
		SELECT deptno, max(sal) sal
		FROM EMP
		GROUP BY deptno);
--	3) 부서번호가 20인 최고연봉 (리턴유형 double)
	SELECT max(sal)
	FROM EMP
	WHERE deptno = 20;
--	4) 사원명이 JONES인 사원정보(출력만)
SELECT * FROM emp WHERE ename = 'JONES';
--	5) 분기별 최고 급여자(출력만)
SELECT empno, ename, job, mgr, hiredate, sal, to_char(hiredate,'Q'), comm, deptno FROM EMP WHERE (sal, to_char(hiredate,'Q')) in( SELECT max(sal) sal, to_char(hiredate,'Q') FROM EMP GROUP BY to_char(hiredate,'Q')) ORDER BY to_char(hiredate,'Q');		

SELECT * 
FROM EMP e 
WHERE ename LIKE '%'||''||'%';