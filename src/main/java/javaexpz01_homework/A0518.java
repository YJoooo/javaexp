package javaexpz01_homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A0518 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-18
//		[1단계:개념] 1. Set컬렉션의 특징을 기본 예제를 통해서 기술하세요.
		Set<String> name = new HashSet<String>();
		name.add("김연주");
		name.add("김연주");
		name.add("김현석");
		name.add("김정임");
		name.add("김태성");
		name.add("김길동");
		name.add("김길동");
		name.add("김연주");
		for(String n:name) {
			System.out.println(n); // 중복 제외하고 순서없이 출력
		}
//		[1단계:개념] 2. map컬렉션의 특징을 기본 예제를 통해서 기술하세요.
		Map<String,Integer>name1 = new HashMap<String,Integer>();
		name1.put("사과", 1100);
		name1.put("참외", 1500);
		name1.put("참외", 2000);
		name1.put("참외", 1500);
		name1.put("딸기", 12500);
		name1.put("딸기", 15000);
		name1.put("수박", 15000);
		Set<String> key = name1.keySet();
		for(String fruit:key) {
			System.out.println(fruit+" 가격은 "+name1.get(fruit));// 중복된 키는 나중에 선언된 키값으로 출력
		}
		
//		[1단계:개념] 3. Map<Integer, Player> 형태로 번호와 선수정보를 mapping하는
//		      Map 객체를 생성하여 선수의 팀명 이름 성적으로 3명 선수번호와 함께 출력하세요.
		// 번호 키 (중복되지 않음), Player 정보설정.
		Map<Integer, Player> blist = new HashMap<Integer, Player>();
		blist.put(10, new Player("삼성","피렐라",0.399)); // auto boxing 10==> Integer
		blist.put(12, new Player("롯데","이대호",0.359));
		blist.put(11, new Player("롯데","한동희",0.379));
		for(int no : blist.keySet()) { // Integer ==> int auto unboxing
			Player p = blist.get(no); // 매개체.get(키) : 연결된 단위 객체를 value로 가져온다.
			System.out.print(no+"\t");
			System.out.print(p.getTname()+"\t");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getRecord()+"\n");
		}
		
//		--[1단계:개념] 4. select 컬럼과 where 조건의 차이점를 예제로 기술하세요.
//		--SELECT -> 원하는 컬럼을 불러오고 별칭을 정할수 있다. 순서는 정할수 없다.
//		--WHERE -> 조건절로 다양한 연산자를 통해 실행할 조건을 입력받아 수행한다.
//		SELECT ename 사원명, sal 연봉 -- 원하는 컬럼에 별칭을 붙여 보여줌
//		FROM emp
//		WHERE sal >=2000; -- 연봉이 2000이상인 사람들을 걸러줌
//
//		--[1단계:활용] 5. 사원정보에서 급여가 2000~5000인 사원번호, 사원명, 급여를 출력하세요.
//		-- empno(사원번호), ename(사원명), job(직책명), mgr(관리자번호), hiredate(입사일), comm(보너스), deptno(부서번호)
//		SELECT empno, ename, sal 
//		FROM emp
//		WHERE sal BETWEEN 2000 AND 5000;
//		--[1단계:활용] 6. 직책이 CLERK와 MANAGER를 검색하여 이에 해당 하는 사원 정보를 출력하세요.
//		SELECT *
//		FROM emp
//		WHERE job = 'CLERK' or job = 'MANAGER';
//		--[1단계:활용] 7. [SUBQUERY in] 사원번호 7566, 7782가 소속된 부서번호에 해당하는 
//		--      사원정보를 출력하세요.
//		SELECT *
//		FROM emp
//		WHERE deptno in(
//			SELECT deptno
//			FROM emp
//		WHERE empno in(7566,7782)
//		);
//		--[1단계:개념] 8. 키워드 검색의 종류를 예제와 함께 나열해보세요.
//		--		'데이터%' : 해당 데이터로 시작
//		--		'%데이터' : 해당 데이터로 끝
//		--		'%데이터%' : 해당 데이터 포함
//		--		'_데이터' : 첫자이후에 특정데이터 포함 - 자릿수까지 keyword검색
//		--		'데이터_' : 데이터가 마지막 한자 데이터 포함	
//		SELECT *
//		FROM emp
//		WHERE empno LIKE '7%' -- empno에 첫글자가 7인 데이터
//			OR job LIKE '%N' -- job에 마지막 글자가 N 인 데이터
//			OR deptno LIKE '%3%' -- deptno에 3이 포함된 데이터
//			OR sal LIKE '__5%'; -- sal에 세번째 숫자가 5인 데이터
//		--[1단계:활용] 9. 1981에 입사한 사원들의 직책을 기준으로 사원정보를 출력하세요..
//		SELECT *
//		FROM emp
//		WHERE job in(
//			SELECT job
//			FROM emp
//		WHERE to_char(hiredate) LIKE '81%'
//		);
//		--[1단계:활용] 10. like 키워드로 1/4분에 입사한 사원들의 부서정보와 동일한 사원들을 출력하세요.
//		SELECT *
//		FROM emp
//		WHERE deptno in(
//			SELECT deptno
//			FROM emp
//		WHERE to_char(hiredate) LIKE '__/01%'
//			OR to_char(hiredate) LIKE '__/02%'
//			OR to_char(hiredate) LIKE '__/03%'
//		);
//		--[1단계:개념] 11. 집합연산자의 종류를 예제를 통해서 기술하세요.
//		--	1) union : 두 집합에 대해 중복되는 행을 제외한 합집합
//		--	2) union all : 두 집합에 대해 중복되는 행을 포함한 합집합
//		--	3) minus : 두 집합간의 차집합
//		--	4) intersect : 두 집합간의 교집합
//		SELECT *
//		FROM emp
//		UNION
//		SELECT *
//		FROM emp_cp100; -- 중복행 제외한 합집합
//		SELECT ename
//		FROM emp
//		MINUS
//		SELECT ename
//		FROM emp_cp100; -- 차집합
//		SELECT ename
//		FROM emp
//		intersect
//		SELECT ename
//		FROM emp_cp100; -- 교집합
//		SELECT ename, sal
//		FROM emp
//		UNION all
//		SELECT ename, sal
//		FROM emp_cp100;--중복포함 합집합
	}

}
class Player{
	private String tname;
	private String name;
	private double record;
	public Player(String tname, String name, double record) {
		super();
		this.tname = tname;
		this.name = name;
		this.record = record;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRecord() {
		return record;
	}
	public void setRecord(double record) {
		this.record = record;
	}

}