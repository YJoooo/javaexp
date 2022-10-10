package javaexpz01_homework;

import java.util.Scanner;

public class A0429 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-04-29
//		[1단계:개념] 1. Math.radom() 기능의 기본 임의 데이터 처리 공식을 예제를 통해 기술하세요.
		//5지선다 문제중 내가 찍을 번호 
		int ladder = (int)(Math.random()*5);
		System.out.println("내가 찍을 번호 : "+ladder);
		
//		[1단계:응용] 2. 학생 30명의 반에 영어점수(1~100)가 반복문으로 통해 임의로 처리되게 하세요.
//		      예) 번호 점수, 최하단에 반전체 평균을 출력하세요.
		int tot = 0;
		double avg = 0.0;
		for(int stu=1;stu<=30;stu++) {
		int eng = (int)(Math.random()*100+1);
		tot += eng;
		avg = tot/30;
		System.out.println(stu+" 영어점수:"+eng);
		}
		System.out.println("반전체 평균:"+avg);
		
//		[2단계:응용] 3. 두명(컴퓨터vs컴퓨터)의 구슬 홀짝게임 : 한명이 구슬 10개를 가지고 임의의로 쥐게 하여, 
//		       다른 한명이 이것을 맞추었는지 여부에 따라 승/패로 출력하게 하세요.
		int game01 = (int)(Math.random()*2);
		int game02 = (int)(Math.random()*2);
		if(game01 == game02) {
			System.out.println("승!");
		}else {
			System.out.println("패!");
		}
		//선생님 답
		int com01 = (int)(Math.random()*10+1);
		System.out.println("컴1의 구슬수:"+com01);
		String result01 = com01%2==0?"짝":"홀";
		System.out.println("컴1의 홀짝:"+result01);
		int com02 = (int)(Math.random()*2);
		String result02 = com01%2==0?"짝":"홀";
		System.out.println("컴2의 홀짝:"+result02);
		String vic = result02.equals(result02)?"컴2의 승":"컴1의 승";
		System.out.println("결과:"+vic);
		
//		[1단계:응용] 4. 두 팀(홍/청-컴퓨터vs컴퓨터)이 주사위를 던져 홍팀의 결과를 출력하세요(승/무/패)
		int dice01 = (int)(Math.random()*6+1);
		int dice02 = (int)(Math.random()*6+1);
		if(dice01>dice02) {
			System.out.println("홍팀의 승리!");
		}else if(dice01 == dice02) {
			System.out.println(("무승부"));
		}else {
			System.out.println("홍팀의 패배!");
		}
		// 선생님 답
		int dice1 = (int)(Math.random()*6+1);
		int dice2 = (int)(Math.random()*6+1);
		if(dice1>dice2) {
			System.out.println("홍팀 승");
		}else if(dice1<dice2) {
			System.out.println("홍팀 패");
		}else {
			System.out.println("무승부");
		}
		
//		[1단계:개념] 5. while문의 기본 형식을 예제를 통해 설명하세요.
		//10에서 5씩 감소하여 -20까지 출력
		int num = 10;
		while(num>=(-20)) {
			System.out.println(num);
			num-=5;
		}
//		[1단계:응용] 6. while문을 이용해서 학생의 국어,영어,수학점수를 등록하고 총점과 평균을 
//		   출력하되, 등록을 종료시 -1를 입력해서 처리하세요.
		/*
		Scanner sc= new Scanner(System.in);
		int total01 = 0;
		int avg01 = 0;
		while(true) {
			System.out.println("국어/영어/수학 점수를 입력하세요(종료시 -1).");
			int score = sc.nextInt();
			if(score == -1) {
				System.out.println("등록을 완료하였습니다.");
				break;
			}
			total01+=score;
			avg01 = total01/3;
		}
		System.out.println("총점 : "+total01);
		System.out.println("평균 : "+avg01);
		*/
		//선생님 답
		/*Scanner sc = new Scanner(System.in);
		int no=1;
		while(true) {
			System.out.println(no+"번 학생의 국어 점수를 등록하세요");
			int kor = sc.nextInt();
			System.out.println(no+"번 학생의 영어 점수를 등록하세요");
			int eng = sc.nextInt();
			System.out.println(no+"번 학생의 수학 점수를 등록하세요");
			int math = sc.nextInt();
			System.out.println("# "+(no++)+"번 학생의 성적 #");
			System.out.println("국어:"+kor);
			System.out.println("영어:"+eng);
			System.out.println("수학:"+math);
			int tot1 = kor+eng+math;
			double avg1 = tot/3.0;
			System.out.println("총점:"+tot1);
			System.out.println("평균:"+avg1);
			System.out.println("종료시 -1, 계속 등록할 시 0 입력하세요.");
			int isCon = sc.nextInt();
			if(isCon==-1) {
				System.out.println("등록을 종료합니다!!");
				break;
			}
		}
		 */
