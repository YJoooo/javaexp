--2022-05-27
--[1단계:개념] 1. 무결성 제약조건을 설정하는 목적을 기술하세요.
--	데이터의 정확성과 일관성을 유지하고 보증하기 위하여
--	즉, 정보가 변경되거나 오염되지 않도록 하기위해 (위조 방지)
--[1단계:개념] 2. not null 무결성 제약조건의 기본예제와 함께 제약조건의 내용을 기술하세요
CREATE TABLE people(
	NO NUMBER PRIMARY KEY, 
	name varchar2(50) NOT NULL,
	age NUMBER NOT NULL
);
INSERT INTO people values(1,NULL,20);-- x NULL 값 불가
INSERT INTO people values(1,'홍길동',20);-- o
INSERT INTO people values(2,'박길동',null);-- x NULL 값 불가
INSERT INTO people values(3,'홍길동',30);-- o 중복값 가능
INSERT INTO people values(4,'김길동',20);-- o 중복값 가능

--[1단계:개념] 3. unique 무결성 제약조건의 기본예제와 함께 제약조건의 내용을 기술하세요
CREATE TABLE mart(
	NO NUMBER unique, 
	name varchar2(50) NOT NULL,
	price NUMBER NOT null
);
INSERT INTO mart values(1,'아수스 비보북',600000);-- o
INSERT INTO mart values(2,'아이패드 9세대',450000);-- o
INSERT INTO mart VALUES(2,'애플펜슬 1세대',100000);-- x 중복값 불가
INSERT INTO mart values(null,'애플펜슬 1세대',100000);-- o NULL 값 가능
SELECT * FROM mart;
--[1단계:확인] 4. 회원테이블에서 id, pass, 이름, 권한, 포인트를 설정하되,
--      제약조건의 이름은 모두가 설정하고,
--      id : not null, unique, pass : not null, 이름: not null
--      권한 : 관리자/일반사용자/슈퍼유저 만등록, 포인트 : 0이상 등록 가능
CREATE TABLE member02(
	id varchar2(20) CONSTRAINT member02_id_ck UNIQUE NOT NULL,
	pass varchar2(20) CONSTRAINT member02_pass_ck NOT NULL,
	name varchar2(20) CONSTRAINT member02_name_ck NOT NULL,
	authority varchar2(20) CONSTRAINT member02_authority_ck check(authority IN('관리자','일반사용자','슈퍼유저')),
	point NUMBER CONSTRAINT member02_point_ck CHECK(point>=0)
);
INSERT INTO member02 values('hong123','hong124','홍길동','일반사용자',1000);
SELECT * FROM member02;
--[1단계:개념] 5. 무결성 제약 조건의 null의 관계를 기술하세요.
--	not null : null사용 x
--	unique : null 사용 o
--	primary key : null사용 x
--	check : null 사용 o
--	foreign key : 부모키는 제약 조건에 따라 다르지만 참조키는 null 사용 o

--[1단계:개념] 6. 무결성 제약조건의 이름을 쓰는 경우와 쓰지 않는 경우 형식의 차이를 기술하세요.
--	이름을 쓰는 경우 : 컬럼명 데이터유형 constraint 제약명 제약조건
--	이름을 쓰지 않는 경우 : 컬럼명 데이터유형 제약조건
--	# (constraint 제약명) 생략가능

--[1단계:확인] 7. 물건(물건번호, 이름, 가격, 단위, 분류번호) 제품구분(분류번호, 분류명, 우선순위)
--      1000 사과   3000 개  10     10 과일류 1
--      1001 소고기 10000 g  20     20 육류  2
--        제품구분의 분류번호와 물건의 분류번호는 foreign key 관계로 설정하세요.

DROP TABLE product1;
CREATE TABLE Category(
	divideno NUMBER PRIMARY KEY,
	divname varchar(50) NOT NULL,
	ranking NUMBER NOT null
);

CREATE TABLE product1(
	NO NUMBER PRIMARY KEY,
	name varchar(50) NOT NULL,
	price NUMBER NOT NULL,
	unit varchar(5),
	divideno NUMBER REFERENCES Category(divideno));

INSERT INTO Category VALUES(10,'과일류', 2);
INSERT INTO Category values(20,'육류', 1);
INSERT INTO Category values(30,'채소류', 3);
SELECT * FROM Category;

INSERT INTO product1 values(1000,'사과',3000,'개',10);
INSERT INTO product1 values(1001,'소고기',10000,'g',20);
SELECT * FROM product1;

