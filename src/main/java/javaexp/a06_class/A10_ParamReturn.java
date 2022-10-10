package javaexp.a06_class;

public class A10_ParamReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 메서드의 매개변수와 리턴값 처리 연습
		1. 객체의 기능메서드는 매개변수를 통해 입력되고, 리턴값을 통해서 데이터의 최종결과를 받을 수 있다.
		2. 두개의 구성요소에 대한 입/출력에 대한 종합 예제를 해보자.
		 */
		Calcu c1 = new Calcu();
		System.out.println(c1.plus(25,30));
		int tot = c1.plus(40,30);
		System.out.println("변수할당:"+tot);
		
		String plusInfo = c1.plus("+",50,4);
		System.out.println(plusInfo);
		
		// ex) Product06 클래스를 선언하고, buy()메서드를 통해서 물건 가격과 물건 갯수를 입력받아서 내용을 출력하고 총계를 리턴하여 출력
		//		메서드는 2번 호출하여 결과값을 출력.
		// 같은 패키지 안에 동일한 클래스 있을 시 에러나니, 클래스명 변경
		Product06 p01 = new Product06();
		System.out.println(p01.buy(3000, 2));
		int tot2 = p01.buy(4000, 5);
		System.out.println("구매총액:"+tot2);
		
		String buyInfo = p01.buy("사과", 2000,3);
		System.out.println(buyInfo);
	}

}
class Product06{
	int buy(int price,int cnt) {
		System.out.println("물건의 가격:"+price);
		System.out.println("물건의 갯수:"+cnt);
		return price*cnt;
	}
	String buy(String name, int price, int cnt) {
		// 입력받은 내용을 선언된 메서드를 통해서 전달하고, 그 결과를 받아서 처리.
		int tot = buy(price,cnt);
		
		return"구매 정보:"+name+", 총비용:"+tot;
	}
	
}
class Calcu{
	int plus(int num01,int num02) {
		System.out.println("입력값 num01:"+num01);
		System.out.println("입력값 num02:"+num02);
		return num01+num02;
	}
	// ex) plus의 매개변수 연산자(+,-..), 첫번째숫자, 두번쨰숫자
	//		리턴 유형으로 문자열로 처리하여 변수에 할당하여 출력하세요.
	String plus(String operator, int num01, int num02) {
		int totNum = plus(num01,num02);
		
		return num01+operator+num02+"=" +totNum;
	}
}