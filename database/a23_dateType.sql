/*
# 데이터 타입
1. 개요
	1) 데이터베이스에 저장되는 데이터는 문자, 숫자, 날짜, 이미지 등과 같은 다양한 형식으로 표현
	2) 실무에선 컬럼에 대한 데이터 타입이나 길이의 결정은 데이터베이스 설계 단계에서 신중하게 고려해야하는 중요한 사항
	3) 데이터베이스 설계 단계에서 잘못 선정된 데이터 타입은 응용 프로그램 개발을 어렵게 하거나 성능을 저하시키는 요인이 된다.
2. 종류
	1) 사용자 정의 : pl/sql에서 사용자 정의로 선언하여 사용한다.
	2) 내장
		- 스킬라 : *char(n), nchar(n), 
				*vrchar2(n), nvarchar2(n)
				*number(p,s)
				*date
				raw(n)
				blob, *clob, nclob, bfile
				long, long raw
				rowid
		- 모음(collection) : 주로 pl/sql에서 사용된다.
			varray
			table
		- 관계 : pl/sql에서 사용
3. 가장 많이 활용되는 oracle 데이터 타입의 종류(version에 따라 차이가 있음)
	1) char(size) : 
		- size크기의 고정 길이 문자 데이터 타입
		- 최대 크기 : 2000바이트
		- 최소 크기 : 1바이트
		ex) 주민번호, 학번, 코드성데이터
	2) varchar2(size)
		- size 크기의 가변 길이 문자 데이터 타입
		- 최대 크기 : 4000바이트
		- 최소 크기 : 1바이트
	3) nvarchar2(size)
		- 국가별 문자 집합에 따른 size 크기의 문자 또는 바이트의 가변길이 문자 데이터 타입
		- 최대 크기 : 40000바이트
		- 최소 크기 : 1바이트
	4) number(p,s)
		- 정밀도(p)와 스케이(s)로 표현되는 숫자 데이터 타입
		- p: 1 ~ 38	: 소숫점을 포한하는 전체 자리수	
		- s: 84 ~ 127 : 소숫점 이하 자리수
	5) Date : 날짜 형식을 저장하기 위한 데이터 타입.
4. 기타 데이터 유형
	1) rowid : 테이블내 행의 고유 주소를 가지는 64진수 문자 타입 행당 6바이트 (제한된rowid) 또는 10바이트(확장된 rowid)
	2) blob : 대용량의 바이너리 데이터를 저장하기 우히ㅏㄴ 데이터 타입 최대크기 4gb
	3) clob : 대용량의 텍스트 데이터를 저장하기 위한 데이터 타입 최대크기 4gb
	4) bfile :대용량의 바이너리 데이터를 파일 형태로 저장하기 위한 데이터 타입 최대크기 4gb
	5) timestamp(n) : date데이터 타입의 확장된 형태. n은 milli second자리수로 최대 9자리까지 표현가능
	6) interval year to month : 년과 월을 이용하여 기간을 저장
	7) interval day to second
		일, 시, 분, 초를 이요하여 기간을 저장
		두 날짜 갑ㅅ의 정확한 차이를 표현하는데 유효
*/
SELECT rownum,e.*
FROM emp e; -- 행별로 고유의 번호 넣기
-- 회원정보 테이블 921212-1702611
CREATE TABLE member(
	id varchar2(50),
	pass varchar(50),
	civilnumber char(14),
	point NUMBER, 
	auth varchar2(20)
);
SELECT *FROM MEMBER;
INSERT INTO member101 values('himan','7777','921212-1702611',1000,'관리자');
-- ex) 물건정보테이블을 만들되 물건의 일련번호(자리수-8)를 포함해서 물건명, 가격, 제품소개 으로 만들고 데이터를 입력하세요.
CREATE TABLE thing(
	name varchar2(50),
	serialnumber char(14),
	price NUMBER,
	introduce varchar(50)
);
INSERT into thing values('연필','12345678',1000,'연필입니다.');
SELECT * FROM thing;