//		[2단계:응용] 7. while문 숫자 맞추기 게임, 컴퓨터가 임의로 1~100범위의 숫자를 저장하면,
//		   while문을 통해서 해당 숫자를 입력한다. 비교해서 동일하면 종료,
//		   보다크다/보다 작다라는 hint로 맞추기를 진행할 수 있도록 한다. 최종적으로 몇번만에 맞추었는지 표기
		
			/*int num01 = (int)(Math.random()*100+1);
			Scanner sc= new Scanner(System.in);
			int total =1;
			while(true) {
				System.out.println("1~100까지 숫자중 하나를 입력하세요.");
				int num02 = sc.nextInt();
				total+=1;
				if(num01 == num02) {
				System.out.println("종료되었습니다.");
				break;
				}else if(num01 > num02) {
				System.out.println("hint : "+num02+"보다 크다");
				continue;
				}else {
				System.out.println("hint : "+num02+"보다 작다");
				}
			}
			System.out.println("최종적으로 몇번만에 맞추었는가?"+total);
			*/
		// 선생님 답 (do while문)
		// 전역 변수 결정 : 몇번만에 맞추는지 전역변수로 선언.
		int corCnt = 0;
		boolean isOk = false; // 정답여부(정답일때, 반복 중지)
		int comRan = (int)(Math.random()*100+1); // 1~100범위 컴퓨터의 임의 수.
		Scanner sc = new Scanner(System.in);
		do {
			corCnt++;
			System.out.println(corCnt+"번째 도전!!\n맞힐 숫자를 입력하세요.");
			int inNum = sc.nextInt();
			if(comRan>inNum) {
				System.out.println("입력된 숫자가 작습니다!!");
			}
			if(comRan<inNum) {
				System.out.println("입력된 숫자가 크군요!!");
			}
			isOk = comRan==inNum;
		}while(!isOk); // 틀리면 계속 반복 처리.
		System.out.println(corCnt+"번째만에 맞추었습니다!\n축하합니다!!");
		
		
//		[1단계:개념] 8. 참조변수가 무엇인지? 메모리 영역을 기본 데이터유형과 비교하여
//		      기본 예제를 통해서 설명하세요.
		int number = 1;
		int number2 = 2;
		System.out.println("stack영역 비교 :"+(number == number2));
		Music mm1 = new Music();
		Music mm2 = new Music();
		System.out.println("참조변수 비교"+(mm1 == mm2)); // 주소값이 다름, heap영역
		Music mm3=mm1;
		System.out.println("stack영역 참조변수 비교"+(mm3 == mm1)); // 주소값이 같아짐
			
//		[1단계:확인] 9. Music 클래스를 선언하고, 해당 m01, m02 참조변수를 선언하고, 비교하세요.
			Music m01 = new Music();
			Music m02 = new Music();
			System.out.println(m01 == m02);
		
//		[1단계:개념] 10. String 객체의 주소 활용방식을 ==, .equals()를 통하여 기본예제로 기술하세요. 
			String nickName01 = new String("아줌마");
			String nickName02 = new String("아줌마");
			System.out.println((nickName01 == nickName02)); // 주소 비교 false
			System.out.println(nickName01.equals(nickName02)); // 문자 자체비교 true

	}

}
class Music{
}