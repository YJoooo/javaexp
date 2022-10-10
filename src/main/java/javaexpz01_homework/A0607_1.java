package javaexpz01_homework;

import java.sql.*;
import java.util.ArrayList;

import javaexp.a13_database.A03_Dao;
import javaexp.z03_vo.Dept;
import javaexp.z03_vo.Emp;

public class A0607_1 {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public void setConn() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info, "scott","tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 에러:"+e.getMessage());
		} 
	}

	
//	[1단계:확인] 3. 연봉이 범위(@@~@@) 사이이고, 부서별로 검색하는 사원 정보를 PreparedStament 로 처리하여 결과를 출력하세요		
	public void showsalarea(Double sal) {
		try {
			setConn();
			String sql ="SELECT *\r\n"
					+ "FROM emp\r\n"
					+ "WHERE ? BETWEEN 1000 AND 2000";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, sal);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("empno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("job")+"\t");
				System.out.print(rs.getString("mgr")+"\t");
				System.out.print(rs.getDate("hiredate")+"\t");
				System.out.print(rs.getDouble("sal")+"\t");
				System.out.print(rs.getDouble("comm")+"\t");
				System.out.print(rs.getInt("deptno")+"\n");
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB에러 : "+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반 예외 : "+ e.getMessage());
		}finally {
			//예외 상관없이 처리할 내용
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
//	[1단계:확인] 4. 사원명과 부서명을 키워드검색(like,%활용)하여, 부서명, 사원명, 사원번호, 급여를 출력 하게 하세요.
	public void showempdept(String ename,String dname) {
		try {
			setConn();
			String sql ="SELECT *\r\n"
					+ "FROM emp e, dept d\r\n"
					+ "WHERE ? LIKE '%N' AND ? LIKE 'S%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setString(2, dname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("dname")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("empno")+"\t");
				System.out.print(rs.getDouble("sal")+"\n");
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB에러 : "+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반 예외 : "+ e.getMessage());
		}finally {
			//예외 상관없이 처리할 내용
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
//	[1단계:확인] 5. select * from dept where dname like '%'||''||'%' and loc like '%'||''||'%' 를 이용해서
//  리턴 ArrayList<Dept>로 처리해서 main()에서 확인하세요.
	public ArrayList<Dept> getDeptList(String dname,String loc) {
		ArrayList<Dept> deptList = new ArrayList<Dept>();
		try {
			setConn();
			String sql ="select * \r\n"
					+ "from dept \r\n"
					+ "where ? like '%'||''||'%' and ? like '%'||''||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				deptList.add(new Dept(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc"))
					);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB에러 : "+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반 예외 : "+ e.getMessage());
		}finally {
			//예외 상관없이 처리할 내용
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return deptList;
	}
	public static void main(String[] args) {
		A0607_1 a = new A0607_1();
	}


}


