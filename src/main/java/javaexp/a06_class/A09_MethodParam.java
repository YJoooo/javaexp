package javaexp.a06_class;

public class A09_MethodParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 메서드의 매개변수 처리
		1. 메서드는 매개변수의 유형에 따라 데이터를 객체에 전달하고, 전달된 데이터에 따라 데이터를 처리할 수 있다.
		2. 유형
			리턴타입 메서드명(매개변수1, 매개변수2, ...){
				매개변수로 전달된 데이터처리
			}
		3. 메서드 오버로딩 규칙
			1) 외부에서 호출할 때, 식별이 가능하게 호출하면 선언이 가능하다.
			2) 기준 :
				- 매개변수 갯수
				- 타입이 다르면 갯수가 동일하여도 가능하다.
				- 타임의 순서가 다르면 가능하다.
		 */
		MethodParamExp mp = new MethodParamExp();
		mp.call();
		mp.call(25);
		mp.call(25,30);
		mp.call("문자열");
		mp.call("문자열",30);
		mp.call(30,"문자열");
		// ex) GoTravel 클래스를 선언하고
		//		오버로딩의 원칙에 따라 메서드를 선언하되
		//			1) setTarget : 목적지를 1, 2, 3개로 선언하여 출력
		GoTravel gt = new GoTravel();
		gt.setTarget("제주도");
		gt.setTarget("제주도","부산");
		gt.setTarget("제주도","부산","여수");
		
		//			2) setTarget : 비용을 선언하는 내용 처리
		gt.setTarget(1500000);
		//			3) setTarget : 목적지와 비용을 순서를 다르게 선언 출력
		gt.setTarget(1500000,"제주도","부산","여수");
		gt.setTarget("제주도","부산","여수",1500000);
		
	}

}
class GoTravel{
	void setTarget(String des) {
		System.out.println("목적지 1개: "+des);
	}
	void setTarget(String des,String des1) {
		System.out.println("목적지 2개: "+des+","+des1);
	}
	void setTarget(String des,String des1,String des2) {
		System.out.println("목적지 3개: "+des+","+des1+","+des2);
	}
	void setTarget(int cost) {
		System.out.println("비용:"+cost);
	}
	void setTarget(String des,String des1,String des2,int cost) {
		System.out.println("목적지 3곳/비용:"+des+","+des1+","+des2+"/"+cost);
	}
	void setTarget(int cost,String des,String des1,String des2) {
		System.out.println("비용/목적지 3곳:"+cost+"/"+des+","+des1+","+des2);
	}
}
class MethodParamExp{
	void call() {
		System.out.println("매개변수 없는 메서드");
	}
	void call(int num01) {
		System.out.println("매개변수 1개 메서드(숫자)");
	}
	void call(String str) {
		System.out.println("매개변수 1개 메서드(문자열)");
	}
	void call(int num01, int num02) {
		System.out.println("매개변수 2개 메서드");
	}
	void call(String str1, int num02) {
		System.out.println("매개변수 2개 메서드(순서-문자열,숫자)");
	}
	void call(int num02,String str1) {
		System.out.println("매개변수 2개 메서드(순서-숫자,문자열)");
	}
}