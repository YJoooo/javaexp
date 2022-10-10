package javaexpz01_homework;

public class A0510 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		# 1:1 관련 추가 연습 예제를 통해 종속객체를 할당하고 내용을 출력 처리하는 연습
//		1. 컴퓨터(제조사, CPU)  VS 소유주(이름, 컴퓨터)
		Owner o01 = new Owner("김연주");
		o01.ownerInfo();
		o01.choiceCom(new Computer("삼성","i7"));
		o01.ownerInfo();
//		2. 연필(종류, 제조사)VS 지우개(제조사, 연필)
		Eraser e01 = new Eraser("펜텔");
		e01.eraserpen();
		e01.choicePen(new Pencil("4B","더존"));
		e01.eraserpen();
//		3. 자동차(배기량, 제조사) VS 소유주(이름, 자동차)
		Owner01 o02 = new Owner01("김현석");
		o02.choiceCar(new Car01(1500,"도요타"));
		o02.proveCar();
//
//		2022-05-10(과제)
//		[1단계:개념] 1. static 변수와 일반 변수의 차이점을 기본 예제를 통해 설명하세요.
		// instance 변수는 객체마다 값이 다르며, 따로 지정하여 변경할 수 있는 반면,
		// static 변수는 클래스 변수이기때문에 변경하여도 변경 전 후 상관없이 클래스 안에서 모두 값이 같다.
		
//		[1단계:확인] 2. 가수의 정보(이름, 소속사, 현재타이틀곡)을 static과 일반변수를 적절하게 설정하고 메서드를 통해 출력하세요.
		Singer01.name = "아이유";
		Singer01 s01 = new Singer01("이담","Celebrity");
		Singer01 s02 = new Singer01("로엔","좋은날");
		s01.singerInfo();
		s02.singerInfo();
		
//		[1단계:개념] 3. static final 상수와 static 변수의 차이점을 기술하세요.
		// static : 객체마다 가질 필요가 없는 공용으로 사용하는 필드 혹은 인스턴스 필드를 포함하지 않는 메소드
		//			변경되면 모든 변수가 동일하게 변경
		// static final : 객체마다 값이 바뀌는 것이 아닌 클래스에 존재하는 상수이므로 선언과 동시에 초기화를 해 주어야하는 클래스 상수이다.
		//				한번 값을 지정하면 변경할수 없다.
		
//		[1단계:개념] 4. package란 무엇이고 클래스와의 관계를 설명하세요.
		// 클래스를 한곳에 묶어놓은게 패키지
		// 클래스 이름이 같아 충돌하는것을 패키지가 막아준다.
		
//		[1단계:개념] 5. 접근제어자의 범위를 기술하세요.
		// public : 접근을 제한이 없음
		// protected : 동일한 패키지 내에 존재하거나 파생클래스에서만 접근 가능
		// default : 아무런 접근 제한자를 명시하지 않으면 default 값이 되며, 동일한 패키지 내에서만 접근이 가능
		// private : 자기 자신의 클래스 내에서만 접근이 가능
		
//		[1단계:확인] 6. playroom패키지 선언과 내부적으로 친구1, 친구2 클래스 선언, studyroom패키지선언 학생1, 학생2 클래스
//		            선언후, 친구1, 학생1에서 private, X(default), public에 적절한 필드값을 선언하고, 상호간에 호출하세요.
		
//		[1단계:확인] 7. 클래스의 1:1 내용을 현실에서 3개 이상 선언하고 할당하여 출력하는 내용을 처리하세요
		// 학생(이름,나이,성별) vs 선생님(과목,학생)
		Teacher t01 = new Teacher("한국사");
		t01.study();
		t01.teaching(new Student("김태진",19,"남"));
		t01.study();

	}

}
class Student{
	private String name;
	private int age;
	private String gender;
	public Student(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	void studentInfo() {
		System.out.println(name+" 학생 인적사항");
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("성별 : "+gender);
	}
	
}
class Teacher{
	private String subject;
	private Student stu;
	public Teacher(String subject) {
		super();
		this.subject = subject;
	}
	public void teaching(Student stu) {
		this.stu = stu;
	}
	public void study() {
		System.out.println(subject+"과목 학생 list");
		if(stu==null) {
			System.out.println("학생이 없습니다.");
		}else {
			stu.studentInfo();
		}
	}
}
class Singer01{
	static String name;
	String company;
	String title;
	Singer01(String company,String title) {
		this.company = company;
		this.title = title;
	}
	void singerInfo() {
		System.out.println("# "+name +" 가수의 프로필 #");
		System.out.println("소속사 : "+company);
		System.out.println("타이틀곡 : "+title);
	}
}
class Car01{
	private int cc;
	private String company;
	public Car01(int cc, String company) {
		super();
		this.cc = cc;
		this.company = company;
	}
	public void carInfo() {
		System.out.println("# 자동차 소개 #");
		System.out.println("배기량 : "+cc);
		System.out.println("제조회사 : "+company);
	}
	
}
class Owner01{
	private String name;
	private Car01 cr;
	public Owner01(String name) {
		super();
		this.name = name;
	}
	public void choiceCar(Car01 cr) {
		this.cr = cr;
	}
	public void proveCar() {
		System.out.println(name + "님의 자동차");
		if (cr==null) {
			System.out.println("구매한 자동차가 없습니다.");
		}else {
			cr.carInfo();
		}
	}
	
}
class Pencil{
	private String kind;
	private String company;
	public Pencil(String kind, String company) {
		super();
		this.kind = kind;
		this.company = company;
	}
	public void penInfo() {
		System.out.println("# 연필 소개 #");
		System.out.println("연필 종류 : "+kind);
		System.out.println("연필 제조사 : "+company);
	}
}
class Eraser{
	private String factory;
	private Pencil pen;
	public Eraser(String factory) {
		super();
		this.factory = factory;
	}
	public void choicePen(Pencil pen) {
		this.pen = pen;
	}
	public void eraserpen() {
		System.out.println("연필 지우개");
		if (pen==null) {
			System.out.println("연필이 없습니다.");
		}else {
			pen.penInfo();
		}
	}
}
class Computer{
	private String company;
	private String cpu;
	public Computer(String company, String cpu) {
		super();
		this.company = company;
		this.cpu = cpu;
	}
	public void comInfo() {
		System.out.println("# 컴퓨터 정보 #");
		System.out.println("제조사:"+company);
		System.out.println("CPU:"+cpu);
	}
}
class Owner{
	private String name;
	private Computer com;
	public Owner(String name) {
		super();
		this.name = name;
	}
	public void choiceCom(Computer com) {
		this.com = com;
	}
	public void ownerInfo() {
		System.out.println(name+"님의 컴퓨터를 말씀드립니다.");
		if(com==null) {
			System.out.println(name+"님은 소유한 컴퓨터가 없습니다.");
		}else {
			com.comInfo();
		}
	}
}
