--2022-05-20
--[1단계:개념] 1. 형변환 형태의 2가지와 타입에 따른 유형3가지를 기본 예제를 통하여 기술하세요.
-- 묵시적 형변환
SELECT ename, hiredate, TO_char(hiredate)
FROM emp
WHERE to_char(hiredate)LIKE '___11%'; --> 묵시적 형변환
SELECT ename, hiredate, TO_char(hiredate)
FROM emp
WHERE to_char(hiredate)LIKE to_char('___11%'); --> 명시적 형변환
-- 명시적 형변환
--	1) to_char() : 숫자/날짜 데이터를 문자형으로 변환
SELECT to_char(HIREDATE, 'YYYY"년" MM"월" DD"일"')
FROM emp;
--	2) to_number() : 문자데이터를 숫자형으로 변환
SELECT   to_number(to_char(hiredate,'DD'))
from emp;
--	3) to_date() : 문자열데이터를 날짜형으로 변환
SELECT to_date(to_char(HIREDATE,'YYYY MM DD'))
FROM emp;
--[1단계:확인] 2. 사원 정보 테이블에 입사한 월의 1일을 사원명과 함께 출력하세요
SELECT ename, to_char(hiredate,'MONTH "1일"')
FROM emp;
--[1단계:개념] 3. to_char(날짜데이터,'옵션') 에서 날짜처리하는 옵션 매개변수에 대하여 기술하세요.
--	Q : 분기
--	MM : 월
--	MONTH :월 영문
--	WW : 연단위 주표기/ 년도 째주
--	W : 월단위 주표기/ 월의 째주
--	YYYY : 연도
--	MM : 월
--	DD : 일
--	DL : 년 월 일 요일
--	DDD : 001~365일로 나타냄
--	DY : 요일
--	DAY : 요일
--	AM/PM : 오전/오후 A.M/P.M
--	HH/HH12 : 시간(1~12) 표시
--	HH24 : 24시간(0~23) 표시
--	MI : 분
--	SS : 초

--[1단계:확인] 4. 사원의 입사분기별로 보너스를 차등 지급하고자 한다. 열단위로 처리하세요.사원명, 급여, 보너스 %, 보너스
--      (급여의 1/4분기 10%, 2/4분기 20%, 3/4분기 30%, 4/4분기 30%)
SELECT ename "사원명", sal "급여", decode(to_char(HIREDATE,'Q'),'1','10%',
												'2','20%',
												'3','30%','30%') "보너스%",
		decode(to_char(HIREDATE,'Q'),'1',sal*0.1,'2',sal*0.2,'3',sal*0.3,sal*0.3) 보너스	
FROM emp;
--		(급여의 1/4분기 10%, 2/4분기 20%, 3/4분기 30%, 4/4분기 40%)
SELECT ename, hiredate, to_number(to_char(hiredate,'Q')) 분기,
	to_number(to_char(hiredate,'Q'))*10 "보너스%",
	sal,
	sal*to_number(to_char(hiredate,'Q'))*0.1 보너스
FROM emp;

--[1단계:확인] 5. 입사월이 4/4분기에 해당하는 사원의 정보를 +9시간 더하여 다음과 같이 출력하세요
--      사원명, @@@년 @@월 @@일 +9 출근
SELECT to_char(HIREDATE,'YYYY"년" MM"월" DD"일"')||to_char(HIREDATE,'" 09":MI:SS" 출근"')
FROM emp
WHERE to_char(HIREDATE,'Q')='4';

--[1단계:확인] 6. [nvl2활용] comm일 null일때는 sal의 15%로 설정하고, null일 아닐 때는 comm에서 sal의 5%를 더하여 보너스금액을
--              설정하여   사원명 연봉 보너스  를 출력하세요.
SELECT ename 사원명, sal 연봉, floor(nvl2(comm,comm+(sal*0.05),sal*0.15)) 보너스금액
FROM emp;

--[1단계:확인] 7. [중첩함수] 사원번호를 기준으로 짝수이면 홍팀, 홀수이면 청팀으로 처리하여 출력하세요
SELECT ename 사원명, decode(MOD(empno,2),0,'홍팀',1,'청팀','데이터없음') 팀
FROM emp;
/*
중첩함수 : 함수가 2개이상 중첩되어 적용되는것을 말한다.
mod : 나머지연산처리, 
decode(데이터, 
	경우1, 경우1일때데이터, 
	경우2, 경우2일때데이터,
	경우3, 경우3일때데이터,
	경우4, 경우4일때데이터,
	..
	그외데이터)
*/

