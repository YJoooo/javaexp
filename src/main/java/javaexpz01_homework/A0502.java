package javaexpz01_homework;

public class A0502 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-05-02
//		[1단계:개념] 1. 배열의 속성들을 기술하고, 선언과 할당 방식을 기술하세요
		String [] num = new String[2]; // new 데이터유형[배열의 크기]; 초기값(0)으로 모든 배열의 구성요소를 할당.
		int[] num1 = {5,6,7}; // {데이터1, 데이터2, 데이터3} : 선언과 직접적인 데이터 할당 한번에
		int []num2;
		num2=new int[]{2,3,5,9}; // new 데이터 유형[]{데이터1, 데이터2, 데이터3}; : 선언/할당 분리할 때
		
//		[1단계:개념] 2. 배열과 반복문의 관계를 기술하고, 학생 30명을 임의의 점수(0~100)로 배열에 할당/출력하세요.
		// 배열은 복수의 데이터를 보관하는 그릇입니다. 반복문은 복수의 반복되는 작업을 처리하는 도구입니다.
		int[]score = new int[] {0,10,20,30,40,50,60,70,80,90,50,60,90,70,50,62,34,81,
				51,32,98,75,26,54,55,61,23,15,98,30};
		for(int cnt=1;cnt<=30;cnt++) {
			System.out.println(cnt+"번 학생의 점수 : "+(score[cnt-1]));
		}
		
//		[1단계:응용] 3. 무지개 색상을 배열로 선언하고, 이 중에서 임의의 색상 3개를 출력하세요
		String [] rainbow = new String[7];
		rainbow[1] = "주황색";
		rainbow[4] = "파랑색";
		rainbow[6] = "보라색";
		System.out.println(rainbow[1]);
		System.out.println(rainbow[4]);
		System.out.println(rainbow[6]);
		// 선생님 답
		String[]rainbow1 = {"빨","주","노","초","파","남","보"};
		for(int idx=0;idx<rainbow1.length;idx++) {
			System.out.print(rainbow1[idx]+",");
		}
		System.out.println();
		//임의로 나올 index만 지정되면 해당 index에 지정한 색상을 가지고 올 수 있다,
		//0~6까지 index인데 임의값이 이 범위로 가져오면 rainvow[임의의indx번호]를 통해서 특정한 색상을 가지고 올 수 있다.
		// (int)(Math.random()*경우의수 + 시작수);
		// (int)(Math.random()*7 + 0);
		for(int cnt=1;cnt<=3;cnt++) {
			int ranIdx = (int)(Math.random()*7); //0~6까지 임의의 index값을 뽑아 낼 수 있다.
			System.out.println(cnt+"번째 색상:"+rainbow1[ranIdx]);
		}
		// 중복 제거 : 배열에서 알고리즘을 활용하여 처리하는데, 이중 for문 temp변수 활용하여 사용한다.
		//		ArrayList	shuffle() : 중복없이 섞어주는 처리.
		
//		[1단계:응용] 4. 1차원 배열로 회원의 이름 5명을 선언하고 할당 출력하세요
		String [] arry = new String[5];
		arry = new String[] {"김연주","김현석","김정임","김태성","오정준"};
		System.out.print("회원명:");
		System.out.print(arry[0]+",");
		System.out.print(arry[1]+",");
		System.out.print(arry[2]+",");
		System.out.print(arry[3]+",");
		System.out.print(arry[4]);
		System.out.println();
		
		
//		         2차원 배열로 위 회원이름에 추가하여 나이와 사는 곳을 만들어 할당하고 출력하세요
		String[][]person1 = {
				{"김연주","27","인천 서구"},
				{"김현석","54","인천 부평구"},
				{"김정임","51","인천 계양구"},
				{"김태성","26","수원 영통구"},
				{"오정준","27","인천 연수구"}
		};
		for(int indx=0;indx<person1.length;indx++) {
			System.out.println((indx+1)+"번째 회원님의 개인정보");
			for(int jdx=0;jdx<person1[indx].length;jdx++) {
				if (jdx==0) {
					System.out.println("이름:"+person1[indx][jdx]);
				}else if(jdx==1) {
					System.out.println("나이:"+person1[indx][jdx]);
				}else {
					System.out.println("주소:"+person1[indx][jdx]);
				}
			}
		}
		
		String[][]person = new String[5][3];
		person[0][0] = "김연주";
		person[0][1] = "27";
		person[0][2] = "인천 서구";
		
		person[1][0] = "김현석";
		person[1][1] = "54";
		person[1][2] = "인천 부평구";
		
		person[2][0] = "김정임";
		person[2][1] = "51";
		person[2][2] = "인천 계양구";
		
		person[3][0] = "김태성";
		person[3][1] = "26";
		person[3][2] = "수원 영통구";
		
		person[4][0] = "오정준";
		person[4][1] = "27";
		person[4][2] = "인천 연수구";
		// 선생님 답
		String[]mnames = {"홍길동","김길동","신길동","오길동","마길동",};
		String[][] members = {
				{"홍길동","25","서울신림동"}, // 첫번째 회원의 정보인 이름, 나이, 사는 곳
				{"김길동","27","서울방배동"}, // 두번쨰 회원의 정보
				{"신길동","30","서울디지털단지"}, // 세번째 회원의 정보
				{"오길동","45","서울서초"},
				{"마길동","70","인천연수"}
		};
		System.out.println("1차원 배열의 첫번째 사람:"+mnames[0]);
		System.out.println("1차원 배열의 데이터 갯수:"+mnames.length);
		for(int idx=0;idx<+mnames.length;idx++) {
			System.out.println(idx+":"+mnames[idx]);
		}
		System.out.println("2차원 배열의 세번째 사람:"+members[2][1]);
		System.out.println("2차원 배열의 사람의 수:"+members.length);
		System.out.println("2차원 배열의 첫번째 사람의 속성의 수:"+members[0].length);
		for(int idx=0;idx<members.length;idx++) {
			for(int jdx=0;jdx<members[idx].length;jdx++) {
				System.out.println("\t"+jdx+":"+members[idx][jdx]);
			}
		}
		
		
//		[1단계:개념] 5. main(String args[])에서 args를 사용하는 방법과 내용을 기술하세요
		// A0502.java 에 내용을 출력 후
		// Run As ==> Run Configurations ==>Arguments ==> Program arguments ==> 데이터 입력
		// args[0], args[1], args[2]로 순서대로 할당 
		// (이때 args[0]... 는 문자열로 연산시에 int num = Integer.parseInt(args[0])로 형변환 필요)
		
//		[1단계:개념] 6. args[]로 구매할 물건명 가격 갯수를 입력받아서 물건명과 총비용을 출력하세요.
		//args[0] : "딸기라떼"
		//args[1] : 4500
		//args[2] : 2
		String thing = args[0];
		int price = Integer.parseInt(args[1]);
		int cnt = Integer.parseInt(args[2]);
		System.out.println("구매할 물건명: "+price);
		System.out.println("구매할 물건의 총비용: "+(price*cnt));

	}

}
