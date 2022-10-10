CREATE TABLE INFMEMBER(
	memno NUMBER PRIMARY KEY,
	email varchar2(50),
	password varchar2(50)
);
-- 회원가입(삽입)
INSERT INTO INFMEMBER values(1,'hong1234@naver.com','165985@@hong');
INSERT INTO INFMEMBER values(2,'Han1234@googel.com','Han985564354!');
INSERT INTO INFMEMBER values(3,'kim@naver.com','yeonjoo519$#@');
INSERT INTO INFMEMBER values(4,'5432Hong@naver.com','$!$#gil546513');
INSERT INTO INFMEMBER values(5,'dkwnRKfk@naver.com','$!$#gil546513');
-- 비밀번호 변경(수정)
UPDATE INFMEMBER
	SET password = 'yeon45359$#@'
	WHERE email = 'kim@naver.com';
-- 회원탈퇴(삭제)
DELETE 
FROM INFMEMBER
WHERE memno = 2;
SELECT *FROM INFMEMBER;

CREATE TABLE infprofile(
	memno NUMBER PRIMARY KEY,
	FOREIGN KEY(MEMNO)
	REFERENCES INFMEMBER(MEMNO),
	nickname varchar2(100),
	introduce varchar2(500)
);
SELECT * FROM infprofile;
-- 프로필 생성
INSERT INTO infprofile values(1,'길동이','안녕하세요 공부 열심히 하겠습니다');
-- INSERT INTO infprofile values(2,'한','반갑습니다'); -- INFMEMBER 테이블에 멤버번호 2번이 없어서 생성 불가
INSERT INTO infprofile values(3,'홍홍','자바 공부 중 입니다.');
INSERT INTO infprofile values(4,'나나','지금은 쉬는 중 입니다.');

-- 닉네임 변경
UPDATE infprofile
	SET nickname = '하하하'
	WHERE memno = '3';
-- 자기소개 삭제
DELETE 
FROM infprofile
WHERE nickname = '나나';
SELECT *FROM INFMEMBER;
DROP TABLE infpost;
-- # 작성게시글
CREATE TABLE infpost(
	memno NUMBER PRIMARY KEY,
	FOREIGN KEY(MEMNO)
	REFERENCES INFMEMBER(MEMNO),
	created Date,
	community varchar2 (300)
	CONSTRAINT community_ck check(community IN('질문','자유주제','스터디')),
	title varchar2 (300),
	tag varchar2(300),
	Contents varchar2(1000)
);
SELECT * FROM infpost;
-- 게시글 작성
INSERT INTO infpost values(1,'2022-04-01','질문','자바 질문',NULL,'질문입니다.');
INSERT INTO infpost values(3,'2022-01-05','질문','객체지향','#자바','자바는 객체지향이 맞나요?');
INSERT INTO infpost values(4,'2021-10-24','스터디','에러 문제','#에러','에러 해결 부탁드립니다.');
INSERT INTO infpost values(5,'2019-8-17','자유주제','계획세우기',NULL,'공부계획은 어떻게 되시나요?');
-- 내용 변경
UPDATE infpost
	SET Contents = '오라클 sql문 수정은 어떻게 하나요?'
	WHERE memno = '1';
-- 게시글 삭제
DELETE 
FROM infpost
WHERE created = '2022-01-05';
SELECT *FROM infpost;
-- # 관리자
CREATE TABLE infmanager(
	mgrno NUMBER PRIMARY KEY,
	name varchar2 (50),
	nickname varchar2 (50)
);
SELECT * FROM infmanager;
-- 관리자 등록
INSERT INTO infmanager values(9001,'김지연','지미');
INSERT INTO infmanager values(9002,'안준호','쭌');
INSERT INTO infmanager values(9003,'이소진','인프런이끄미');
INSERT INTO infmanager values(9004,'강진혁','진할배');
-- 닉네임 변경
UPDATE infmanager
	SET nickname = '진아재'
	WHERE mgrno = 9004;
-- 관리자 퇴사
DELETE 
FROM infmanager
WHERE mgrno = 9002;
SELECT *FROM infmanager;
-- # 공지사항
DROP TABLE infnotice;
CREATE TABLE infnotice(
	notno NUMBER PRIMARY KEY,
	mgrno NUMBER,
	FOREIGN KEY(mgrno)
	REFERENCES infmanager(mgrno),
	created date,
	title varchar2(500),
	contents varchar2(1000)
);
SELECT * FROM infnotice;
-- 공지사항 작성
INSERT INTO infnotice values(1,9001,'2022-01-09','공지사항입니다.','공지입니다.');
INSERT INTO infnotice values(2,9004,'2020-06-17','사이트 에러 해결문제 입니다.','동영상 재생중단 문제 해결');
INSERT INTO infnotice values(3,9001,'2019-07-20','이벤트 공지입니다.','수강료 10% 할인');
INSERT INTO infnotice values(4,9003,'2022-06-07','통합 계정 서비스 안내입니다.','6월부터 통합계정으로 바뀝니다.');

-- 공지사항 관리자 변경
UPDATE infnotice
	SET mgrno = 9003
	WHERE title = '공지입니다.';
-- 공지사항 삭제
DELETE 
FROM infnotice
WHERE notno = 3;
SELECT *FROM infnotice;
--# 블로그 게시글
CREATE TABLE infblogpost(
	postno NUMBER PRIMARY KEY,
	title varchar2 (500),
	Contents varchar2(1000),
	tag varchar2(300),
	image varchar2(300),
	openclose varchar2(50)
	CONSTRAINT open_ck check(openclose IN('공개','비공개'))
);
SELECT * FROM infblogpost;
-- 블로그 게시글 작성
INSERT INTO infblogpost values(1,'제목','내용 없음','#자바',Null,'비공개');
INSERT INTO infblogpost values(3,'공부계획','공부계획입니다.','#공부',null,'공개');
INSERT INTO infblogpost values(4,'문제풀이','테이블을 만들어라',null,'table.jpg','비공개');
INSERT INTO infblogpost values(5,'코딩테스트','로그인 기능 구현하기','#로그인 #자바','login.jpg','공개');
-- 내용 변경
UPDATE infblogpost
	SET Contents = '테이블을 만들고 데이터를 넣으세요.'
	WHERE postno = '4';
-- 게시글 삭제
DELETE 
FROM infblogpost
WHERE postno = 1;
SELECT *FROM infblogpost;
-- # 블로그
DROP TABLE infblog;
CREATE TABLE infblog(
	memno NUMBER PRIMARY KEY,
	FOREIGN KEY(MEMNO)
	REFERENCES INFMEMBER(MEMNO),
	webadress varchar2 (500),
	introduce varchar2 (1000),
	postno NUMBER,
	FOREIGN KEY(postno)
	REFERENCES infblogpost(postno)
);
SELECT * FROM infblog;
-- 블로그 생성
INSERT INTO infblog values(1,'https://www.inflearn.com/users@Hong','안녕하세요','3');
INSERT INTO infblog values(3,'https://www.inflearn.com/users@Kim','자바 공부중입니다','5');
INSERT INTO infblog values(4,'https://www.inflearn.com/users@HAHA','웹개발자가 꿈입니다.','4');
-- 자기소개 수정
UPDATE infblog
	SET introduce = '컴공과 재학중인 학생입니다'
	WHERE memno = '1';
-- 블로그 삭제
DELETE 
FROM infblog
WHERE webadress = 'https://www.inflearn.com/users@Kim';
SELECT *FROM infblog;