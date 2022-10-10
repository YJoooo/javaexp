package javaexp.z03_vo;

public class BPlayer {
	// 번호, 이름, 생년월일 show() 단위정보
	private int no;
	private String name;
	private String birthday;
	public BPlayer() {
		
	}
	public BPlayer(int no, String name, String birthday) {
		this.no = no;
		this.name = name;
		this.birthday = birthday;
	}
	public void show() {
		System.out.println(no+"\t");
		System.out.println(name+"\t");
		System.out.println(birthday+"\t");
	}
	
	
	@Override
	public String toString() {
		return "BPlayer [no=" + no + ", name=" + name + ", birthday=" + birthday + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
