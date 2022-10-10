package javaexp.a13_database;

import java.sql.*;

public class A03_Dao {
	// 1. 공통 필드 선언
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	// 2. 연결메서드 선언
	//	1) 드라이버 선언
	public void setConn() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 : "+e.getMessage());
		}
		// 2) 서버연결처리(Connection 객체 생성)
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info,"scott","tiger");
		System.out.println("접속성공!");
	}
	
	// 3. 조회 처리 기능 메서드 선언
	public void empList() {
	//	1) 연결메서드 호출
		try {
			setConn();
	//	2) 대화객체 만들기
			stmt = con.createStatement();
	//	3) 결과객체 할당하기
			String sql = "select * from emp";
			rs = stmt.executeQuery(sql);
			System.out.println("기능 sql 처리 완료");
		} catch (SQLException e) {
			System.out.println("DB처리 :"+e.getMessage());
			// TODO Auto-generated catch block
		}
	}
	// ex) 부서정보를 조회하여 출력하는 기능 메서드 처리
	public void deptList() {
		// 연결 공통 메서드
		try {
			setConn();
			String sql = "select * from dept";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			int cnt = 1;
			while(rs.next()) {
				System.out.print(rs.getInt("deptno")+"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.print(rs.getString("loc")+"\n");
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println("일반 예외 : "+ e.getMessage());
		}finally {
			if(rs!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A03_Dao dao = new A03_Dao();
		dao.deptList();
	}

}
