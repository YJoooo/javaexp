package javaexp.a11_api;

public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 자바 api 도큐먼트
		1. 자바에서 기본적으로 제공하는 라이브러리
		2. 프로그램 개발에 자주 사용되는 클래스 및 인터페이스 모음
		3. 쉽게 api찾아 이용할 수 있도록 문서화 한 것
		4. html 페이지로 작성되어 있어 웹 브라우저로 바로 볼 수 있음.
		# java.lang 패키지
		1. 자바프로그램의 기본적인 클래스를 담은 패키지
		2. 포함된 클래스와 인터페이스는 import 없이 사용
		3. 주요 클래스
			1) Object : 자바 클래스의 최상위 클래스로 사용
			2) System : 표준 입력/출력 장치 처리 필요
			3) Class : 클래스를 메모리로 로딩할 때, 사용
			4) String : 문자열을 저장하고 여러가지 정보를 얻을 때 사용
			5) StringBuffer, StringBuilder : 문자열을 저장혹 내부문자열을 조작할 때 사용
			6) Math : 수학 함수를 이용할 때 사용
			7) Wrapper(Byte, Short, Character, Integer, Float, Double, Boolean)
				기본 타입의 데이터를 갖는 객체를 만들 때 사용
				문자열을 기본 타입으로 변환할 때 사용
				입력 값 검사에 사용
		 */
		/*
		# String 클래스 메소드
		1. 문자열의 추출, 비교, 찾기, 분리, 변환등과 같은 다양한 메소드를 가진다.
		2. 사용 빈도 높은 메소드.
			1) charAt(int idx) : 특정위치에 문자 리턴
		 */
		String str01 = "EMP1061521";
		System.out.println("첫번째문자 : "+str01.charAt(0));
		System.out.println("마지막에 있는 문자:"+str01.charAt(9));
		// ex) 주민번호로 생년월일의 문자를 charAt로 추출하여 출력하세요.
		String civilNum = "901212-1702618";
		// System.out.print()로 한자씩 출력하세요.
		System.out.print("19");
		System.out.print(civilNum.charAt(0));
		System.out.print(civilNum.charAt(1));
		System.out.print("년");
		System.out.print(civilNum.charAt(2));
		System.out.print(civilNum.charAt(3));
		System.out.print("월");
		System.out.print(civilNum.charAt(4));
		System.out.print(civilNum.charAt(5));
		System.out.println("일");
		//indexOf(String str) : 문자열내에 주어진 문자열의 위치를 리턴
		String data01 = "안녕하세요! 홍길동입니다!";
		//				 012345678
		//				 abc
		//				 ABC
		System.out.println(data01.indexOf("홍길동"));
		// 특정한 문자열의 데이터가 없을때는 -1을 리턴 : 검색시, 주로 활용된다.
		// ex) 하세요의 시작 index, 입니다.의 시작 index를 출력하세요.
		System.out.println(data01.indexOf("하세요"));
		System.out.println(data01.indexOf("입니다"));
		// 3) length() : 총문자의 수를 리턴
		// 		주의) 배열의 갯수는 length로 사용되나, 문자열의 문자갯수는 length()
		System.out.println("문자열의 크기"+data01.length());
		
		// ex) 문자열의 함수의 이중활용, data01의 홍길동의 시작 index위치와 마지막 index 위치를 추출.
		System.out.println(data01.indexOf("홍"));
		System.out.println(data01.indexOf("동"));
		
		String schText = "홍길동";
		int schLen = schText.length();
		int startIndx = data01.indexOf(schText);
		System.out.println(startIndx); // 시작인덱스
		System.out.println(startIndx+schLen-1); // 마지막인덱스
		// ex) 검색 필요 내용이 있으면 data.indexOf("검색할 문자") !=-1
		//		-1 : 검색한 결과 값이 없을때.
		// 4) replace(): 특정 부분의 문자를 대체하여 변경처리할 때 사용된다.
		String target = "Hello! Good day";
		String newText = target.replace('o','i');
		System.out.println(newText);
		// ex) "김길동 신길동 오길동 마길동"에서 "길" ==> 신으로 변경해서 출력하세요.
		String name = "김길동 신길동 오길동 마길동";
		String newName = name.replace('길','신');
		System.out.println(newName);
		// replaceAll(), split() : 등은 정규식 표현에 의해 데이터를 변경, 구분자에 의해서 구분처리
		// 5) substring(시작index) : 특정한 문자열을 시작 index부터 추출한다.
		//	  substring(시작index, 마지막index) : 특정한 문자열을 시작 index로부터 바지막 index를 추출해준다.
		//	 	주의) 시작 index는 0부터 시작하고, 마지막 index는 1부터 시작한다.
		String data2 = "사과 바나나 딸기 오렌지";
		System.out.println(data2.substring(3));
		System.out.println(data2.substring(7,9));
		// ex) 다시 주민번호를 substring을 이용해서 생년월일을 추출하여 출력하세요.
		String civilNum01 = "901212-1702618";
		System.out.print("19");
		System.out.print(civilNum01.substring(0,2));
		System.out.print("년");
		System.out.print(civilNum01.substring(2,4));
		System.out.print("월");
		System.out.print(civilNum01.substring(4,6));
		System.out.println("일");
		// 6) toLowerCase()/toUpperCase()
		//		소문자로 변경/대문자로변경
		//		cf) 특정데이터를 대소문자 구분없이 검색처리할때, 주로 활용된다.
		String data3 = "Hello! Good Day";
		System.out.println(data3.toLowerCase());
		System.out.println(data3.toUpperCase());
		// 7) trim() : 문자열 앞뒤에 공백을 제거할 때, 사용된다.
		//	[안녕 ]	검색시나 입력시 공백이 들어간 경우, 육안으로 확인이 안된다.
		//			이떄, 이러한 키입력상의 예외를 방지하기 위하여 trim()써서 검색하는 경우가 많다.
		String data4 = " Hello ";
		System.out.println("문자열의 크기"+data4.length());
		String data5 = data4.trim();
		System.out.println("trim()후 문자열:"+data5);
		System.out.println("trim()후 문자열의 크기:"+data5.length());
		// 8) split("구분할문자") : 특정데이터를 구분할 문자열로 분리하여 배열을 만들때, 사용된다.
		String data6 = "사과&바나나&딸기&오렌지";
		String fnames[] = data6.split("&");
		for(String fruit:fnames) {
			System.out.println(fruit);
		}
		// ex) 점심메뉴 선택할 내용을 5가지를 @로 구분하여 문자열 데이터를 할당한 후, 배열로 출력하세요.
		String data7 = "고구마@라면@미역국@김치찌개@닭가슴살";
		String lunch[] = data7.split("@");
		for(String menu:lunch) {
			System.out.println(menu);
		}
		// data7.split("\\^") 특별한 특수문자는 \\후 특수문자
	}

}
