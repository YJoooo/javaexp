--2022-05-26
--[1단계:확인] 1. inline view을 활용하여 분기별 최저급여자의 사원 정보를 출력하세요.
SELECT q.*, e.*
FROM (SELECT min(sal) sal
	FROM emp
	GROUP by to_char(hiredate,'Q')) q, emp e
WHERE q. sal = e.sal;
-- 선생님 답
--	1) 분기별 최저 급여
SELECT to_char(hiredate,'Q') div, min(sal) sal
FROM emp
GROUP BY to_char(hiredate,'Q');

--	2) 북지별 최저급여의 사원 정보
SELECT q.div, q. sal, e.empno, e.ename
FROM (
	SELECT to_char(hiredate,'Q') div, min(sal) sal
	FROM emp
	GROUP BY to_char(hiredate,'Q')
	)q, emp e
WHERE q.sal= e.sal -- 1, 3분기의 최저값이 같기에, 분기도 검색조건으로 추가하여야 한다.
AND q.div = to_char(e.hiredate,'Q')
ORDER BY div;

--[1단계:개념] 2. 삭제 처리 기본 형식과 subquery를 통한 삭제 형식를 예제를 통해서 설명하세요.
--	삭제 기본형식
SELECT * FROM EMP_CPY302 ec ;
DELETE FROM EMP_CPY301
WHERE sal < 1000; -- 조건에 맞는 한건 삭제
-- subquery를 활용한 형식
UPDATE EMP_CPY302
SET sal = (
	SELECT COMM 
	FROM EMP_CPY302
	WHERE comm IS NULL)
WHERE sal<1000;
--[1단계:확인] 3. emp02로 복사테이블을 만들고, delete subquery를 이용하여, 상/하반기 최고 급여자를 삭제처리하세요.
CREATE TABLE emp02
AS SELECT * FROM emp;
SELECT * FROM emp02;
DELETE FROM emp02
WHERE sal= (
	SELECT max(sal)
	FROM emp02
	WHERE to_char(hiredate,'Q')<=2
);
DELETE FROM emp02
WHERE sal= (
	SELECT max(sal)
	FROM emp02
	WHERE to_char(hiredate,'Q') =3 OR to_char(hiredate,'Q') = 4
);

SELECT * FROM emp02;
-- 선생님 답 (순차적으로 진행과정 생각해보기)
-- 1) 복사테이블 만들기
CREATE TABLE emp02
AS SELECT * FROM emp;
-- 2) subquery에 들어갈 query : 상/하반기 최고 급여자
SELECT hiredate, 
	decode(CEIL(to_number(to_char(hiredate, 'MM'))/6),1,'상반기','하반기') div
FROM emp02;

SELECT decode(CEIL(to_number(to_char(hiredate, 'MM'))/6),1,'상반기','하반기') div, max(sal)
FROM emp02
GROUP BY CEIL(to_number(to_char(hiredate, 'MM'))/6);

-- subquery로 풀어나가기 방법
SELECT h, decode(h4,1,'상반기','하반기') "상반기/하반기"
from(
	SELECT h, CEIL(h3) h4
	from(
		SELECT h, to_number(h2)/6 h3
		FROM(
			SELECT h, to_char(h,'MM')h2
			from(
				SELECT hiredate h
				FROM emp02)
		)
	)
);
-- 3) delete의 query 명령어로 삭제 처리
DELETE FROM emp02
WHERE (decode(CEIL(to_number(to_char(hiredate, 'MM'))/6),1,'상반기','하반기'), sal) 
		IN (
SELECT decode(CEIL(to_number(to_char(hiredate, 'MM'))/6),1,'상반기','하반기') div, max(sal)
FROM emp02
GROUP BY CEIL(to_number(to_char(hiredate, 'MM'))/6));
SELECT *
FROM emp02;
-- 커밋(commit) : 확정, 다음 접속하거나, 다른 client가 접속하면 변경이 된 사항

--[1단계:개념] 4. merge의 기본 형식을 선언하고, 2가지 기본예제(2개 테이블 비교 수정/등록, 
--            dual을 통한 데이터 비교 수정/등록)를 통하여 설명하세요.
--	merge into 목적테이블명
--	using 비교할 테이블 및 suvquery
--	on 두 테이블의 비교 조건
--	when matched then
--		비교조건이 일치할 때, 수정 구문 처리
--	when not matched then
--		비교조건이 일치하지 않을 때, 등록 구문 처리
CREATE TABLE emp10
AS SELECT * FROM emp WHERE deptno =30;
CREATE TABLE emp11
AS SELECT * FROM emp;
SELECT *FROM emp10;
SELECT *FROM emp11;
MERGE INTO emp11 b
USING emp10 a
on(b.empno = a.empno)
WHEN MATCHED THEN 
	UPDATE SET b.ename = a.ename
WHEN NOT MATCHED THEN 
	INSERT VALUES (a.empno, a.ename,a.job, a.mgr, a.hiredate, a.sal, a.comm, a.deptno);
SELECT *FROM emp10;
SELECT *FROM emp11;


--[1단계:확인] 5. 물건테이블과 회원테이블을 만들어 기본 데이터 5개를 입력하되, merge를 이용하여
--            등록/수정처리해보세요.
CREATE TABLE product02
	(pnumber NUMBER(8),pname varchar(50), price NUMBER,system varchar(50));
SELECT * FROM product02;
CREATE TABLE member01
	(mnumber number(10),mname varchar(20),pnumber number(8),pname varchar(50));
SELECT * FROM member01;
MERGE INTO member01 m
USING product02 p
ON m.PNUMBER = p.pnumber
WHEN MATCHED THEN 
	UPDATE SET m.pname = p.pname
WHEN NOT MATCHED THEN 
	INSERT values(p.pnumber ,p.pname, p.price,p.system);

-- 선생님 답 
CREATE TABLE product001(
	name varchar2(50),
	price NUMBER,
	cnt number
);
CREATE TABLE member001(
	id varchar2(50),
	pass varchar2(50),
	name varchar2(50),
	point NUMBER,
	auth varchar2(50)
);
SELECT '사과' name, 3000 price, 2 cnt FROM dual;
MERGE INTO product001 t
USING (SELECT '딸기' name, 12000 price, 2 cnt FROM dual) s
ON (t.name = s.name)
WHEN MATCHED THEN 
	UPDATE SET	t.price = s.price,
				t.cnt = s.cnt
WHEN NOT MATCHED THEN 
	INSERT VALUES(s.name, s.price, s.cnt);
SELECT * FROM product001;
--[1단계:개념] 6. 문자열, 숫자형, 날짜형 데이터 유형을 기능별로 설명하세요
-- 1) 문자형 
--		- char : 고정형 데이터 , 최대 200byte
--		- varchar2 : 가변형 데이터, 최대 400byte
-- 2) 숫자형
-- 		- number : 가변형 숫자타입
-- 3) 날짜형
-- 		- date : 고정형 날짜 타입, 7byte 고정

--[2단계:확인] 7. 어떤 회원이 구매한 물건 정보를 담는 구매테이블을 만들려고 한다. 
--        구매테이블은 어떤 컬럼이 필요할지 기술해보고, 실제 저장한 데이터를 입력해보자.
-- 물건 이름 / 바코드 / 가격 / 분류 / 구매갯수
CREATE TABLE product01 
	(barcode NUMBER(11),pname varchar(50), price NUMBER, system varchar(50), cnt NUMBER);
SELECT * FROM product01;
INSERT INTO product01 VALUES (12345678910,'연필',1500,'문구류',2);
