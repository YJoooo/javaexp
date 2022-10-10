package javaexp.a07_multiObj;

import java.util.ArrayList;

import javaexp.z03_vo.*; // 해당 패키지 안에있는 모든 클래스를 객체화하여 사용 가능

public class A10_OneVsMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 1:다관계 객체 처리.
		1. 프록래밍에서 1:다관계의 내용은 자주 발생하는 프로그래밍 형태이다.
		2. 하나의 클래스안에 여러개의 다중의 선언된 클래스를 호출하여 선언하고 할당하는 경우를 말한다.
			1) 다른 종류의 여러가지 객체가 할당되는 경우
				ex) 컴퓨터안에 cpu, ram, hdd등 여러가지 다른 종류의 내용들이 할당되어 되는 경우
				class Computer{
					private String comp;
					private Cpu cpu;
					private Ram ram;
					private Hdd hdd;
					public void addCpu(Cpu cpu){
						this.cpu = cpu;
					}
					public void addRam(Ram ram){
						this.ram = ram;
					}
					..
					public void showInfo(){
						if(cpu!=null){
							cpu.showInfo();
						}else{
							System.out.println("cpu가 장착되지 않았습니다!")
						}
					}
				}		
			2) 같은 종류의 여러가지 객체가 할당되는 경우
				ex) 마트안에 판매하는 여러개의 물품을 구매하는 경우
					배열이나 동적배열 ArrayList를 통해 처리.
			3) 하나의 클래스 안에 같은 종류의 다중의 클래스 선언과 호출, 다른 종류의 클래스 선언과 호출.		
		3. 위 내용은 하나씩 객체를 할당하는 메서드를 사용하는 경우와 한꺼번에 할당하는 경우가 있다.
			1) 마트에서 물건을 하나씩 담는 경우
				ex) 
				class Mart{
					private String name;
					private ArrayList<Product> plist;
					public Mart(String name){
						this.name = name;
						plist = new ArrayList<Product>(); // 생성자를 통한 초기화 처리
					}	
					// 하나씩 물건을 담는 경우에는 생성자를 통하여 동적배열(ArrayList)가 생성되어야 한다.
					public void buyOne(Product p){
					plist.add(p);
				}
			2) 마트에서 세트로 물건을 바로 담는 경우
				class Mart{
					private ArrayList<Product> plist;
					public void buyAll(ArrayList<Product> plist{
						this.plist = plist;
					}
		4. 담은 다중의 물건을 확인할 때, 반복문을 활용한다. 단 이때도 조건 처리로 해당 내용을 메모리를 확인하거나, 
			담은 갯수가 1개 이상인 경우로 처리하는 경우가 많다.	
			public void calcuProd(){
				System.out.println(name+"마트에서 구매한 물건 계산");
				if(plist!=null && plist.size()>0){
					for(Product p:plist){
						p.showInfo();
					}
		5. 구현 순서
			1) 다중으로 처리한 종속된 단위 객체를 위한 클래스 선언.
			2) 해당 다중 객체를 포함할 클래스 선언
				- 필드 : ArrayList<단위객체>
				- 초기 생성자 설정 : 속성값 초기화, ArrayList<단위객체>객체 생성
				- 다중의 데이터 처리할 입력 메서드 선언.
				- 1:다관계로 출력하거나 리턴할 객체 선언.
					if(list!=null && list.size()>0)
		 */
		Product p = new Product("사과",3000,2);
		System.out.println(p);
		Mart m = new Mart("행복"); // ctrl+shift+o
		m.calcu();
		m.addCart(new Product("사과",3000,2));
		m.addCart(new Product("바나나",4000,2));
		m.addCart(new Product("딸기",12000,2));
		m.calcu();
/*
ex) BPlayer : 번호, 이름, 생년월일 show() 단위정보
	BTeam : 팀명, ArrayList<BPlayer>
		public void addPlayer(BPlayer bp)
		public void showTeamList()
		팀명과 등록된 선수 정보 출력
		
1) 	package javaexp.z03_vo에
	BPlayer 클래스 선언
	BTeam 클래스 선언
2) main()호출 처리.
	BTeam 객체생성과 초기화
	BPlayer 단위객체 추가처리
	전체리스트 출력메서드 호출
*/
		BTeam bt = new BTeam("SSG"); // 객체생성
		bt.showTeamList();
		//외부에서 등록할 멤버를 한번에 List형태로 만들어서 바로 할당 처리하는 경우
		ArrayList<BPlayer>blist = new ArrayList<BPlayer>();
		blist.add(new BPlayer(29,"김광현","1988-07-22"));
		blist.add(new BPlayer(17,"추신수","1982-07-13"));
		blist.add(new BPlayer(33,"노바","1987-01-12"));
		
		bt.setBlist(blist);
		//bt.showTeamList();
		
		//한명씩 등록 멤버 처리.
		bt.addPlayer(new BPlayer(29,"김광현","1988-07-22"));
		bt.addPlayer(new BPlayer(17,"추신수","1982-07-13"));
		bt.addPlayer(new BPlayer(33,"노바","1987-01-12"));
		bt.showTeamList();
	}
}
