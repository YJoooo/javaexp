package javaexpz01_homework;

import java.util.Scanner;

public class A0513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		2022-05-13
//		[1단계:개념] 1. 예외 처리의 기본 형식과 처리 순서를 기본 예제에 의해 기술하세요.
		System.out.println("내이름은 김연주");
		try {
			System.out.println("내이름은 강하윤");
			String name = null;
			System.out.println(name.length());
			System.out.println("내이름은 김현석");// 에러가 발생하면 실행되지 않음
		}catch(Exception e){
			System.out.println("내이름은 김태성"); // try{}에서 에러가 발생하지 않으면 실행되지 않음
		}finally {
			System.out.println("내이름은 김정임"); //무조건 실행됨
		}
		System.out.println("내이름은 오정준");
//		[1단계:확인] 2. args를 통해서 나올 수 있는 예외를 아래에 하나씩 처리하세요
//		      1) args값을 입력하지 않았을 때.
//				NullPointerException
		try {
			System.out.println("첫번째 데이터:"+args[0]);
			for(int idx=0;idx<args.length;idx++) {
				String data = args[idx];
				System.out.println(data);
				int num01= Integer.parseInt(data);
			}
			
			for(String arg:args) {
				String data = arg; // 입력된 여러개의 데이터에 대한 처리
				System.out.println(data);
				// 입력값이 모두 숫자형 문자열 일때.
				int num01= Integer.parseInt(data);
			}
		}catch(NullPointerException e) {
			System.out.println("입력된 데이터가 없습니다."+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException aie) {
			System.out.println("배열의 범위를 넘어섬."+aie.getMessage());
		}catch(Exception e) {
			System.out.println("기타 예외 상황:"+e.getMessage());
		}finally {
			System.out.println("예외 상관없이 처리할 내용!");
		}
//		      2) args값의 배열의 범위를 넘어설 때.
//				ArrayIndexOutOfBoundsException
		try {
		String array01[] = {"김연주"};
		System.out.println(array01[3]);
		}catch(ArrayIndexOutOfBoundsException aob) {
			System.out.println(aob.getMessage());
		}
//		      3) args의 값 중에 숫자형 문자를 입력하여야 하는데 문자 자체를 입력했을 때.
		try {
		int price = Integer.parseInt(args[0]);
		}catch(NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		}
//		[1단계:개념] 3. 예외 처리의 계층별 처리란 무엇인지 기술하세요.
		/*
		아래 구조처럼 맨 아래에 있는 예외부터 순차적으로 처리하는것을 말한다.
		try{
			
		}catch(최하위에 있는 예외){
		
		}catch(차상위에 있는 예외){
		
		}catch(최상위에 있는 예외{
		}
		*/
//		[1단계:개념] 4. 예외의 위임처리하는 내용을 예제를 통해서 기술하세요.
		Exception01 ex = new Exception01();
		try {
			ex.exc01();
		}catch(NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
//		[1단계:확인] 5. DBException이라는 사용자 정의 예외를 선언하고, Scanner를 통해서
//		      입력되는 값이  null이거나 공백문자일 때, 처리되게 하세요.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("회원명을 입력하세요!");
		try {
		String mname = sc.nextLine();
		if(mname==null||mname.equals("")) {
			throw new DBException();
		}
		System.out.println("입력한 회원명:"+mname);
		//System.out.println("입력한 데이터 check:"+mname.equals(""));
		}catch(DBException db) {
			System.out.println("사용자 정의 예외 던짐!"+db.getMessage());
		}catch(Exception e) {
			System.out.println("기타 예외:"+e.getMessage());
		}finally {
			System.out.println("예외 상관없이 처리할 내용!");
		}
		System.out.println("입력완료");
		
	}

}
class DBException extends Exception{
	public DBException() {
		// TODO Auto-generated constructor stub
		super("입력값 예외(사용자정의)");// 생성자를 통해서 추가 처리
	}

	@Override
	public String getMessage() { // 재정의 메서드 처리
		// TODO Auto-generated method stub
		return "[재정의!]"+super.getMessage();
	}
}
class Exception01{
	public void exc01() throws NullPointerException{
		String name01 = null; System.out.println(name01.length());
	}
}