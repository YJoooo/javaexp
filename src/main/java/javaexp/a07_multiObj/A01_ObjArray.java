package javaexp.a07_multiObj;

public class A01_ObjArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 객체형 배열 처리
		1. 하나의 클래스에서 만들어진 객체는 여러개의 배열로 사용할 수 있다.
		2. 객체 배열
			단위객체명[] 배열명 = new 단위객체명[갯수];
			단위객체명[] 배열명 = {new 객체명(),new 객체명(),....};
			배열명[index번호] ; 호출
			배열명[index번호] = new 객체명(); 할당
		*/
		Student []arr1 = new Student[3];
		// 각 index별로 실제 객체를 할당하고 메서드를 사용
		arr1[0] = new Student(1,"홍길동"); arr1[0].setPoint(80);
		arr1[1] = new Student(2,"신길동"); arr1[1].setPoint(90);
		arr1[2] = new Student(3,"마길동"); arr1[2].setPoint(100);
		int tot = 0;
		// 해당 메서드를 통해서 점수가 return이 되기 때문에 tot 이라는 변수에 누적할 수 있다.
		// 리턴값이 있으면 해당 메서드를 호출하는 곳에서 데이터를 활용이 가능하다.
		tot+=arr1[0].showInfo();
		tot+=arr1[1].showInfo();
		tot+=arr1[2].showInfo();
		System.out.println("총점수:"+tot);
		
		// ex) Fruit 필드 : 과일종류, 가격, 
		//			생성자: 필드값 초기화
		//			메서드 :show(): 종류와 가격 출력.
		//		배열로 3개를 선언 및 할당, show()호출.
		Fruit []arr2 = new Fruit[3];
		arr2[0] = new Fruit("딸기",15000);
		arr2[1] = new Fruit("포도",5000);
		arr2[2] = new Fruit("망고",20000);
		for(int idx=0;idx<arr2.length;idx++) {
				arr2[idx].show();
		}
		Fruit[]arr3 = {new Fruit("오렌지",1200),new Fruit("키위",1500),new Fruit("수박",15000)};
		//for each구문을 통한 처리
		//for(단위객체:배열) : 배열에 있는 갯수만큼 반복해서 단위 객체에 할당.
		for (Fruit fru:arr3) {
				fru.show();
		}
		/*
		ex2) Computer 클래스 선언 : cpu,ram,hdd 속성을 선언하고, 객체선언과 할당을 동시처리
			생성자 : 필드 초기화
			매서드 : comInfo()를 통해 속성 출력 처리
		*/
		Computer[]arr4 = {new Computer("3.2Ghz i7",16,256),
						new Computer("3.1Ghz i5",8,256),new Computer("3.4Ghz i9",32,500)};
		// arr4[0] == new Computer("3.2Ghz i7",16,256)
		for(Computer com:arr4) {
			com.comInfo();
		}

	}

}
class Computer{
	String cpu;
	int ram;
	int hdd;
	Computer(String cpu,int ram,int hdd){
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
	void comInfo() {
		System.out.print(cpu+"\t");
		System.out.print(ram+"\t");
		System.out.print(hdd+"\n");
	}
}
class Fruit{
	String fruitName;
	int fruitPrice;
	Fruit(String fruitName,int fruitPrice){
		this.fruitName = fruitName; // 필드값 초기화
		this.fruitPrice = fruitPrice;
	}
	void show() {
		System.out.println("종류:"+fruitName+"\n가격:"+fruitPrice);
	}
}
class Student{
	int no;
	String name;
	int kor;
	Student(int no,String name){
		this.no = no;
		this.name = name;
	}
	void setPoint(int kor) {
		this.kor = kor;
	}
	int showInfo() {
		System.out.println(no+"\t"+name+"\t"+kor);
		return kor;
	}
}