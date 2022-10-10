package javaexp.a06_class;

public class A04_Parameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 생성자 및 메서드의 매개변수 처리
		1. 함수형 기능 처리는 매개변수를 효율적으로 처리하여야 한다.
		2. 주로 외부에서 데이터를 입력할 때, 주로 사용된다.
		3. 선언..
			1) 생성자 선언
			Person(int age){ // int age = 25;
			
			}
			Person(String name{ // String name = "홍길동"
			
			}
			매개변수가 정수형으로  age로 선언하면
			
			2) 호출
			
			new Person(25);
			선언된 형식대로 1개 매개변수에 정수형 데이터를 할당하여야 한다.
			new Person("홍길동");
			
			cf) 일반적으로 클래스에 선언된 생성자 하나를 선택하여 객체 생성한다.
			
			
		 */
		ParamObj p01 = new ParamObj("홍길동");
		ParamObj p02 = new ParamObj(25);
		ParamObj p03 = new ParamObj(true);
		ParamObj p04= new ParamObj('A');
		// ex) 생성자 매개변수값 처리..
		//		House 클래스를 선언하고 생성자에 문자열, byte,char,int,double 데이터를 매개변수로 선언하고 
		//		객체 생성시 처리하게하세요(입력값 출력)
		House h01 = new House("김연주");
		House h02 = new House((byte)27);// 자동형변환이 된다.
		House h03 = new House('C');
		House h04= new House(55);
		House h05 = new House(164.8);
		House h06 = new House("서울 강남",(byte)30);
		House h07 = new House("서울 방배",(byte)40,'A');
		
		

	}

}
class House{
	String loc;
	byte dis;
	char c;
	House(String loc){
		this.loc = loc;
		System.out.println("집의 위치:"+loc);
	}
	
	// 한번에 두가지의 생성자를 호출하는 방법.
	House(String loc, byte dis){
		this(loc);
		// 최상위 라인에 this(매개변수)를 통해서 선언된 다른 생성자를 호출하여 사용할 수 있다.
		this.dis = dis;
	}
	House(String loc, byte dis, char c){
		this(loc,dis);
		this.c = c;
	}
	
	House(byte fage){
		System.out.println("byte 입력 :"+fage);
	}
	House(char fc){
		System.out.println("char 입력 :"+fc);
	}
	House(int fweight){
		System.out.println("int 입력 :"+fweight);
	}
	House(double fheight){
		System.out.println("double 입력 :"+fheight);
	}
	
}
class ParamObj{
	ParamObj(String name){
		System.out.println("문자열 입력:"+name);
	}
	ParamObj(int age){
		System.out.println("숫자 입력:"+age);
	}
	ParamObj(boolean b){
		System.out.println("boolean값 입력:"+b);
	}
	ParamObj(char c){
		System.out.println("char값 입력:"+c);
	}
}