package javaexpz01_homework;

public class A0426 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		[1단계:개념] 1. 변수의 초기화에 대하여, 예제를 통하여 기술하세요
			//- 변수를 선언하고 변수를 초기화 하세요.
				int num; // 변수선언
				num = 5; // 변수 초기화
				
//		[1단계:개념] 2. 기본데이터유형이 할당되는 jvm 메모리와 해당 유형 종류를 크기에 따라 기술하세요.
//					stack(기본데이터유형, 객체의 heap주소값), heap(객체가 할당)
		/*기본 타입은 정수형, 실수형, 문자형, 논리형으로 데이터유형이 있다.
		정수형 byte(1byte), short(2byte), int(4byte), long(8byte)
		실수형 float(4byte), double(8byte)
		문자형 char(2byte)
		논리형 boolean(1byte)
		*/
//		[1단계:코드] 3. 21억, 15억 데이터를 int에 할당하고, 합산결과를 변수를 선언하여 할당 출력하세요
			int num01 = 2100000000;
			int num02 = 1500000000;
			long tot01 = num01+(long)num02;
			System.out.println(tot01);
			
//		[1단계:개념] 4. 150라는 데이터를 기본데이터유형 중에 어디에 할당이 가능한가를 기술하고 그 이유에 대하여 설명하세요
//			byte code01 = 150; byte는 -128애서 127까지만 저장하는 1바이트 정수 자료형이기때문에 불가능
			short code02 = 150; //short는 -32768에서 32767까지 저장하는 2바이트 정수 자료형이기때문에 가능
			
//		[2단계:코드] 5. 알파벳의 코드값 범위와 문자 0부터 9까지 범위의 코드값 범위를 확인하고 출력하세요.
//					0 : 숫자, '0' : 문자, "0" : 문자열
			char ch01 = 'A';
			char ch02 = 'a';
			char ch03 = 'Z';
			char ch04 = 'z';
			System.out.println("대문자 알파벳 코드값 범위는 "+(int)ch01+"~"+(int)ch03);
			System.out.println("소문자 알파벳 코드값 범위는 "+(int)ch02+"~"+(int)ch04);
			
			int num03 = 0;
			int num04 = 9;
			System.out.println("문자 0부터 9까지 코드값 범위는"+((char)num03)+"~"+((char)num04));
			
			System.out.println("0부터 9까지의 코드값:"+(int)'0'+"~"+(int)'9'); // 정답
			
//		[1단계:개념] 6. 형변환 두가지 유형을 예제를 통해서 기술하고 설명하세요..
			//묵시적 형변환
			short num10 =621;
			int num11 = num10 +54;
			double num12 = num11;
			System.out.println(num10); // 621
			System.out.println(num11); //675
			System.out.println(num12); //675.0
			
			//명시적 형변환
			int tissu = 250;
			int people = 7;
			System.out.println("티슈를 사람수대로 나누면"+tissu/(double)people);
			
//		[1단계:코드] 7. 500cc의 오렌지쥬스를 3잔에 나누어 할당할려고 한다. 소숫점 이하가 처리된 경우와
//		      소숫점 이하가 처리되지 않는 경우를 나누어 코딩하세요
			int juice = 500;
			int cup = 3;
			System.out.println(juice/cup); // 소숫점 이하가 처리되지 않는 경우
			System.out.println((double)juice/cup); // 소숫점 이하가 처리된 경우
			
//		[1단계:개념] 8. 연산자, 피연산자, 연산식의 개념을 기본예제를 통해서 구분하여, 설명하세요.
			int applebuy = 15; // applebuy(피연산자) , =(연산자)
			int appleprice = 800;
			int appletotprice = applebuy*appleprice; // 연산식
			System.out.println("구매한 사과의 총 금액은 "+appletotprice+"원 입니다.");
			
//		[1단계:코드] 9. 일일 가계부 입력에 필요한 연산식을 만들고 아래 형식으로 출력하세요 (어려워요)
//		      날짜   지출구분   내용  입금액    출금액  잔액
//		      4/1   입금     용돈   30000         30000
//		      4/1   출금     점심    6000         24000
			
			int money = 30000;
			int lunch = 6000;
			int extra01 = money;
			int extra02 = money-lunch;
			System.out.println("날짜 "+" 지출구분 "+" 내용 "+" 입금액 "+" 출금액 "+" 잔액");
			System.out.println("4/1 "+" 입금 "+" 용돈 "+"  "+money+"      "+extra01);
			System.out.println("4/1 "+" 출금 "+" 점심 "+"  "+lunch+"      "+extra02);
			
			System.out.println("날짜\t지출구분\t내용\t입금액\t출금액\t잔액"); // 간격 맞추기 \t
			String date01 = "4/1";
			String div01 = "입금";
			String cont01 = "용돈";
			int income01 = 30000;
			int out01 = 0;
			int rest = 0;
			rest+=income01;
			// System.out.print(); : 줄바꿈 없이 처리
			System.out.print(date01+"\t");
			System.out.print(div01+"\t");
			System.out.print(cont01+"\t");
			System.out.print(income01+"\t");
			System.out.print(out01+"\t");
			System.out.print(rest+"\n"); // \n: 줄바꿈 처리
			
			date01 = "4/1";
			div01 = "출급";
			cont01 = "점심";
			income01 = 0;
			out01 = 6000;
			rest-=out01; // 지출시 - 처리
			// System.out.print(); : 줄바꿈 없이 처리
			System.out.print(date01+"\t");
			System.out.print(div01+"\t");
			System.out.print(cont01+"\t");
			System.out.print(income01+"\t");
			System.out.print(out01+"\t");
			System.out.print(rest+"\n"); // \n: 줄바꿈 처리
			
//		[1단계:코드] 10. 변수 선언하고 이를 이용하여 타율(안타/타석)을 계산하여 출력하세요.
			int hits = 100;
			int bat = 258;
			System.out.println("이선수의 타율은 "+ hits/(double)bat+ " 입니다.");
			
//		[1단계:코드] 11. 삼각형의 면적을 구하는 공식을 이용하여 밑면과 높이로 출력하세요.
			//(밑변*높이)/2
			String base = "밑면";
			String height = "높이";
			int base01 = 5;
			int height02 = 12;
			System.out.println(base+"*"+height+"/"+"2"+"="+(base01*height02)/2);
			
//		[1단계:코드] 12. 대입연산자와 연산자의 진행방향의 차이점을 기본 예제를 통해 설명하세요.
			//대입연산자
				int age = 15; // 오른쪽에서 왼쪽
			//연산자	
				int count = (age+2)/3; // 우선순위 연산자부터 () ==> / ==> =
						
//		# 다 하신 후에 어렵거나 자세한 풀이가 필요한 문제는 제출시 표기해주세요
		
		

	}

	
	
}
