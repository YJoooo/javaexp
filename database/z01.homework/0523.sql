--2022-05-23
--[1단계:개념] 1. case when의 2가지 기본형식을 정리하고 예제를 통해서 비교하세요.

--1) 
--	CASE WHEN 논리/관계식1 THEN 처리할데이터
--		 WHEN 논리/관계식2 THEN 처리할데이터
--		 ...
--		 ELSE 위에 선언된 논리/관리식이 아닐때 처리 할 데이터
--	END
SELECT *
FROM emp;
-- 입사년도가 80년대 81년대 82년대인 사람들각각 월급을 30,20,10의 보너스
SELECT ename 사원명, to_char(hiredate,'YY"년"') 입사년도,
	CASE WHEN to_char(hiredate,'YY')=80 THEN sal*0.3
		 WHEN to_char(hiredate,'YY')=81 THEN sal*0.2
		 WHEN to_char(hiredate,'YY')=82 THEN sal*0.1
		 ELSE 0
	END 보너스
FROM emp;

--2) 형식2
--	CASE 컬럼|데이터
--		WHEN 컬럼에 데이터1일때 THEN 처리할 데이터
--		WHEN 컬럼에 데이터2일때 THEN 처리할 데이터
--		...
--		ELSE 위에 WHEN에 나열된 데이터가 아닐 때, 처리할 데이터
--	END
SELECT ename 사원명, to_char(hiredate,'YY"년"') 입사년도,
	CASE to_number(to_char(hiredate,'YY')) -- 숫자형으로 바꾸기!
		WHEN 80 THEN sal*0.3
		WHEN 81 THEN sal*0.2
		WHEN 82 THEN sal*0.1
		ELSE 0
	END 보너스
FROM emp;

--[1단계:확인] 2. 입사월을 3가지 분류를 나누어 보너스금액을 10%, 20%, 30%로 정하여 출력하세요.
SELECT ename 사원명,to_char(hiredate,'MM"월"') 입사월,
		CASE WHEN to_char(hiredate,'MM')<=4 THEN sal*0.1
			WHEN to_char(hiredate,'MM')<=8 THEN sal*0.2
			WHEN to_char(hiredate,'MM')<=12 THEN sal*0.3
			ELSE 0
		END "보너스 금액"	
FROM emp;
--[1단계:확인] 3. case when 2번째 형식(복합함수)으로 상반기/하반기 입사자로 구분하여 출력하세요.
SELECT ename, CASE to_number(to_char(hiredate,'Q'))
			WHEN 1 THEN '상반기'
			WHEN 2 THEN '상반기'
			WHEN 3 then'하반기'
			WHEN 4 then'하반기'
			ELSE '데이터없음'
		END "상반기/하반기"
FROM emp;
-- 선생님 답
SELECT hiredate, to_char(hiredate,'MM') div1,
		CEIL(to_number(to_char(hiredate,'MM'))/6) div2,
		CASE CEIL(to_number(to_char(hiredate,'MM'))/6) 
			WHEN 1 THEN '상반기'
			WHEN 2 THEN '하반기'
			ELSE '데이터 없음'
		END "상/하반기"	
FROM emp;
--[1단계:개념] 4. 그룹함수의 개념과 기본형식을 기본예제를 통해서 설명하세요.

SELECT job,sal
FROM emp					
ORDER BY job,sal desc;-- 직업 오름차순 정렬후 급여 큰순으로 정렬하여 눈으로 최대금액 확인

SELECT job,max(sal)
FROM emp
GROUP BY job; -- 직업별로 그룹으로 묶고 거기서 최대값 추출

--[1단계:확인] 5. 분기별, 입사 사원수의 수가 2이상인 분기(1~4분기)와, 해당분기의 최고 급여를 출력하세요.
SELECT to_char(hiredate,'Q"분기"') 분기, count(hiredate) 입사사원수, max(sal) 최고급여
FROM emp
GROUP BY to_char(hiredate,'Q"분기"');

