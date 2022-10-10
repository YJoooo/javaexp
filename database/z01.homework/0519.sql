--2022-05-19
--[1단계:개념] 1. 데이터베이스의 정렬의 기본 형식을 기본 예제를 통해서 설명하세요.
SELECT job, sal
FROM emp
ORDER BY job, sal DESC;  -- job 오름차순 정렬(A-Z순으로) , 같은 직책은 sal 내림차순 정렬

--[1단계:개념] 2. 함수의 크게 단일행/복수행 함수로 나누어진다. 이것의 구별기준을 예제로 설명하세요.
-- 단일행 : 테이블에 하나의 행에 적용되는 함수
-- 복수행 : 테이블에 여러행을 그룹화하여 적용되는 함수
SELECT round(164.8549,1) --> 다른행은 필요없이 단독으로 적용된 함수
FROM dual;
-- 복수행 함수는 보통 더하기나 평균처럼 다른행들과 연산하여 나타내는 함수
--[1단계:확인] 3. 아래의 형식으로 함수를 적용해서 출력하되 ename이 대소문자 구분없이 a/A인 데이터로 두번째 포함되어 검색 되게 처리하세요.
--                The salary of Ward is @@@ won!!!
SELECT 'The salary of Ward is '||ename||'won!!!'
FROM emp
WHERE instr(ename,'A')=2;

--[1단계:개념] 4. substr() 함수의 기본 매개변수와 기능을 기본예제를 통해서 설명하세요.
-- 입사년도가 81년인 사람의 정보
SELECT ename,to_char(hiredate) 입사일, substr(to_char(hiredate),1,2) 입사년도 
FROM emp
WHERE substr(to_char(hiredate),1,2)=81; -- substr(데이터, 출력시작위치,출력할 갯수)
--[1단계:확인] 5. ename의 첫번째에서 3번째 데이터 추출, job과 혼합하여 화면에 출력하되, substr(), concat()함수를 활용하세요
SELECT concat(substr(ename,1,3), job)
FROM emp;
--[1단계:확인] 6. ||, substr을 활용하여 1980에 입사한 사람의 입사일정보를 @@@는 @@@@년 @@월 @@일에 입사했습니다.로 출력하세요
-- (ename, hiredate활용)
SELECT ename||'는 '||
	substr(to_char(hiredate),1,2)||'년 '||
	substr(to_char(hiredate),3,2)||'월 '||
	substr(to_char(hiredate),5,2)||'일에 입사했습니다.' 입사일정보
FROM emp
WHERE substr(to_char(hiredate),1,2)=80;
--[1단계:개념] 7. instr의 기본 매개변수 옵션을 예제를 통해서 기술하세요.
SELECT ename, instr(ename,'A',2,1) -- ename에 2번째 글자부터 시작해서 A가 나온위치 ==> 위치는 첫번째부터 센다.
FROM emp;
--[1단계:확인] 8. 사원번호, 사원명, 직책 급여을 출력하되, 사원명, 직책은 최고 크기를 확인하고, 
--                사원명과 직책은 각각 최고 크기의 기준으로 왼쪽과 오른쪽에 #을 삽입하여 출력하세요.
SELECT LENGTH(ename), LENGTH (JOB)
FROM emp
ORDER BY LENGTH(ename) desc, LENGTH (JOB)desc;

SELECT empno, lpad(ename,6,'#'), rpad(job,8,'#'), sal
FROM emp;
--[1단계:개념] 9. 숫자형 함수 중에 자리수 처리에 대한 처리를 함수별로 비교를 기술하세요.
/*	
	1) round : 지정한 소숫점 자리로 반올림 처리를 해주는 함수
		round(데이터, 자릿수)
	2) trunc : 지정한 소숫점 자리까지 남기고 절삭처리
		trunc(데이터, 자리수)
	3) mod : 데이터베이스에서 산술연산자 %대신 쓰이는 나머지 처리 함수를 말한다.
		mod(데이터,m) : 데이터를 m으로 나눈 나머지값
	4) ceil : 지정한 값보다 큰 수 중에서 가장 작은 정수
 		소숫점이하의 내용에 대하여 올림 정수
	5) floor : 지정한 값보다 작은 수 중에서 가장 큰 정수
		소숫점이하의 내용에 대하여 내림 정수
 * */
