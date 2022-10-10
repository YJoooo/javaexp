package javaexp.a03_calcu;

public class A04_Calcu04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 증감
		1. 증가 또는 감소 처리를 할 때, 활용된다.
			- 기본적으로 1씩 증가 또는 감소를 한다.
		2. 반복문에 주로 활용된다.
		3. 형식
			변수명++, 변수명-- : 해당 라인 이후에 증가/감소
			++변수명, --변수명 : 해당 라인에서 증가/감소
		ps) 2이상, 증가 감소시는 +=, -=을 활용한다.	
		 */
		int num01 = 1;
		int num02 = 10;
		System.out.println(num01++); // 증가는 했지만 다음 프로세스에 적용
		System.out.println(num01++);
		System.out.println(num01++);
		System.out.println(num01);
		System.out.println(num01+=2);
		System.out.println(num01+=2);
		System.out.println(num01+=2);
		System.out.println(++num01);
		System.out.println(++num01);
		System.out.println(++num01);
		System.out.println(++num01);
		
		System.out.println(--num02);
		System.out.println(--num02);
		System.out.println(num02--);
		System.out.println(num02--);
		// ex) 구매하는 김밥의 갯수를 선언하고, 1씩 증가하여
		//		김밥의 단가(2500)
		//		김밥 1개 구매 2500 (산술연산자 활용)
		//		김밥 2개 구매 5000
		//		김밥 3개 구매 10000
		//		김밥 4개 구매 12500
		//		김밥 5개 구매 15000
		
		int rice = 1;
		int riceprice = 2500;
		System.out.println("김밥 "+rice+"개 구매 "+(rice++)*riceprice);
		System.out.println("김밥 "+rice+"개 구매 "+(rice++)*riceprice);
		System.out.println("김밥 "+rice+"개 구매 "+(rice++)*riceprice);
		System.out.println("김밥 "+rice+"개 구매 "+(rice++)*riceprice);
		System.out.println("김밥 "+rice+"개 구매 "+(rice++)*riceprice);
		System.out.println("김밥 "+rice+"개 구매 "+(rice++)*riceprice);
		
		//답
		int price = 2500;
		int buyCnt = 0;
		System.out.println("김밥 "+(++buyCnt)+"개 구매\t"+price*buyCnt);
		System.out.println("김밥 "+(++buyCnt)+"개 구매\t"+price*buyCnt);
		System.out.println("김밥 "+(++buyCnt)+"개 구매\t"+price*buyCnt);
		System.out.println("김밥 "+(++buyCnt)+"개 구매\t"+price*buyCnt);
		System.out.println("김밥 "+(++buyCnt)+"개 구매\t"+price*buyCnt);
		

	}

}
