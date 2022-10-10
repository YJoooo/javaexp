--2022-06-02
--[1단계:개념] 1. 잘못된 설계에 의한 이상현상을 종류 기술하세요
/*
# 삽입이상 : 새 데이터를 삽입하기 위해 불필요한 데이터까지 삽인되는 경우
# 수정이상 : 중복 튜플 중 일부만 변경하여 데이터가 불일치하게 되는 경우
# 삭제이상 : 튜플을 삭제하면 꼭 필요한 데이터까지 함께 삭제되는 데이터 손실의 경우
 */
--[1단계:확인] 2. 오늘 만든 수강테이블의 삭제이상의 경우를 처리하고 문제점을 기술하세요
DROP TABLE studentclass;
CREATE TABLE studentclass(
	stuno NUMBER,
	name varchar2(20),
	department varchar2(50),
	adress varchar2(100),
	lecture varchar2(50),
	lecroom varchar2(50)
);
INSERT INTO studentclass values(202101,'김연주','보건의료관리과','인천 서구 가정동','공중보건학','보건관 201호');
INSERT INTO studentclass values(202102,'김태성','산업경영학과','경기도 수원 영통구','통계학','경영관 302호');
INSERT INTO studentclass values(202103,'오정준','자동차학과','인천 서구 가좌동','기계설비학','공학관 501호');
SELECT * FROM studentclass;
-- Q. 김태성 학생의 수강신청 취소
DELETE 
FROM studentclass
WHERE name = '김태성';
SELECT * FROM studentclass; -- 필요한 정보인 통계학의 강의실 위치까지 사라져버림

--[1단계:확인] 3. 수강테이블의 등록이상의 경우를 처리하고 문제점을 기술하세요
INSERT INTO studentclass values(202102,'김태성','산업경영학과','경기도 수원 영통구','통계학','경영관 302호');
SELECT * FROM studentclass;
-- Q. 무역학과 무역학 강좌 개설
INSERT into studentclass values(202105,NULL,'무역학과',NULL,'무역학','경영관 305호');
SELECT * FROM studentclass; -- null을 비롯한 불필요한 정보까지 과다하게 입력됨. 
--								(stuno가 primary key라 null값 입력도 안됨.)
SELECT count(*)
FROM studentclass; -- 수강인원은 3명이지만 필수입력 사항과 NULL 값 때문에 4개로 확인됨.
SELECT count(name)
FROM studentclass
WHERE name IS NOT NULL; -- null값 제외하고 조회

--[1단계:확인] 4. 수강테이블의 수정이상의 경우를 처리하고 문제점을 기술하세요
INSERT INTO studentclass values(202101,'김연주','보건의료관리과','인천 서구 가정동','의학용어','보건관 203호');
UPDATE studentclass
SET adress = '인천 청라'
WHERE lecture = '의학용어';
SELECT * FROM studentclass; -- 김연주가 의학용어도 듣고 통계학도 듣는데, 같은사람이지만 의학용어 듣는 김연주만 주소 변경됨

--[1단계:확인] 5. 수강테이블의 이상현상을 없애기 위한 테이블 구조를 erd를 통해 분리시키고, 테이블을 작성하고 데이터를 입력하세요
CREATE TABLE student1
AS SELECT stuno, name, department, adress
FROM studentclass;

CREATE TABLE lecture1
AS SELECT stuno, lecture, lecroom
FROM studentclass;


--[1단계:확인] 6. 분리된 테이블에서 이상 현상이 더 이상 발생하지 않음을 sql을 통해 처리결과를 출력해보세요.
-- # 등록이상
-- Q. 무역학과 무역학 강좌 개설
INSERT INTO lecture1 values(NULL,'데이터 수집','정보통신관 505호');
-- # 삭제이상
-- Q. 김태성 학생의 수강신청 취소
DELETE 
FROM student1
WHERE name = '김태성';
SELECT * FROM student1; -- 학생 테이블에서만 삭제
-- # 수정이상
-- Q. lecture가 의학용어인 김연주 주소변경 --> 같은 테이블이 아니라 진행할수 없음
UPDATE student1
	SET adress = '인천 청라'
	WHERE name = '김연주';
SELECT * FROM student1;