SELECT round(164.8549,2) 반올림,
	trunc(164.8549,1) 절삭,
	mod(9,2) 나머지,
	ceil(164.8549) "올림 정수",
	floor(164.8549) "내림 정수"
FROM dual;	

--[1단계:확인] 10. 근무일수를 2분위로 나누어서(중앙값을 기준)서 보너스를 급여의 150%,200% 차등 지급하기로 했다. 
-- 사원명, 입사일, 분류, 보너스금액
SELECT ename, hiredate, (SYSDATE -hiredate)/2, (comm*1.5)+(comm*2)
FROM emp;
-- 선생님 답
-- 1) 근무일수 확인
-- 2) 근무일수의 중앙값 추출. : 육안 14955
-- 3) 근무일수의 중앙값을 기준점으로 미만과 이상을 구분자로 준다.
--		이상인지 미만인지구분 : 나눗셈과 절삭을 통해 1이상이면 중앙값이상, 1미만이면 중앙값미만
-- 4) 위 구분자로 보너스를 150% ==> 1.5, 200% ==> 2.0으로 처리되게 한다.
--		0 ==> 1.5, 1 ==> 2.0
--		+3	3 ==> 1.5	4==> 2.0
--		*0.5	0.5*3 ==> 1.5, 0.5*4 ==> 2.0
SELECT ename, sysdate - hiredate workdate1,
	floor(sysdate - hiredate) workdate2
FROM emp
ORDER BY workdate1;-- 육안으로 근무일수 중앙값 식별 : 14955
SELECT 
	floor(median(sysdate - hiredate)) 중앙값,
	floor(avg(sysdate - hiredate)) 평균값,
FROM emp;
-- 함수를 이용해서 중앙값 : 14909, 평균값 : 14918
--중앙값 이상, 미만 구분.
SELECT ename, hiredate, 
	floor(sysdate - hiredate) workdate2,
	floor((sysdate - hiredate)/14955) 구분자,
	sal,
	sal*(floor((sysdate - hiredate)/14955)+3)*0.5 "보너스"
FROM emp;


--[1단계:확인] 11. 오늘을 1일을 기준으로 1000일 기념일의 날짜와  걸린 기간을 @@년 @@개월 @@일 형식으로 표기하세요. hint)mod함수 활용
SELECT substr(SYSDATE +1000,1,2)||'년 '||
	substr(SYSDATE +1000,4,2)||'월 '||
	substr(SYSDATE +1000,7,2)||'일' "1000일 기념일",
	trunc(months_between(sysdate+1000,sysdate)/12,0)||'년 '||
	FLOOR(mod((1000/30),12))||'개월 '||
	MOD(1000,30)||'일' "걸린 기간"
FROM dual;
SELECT mod(1000,30)
FROM dual;
-- 선생님 답
	SELECT SYSDATE "오늘",
		sysdate+1000 "1000일 기념일",
		floor(months_between(sysdate+1001,sysdate)) "월계산",
		floor(months_between(sysdate+1001,sysdate)/12) "연계산",
		mod(floor(months_between(sysdate+1001,sysdate)),12) "월",
		mod(1001,floor(months_between(sysdate+1001,sysdate))) "일",
		floor(months_between(sysdate+1001,sysdate)/12)||'년 '||
		mod(floor(months_between(sysdate+1001,sysdate)),12)||'개월 '||
		mod(1001,floor(months_between(sysdate+1001,sysdate)))||'일' "1000일"
	FROM dual;
	/*
	MONTHS_BETWEEN : 월 계산에서 1.5 1개월 15일 ==> CEIL FLOOR를 통해서 차이가 남
	# 기간 계산 처리 형식
	1. 날짜 자체로 처리 방식
		1000 ==> /365 나누어서 년, /12 월, /30 일
	2. between_months를 날짜로 계산하여 처리하는 방식
		1) 사이의 월을 계산
			between_months(sysdate, sysdate+1001)
			오늘이 1일이므로 +1을 더해서 월을 계산
		2) 월계산/12 ==> 연도 계산
		3) 월계산*30 ==> 일계산(위 날짜 자체 계산처리 방식에서 mod로 활용하여 처리)
		# cf) 위 계산식에서 절삭(floor)과 나머지 연산자(mod)를 활용하여 처리한다.
		
	 * */




