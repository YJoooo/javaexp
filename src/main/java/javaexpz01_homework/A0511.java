package javaexpz01_homework;

import java.util.ArrayList;

public class A0511 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		[1단계:개념] 1. 1:1관계 클래스와 1:다관계 클래스를 구현할 때, 구조상/코드상 차이점을 기술하세요. 
//		- 1: 다관계에서는 다중처리를 위한 배열이 필요하다.
//		[1단계:개념] 2. 1:다관계 클래스 구현할 때, 간단한 예제와 함께 구현 순서를 기술하세요.
//		# 1:1 관계
//			1) 2개 클래스 선언
//			2) 필드값 선언
//			3) 필드값 초기화 생성자 선언
//			4) 기능메서드 선언
//			5) 기능메서드 내용 처리 및 출력
//		# 1:N 관계
//			1) 다중으로 처리한 종속된 단위 객체를 위한 클래스 선언.
//				- 필드선언
//				- 매개변수 없는 생성자 선언
//				- 필드값 초기화 생성자 선언
//				- 기능 메서드 선언
//				- 각 필드값을 쓰기 메서드와 읽기 메서드를 구분하여 처리
//			2) 해당 다중 객체를 포함할 클래스 선언
//			- 필드 (배열이나 동적배열 ArrayList를 통해 처리)
//			- 초기 생성자 설정
//			- 다중의 데이터 처리할 입력 메서드 선언.
//			- 1:다관계로 출력하거나 리턴할 객체 선언.
		
		
//		[1단계:확인] 3. 아래의 여러가지 1:다 관계 클래스를 선언하고 출력하세요.
//		         1) 버스, 버스에 탄 승객
		Bus01 b01 = new Bus01(1000);
		b01.showPassList();
		b01.addPass(new Passengers("김연주","무직"));
		b01.addPass(new Passengers("김현석","사업가"));
		b01.addPass(new Passengers("김정임","직장인"));
		b01.showPassList();
		
//		         2) 담당교수, 수강 학생
		Professor pf = new Professor("정창훈");
		pf.showStudent();
		pf.addStudent(new Student3("김연주",3.5));
		pf.addStudent(new Student3("이지수",3.7));
		pf.addStudent(new Student3("송혜림",4.2));
		pf.showStudent();
		
		
//		         3) 기차, 기차 좌석정보
		Train tr = new Train("춘천");
		tr.showSeatList();
		tr.addSeat(new Seat(2,5));
		tr.addSeat(new Seat(5,10));
		tr.addSeat(new Seat(7,15));
		tr.showSeatList();
		
//		[1단계:개념] 4. 상속의 한계에 대하여 예제와 함께 기술하세요
//		상위 클래스 기능에 오류 생기거나 기능의 추가/변경 등으로 변화가 생겼을 때 하위 클래스는 상위 클래스의 부분 집합이기 때문에
//		상위 클래스를 상속 받는 하위 클래스가 정상적으로 작동할 수 있을지에 대한 예측이 힘듬
//		하위 클래스는 반드시 상위 클래스로부터 물려 받은 기능들을 제공해야 함 + 하위 클래스에서 기능들이 추가됨
//		기능 확장에 따라 상위 클래스에서 파생된 클래스들이 많아지고, 
//		그 규모가 커짐에 따라 일관성 있게 작성하지 않은 클래스들에 대한 이해도는 점차 복잡해지고 사용에 어려움이 생길 수 있음

		
//		[1단계:확인] 5. 상위로 탈것(속도)을 선언하고, 이것을 상속받은 하위로 자동차(승객수), 
//		      트럭(중량)를 선언하고 출력하는 메서드를 통해서 출력처리하세요.
		Vehicle01 vc = new Vehicle01();
		vc.speeding();
		System.out.println(vc.speed);
		Car02 c = new Car02();
		System.out.println(c.passengers);
		c.numPassen();
		Truck t = new Truck();
		System.out.println(t.weight);
		t.ton();
		
//		[1단계:개념] 6. 상속 관계에서 super()는 생성자관계에서 사용하는 규칙을 기본 예제를 통해서
//		      기술하세요.
		English eng = new English();
		eng.teaching();
		
//		[1단계:확인] 7. 상위로 Robot을 생성자로 로봇의 종류를 할당하게 하고, Dagan, Gandam을
//		      상속하여 해당 생성자를 통해서 호출하여 처리하고 출력되게 하세요.
		Dragan dg = new Dragan ();
		dg.show();
		Gandam gd = new Gandam();
		gd.show();
		
//		[1단계:개념] 8. 메서드 재정의 규칙을 기본예제를 통해서 설명하세요.
		// 상위 클래스 Flower 선언, 꽃의 종류를 필드로 선언 재정의 메서드로 blooming()을 선언 하위로 Sunflower, Rose에서 재정의
		Sunflower sf = new Sunflower();
		sf.blooming();
		Rose r = new Rose();
		r.blooming();
		
