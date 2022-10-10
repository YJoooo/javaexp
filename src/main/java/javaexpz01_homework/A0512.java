package javaexpz01_homework;

public class A0512 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-12
//		[1단계:개념] 1. protected의 접근 범위에 대하여 예제를 통하여 기술하세요
		// 외부패키지에서는 protected로 선언되면 접근이 불가능하나,
		// 상속관계에 있으면 외부패키지이더라도 protected로 선언되면 접근이 가능하다.
		
//		[1단계:개념] 2. 다형성을 오버라이딩과 함께 기본 예제를 통하여 설명하세요.
		//책/ 소설, sf, poem
		Book bk1 = new Novle();
		bk1.publish();
		Book bk2 = new Sf();
		bk2.publish();
		Book bk3 = new Poem();
		bk3.publish();
		
//		[1단계:확인] 3. 상위 컴퓨터 부품(ComPart), 하위 Ram, Hdd, Cpu롤 선언하여 fuction메서드를 통해 해당 기능을 출력하게 선언하고
//		            다양한 기능이 처리되게 하세요..
		ComPart cp1 = new Ram();
		cp1.function();
		ComPart cp2 = new Hdd();
		cp2.function();
		ComPart cp3 = new Cpu();
		cp3.function();
		
//		[1단계:개념] 4. 추상 클래스의 특징을 기술하세요. 
		// 추상클래스는 new로 객체 생성이 불가능하다.
		// 추상클래스 참조 = new 추상클래스(); (x)
		// 추상클래스 참조 = new 하위실체클래스(); (ㅇ)
		// 추상클래스를 사용하려면 꼭 상속을 받아야 된다.
		// 추상클래스를 상속받을 경우 추상메서드는 반드시 구현해주어야 한다. 
		// 만약 추상메서드 중 하나라도 구현하지 않는다면, 자손 클래스 역시 추상클래스로 지정해 주어야 한다.

//		[1단계:확인] 5. 추상/구상클래스 선언하되, 추상클래스 Robot : 필드로 로봇종류, 
//					추상메서드 attack(), 공통메서드 move() 선언하여 처리되게 하세요.
		Robot01 r = new Cleaning();
		r.attack();
		r.move();
		
//		[1단계:개념] 6. 인터페이스의 역할을 기술하세요
//			1) 개발 코드가 객체에 종속되지 않게 --> 객체 교체할 수 있도록 하는 역할
//			2) 개발 코드 변경 없이 리턴값 또는 실행 내용이 다양해 질 수 있음(다형성)
//			3) 인터페이스 변수에 인터페이스가 구현된 서로 다른 구현 객체를 할당해서 사용이 가능합니다.
		
//		[1단계:확인] 7. 인터페이스로 SoundWay 추상메서드 sound(), 하위상속클래스 NormalSound(꽥꽥꽥), 
//					EleSound(삑삑삑)로 처리하고, Duck클래스에 SoundWay를 필드로 선언 setSound(SoundWay sw)를 
//					통해서 할당하고 duckSound()메서드를 통해서 출력처리하게 하세요.
		SoundWay s = new NormalSound();
		s.sound();
		SoundWay s1 = new EleSound();
		s1.sound();
		Duck d01 = new Duck();
		d01.duckSound();
		d01.setduck(new NormalSound());
		d01.duckSound();
		d01.setduck(new EleSound());
		d01.duckSound();
		// 소리의 여러가지 다양한 종류가 필요하면 Soundway를 상속받은(implements) 실제 클래스를 통해서 처리 할 수 있다.
	}
}
class Book{ //부모클래스
	private String kind;

	public Book(String kind) {
		super();
		this.kind = kind;
	}
	public void publish() { 
		System.out.println(kind+"을 출판했다.");
	}
}
class Novle extends Book{ // 자식클래스

	public Novle() {
		super("소설");
		// TODO Auto-generated constructor stub
	}

	@Override // 오버라이딩
	public void publish() {
		// TODO Auto-generated method stub
		super.publish();
		System.out.println("100권을 출판했다.");
	}
	
}
class Sf extends Book{

	public Sf() {
		super("판타지");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void publish() {
		// TODO Auto-generated method stub
		super.publish();
		System.out.println("초판을 출판했다");
	}
	
}
class Poem extends Book{

	public Poem() {
		super("시");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void publish() {
		// TODO Auto-generated method stub
		super.publish();
		System.out.println("5000권을 출판했다.");
	}
	
}
class ComPart{
	private String name;
	public ComPart(String name) {
		super();
		this.name = name;
	}

	public void function(){
		System.out.println(name + "은 기능을 한다.");
	}
}
class Ram extends ComPart{

	public Ram() {
		super("Ram");
		// TODO Auto-generated constructor stub
	}
	
}
class Hdd extends ComPart{

	public Hdd() {
		super("하드디스크");
		// TODO Auto-generated constructor stub
	}
	
}
class Cpu extends ComPart{

	public Cpu() {
		super("CPU");
		// TODO Auto-generated constructor stub
	}
	
}
abstract class Robot01{
	private String kind;
	public Robot01(String kind) {
		super();
		this.kind = kind;
	}
	abstract void attack();
	void move() {
		System.out.println(kind+"움직이다.");
	}

}
class Cleaning extends Robot01{

	public Cleaning() {
		super("로봇청소기");
		// TODO Auto-generated constructor stub
	}

	@Override
	void attack() {
		// TODO Auto-generated method stub
		System.out.println("청소하다");
	}
	
}
class Duck{
	private SoundWay sw;

	public void setduck(SoundWay sw) { // set메서드 소스 사용 (soundway만)
		this.sw = sw;
	}
	public void duckSound() {
		if(sw!=null) {
			System.out.println("오리가 내는 소리입니다!");
			sw.sound();
		}else {
			System.out.println("입력된 소리가 없습니다.");
		}
	}
	
}
// SoundWay s = new NormalSound(); 다형성 + 재정의
interface SoundWay{
	void sound();// public abstract 생략
}
class NormalSound implements SoundWay{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("꽥꽥꽥");
	}
	
}
class EleSound implements SoundWay{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("삑삑삑");
	}
	
}


