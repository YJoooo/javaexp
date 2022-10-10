package javaexp.a08_access.a04_woodhome;

public class WoodCutter {
	private String priveSec = "개인비밀";
	String payOurHome = "우리집 생활경비";
	protected String inheritMoney = "상속 재산";
	public String announce = "막내딸이 오월의 신부가 됩니다!";
	
	public void callWoodCutter() {
		System.out.println("private:"+priveSec);
		System.out.println("default:"+payOurHome);
		System.out.println("protected:"+inheritMoney);
		System.out.println("public:"+announce);
	}

}
