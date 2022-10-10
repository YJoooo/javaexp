package javaexpz01_homework;

import java.util.ArrayList;

public class A0509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-09
//		[1단계:개념] 1. 하나의 클래스를 통해 여러개의 객체을 생성하는 기본 예제를 작성하고 설명하세요.
		Exercise [] arr04 = new Exercise[3];
		arr04[0] = new Exercise("헬스",100000);
		arr04[1] = new Exercise("필라테스",300000);
		arr04[2] = new Exercise("요가",150000);
		arr04[0].exInfo();
		arr04[1].exInfo();
		arr04[2].exInfo();
	
		
//		[1단계:개념] 2. 배열과 반복문 처리의 형식 2개(일반 for문, forEach 문)를 예제를 통하여 기술하세요
			Today [] arr03= new Today[3];
			arr03[0] = new Today(10,"흐릴");
			arr03[1] = new Today(30,"화창할");
			arr03[2] = new Today(12,"비가 올");
			for(int idx=0;idx<arr03.length;idx++) { // 일반 for문
				arr03[idx].todayInfo();
			}
			for (Today day:arr03) { // forEach문
				day.todayInfo();
			}
//		[1단계:확인] 3. 삼각형 3개 배열을 생성하되, 삼각형의 밑면과 높이 색상을 필드로 선언하고, 생성자를 통해를 이를 할당하고
//		      출력메서드를 통해서 해당 정보를 출력하되, 면적을 리턴하는 메서드를 선언하세요.
		Triangle[] arr02 = new Triangle[3];
		arr02[0] = new Triangle(3,5,"yellow");
		arr02[1] = new Triangle(10,6,"red");
		arr02[2] = new Triangle(7,7,"blue");
		arr02[0].triInfo();
		arr02[1].triInfo();
		arr02[2].triInfo();
		System.out.println(arr02[0].triInfo());
		System.out.println(arr02[1].triInfo());
		System.out.println(arr02[2].triInfo());
		
		
//		[1단계:개념] 4. 일반 배열과 동적배열(ArrayList)의 차이점을 예제를 통해서 기술하세요.
		//일반배열 => 초기 크기가 정해지면 변경 불가
		Circles []arr01 = new Circles[3];
		arr01[0] = new Circles("김연주","보건행정학",2);
		arr01[1] = new Circles("김태성","산업경영학",3);
		arr01[2] = new Circles("오정준","자동차공학",4);
		arr01[0].peopleInfo();
		arr01[1].peopleInfo();
		arr01[2].peopleInfo();
		
		//동적배열 => 유동적으로 크기 변경 가능
		ArrayList<Circles> peoplelist = new ArrayList<Circles>();
		peoplelist.add(new Circles("김연주","보건행정학",2));
		peoplelist.add(new Circles("김태성","산업경영학",3));
		peoplelist.add(new Circles("오정준","자동차공학",4));
		peoplelist.remove(1); // 객체 삭제로 크기가 3->2로 변경
		for(int idx=0;idx<peoplelist.size();idx++) {
			peoplelist.get(idx).peopleInfo();
		}
		
//		[1단계:개념] 5. 동적배열 ArrayList의 활용 방법과 주요 기능 메서드를 기본 예제를 통하여 기술하세요.
		// 한반에 2명 이었는데 한명이 전학오고 한명 전학갔다.
		ArrayList<Ban> b = new ArrayList<Ban>();
		b.add(new Ban(1,"김연주","쥐"));
		b.add(new Ban(2,"김정임","고양이"));
		b.add(new Ban(3,"김현석","토끼"));
		b.add(new Ban(4,"김태성","강아지"));// 전학옴
		b.remove(2); // 김현석 전학감 3번자리 빔
		for(Ban bn:b) {
			bn.BanInfo();
		}
		
//		[2단계:확인] 6. ArrayList<Product>를 활용하여 구매할 물건 정보 3개를 추가하여 출력처리하세요.
//		int tot()메서드로 내용 출력과 물건가격*물건단가를 리턴하게 하여, 물건 3개의 총비용을 누적 처리되게 하세요.
		ArrayList<Product> plist = new ArrayList<Product>();
		// import 단축키 :ctrl+shift+o
		plist.add(new Product("연필",500,12));
		plist.add(new Product("지우개",1000,2));
		plist.add(new Product("자",1500,1));
		int tot = 0;
		for(Product p:plist) {
			tot+=p.tot(); // tot()기능 메서드를 통해서 console 출력과 최종값이 리턴된다.
		}
		System.out.println("총비용:"+tot);
		
//		[1단계:개념] 7. static 멤버와 instance 멤버의 차이점을 예제를 통해 기술하세요.
		Buycell02.volume = 128;
		Buycell02 phone01 = new Buycell02("삼성",970000);
		Buycell02 phone02 = new Buycell02("애플",1300000);
		Buycell02.volume = 258;// static 멤버는 변경하면 모든 결과에 영향을 미친다.
		Buycell02 phone03 = new Buycell02("LG",850000);
		phone01.showInfo();
		phone02.showInfo();
		phone03.showInfo();
		
		
	}

}
class Exercise{
	String kind;
	int price;
	Exercise(String kind,int price){
		this.kind = kind;
		this.price = price;
	}
	void exInfo() {
		System.out.println("운동종류\t"+"비용");
		System.out.println(kind+"\t"+price);
	}
}
class Today{
	int Temperatures;
	String weather;
	
	Today(int Temperatures,String weather){
		this.Temperatures = Temperatures;
		this.weather = weather;
	}
	void todayInfo() {
		System.out.println("오늘 기온은"+Temperatures+"도 이며,"+ "날씨는 "+ weather+"것으로 예상됩니다.");
	}
}
class Triangle{
	int bottom;
	int height;
	String color;
	Triangle(int bottom,int height,String color){
		this.bottom = bottom;
		this.height = height;
		this.color = color;
	}
	String triInfo() {
		System.out.println("밑면\t"+"높이\t"+"색상");
		System.out.println(bottom+"\t"+height+"\t"+color);
		return "삼각형의 면적 "+(bottom*height)+"\n";
	}
}
class Ban{
	int num;
	String name;
	String nickname;
	Ban(int num,String name,String nickname){
		this.num = num;
		this.name = name;
		this.nickname = nickname;
	}
	void BanInfo() {
		System.out.println("번호\t"+"이름\t"+"별명");
		System.out.println(num+"\t"+name+"\t"+nickname+"\n");
	}
}
class Product{
	String name;
	int price;
	int cnt;
	Product(String name,int price,int cnt){
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	int tot() {
		System.out.println("구매물건\t"+"가격\t"+"수량");
		System.out.println(name+"\t"+price+"\t"+cnt+"\n");
		System.out.println("총계 : "+price*cnt);
		return price*cnt;
	}
}
class Circles{
	String name;
	String department;
	int grade;
	Circles(String name,String department,int grade){
		this.name = name;
		this.department = department;
		this.grade = grade;
	}
	void peopleInfo() {
		System.out.println(name+"\t"+department+"과\t"+grade+"학년\n");
	}
	
}
class Buycell02{
	String brand; // instance 멤버
	int price;
	static int volume; // static 멤버
	Buycell02(String brand,int price){
		this.brand = brand;
		this.price = price;
	}
	void showInfo(){
		System.out.println("구매한 핸드폰 브랜드:"+brand);
		System.out.println("구매한 핸드폰 가격:"+price);
		System.out.println("구매한 핸드폰 용량:"+volume);
	}
}
