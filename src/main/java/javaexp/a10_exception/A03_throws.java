package javaexp.a10_exception;

public class A03_throws {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# throws
		1. 메소드 단위로 예외를 해당 메소드별로 코드를 처리하는 것이 아니라 메소드를 호출하는 곳에서 한꺼번에 예외를 처리할때 활용된다.
		2. 기본형식
			리턴타입 메소드명() throws 예외클래스1, 예외클래스2{
			
			}
			
		 */
		// 컴파일 예외 처리(필수예외)
		//Class clz1 = Class.forName("java.lang.String2");를 try/catch 처리
		try {
			// 해당 패키지를 메모리로딩하여 처리할 때, 사용되는 코드(필수 예외처리)
			Class clz = Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		DBConn con = new DBConn();
		try {
			// 위임된 예외를 한번에 처리함.
			con.conn01();
			con.conn02();
			con.conn03();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

//	ex) DBConn안에 메서드로 public void callString1() callString2() callString3() 선언하고,
//			String name=null; System.out.println(name.toString())으로 하여
//		NullPointerException을 예외 위임을 처리하여, 위임된 예외를 메인메서드에서 처리하게 하세요.
//		주의) 필수예외가 아니기에 직접 throws, try{}catch 코드를 직접해야합니다.
		try {
			con.callString1();
			con.callString2();
			con.callString3();
		}catch(NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
	}
}
class DBConn{
	// throws 위임할 예외 클래스
	public void conn01() throws ClassNotFoundException{
		Class clz = Class.forName("db.com.oracle");
	}
	public void conn02() throws ClassNotFoundException {
		Class clz = Class.forName("db.com.musql");
	}
	public void conn03() throws ClassNotFoundException {
		Class clz = Class.forName("db.com.musql");
	}
	public void callString1() throws NullPointerException{
		String name=null; System.out.println(name.toString());
	}
	public void callString2() throws NullPointerException{
		String name=null; System.out.println(name.toString());
	}
	public void callString3() throws NullPointerException{
		String name=null; System.out.println(name.toString());
	}
}
