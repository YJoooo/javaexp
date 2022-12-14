/*
# database에서 함수(function)
1. sql에서 함수(주로 내장함수) cf) 사용자 정의 함수도 있음.
	1) 컬럼의 값이나 데이터 타입을 변경하는 경우
	2) 숫자 또는 날짜 데이터의 출력 형식을 변경하는경우
	3) 하나 이상의 행에 대한 집계(aggregation)를 하는 경우
2. sql 함수의 유형
	1) 단일행 함수 : 테이블에 저장되어 있는 개별 행을 대상으로 하는 함수를 말하고, 
		적용을 하며 하나의 행당 하나의 결과를 반환하는 함수를 말한다.
		ex) 소문자/대문자 변환처리
	2) 복수행 함수 : 조건에 따라 여러행을 그룹화 하여 그룹별로 결롸를 하나씩 반환하는 함수
		여러행의 데이터에 함수가 적용되었을 때, 단일 또는 줄어든 행의 결과값을 리턴하는 함수를 말한다.
		ex) 부서별 급여가 가장 적은 데이터, 직책별 인원수
3. 단일행 함수
	1) 데이터 값을 조작하는데 주로 사용된다.
	2) 행별로 함수를 적용하여 하나의 결과를 변환하는 함수이다.
	3) 단일행 함수의 종류
		문자함수 : upper, lower, initcap
		숫자함수 : ceil, trunc, round
		날짜함수 : add_months
		변환함수 : 묵시적/명시적 데이터 변환 - 문자열 ==> 숫자형, 숫자형 ==> 날짜형, 날짜형 ==> 문자열
		일반함수 : 일반함수 nvl, decode, case when
	4) 단일행 함수의 사용법
		select 함수명(컬럼명/데이터, 매개변수1, 매개변수2..)
		where 컬럼 = 함수명(컬럼명/데이터, 매개변수1, 매개변수2..)
			함수(컬럼) = 데이터
			함수(컬럼) = 함수(컬럼)
# 문자함수
1. 문자 데이터를 입력하여 문자나 숫자를 결과로 반환하는 함수
2. 문자함수의 종류
	1) 대소문자 변환 함수
		initcap() : 첫번째 문자만 대문자로 변환 처리함수
		lower() : 문자열 전체를 소문자로 변환
		upper() : 문자열 전체를 대문자로 변환
	2) 문자조작 함수
		concat(문자열1,문자열2) : 두 문자열을 결합처리 한다. cf) 문자열||문자열2
			ex) concat('sql','plus') ==> sqlplus
			==> ||를 이용하는 경우가 많다.
		substr(문자열데이터, 시작위치, 시작위치에서 갯수)
			문자열 데이터를 시작위치와 마지막위치를 기준으로 절삭처리하여 사용하는 것을 말한다.
			index : 0부터 시작하는 경우/1부터 시작하는 경우
				oracle에서 substr은 1부터 시작!
				ex) substr('sql*plus',5,4) ==> plus
				
					sql*plus
					12345678	p부터 추출
						plus
						1234	4개 추출	
		ex) 사원명 : [AB ] [검색]
			1) 양옆에 공백 문자에 처리.
				js, java, DB(trim(), ltrim(), rtrim())
			2) 대소문자 구분없이 검색되게 처리
				DB테이블
					Hello
				검색 Hello시 해당내용을 검색하지 않으면 검색이 안된다.
					Hello, hellO, hello, HELLO로도 검색이 되게 하려면,
					where upper(ename) like '%'||upper('hello')||'%'			
	3) 문자열 길이 변환 함수
		- 문자열은 크기 문자자체에 대한 갯수와 byte단위로 크기를 처리하는 것으로 나누어진다.
			영문은 1자가 1byte, 한글은 oracle기준으로 3bytes
		- length(데이터/컬럼명) : 문자열의 길이(글자수)를 반환하는 함수, 한글/영문 동일
		- lengthb(데이터/컬럼명) : 문자열의 바이트를 반환하는 함수
			한글이나 특수문자인 경우 1글자당 3bytes인 경우가 있어 한글/영문이 차이가 난다.
cf) 함수는 일반적으로 중첩하여 사용하는 경우가 많다.
	함수1(함수2(함수3(데이터, 매개변수),매개변수),매개변수)			
3. 	
 * */
SELECT ename, initcap(ename), lower(ename), upper(ename)
FROM emp
WHERE lower(ename) LIKE '%a%';
-- ex) 함수를 이용하여 다음과 같은 형태로 출력하세요. 활용 컬럼(ename, job), 조건문 소문자변환하여 k 포함할때
--		The job Smith is a Clerk! ==> Smith, Clerk 컬럼 데이터
SELECT 'The job '||initcap(ename)||' is a '||initcap(job)||'!' show
FROM emp
WHERE initcap(ename) LIKE 'S%'
AND initcap(job) LIKE 'C%';
-- 선생님 답
SELECT 'The job '||initcap(ename)||' is a '||initcap(job)||'!' show
FROM emp
WHERE lower(ename) like'%k%';
-- cf) WHERE ename = like'%'||upper('k')||'%';
-- Q) 대소문자 구분없이 데이터를 검색하려면 어떻게 처리할 것인가?

-- dual 가상테이블 : 하나의 데이터를 테스트용으로 확인할 때 사용된다.
SELECT *FROM dual;
SELECT '데이터1' 문자열, 25 숫자형, 25+30 연산, '안녕'||'하세요' 문자연결 FROM dual;

-- concat(문자열1, 문자열2)
SELECT concat('좋은','날입니다. ^^') concat1 FROM dual;
SELECT concat(empno, ename) show FROM emp;
-- substr(문자열데이터, 시작위치, 시작위치에서 갯수)
SELECT substr('sql*plus', 5, 4) substr01 FROM dual;
-- 1부터 시작하는 5번째 p문자부터 4개를 추출해서 출력한다.
-- ex) 951212-2701521 본인의 주민번호를 기준으로 substr를 활용하여 @@년 @@월 @@일 생일하고 표현하세요
SELECT substr('951212-2701521',1,2)||'년 '||
	substr('951212-2701521',3,2)||'월 '||
	substr('951212-2701521',5,2)||'일 생일' 생일
FROM dual;
-- 문자열 길이 length, lengthb
SELECT length('hello') str1, lengthb('hello') str2,
		length('안녕하세요') str3, lengthb('안녕하세요') str4
FROM dual;
SELECT ename, length(ename)
FROM emp;
-- ex) 사원명과 직책의 글자수를 사원명과 직책명과 함꼐 출력하되, 직책의 글자수가 6이상인 경우만 검색하세요.
SELECT ename, length(ename) 이름글자수, job, length(job) 직책글자수
FROM emp
WHERE length(job)>=6;
