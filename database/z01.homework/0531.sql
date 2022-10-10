--2022-05-31
--[1단계:개념] 1. 데이터베이스의 생명주기를 예시와 함께 설명하세요.
--	요구사항 분석 -> 설계 -> 구현 -> 운영 -> 감시 및 개선의 5가지 단계로 나누어 짐

--[1단계:개념] 2. 개념적모델링/논리적모델링/물리적 모델링의 차이점을 기술하세요
-- 개념적 모델링 : 포괄적인 수준의 모델링
-- 논리적 모델링 : 시스템으로 구축하려는 업무의 key, 속성, 관계 를 정확하게 표현
-- 물리적 모델링 : 데이터베이스가 물리적으로 컴퓨터에 어떻게 저장될것인가에 대한 정의를 물리적 스키마라고 한다.
--				트랜잭션 세부사항을 설게, 물리적인 저장 구조와 사용될 저장 장치 접근방법 설정
--[1단계:확인] 3. 아래와 같은 요구사항에 합당한 개념/논리/물리 모델링을 처리하세요.
--               회사는 네개의 부서를 운영한다. 부서는(부서번호, 부서이름)을 저장한다.
--               부서는 1명 이상의 직원(직원번호,직원이름,직책)을 있다. 각 직원은 하나의 부서에 소속된다.
--               직원은 부양가족(이름, 나이)이 있을 수 있다

--[1단계:확인] 4. 사원테이블 내에 사원번호와 관리자번호와 1:1관계로 설정한 엔티티타입을 erd로 만드세요.

--[1단계:확인] 5. 커플사이트에 회원들 간에 남녀 매칭하는 테이블을 구현할려고 한다. erd를 만들고, 카디넬러티를 
--            만든후, 실제 테이블을 만들고 데이터를 입력처리하여 조인결과를 확인하세요.
CREATE TABLE man(
	mno NUMBER PRIMARY KEY,
	mname varchar2(50),
	mage NUMBER,
	mjob varchar2(50)
);
CREATE TABLE woman(
	wno NUMBER PRIMARY KEY,
	wname varchar2(50),
	wage NUMBER,
	wjob varchar2(50)
);
DROP TABLE matching;
CREATE TABLE 
AS SELECT FROM man m,woman w 
WHERE  
INSERT INTO man values(1,'홍길동',28,'회사원');
INSERT INTO man values(2,'김길동',32,'ceo');
INSERT INTO man values(3,'안길동',38,'쉐프');
INSERT INTO woman values(1,'배수지'30,'은행원');
INSERT INTO woman values(2,'안소희'25,'가수');
INSERT INTO woman values(3,'김연아'28,'피겨선수');
CREATE TABLE 
--[1단계:개념] 6. DB권한과 역할을 종류를 기술하세요 
--<관리자 권한> : 관리자가 가지고 있는 권한
--CREATE USER : 사용자를 새롭게 생성하는 권한 
--DROP USER : 사용자를 삭제하는 권한 
--DROP ANY TABLE : 임의의 테이블을 삭제할 수 있는 권한 
--QUERY REWRITE : 함수 기반 인덱스를 생성하는 권한  
--BACKUP ANY TABLE : 임의의 테이블을 백업할 수 있는 권한
--<관리하는 권한> : 관리자가 사용자에게 부여하는 권한
--CREATE SESSION : 데이터베이스에 접속할 수 있는 권한 
--CREATE TABLE : 사용자 스키마에서 테이블을 생성할 수 있는 권한 
--CREATE VIEW : 사용자 스키마에서 뷰를 생성할 수 있는 권한 
--CREATE SEQUENCE : 사용자 스키마에서 시퀀스를 생성할 수 있는 권한 
--CREATE PROCEDURE : 사용자 스키마에서 함수를 생성할 수 있는 권한

--[1단계:확인] 7. 관리자 권한에서 scott3계정을 만들고, 해당 계정으로 접근하게 처리하세요