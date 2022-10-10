package javaexp.a13_database;

import java.sql.*;
import javaexp.z03_vo.Dept;

public class A06_PreDAO {
	private Connection con; // 연결객체
	private PreparedStatement pstmt; // 대화객체
	private ResultSet rs; // data를 받는 결과 객체 select sql의 처리 결과로 활용
	public void setConn() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info, "scott","tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("클래스 에러:"+e.getMessage());
		} 
	}
	

	public void showDept() {
		// 선언한 공통 연결메서드 호출
		try {
			setConn();
			String sql = "select * from dept01";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("deptno")+"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.print(rs.getString("loc")+"\n");
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
	
//	[1단계:확인] 2. 복사테이블로 Dept01 을 만들고, 입력처리하는 메서드를 만드세요.
	
	public void insertDept01(Dept ins) {
		try {
			setConn();
			con.setAutoCommit(false);
			//Dept(int deptno, String dname, String loc)
			String sql = "INSERT INTO dept01 values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ins.getDeptno());
			pstmt.setString(2, ins.getDname());
			pstmt.setString(3, ins.getLoc());
			
			pstmt.executeQuery();
			con.commit();
			pstmt.close();
			con.close();
			//하나의 데이터 결과 처리이기에 바로 처리	
			//[핵심코드]
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB에러:"+e.getMessage());
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}catch(Exception e) {
				System.out.println("일반예외:"+e.getMessage());
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
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

//	[1단계:확인] 3. Dept01부서정보를 전체 컬럼을 수정하세요.
	public void updateDept(Dept upd) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "UPDATE dept01\r\n"
					+ "	SET dname =?\r\n"
					+ "		,loc =?\r\n"
					+ "	WHERE deptno =? ";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upd.getDname());
			pstmt.setString(2, upd.getLoc());
			pstmt.setInt(3, upd.getDeptno());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
			//하나의 데이터 결과 처리이기에 바로 처리	
			//[핵심코드]
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB에러:"+e.getMessage());
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}catch(Exception e) {
				System.out.println("일반예외:"+e.getMessage());
		}finally {
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
	
//	[1단계:확인] 4. Dept01부서정보를 deptno기준으로 삭제하세요
	public void deleteDept(String loc) {
		try {
			setConn();
			String sql = "delete from dept01 where loc=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loc);
			pstmt.executeQuery();
			con.commit();
			pstmt.close();
			con.close();
			//하나의 데이터 결과 처리이기에 바로 처리	
			//[핵심코드]
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB에러:"+e.getMessage());
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}catch(Exception e) {
				System.out.println("일반예외:"+e.getMessage());
		}finally {
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


	public static void main(String[] args) {
		// 실제는 외부에서 위 DAO의 특정한 객체를 호출하는데, 
		// 그전에 테스트로 main()에서 객체를 생성해본다.
		A06_PreDAO dao = new A06_PreDAO();
		/*
		dao.insertDept01(new Dept(50,"마케팅","서울"));
		dao.insertDept01(new Dept(60,"marketing","인천"));
		*/
		dao.updateDept(new Dept(50,"김연주","구미"));
		dao.deleteDept("인천");
		dao.showDept();
		
	}

}