//		[1단계:확인] 9. 상위클래스 Vehicle를 선언하고 필드로 탈것의 종류 선언, 재정의 
//		      메서드로 driving()을 선언하여 하위로 Airplane,
//		      Bus, Ship에서 재정의하여 처리하게 하세요.
		Airplane ap = new Airplane();
		ap.driving();
		Bus b = new Bus();
		b.driving();
		Ship sp = new Ship();
		sp.driving();

	}

}
class Seat{
	private int car;
	private int no;
	public Seat() {
		
	}
	public Seat(int car, int no) {
		this.car = car;
		this.no = no;
	}
	public void seatInfo() {
		System.out.println(car+"칸\t"+no+"번 좌석");
	}
	public int getCar() {
		return car;
	}
	public void setCar(int car) {
		this.car = car;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
}
class Train{
	private String taget;
	private ArrayList<Seat> stlist;
	public Train() {
		stlist = new ArrayList<Seat>();
	}
	public Train(String taget) {
		this.taget = taget;
		stlist = new ArrayList<Seat>();
	}
	public void addSeat(Seat st) {
		stlist.add(st);
		System.out.println(st.getCar()+"-"+st.getNo()+"좌석 탑승");
	}
	public void showSeatList() {
		System.out.println(taget+"행 탑승 좌석 명단");
		if(stlist.size()>0) {
			for(Seat st:stlist) {
				st.seatInfo();
			}
		}else {
			System.out.println("아무도 탑승하지 않았습니다.");
		}
	}
	public String getTaget() {
		return taget;
	}
	public void setTaget(String taget) {
		this.taget = taget;
	}
	public ArrayList<Seat> getSt() {
		return stlist;
	}
	public void setSt(ArrayList<Seat> stlist) {
		this.stlist = stlist;
	}
	
	
}
class Professor{
	private String name;
	private ArrayList<Student3> sdlist;
	public Professor() {
		sdlist = new ArrayList<Student3>();
	}
	public Professor(String name) {
		this.name = name;
		sdlist = new ArrayList<Student3>();
	}
	public void addStudent(Student3 sd) {
		sdlist.add(sd);
		System.out.println(sd.getName()+"수강신청");
	}
	public void showStudent() {
		System.out.println(name+"학생 명단");
		if(sdlist.size()>0) {
			for(Student3 sd:sdlist) {
				sd.studentList();
			}
		}else {
			System.out.println("수강신청 학생이 없습니다.");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Student3> getSdlist() {
		return sdlist;
	}
	public void setSdlist(ArrayList<Student3> sdlist) {
		this.sdlist = sdlist;
	}
	
}
class Student3{
	private String name;
	private double score;
	public Student3() {
		
	}
	public Student3(String name, double score) {
		this.name = name;
		this.score = score;
	}
	public void studentList() {
		System.out.print(name + "\t");
		System.out.print(score + "\n");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
}
class Bus01{
	private int num;
	private ArrayList<Passengers> pslist;
	
	public Bus01() {
		pslist = new ArrayList<Passengers>();
	}

	public Bus01(int num) {
		this.num = num;
		pslist = new ArrayList<Passengers>();
	}
	public void addPass(Passengers ps) {
		pslist.add(ps);
		System.out.println(ps.getName()+"버스 탑승");
	}
	public void showPassList() {
		System.out.println(num+"버스에 탑승한 승객 정보");
		if(pslist.size()>0) {
			for(Passengers ps:pslist) {
				ps.PassInfo();
			}
		}else {
			System.out.println("탑승한 승객이 없습니다.");
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ArrayList<Passengers> getPslist() {
		return pslist;
	}

	public void setPslist(ArrayList<Passengers> pslist) {
		this.pslist = pslist;
	}
	
	
}
class Passengers{
	private String name;
	private String job;
	
	public Passengers() {
	}

	public Passengers(String name, String job) {
		this.name = name;
		this.job = job;
	}
	public void PassInfo() {
		System.out.print(name+"\t");
		System.out.print(job+"\n");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	
	
}
class Subject{
	private String kind;

	public Subject(String kind) {
		this.kind = kind;
	}
	public void teaching() {
		System.out.println("가르치는 과목은 "+ kind);
	}
}
class English extends Subject{

	public English() {
		super("영어"); // 상위 클래스가 선언하는 생성자의 매개변수에 맞는 super()로 상위 클래스의 생성자를 호출하여야한다.
	}// 반드시 생성자 첫줄에 생성자 호출
	
}
class Vehicle01 {
	int speed = 200;
	void speeding() {
		System.out.println("속도:"+speed);
	}
	
}
class Car02 extends Vehicle01{
	int passengers = 5;
	void numPassen() {
		System.out.println("승객의 수 : "+passengers);
	}
}
class Truck extends Vehicle01{
	int weight = 3;
	void ton() {
		System.out.println("중량 : "+weight);
	}
}
class Robot{
	private String kind;

	public Robot(String kind) {
		this.kind = kind;
	}
	public void show() {
		System.out.println(kind+"로봇");
	}
}
class Dragan extends Robot{

	public Dragan() {
		super("드래곤");
	}
	
}
class Gandam extends Robot {
	public Gandam() {
		super("건담");
	}
}

class Flower {
	private String kind;

	public Flower(String kind) {
		this.kind = kind;
	}
	public void blooming() {
		System.out.println(kind+"꽃이 피다!");
	}
}
class Sunflower extends Flower{

	public Sunflower() {
		super("해바라기");
	}

	@Override
	public void blooming() {
		super.blooming();
		System.out.println("노란색입니다!");
	}
	
}
class Rose extends Flower{

	public Rose() {
		super("장미");
	}

	@Override
	public void blooming() {
		super.blooming();
		System.out.println("빨간색 입니다!");
	}
	
	
}
class Vehicle{
	private String kind;

	public Vehicle(String kind) {
		this.kind = kind;
	}
	public void driving() {
		System.out.println(kind+"를 운전하다!");
	}
	
}
class Airplane extends Vehicle{

	public Airplane() {
		super("비행기");
	}

	@Override
	public void driving() {
		super.driving();
		System.out.println("하늘에서 운행됩니다!");
	}
	
}
class Bus extends Vehicle{

	public Bus() {
		super("버스");
	}

	@Override
	public void driving() {
		super.driving();
		System.out.println("땅에서 운행됩니다!");
	}
	
}
class Ship extends Vehicle{

	public Ship() {
		super("배");
	}

	@Override
	public void driving() {
		super.driving();
		System.out.println("바다에서 운행됩니다!");
	}
	
}