SELECT * FROM EMP;
SELECT max(empno) FROM emp01;
INSERT INTO emp01 values(1001,'마길동','대리',7780,to_date('2010-10-10','YYYY-MM-DD'),3500,100,10);
UPDATE emp01
	SET ename='한길동',
		job = '차장',
		mgr = 7780,
		hiredate = to_date('2000-12-10','YYYY_MM-DD'),
		sal = 5000,
		comm = 100,
		deptno = 20
WHERE empno=1001;
/*
UPDATE emp01
	SET ename=?,
		job = ?,
		mgr = ?,
		hiredate = to_date(?,'YYYY_MM-DD'),
		sal = ?,
		comm = ?,
		deptno = ?
WHERE empno=?

DELETE FROM EMP01
WHERE empno = ?
 */
SELECT * FROM emp01;
DELETE FROM EMP01 e WHERE empno = 1003;


