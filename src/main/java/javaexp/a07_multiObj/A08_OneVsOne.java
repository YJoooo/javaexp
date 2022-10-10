package javaexp.a07_multiObj;

public class A08_OneVsOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 1:1 관계 클래스 선언과 활용
		1. 1:1관계에 있는 경우는 현실에서도 많이 있을 뿐만아니라 실제 프로그래밍에서 많이 발생한다.
			ex) 사람이 가지고 있는 핸드폰, 연필 지우개, 학생과 성적표, 학생과 전공지도교수, TV와 리모콘, 결혼할 커플(남/여)
		2. 선언방식
			1) 종속된 클래스를 선언(필드 메서드)
			2) 포함하는 클래스를 선언
		 */
		HPerson p01 = new HPerson("홍길동");
		p01.usingPhone();
		p01.buyPhone(new HandPhone("01088888888","삼성갤럭시",11000000));
		p01.usingPhone();
		/*
		ex) Hobby(취미명,비용,생활기간) : 생성자를 통해서 할당, play() 취미내용 출력.
		PlayMan(이름,Hobby) - 생성자를 통해서 이름을 할당. choiceHobby(Hobby)할당 처리, playHobby()
		1) 2개 클래서 선언
		2) 필드값 선언
		---------------------------------------------------------
		3) 생성자 선언 : 데이터를 초기화 처리
		4) 기능메서드 선언 : 출력 메서드, Hobby를 할당할 메서드, @@가 취미생활이 없다/@@가 취미생활이 @@@이다.
		2) 기능메서드 내용 처리 및 출력
		 */
		PlayMan pm = new PlayMan("홍자성");
		pm.playHobby();
		pm.choiceHobby(new Hobby("산책",1000,2));
		pm.playHobby();
	
	}

}
class PlayMan{
	private String name;
	private Hobby hob;
	public PlayMan(String name) {
		super();
		this.name = name;
	}
	public void choiceHobby(Hobby hob) {
		this.hob=hob;
	}
	public void playHobby() {
		System.out.println(name+"의 취미생활");
		if(hob==null) {
			System.out.println(name+"가 취미생활이 없다.");
		}else {
			hob.play();
		}
	}
}
class Hobby{
	// 일반 객체의 필드값은 접근제어자를 private
	private String hname;
	private int price;
	private int time;
	public Hobby(String hname, int price, int time) {
		super();
		this.hname = hname;
		this.price = price;
		this.time = time;
	}
	public void play(){
		System.out.println("# 취미 내용 #");
		System.out.println("취미명 : "+hname);
		System.out.println("금액 : "+price);
		System.out.println("기간 : "+time);
	}
	
}
class HPerson{
	private String name;
	private HandPhone phone; // 아직 할당되지 않음.
	// 생성자를 통해서 이름을 할당.
	public HPerson(String name) {
		super();
		this.name = name;
	}
	public void buyPhone(HandPhone phone) { // new HandPhone("01088888888","삼성갤럭시",11000000)
		this.phone = phone; // this.phone = phone;
	}
	public void usingPhone() {
		System.out.println(name+"님 핸드폰을 사용합니다.");
		if(phone==null) {
			// phone객체가 메모리로 들어오지 않는 상황
			System.out.println("핸드폰을 소유하지 않았습니다.");
		}else { // HandPhone가 할당이 된경우.
			phone.showInfo();
		}
	}
	
}
class HandPhone{
	private String number;
	private String comp;
	private int price;
	public HandPhone(String number, String comp, int price) {
		super();
		this.number = number;
		this.comp = comp;
		this.price = price;
	}
	void showInfo() {
		System.out.println("# 핸드폰의 정보 #");
		System.out.println("번호:"+ number);
		System.out.println("제조사:"+ comp);
		System.out.println("구매가격:"+ price);
	}
	
}
