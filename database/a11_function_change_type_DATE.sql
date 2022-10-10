/*
# 날짜형 데이터
1. 형식
	date : 날짜와 시간을 처리하는 데이터 유형
2. 포함 내용
	YYYY : 연도
	MM : 월
	DD : 일
	DAY : 요일
	AM/PM : 오전/오후 A.M/P.M
	HH/HH12 : 시간(1~12) 표시
	HH24 : 24시간(0~23) 표시
	MI : 분
	SS : 초
3. 형변환 형식
	1) to_char(날짜데이터, '형식')
	2) to_date('문자열데이터', '형식지정')
		날짜형식으로 데이터를 등록, 수정할 때, 조건문에서 날짜를 검색할 떄, 주로 활용된다.
		cf) 회원의 생일을 날짜 타입으로 설정할 때, 생일[YYYY-MM-DD] 이렇게 문자열로된 데이터 날짜로 변경해서 입력해야한다.
			to_date('1995-12-12','YYYY-MM-DD) 입력하는 문자열이 어떤형식으로 날짜데이터에 입력하는지를 선언하고, 
			형 변환에 의해 변환처리하여 입력/조회/수정할 수 있게 한다.
 * */
SELECT to_char(sysdate,'AM HH:MI:SS') "현재시간(12)"
FROM dual;
-- ex) 사원정보 테이블에서 사원명, 입사일+현재시간 표현 @@@년 @@월 @@일 24시간표 @@시 @@분 @@초 표현하여 출력하세요.
SELECT ename, hiredate||' '||to_char(sysdate,'HH:MI:SS') "입사일+현재시간",
	to_char(hiredate,'YYYY"년" MM"월" DD"일"'), -- 표현시 /,- 기본적으로 지원되는 문자 이외에는 "문자"를 추가하여 처리가 가능하다.
	to_char(hiredate,'YYYY')||'년 '||
	to_char(hiredate,'MM')||'월 '||
	to_char(hiredate,'DD')||'일 '||
	to_char(sysdate,'HH24:MI:SS') 입사,
	to_char(hiredate,'YYYY')||'년 '||
	to_char(hiredate,'MM')||'월 '||
	to_char(hiredate,'DD')||'일 ' "입사일",
	to_char(sysdate,'HH24:MI:SS') "현재 시각",
	to_date(to_char(hiredate,'YYYY MM DD')||
	to_char(sysdate,'HH24MISS'),'YYYYMMDD HH24MISS') " 날짜형 변경"
FROM emp;
/*
# 숫자형 데이터를 문자열 형식 변환처리
1. 기본형식 : to_char(숫자형 데이터, '형식')
2. 주요형식
	해당자리수 이상의 데이터가 처리될 때, ###으로 표기된다.
	9999 : 기본 자리수에 맞게 처리
	0000 : 해당 자리수 이하 일때, 0으로 채워짐
	$ : 앞에 $표기 처리, 
	. : 특장한 자리를 표기 소숫점
	, : X특정한 위치를 효기(천단위표기)
 * */
SELECT ename, sal,
		to_char(sal, '99999') "형식1",
		to_char(sal, '00000') "형식2",
		to_char(sal, '$9999') "형식3",
		to_char(sal, '9,999') "형식4",
		to_char(sal, '9,999,999') "형식5",
		to_char(sal*1000000, '9,999.999') "형식6"
FROM emp;		
		






