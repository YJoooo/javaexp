/*
# 테이블 생성.
1. 지식계열화 내용
	1) 데이터 유형에 대한 이해
	2) 기본 테이블 생성과 데이터 입력
	3) 제약조건
	4) sequence 처리.
	5) 테이블 생성과 샂게 및 다양한 데이터 입력 연습.
		제약조건 primary key, boolean 처리
	6) 테이블 구조의 변경 : 컬럼 추가, 컬럼이름 변경, 컬럼 삭제
	7) 테이블간의 관계 설정 : 설계 단계
*/
SELECT * FROM emp;
-- 1. 구성하는 컬럼들을 설정할 수 있는 데이터 유형 파악.
--		숫자 : number, 문자열 char, varchar2, 날짜 : date
-- 2. 기본 테이블 생성방법.
--		create table (컬럼명 number, 컬럼명 char, 컬럼명 varchar2(50)..)
-- 3. 제약조건 : 입력 수정하는 데이터 무결성. ex) key데이터의 중복 불가 - 학번, 주민번호..
--		ex) 반드시데이터 입력해야되는 경우, 참조테이블에 있는 데이터만 입력, 특정 데이터 check입력 남/여만 입력
--		컬럼명 number primary key,
-- 4. sequence 객체 사용 : primary key와 같이 중복을 하지 않는 데이터를 자동으로 생성하는 oracle 객체
--		1000, 1001....
-- 5. 위 제약조건과 sequence 객체를 통해 입력/수정 처리 연습 및 처리 내용 확인
-- 6. 생성된 테이블의 구조를 변경 : 컬럼명 변경, 컬럼의 유형 변경, 컬럼의 삭제/추가, 제약조건의 수정 및 추가.
-- 7. 테이블간의 관계 설정 : 설계 단계 - erd 관계형 데이터 설정시 문제 정규화 과정에 대한 이해..
SELECT * FROM emp;
