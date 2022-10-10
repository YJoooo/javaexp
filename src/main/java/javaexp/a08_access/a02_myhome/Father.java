package javaexp.a08_access.a02_myhome;

public class Father {
	void callMyInfo() {
		// 접근 제어자 X(default)이상일때, 호출가능(같은 패키지 일때)
		Mine m = new Mine();
		// 같은 패키지에 있는 클래스는 private 이외애는 모두 접근이 가능
//		System.out.println(m.myPrivInfo);
		System.out.println(m.ourFamilyPlan);
		System.out.println(m.mySucceInof);
		
		
	}

}
