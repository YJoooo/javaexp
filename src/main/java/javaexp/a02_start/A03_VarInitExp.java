package javaexp.a02_start;

public class A03_VarInitExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ex) 현재 나이는 변수로 선언하여, 초기화가 되지 않았을때,
		//     10년 후 나이를 처리해보고, 초기화한 후, 10면 후 나이를 처리하고 출력하세요.
//		int age1;
//		int age20 = age1+10;
//		System.out.println("10년후 나이:" + age20);
		int age = 27;
		int age10 = age+10;
		System.out.println("10년후 나이:" + age10);
		
		/*
		 답
		 int age;
		 age= age + 10;
		 age = 25;
		 system.out.println("초기화된 현재 나이:" + age);
		 age = age +10;
		 System.out.println("10년 후 나이:" + age);
		 */

	}

}
