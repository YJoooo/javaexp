SELECT * FROM emp;
/*
조회한 결과와 같은 모양을 ResultSet 객체가 가지고 있다.
rs.next() : 행단위로 커서를 위치시켜주고, 해당 행에 데이터가 있으면 true/없으면 false
rs.next() : 한번 호출하면 첫번째 행, 두번 호출하면 두번째 행에 커서를 위치,
데이터가 12개 있으면 12번째까지 true, 13번째 호출하면 false가 나온다.
rs.getInt("empno") : sql을 결과로 나온 컬럼명과 데이터 유형에 맞게 가져온다.
rs.get데이터유형("컬럼명") : 컬럼명은 대소문자 구분하지 않는다.
ex) rs.getString("job")
ex1) 3번째 행의 sal 를 가져오려면 rs.next()3번, rs.getDouble("sal")를 호출하애하는가?
ex2) 2번째 행의 ename 를 가져오려면 rs.next()2번, rs.getString("ename")를 호출하애하는가?
ex3) 5번째 행의 deptno 를 가져오려면 rs.next()5번, rs.getInt("deptno")를 호출하애하는가?
rs.getString() : 모든 데이터를 가져올수는 있다. 문자형으로

 */
SELECT empno NO, ename name
FROM emp;
--	* 주의 * sql의 결과로 나온 컬럼명(별칭설정 했으면 별칭)으로 rs.getString("컬럼명")을 지정해야지 테이블의 컬럼명으로 하면 안된다.
--	3번째 행의 WARD를 가져오려면
--	rs.next() 3번, rs.getString("name")
SELECT count(*) cnt FROM emp;
SELECT *
FROM EMP
WHERE empno = 7369;
/*
속성을 담을 VO객체를 위한 클래스 선언
class Emp{
	private int empno;
	private String ename;
	...
	
	...
	
	
String sql = "select count(*)
				from emp
			where deptno = "+deptno;	

*/
SELECT count(*)
FROM emp
WHERE job = 'CLERK';
/*
select count(*)
fromemp
where job = CLERK; // 에러발생
 */
/*
String sql = "select count(*)
from emp
where job = '"+job+"'"; // job = 'CLERK'; 형태로 sql 만들어야함

 */

--[1단계:확인] 3. 연봉이 범위(@@~@@) 사이이고, 부서별로 검색하는 사원 정보를 PreparedStament 로 처리하여 결과를 출력하세요
SELECT *
FROM emp
WHERE sal BETWEEN 1000 AND 2000;
--[1단계:확인] 4. 사원명과 부서명을 키워드검색(like,%활용)하여, 부서명, 사원명, 사원번호, 급여를 출력 하게 하세요.
--	(PreparedStament)

SELECT *
FROM emp e, dept d
WHERE ename LIKE '%N' AND dname LIKE 'S%';
--[1단계:확인] 5. select * from dept where dname like '%'||''||'%' and loc like '%'||''||'%' 를 이용해서
--   리턴 ArrayList<Dept>로 처리해서 main()에서 확인하세요.
select * 
from dept 
where dname like '%'||''||'%' and loc like '%'||''||'%';


