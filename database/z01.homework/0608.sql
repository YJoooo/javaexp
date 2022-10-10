CREATE TABLE Dept01
AS SELECT * FROM dept;
SELECT * FROM dept01;
INSERT INTO dept01 values(50,marketing,Seoul);
INSERT INTO dept01 values(?,?,?);

UPDATE dept01
	SET deptno =?
		dname =?
		loc =?
	WHERE deptno =? 