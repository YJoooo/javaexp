SELECT * FROM emp;
-- ResulSet 으로 아래 내용이 할당된다.
-- .next() : 행단위로 이동 처리함. 그 행에 데이터가 있으면 true/없으면 false
-- .getstring("컬럼명") : 해당 row에 상단에 선언된 column명을 기준으로 데이터를 가져온다.
--		주의) select @@ 최종 컬럼명이기 alias가 있으면 alias명으로 호출하여야 한다.
--		.get데이터유형()
--			ex) rs.getInt("empno"), rs.getDate("hiredate"), sal의 경우number(4,2)로 실수형이기에 rs.getDouble("sal")

CREATE TABLE Dept01
AS SELECT * FROM dept;