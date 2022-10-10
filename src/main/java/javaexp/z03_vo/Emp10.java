package javaexp.z03_vo;

public class Emp10 {
	// select의 속성과 동일
	// 매개변수로 처리 할 데이터와 동일
	
	private int no;
	private String name;
	private String job;
	private double salary;
	private String hireq;
	private int dno;
	public Emp10() {
		// TODO Auto-generated constructor stub
	}
	public Emp10(int no, String name, String job, double salary, String hireq, int dno) {
		super();
		this.no = no;
		this.name = name;
		this.job = job;
		this.salary = salary;
		this.hireq = hireq;
		this.dno = dno;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getHireq() {
		return hireq;
	}
	public void setHireq(String hireq) {
		this.hireq = hireq;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}

}
