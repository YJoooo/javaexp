package javaexp.a06_class;

public class A13_ObjectCalcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ex) 메서드를 통해서 기능 처리하는 반복문 예제
		1. 기능 메서드를 통해 반복처리하는 로직 처리.
		 */
		Counter c1 = new Counter();
		c1.setData(1, 10);
		int sum = c1.showCount();
		System.out.println("총합:"+sum);
		c1.setData(1, 100);
		System.out.println("총합:"+c1.showCount());
		// ex) CalcuPay 필드 : 확인할 구매갯수최대값, 단가
		//				메서드 : inputData()
		//						serchData()
		//							단가@@@	@@개 @@@
		//							단가@@@	@@개 @@@
		//							단가@@@	@@개 @@@
		//							단가@@@	@@개 @@@
		CalcuPay cp1 = new CalcuPay();
		cp1.inputData(5,2300);
		cp1.searchLoop();	
	}

}
class CalcuPay{
	int maxCnt;
	int price;
	void inputData(int maxCnt,int price) {
		this.maxCnt=maxCnt;
		this.price=price;
		System.out.println("기본데이터 입력");
		System.out.println("최대 갯수:"+maxCnt);
		System.out.println("구매 단가:"+price);
	}
	void searchLoop() {
		for(int cnt=1;cnt<=maxCnt;cnt++) {
			System.out.println("단가"+price+"\t"+cnt+"개"+(price*cnt));
		}
	}
}
class Counter{
	int from;
	int to;
	void setData(int from, int to) {
		this.from = from;
		this.to = to;
	}
	int showCount() {
		System.out.println("# "+from+"에서부터 "+to+"까지 #");
		int tot=0;
		for(int cnt=from;cnt<=to;cnt++) {
			System.out.print(cnt+", ");
			tot+=cnt;
		}
		System.out.println();
		return tot;
	}
}
