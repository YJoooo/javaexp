/*
# 이상현상의 개념
	테이블을 적절한 분리를 하지 않았을 때, 발생하는 이상 현상.
	==> 분리하는 과정을 단계로 만들어서 처리 하는 과정(정규화 과정)
1. 종류
	0) 내용
		학생정보와 과목정보라는 분리되어야 할 정보를 같은 테이블에서 활용하므로 하나의 학생정보를 등록, 변경, 삭제 했을 때
		발생하는 문제점에 대한 내용
	1) 삭제 이상
		- 튜플(데이터 row단위) 삭제 시 같이 저장된 다른 정부까지 연쇄적으로 삭제되는 현상
		- 연쇄 삭제문제 발생
		ex) 장미란 학생을 삭제하면 장미란이 들고 있는 스포츠 경영학이 삭제 되게 된다.
	2) 삽입 이상
		- 튜플 삽입 시 특정 속성에 해당하는 값이 없어 null값을 입력해야 하는 현상
			==> null 값 문제 발생
		ex) 박세리 학생을 삽입하면, 강좌이름, 강의실이 null이 되어 메모리의 비효율성 문제 발생한다.
	3) 수정 이상
		- 튜플 수정 시 중복된 데이터의 일부만 수정되어 데이터의 불일치 문제가 일어나는 현상
		- 불일피 문제 발생
		ex) 자료구조를 듣는 박지성의 주소를 변경하면 동일하지만 컴퓨터 공학을 듣는 박지성도 같은학생이지만 주소가 
			변경되지 않는다. 일관성을 확보할 수 없다.ㄷ
			특정 데이터의 수정에 있는 등록된 데이터를 전부 수정해야 하는 문제도 포함하고 있다.	
	캡쳐된 학생 수강 erd를 만들고, 테이블과 함께 데이터를 입력까지 하세요.
					
 */
DROP TABLE student;
CREATE TABLE student(
	sno NUMBER ,
	sname varchar2(20),
	department varchar2(20),
	adress varchar2(50),
	subname varchar2(20),
	room varchar2(20)
);
INSERT INTO student VALUES(501,'박지성','컴퓨터학과','영국맨체스터','데이터베이스','공학관 110');
INSERT INTO student VALUES(401,'김연아','체육학과','대한민국 서울','데이터베이스','공학관 110');
INSERT INTO student VALUES(402,'장미란','체육학과','대한민국 강원도','스포츠경영학','체욱관 103');
INSERT INTO student VALUES(502,'추신수','컴퓨터학과','미국 클리블랜드','자료구조','공학관 111');
INSERT INTO student VALUES(501,'박지성','컴퓨터학과','영국맨체스터','자료구조','공학관 111');
SELECT * FROM student;
/*
# 잘못된 설계의 예제 함께 하고, 수정해보기(계절학기 수강 테이블)
1. 테이블 만들기
	여름(식별자, 클래스, 가격)
	
 */
CREATE TABLE summer01(
	sid NUMBER,
	class varchar2(50),
	price NUMBER 
);
INSERT INTO summer01 values(100,'fortran',20000);
INSERT INTO summer01 values(150,'pascal',15000);
INSERT INTO summer01 values(200,'c',10000);
INSERT INTO summer01 values(250,'fortran',20000);
SELECT * FROM summer01;
-- 질의 실습해보기
-- 1) 계절학기를 듣는 학생의 학번과 수강하는 과목
SELECT sid, class
FROM summer01;
-- 2) C 강좌의 수강료
SELECT price
FROM summer01
WHERE class = 'c';
-- 3) 수강료가 가장 비싼 과목
SELECT DISTINCT class, price
FROM summer01
	WHERE price = (
	SELECT max(price)
	FROM summer01);
