package javaexp.a08_access.a04_woodhome;

public class Daughter extends WoodCutter{
	public void callWoodCutter() {
		// 상속관계에 있는 클래스는 객체 생성을 할 필요가 없다.
		// 같은 패키지에 있으면 private이외 모든 필드를 접근할 수 있다.
//		System.out.println("private:"+priveSec);
		System.out.println("default:"+payOurHome);
		System.out.println("protected:"+inheritMoney);
		System.out.println("public:"+announce);
	}
}
