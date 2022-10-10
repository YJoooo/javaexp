package javaexpz01_homework;

public class A0516 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-16
//		[1단계:개념] 1. api 클래스의 주요기능과 java.lang.* 패키지의 특징을 기술하세요
//		API(=라이브러리) : 프로그램 개발에 사용되는 클래스 및 인터페이스의 모음.
		/*
		# api 주요 기능
		1. Object : 자바 클래스의 최상위 클래스로 사용
		2. System : 표준 입력/출력 장치 처리 필요
		3. Class : 클래스를 메모리로 로딩할 때, 사용
		4. String : 문자열을 저장하고 여러가지 정보를 얻을 때 사용
		5. Math : 수학 함수를 이용할 때 사용
		6. Wrapper(Byte, Short, Character, Integer, Float, Double, Boolean)
		7. String 클래스 메소드
			1) charAt(int idx) : 특정위치에 문자 리턴
			2) indexOf(String str) : 문자열내에 주어진 문자열의 위치를 리턴
			3) length() : 총문자의 수를 리턴
			4) replace(): 특정 부분의 문자를 대체하여 변경처리할 때 사용된다.
			5) substring(시작index) : 특정한 문자열을 시작 index부터 추출한다.
	  			substring(시작index, 마지막index) : 특정한 문자열을 시작 index로부터 바지막 index를 추출해준다.
	 			주의) 시작 index는 0부터 시작하고, 마지막 index는 1부터 시작한다.
			6) toLowerCase()/toUpperCase()
				소문자로 변경/대문자로변경
				cf) 특정데이터를 대소문자 구분없이 검색처리할때, 주로 활용된다.
			7) trim() : 문자열 앞뒤에 공백을 제거할 때, 사용된다.
				키입력상의 예외를 방지하기 위하여 trim()써서 검색하는 경우가 많다.
 			8) split("구분할문자") : 특정데이터를 구분할 문자열로 분리하여 배열을 만들때, 사용된다.
 			9) StringBuffer, StringBuilder : 문자열을 저장혹 내부문자열을 조작할 때 사용
				하나의 heap여역의 메모리에 하나의 주소값에 문자열 데이터를 누적해서 처리할때 필요
				- StringBuilder : 단일 스레드 환경에서 사용가능하다.
				- StringBuffer : 멀티 스레드 환경에서 사용된다.
		# java.lang.*
		1. 자바프로그램의 기본적인 클래스를 담은 패키지
		2. 포함된 클래스와 인터페이스는 import 없이 사용
		*/
//		[1단계:활용] 2. charAt() 활용 - 알파벳A~Z까지 있는 문자열 배열에서 임의의 문자 4개를 추출하여 출력하세요.
		String alpa = "ABCDEFGHIJKLNMOPQRSTUVWXYZ";
		System.out.println(alpa.charAt(2));
		System.out.println(alpa.charAt(5));
		System.out.println(alpa.charAt(17));
		System.out.println(alpa.charAt(25));// 0부터 25번까지 출력가능
		// 선생님 답
		System.out.println((int)'A');
		System.out.println((int)'Z'); // 65~90 : 코드 범위
		char c[] = new char[26];
		int idx=0;
		for(int code=65;code<=90;code++) {
			c[idx++]=(char)code;
		}
		// char[] 배열을 String 생성자에 할당하면 문자열이 만들어진다.
		String str = new String(c);
		System.out.println(str);
		for(int cnt = 1;cnt<=4;cnt++) {
			int rIdx = (int)(Math.random()*26); // 0~25
			System.out.print(str.charAt(rIdx));
		}
		System.out.println();
//		[1단계:활용] 3. 과일명 5개가 나열된 문자열에서 해당 특정 과일명의 index위치를 추출하여 출력하세요.
		String fname = "딸기 망고 체리 수박 참외";
		System.out.println(fname.indexOf("체리"));
//		[1단계:활용] 4. 좋아하는 운동선수 3명이 나열된 문자열에서 length()와 charAt() 반복문을 활용하여, 
//					한글자씩을 탭간격으로 출력하세요.
		String player = "김광현박지성손흥민";
		for(int cnt=0;cnt<player.length();cnt++) {
			System.out.print(player.charAt(cnt)+"\t");
		}
		System.out.println();
//		[1단계:활용] 5. 회원명단을 ^로 구분하여 나열한 문자열을 선언하고, 이것을 배열로 처리한 후,
//		      특정회원이 있는지 여부를 확인하는 처리를 해보자.
		String member = "김연주^김현석^김태성^김정임";
		String name[] = member.split("^");
		for(String mn:name) {
			System.out.println(mn);
			boolean memname = (mn== "김연주");
			System.out.println(memname);
		}
		//선생님 답
		String memver = "김연주^김태성^김현석^김정임";
		String[] memArry = memver.split("\\^");
		boolean hasMember = false;
		for(String mem:memArry) {
			if(mem.indexOf("김현석")!=-1) {
				hasMember = true;
			}
			System.out.println(mem);
		}
		System.out.println("회원 있는지 여부:"+hasMember);
//		[3단계:설치] 6. 오늘 진행한 DB설치 내용을 ppt로 작성하여 캡쳐한 내용을 과제와 함께 전달하세요.

	}

}