--[1단계:확인] 6. 급여를 5000이상부터 시작하여 천단위로 등급을 나누고, 등급별 인원수와 평균 급여를 출력하세요.
SELECT sal,
CASE WHEN sal>=5000 THEN 'A등급'
			 WHEN sal>=4000 THEN 'B등급'
			 WHEN sal>=3000 THEN 'C등급'
			 WHEN sal>=2000 THEN 'D등급'
			 WHEN sal>=1000 THEN 'E등급'
			 ELSE 'F등급'
		END "등급"
FROM emp
GROUP BY 등급;
-- 선생님 답
-- 천단위 등급처리 case when1
SELECT sal,
	CASE 
		WHEN sal>=5000 THEN 'A'
		WHEN sal>=4000 THEN 'B'
		WHEN sal>=3000 THEN 'C'
		WHEN sal>=2000 THEN 'D'
		WHEN sal>=1000 THEN 'E'
		WHEN sal>=0 THEN 'F'
		ELSE '등급무'
	END 등급
FROM emp;
SELECT 
		CASE 
		WHEN sal>=5000 THEN 'A'
		WHEN sal>=4000 THEN 'B'
		WHEN sal>=3000 THEN 'C'
		WHEN sal>=2000 THEN 'D'
		WHEN sal>=1000 THEN 'E'
		WHEN sal>=0 THEN 'F'
		ELSE '등급무'
	END 등급,
	count(sal) "인원수", round(avg(sal)) "평균급여"
FROM emp
GROUP BY 
	CASE 
		WHEN sal>=5000 THEN 'A'
		WHEN sal>=4000 THEN 'B'
		WHEN sal>=3000 THEN 'C'
		WHEN sal>=2000 THEN 'D'
		WHEN sal>=1000 THEN 'E'
		WHEN sal>=0 THEN 'F'
		ELSE '등급무'
	END
ORDER BY 등급;
-- 천단위 등급처리 case when2
SELECT 
		CASE floor(sal/1000) 
			WHEN 5 THEN 'A' 
			WHEN 4 THEN 'B' 
			WHEN 3 THEN 'C' 
			WHEN 2 THEN 'D' 
			WHEN 1 THEN 'E' 
			WHEN 0 THEN 'F' 
			ELSE '등급무'
		END 등급, count(sal) "인원수", round(avg(sal)) "평균급여"
FROM emp	
GROUP BY floor(sal/1000) 
ORDER BY 등급;
-- floor(sal/1000)을 통해서 0~5까지 그룹별로 처리하기 때문에 위에 case문에 등급을 입력하지 않아도 된다.

-- decode 이용
SELECT	count(sal) "인원수", round(avg(sal)) "평균급여",
		decode(floor(sal/1000),5, 'A',4, 'B',3, 'C',2, 'D',1, 'E',0, 'F','등급무') 등급
FROM emp
GROUP BY floor(sal/1000) 
ORDER BY 등급;

--[1단계:개념] 7. 조인이란 무엇인가? 기본 예제를 통하여 기술하세요
-- 여러 테이블 데이터를 한번에 조회할수 있는 기능
SELECT *
FROM emp;
sELECT *
FROM dept;
SELECT e.ename, d.loc --e테이블에 사원명과, d테이블의 위치
FROM emp e, dept d -- 한번에 조회할 테이블
WHERE e.deptno = d.deptno
and job='SALESMAN'; -- 직업이 SALESMAN인


--[1단계:확인] 8. [조인]연봉이 1000~2000사이의 사원의 부서명을 출력하세요.

SELECT e. ename, e.sal, d.dname
from emp e, dept d
WHERE e.deptno = d.deptno
AND sal >=1000 AND sal <=2000;

--[1단계:확인] 9. 부서위치(loc)별 평균 연봉을 출력하세요.
SELECT d.loc,round(avg(e.sal)) "평균연봉"
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.loc
-- 조인한 전체 테이블에서 그룹처리할 컬럼을 지정해서 출력처리.