-- 4) 계절학기를 듣는 학생 수와 수강료 총액
SELECT count(*) "학생 수", sum(price) "수강료 총액"
FROM summer01;
-- # 삭제 이상
-- 1. 200번 학생의 계절학기 수강신청을 취소하세요.
--		그리고, 문제점이 무엇인가요?
DELETE 
FROM summer01
WHERE sid=200;
SELECT * FROM summer01;
-- c강좌의 수강료를 조회?
SELECT price 수강료
FROM summer01
WHERE class = 'c';
-- 문제점 : 특정한 학생의 수강정보를 취소했는데, 강좌정보도 모두 삭제 처리되었습니다.
--			현재 어떤 강좌가 개설되었는지 알수가 없음.
-- 이와같이 특정한 컬럼에 의해 정보가 삭제되었을때, 원치 않는 정보도 같이 삭제되어 버리는 현상을 삭제 이상이라고 한다.
-- 문제 해결 : 
INSERT INTO summer01 values(200,'c',10000);
SELECT * FROM summer01;
-- # 삽입이상
--	2. 계절학기에 새로운 자바 강좌를 개설하세요
INSERT INTO summer01 values(null,'java',null);
--		1) 수강전체 인원을 확인해보세요.
SELECT count(*)
FROM summer01;
SELECT count(sid)
FROM summer01;
SELECT count(*)
FROM summer01
WHERE sid IS NOT NULL;
--		2) 어떤문제가 발생하는지 정리해보세요.
--			수강인원을 검색할 시, 해당 컬럼에 대한 직접적인 선언 필요 count(컬럼명)
--			학생정보는 null로 처리가 된다. ==> 컬럼에 필요없는 정보 null로 쌓이게 된다.

/*
# 수정이상
사원번호 100의 fortran강좌의 수강료를 20000에서 15000으로 수정하세요
	1) 어떤문제가 발생하는가?
	2) 이것을 해결하기 위하여 어떻게 하여야 하는가?

 */

UPDATE summer01
SET price = 15000
WHERE class = 'fortran';
SELECT * FROM summer01;
-- 1) 어떤문제가 발생하는가?
--	특정한 sid의 fortran만 수강료가 20000으로 변겨하고, 그 외에는 15000 그대로 이다.
--	특정한 정보를 수정할 때, 등록된 모든 데이터를 수정처리해야 되는 문제가 발생한다.
--	데이터가 등록이 잘 못 되어있거나 오기가 있을 때에 문제가 발생한다.
--	fortran, 'fortran', '포트란' 등 입력된 데이턱가 여러가지 일 경우에 정상적인 수정이 불가능하다.

-- 2) 어떻게 처리?
UPDATE summer01
	SET price = 20000
	WHERE class = 'fortran';
DELETE 
FROM summer01
WHERE sid IS NULL;
DELETE FROM summer01
WHERE sid= 300;
SELECT *FROM summer01;
/*
# 이상 현상이 발생하지 않는 테이블 생성

*/
-- summeer01 ===> summerprice001(class, price), summerEnroll(sid,class)
SELECT * FROM summer01;
-- 1) 계절학기 과목별 수강료
CREATE TABLE summerPrice01
AS
SELECT DISTINCT class, price
FROM summer01;
--2) 학생별 수강 신청과목
CREATE TABLE summerEnro11
AS
SELECT sid, class
FROM summer01;
select * FROM summerEnro11; 
-- 학생별 수강과목과 가격
SELECT sid, p.class, price
FROM summerPrice01 p, summerEnro11 e
where p.class= e.class;
select * FROM summerPrice01;
-- summerPrice01, summerEnroll을 이용해서 아래의 초기 sql을 작성해보세요.
--	1) 계절학기를 듣는 학생의 학번과 수강하는 과목
SELECT * FROM summerEnro11;

--	2) C강좌의 수강료?
SELECT price
FROM summerPrice01
WHERE class = 'c';
--	3) 수강료가 가장 비싼 과목은?
SELECT DISTINCT class
FROM summerPrice01
WHERE price =(
SELECT max(price)
FROM summerPrice01);
--	4) 계절학기를 듣는 학생 수와 수강료 총액
SELECT count(sid), sum(price)
FROM summerPrice01 p, summerEnro11 e
where p.class= e.class;
