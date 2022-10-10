package javaexp.z03_vo;

public class EmpDept {
	private String dname;
	private String ename;
	private int empno;
	private double sal;
	public EmpDept() {
		// TODO Auto-generated constructor stub
	}
	public EmpDept(String dname, String ename, int empno, double sal) {
		super();
		this.dname = dname;
		this.ename = ename;
		this.empno = empno;
		this.sal = sal;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	

}
