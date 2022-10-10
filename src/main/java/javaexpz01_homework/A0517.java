package javaexpz01_homework;

import java.util.ArrayList;
import java.util.List;

public class A0517 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-17
//		[1단계:개념] 1. 특정 DB서버에 접속에 필요한 정보는 무엇이 있는가를 기술해 보세요.
//		select *
//			컬럼1, 컬럼2
//		from 테이블명
//		--[1단계:개념] 1. 특정 DB서버에 접속에 필요한 정보는 무엇이 있는가를 기술해 보세요.
//		--[1단계:개념] 2. select 구문의 컴럼 선택과 별칭사용에 대하여 예제를 통하여 설명하세요.
//		SELECT empno 사원번호, -- 컬럼 별칭
//				ename "사 원 명", -- 컬럼 "별칭" (띄어쓰기, 특수문자 사용시 " " 사용)
//				job "#직책#"
//		FROM emp;
//		--[1단계:확인] 3. emp 테이블의 컬럼명을 한글로 표현해보세요. ex) 사원번호, 사원명, 직책, 관리자, 입사일, 급여, 보너스, 부서번호
//		SELECT empno 사원번호, ename 사원명, job 직책, mgr 관리자, hiredate 입사일, sal 급여, comm 보너스, deptno 부서번호
//		FROM emp;
//		--[1단계:확인] 4. sal를 부서번호로 부너번호%로 보너스처리하여 급여를 정하기로 했다.  sal==> 기본급여, deptno ==> 보너스, 총급여(기본급여+보너스)
//		--            로 처리하여 출력하되 alias명도 함께 처리하세요.
//		SELECT sal 기본급여, deptno||'%' 보너스, (sal*deptno/100) "보너스 금액", (sal+(sal*deptno/100)) 총급여
//		FROM emp;
//		--[1단계:확인] 5. 아래의 형식으로 컬럼간의 연산과 연결처리를 하여 alias로 출력하세요.
//		--            1) @@님의 사원번호는 @@이고, 올해 연말보너스는 연봉의 20%인 @@원입니다.  @@님(ename)
//		SELECT ename ||'님의 사원번호는 '||empno||'이고, 올해 연말 보너스는 연봉의 20%인'||sal*0.2||'원입니다.' 연말보너스
//		FROM emp;
//		--            2) @@님의 입사일은 @@이고, 현재 연봉의 1/13인 월급여는 @@만원.   입사일 @@(hiredate)
//		SELECT ename ||'님의 입사일은 '||hiredate||'이고, 현재 연봉의 1/13인 월급여는 '||ROUND(sal/13)||'만원.' 입사정보
//		FROM emp;
//		--            3) @@님의 이번달 보너스는 연봉(sal)의 deptno%기준으로  @@@만원 지급합니다. 
//		SELECT ename||'님의 이번달 보너스는 연봉('||sal||')의'||deptno||'% 기준으로 '||
//				(sal*deptno/100)||'만원 지급합니다.' "이번달 보너스"
//		FROM emp;
//
//		--[1단계:개념] 6. distinct로 데이터를 처리해야 하는 경우를 기본예제를 통해서 설명하세요.
//			-- 각 부서별로 1명만 보너스 지급 하기로 한다.
//		SELECT DISTINCT deptno
//		FROM emp;
//		[1단계:개념] 7. 기본 유형을 Wrapper 클래스로 만드는 이유를 설명하세요.
		
//		[1단계:확인] 8. 아래의 기본유형의 문자열을 Wrapper클래스의 valueOf 메서드를 이용해서 Wrapper클래스로 만들어 보세요.
//		                (Integer,Character,Boolean)
		Integer num = Integer.valueOf("20");
		Character ch = Character.valueOf('컵');
		Boolean bl = Boolean.valueOf("true");
		System.out.println(num);
		System.out.println(ch);
		System.out.println(bl);
		
//		[1단계:개념] 9. boxing, unboxing, auto boxing/auto unboxing 개념에 대하여 기본예제로 기술하세요.
		Integer num1 = Integer.valueOf(27); // 박싱
		int n = num1.intValue(); // 언박싱
		System.out.println(n);
		int t = 90;
		Integer teg = t; // 자동박싱 Integer teg = new Integer(90); ==> 굳이 명시적으로 박싱하지 않아도 묵시적으로 일어남
		Integer teg1 = new Integer(t); // 명시적 박싱
		int t1 = teg; // 자동언박싱
		System.out.println(teg);
		System.out.println(teg1);
		System.out.println(t1);
		
//		[1단계:개념] 10. 컬렉션 프레임 웍의 최상위 인터페이스 3가지와 그 특징을 기술하세요.
//		List : 순서가 있는 데이터의 집합으로, 데이터의 중복을 허용함.
//		Set : 순서가 없는 데이터의 집합으로, 데이터의 중복을 허용하지 않음.
//		Map :키와 값의 한 쌍으로 이루어지는 데이터의 집합으로, 순서가 없음.
//			이때 키는 중복을 허용하지 않지만, 값은 중복될 수 있음.

		
//		[1단계:확인] 11. List기능 메서드를 예제를 통하여 설명하세요
		  List list = new ArrayList<Student1>();
		  list.add(new Student1 (1,"김연주"));
		  list.add(new Student1 (5,"오정준"));
		  list.add(new Student1 (7,"강하윤"));
		  for(int idx=0;idx<list.size();idx++) {
			  System.out.println(list.get(idx));
		  }
		  System.out.println("# 삭제 #");
		  list.remove(1); // 오정준 삭제
		  for(int idx=0;idx<list.size();idx++) {
			  System.out.println(list.get(idx));
		  }
		  System.out.println("# 추가 #");
		  list.add(1,new Student1(3,"김현석"));
		  for(int idx=0;idx<list.size();idx++) {
			  System.out.println(list.get(idx));
		  }
		  System.out.println("# 변경 #");
		  list.set(2,new Student1(9,"김태성"));
		  for(int idx=0;idx<list.size();idx++) {
			  System.out.println(list.get(idx));
		  }

	}

}
class Student1{
	private int ban;
	private String name;
	public Student1(int ban, String name) {
		super();
		this.ban = ban;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ban+"반 "+name;
	}
	
}