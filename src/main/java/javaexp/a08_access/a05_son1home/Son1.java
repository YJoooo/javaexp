package javaexp.a08_access.a05_son1home;

import javaexp.a08_access.a04_woodhome.WoodCutter;

public class Son1 extends WoodCutter {
	public void callWoodCutter() {
		
	// 상속관계에 있는 클래스는 객체 생성을 할 필요가 없다.
	// 같은 패키지에 있으면 private이외 모든 필드를 접근할 수 있다.
//	System.out.println("private:"+priveSec);
	// 외부 패키지이기 떄문에 default는 접근할 수 없다.
//	System.out.println("default:"+payOurHome);
	//protected(상속+외부패키지)
	// 상속관계에 있으면 외부패키지이더라도 protected로 선언되면 접근이 가능하다.
	System.out.println("protected:"+inheritMoney);
	System.out.println("public:"+announce);
	}
}
