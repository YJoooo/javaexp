package javaexpz01_homework;

public class A0503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-03
//		[1단계:개념] 1. 클래스와 객체의 관계를 메모리를 활용하여 설명하고, 주소값을 출력하세요..
		// 객체를 만들기 위한 설계도가 클래스이다.
		Juso j01 = new Juso();
		System.out.println(j01);
//		[1단계:개념] 2. 클래스를 통해 만들어진 객체와 일반 primitive 데이터와 어떠한 차이점이 있는지 기술하세요.
		// primitive 데이터 : 실제값을 stack 영역에 저장
		// 클래스로 만들어진 객체 : 주소값을 heap 영역에 저장
		
//		[1단계:개념] 3. 클래스의 구성요소 3가지를 예제를 통해서 특징을 기술하세요.
		// 클래스의 구성요소 : 필드(field)/ 생성자(Constructor)/ 메소드(Method)
		// Pants 클래스 생성 후 매개변수 선언
		Pants pan01 = new Pants(); // 생성자 선언
		
		
		
//		[1단계:개념] 4. 매개변수의 통하여 생성자나 메서드에 데이터를 할당 처리할 수 있다. 그 기준이 되는 유형, 갯수 선언
//		              규칙(오버로딩)을 예제를 통하여 설명하세요.
		// CellPhone 클래스 선언 후 매개변수를 브랜드명, 금액, 용량으로 선언하고 데이터를 출력하세요.
		CellPhone cell01 = new CellPhone("삼성"); // cell01과 cell04는 매개변수 갯수가 다름
		CellPhone cell02 = new CellPhone("LG",900000);// cell02와 cell04는 오버로딩 규칙으로 선언가능
		CellPhone cell03 = new CellPhone(1000000,128); // cell03과 cell04는 매개변수 타입유형이 다름
		CellPhone cell04 = new CellPhone(1200000,"애플");
		
//		[1단계:확인] 5. Car 객체의 생성자를 매개변수를 제조사, 최고속도, 배기량을 기준으로 1~3개까지 선언하고 해당 데이터를
//		            출력하세요.
		Car c01 = new Car("대우");
		Car c02 = new Car("테슬라",400);
		Car c03 = new Car("현대",300,1999);
		
//		[1단계:확인] 6. 아래와 같이 여러가지 생성자를 초기화하고 출력하세요.
//		    1) Singer 클래스를 선언하고 매개변수로 이름, 소속사, 메인곡을 선언하고, 생성자를 통해서 초기화 하고 출력하세요.
		Singer s01 = new Singer("조이","SM","빨간맛");
		System.out.println("가수의 이름은 "+s01.name);
		System.out.println("가수의 소속사는 "+s01.company);
		System.out.println("가수의 메인곡은 "+s01.song);
//		    2) Game 클래스를 선언하고 출시회사, 비용, 인기순
		Game g01 = new Game("라이엇게임",2100000000,1);
		System.out.println("롤의 출시회사:"+g01.start);
		System.out.println("롤의 제작비용:"+g01.cost);
		System.out.println("롤의 인기순위:"+g01.ranking);

	}

}
class Juso{
	
}
class Pants{
	int cnt; // 필드 선언
	int price;
	
}
class CellPhone{
	CellPhone(String brandname){
		System.out.println("구매한 핸드폰의 브랜드:"+brandname);
	}
	CellPhone(String brandname,int price){
		System.out.println("구매한 핸드폰의 브랜드:"+brandname);
		System.out.println("구매한 핸드폰의 가격:"+price);
	}
	CellPhone(int price,int volume){
		System.out.println("구매한 핸드폰의 가격:"+price);
		System.out.println("구매한 핸드폰의 용량:"+volume);
	}
	CellPhone(int price,String brandname){
		System.out.println("구매한 핸드폰의 가격:"+price);
		System.out.println("구매한 핸드폰의 브랜드:"+brandname);
	}
}
class Car{
	Car(String brand01){
		System.out.println("#1개#");
		System.out.println("제조사:"+brand01);
	}	
	Car(String brand02,int MaxSpeed02){
		System.out.println("#2개#");
		System.out.println("제조사:"+brand02);
		System.out.println("최고 속도:"+MaxSpeed02);
	}	
	Car(String brand,int MaxSpeed,int beagi){
		System.out.println("#3개#");
		System.out.println("제조사:"+brand);
		System.out.println("최고 속도:"+MaxSpeed);
		System.out.println("배기량:"+beagi);
	}
}
class Game{
	String start;
	int cost;
	int ranking;
	Game(String start,int cost,int ranking){
		this.start=start;
		this.cost=cost;
		this.ranking=ranking;
	}
}
class Singer{
	String name;
	String company;
	String song;
	Singer(String name, String company, String song){
		this.name = name;
		this.company = company;
		this.song = song;
	}
}