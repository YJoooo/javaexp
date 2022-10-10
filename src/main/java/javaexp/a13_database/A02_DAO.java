package javaexp.a13_database;

import java.sql.*;
// DAO(database access object)
// 전화기와 동일 : 연결/대화/결과를 통해 받은 데이터/종료-자원해제,예외처리

public class A02_DAO {
	private Connection con; // 연결객체
	private Statement stmt; // 대화객체
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
	// 3. 각 기능별 메서드
	// 1) emp를 출력하는 기능메서드
	public void showEmp() {
		// 선언한 공통 연결메서드 호출
		try {
			// 1. 필드에 선언된 private Connection con;에 객체가 생성이 된다.
			setConn();
			// 2. 대화객체선언
			//		1) sql문 작성
			String sql = "select * from emp";
			//sql문 안에 (;)을 붙이지 않는다.
			// 계층적으로 연관 관계로 객체가 만들어진다.
			// 드라이버 객체 ==> DB처리하는 연결객체 ==> 대화가 결과객체(상호간에 연동하여 객체 생성)
			//	2) 대화객체 생성
			stmt = con.createStatement();
			//	3) 대화객체를 통해 결과 객체 생성, 매개변수로 sql문을 할당 처리한다.
			rs = stmt.executeQuery(sql);
			//	4) 전체 데이터 가져오기
			//		저장된 갯수만큼 next()를 호출
	/*
	ResulSet 으로 아래 내용이 할당된다.
	.next() : 행단위로 이동 처리함. 그 행에 데이터가 있으면 true/없으면 false
	.getstring("컬럼명") : 해당 row에 상단에 선언된 column명을 기준으로 데이터를 가져온다.
		주의) select @@ 최종 컬럼명이기 alias가 있으면 alias명으로 호출하여야 한다.
	.get데이터유형()
		ex) rs.getInt("empno"), rs.getDate("hiredate"), sal의 경우number(4,2)로 실수형이기에 rs.getDouble("sal")
	*/
			int cnt = 1;
			while(rs.next()) {
				System.out.print(cnt+"행"+rs.getInt("empno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("job")+"\t");
				System.out.print(rs.getString("mgr")+"\t");
				System.out.print(rs.getDate("hiredate")+"\t");
				System.out.print(rs.getDouble("sal")+"\t");
				System.out.print(rs.getDouble("comm")+"\t");
				System.out.print(rs.getInt("deptno")+"\n");
				cnt++;
			}
			// 자원해제(열린순서 반대 방향)
			rs.close();
			stmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
			
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
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	// 단일 row sql 처리
	public int getEmpCnt() {
		int cnt =0;
		//[핵심코드]
		String sql = "select count(*) cnt from emp";
		// 연결
		try {
			setConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			//하나의 데이터 결과 처리이기에 바로 처리	
			//[핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			rs.close();
			stmt.close();
			con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(con!=null) {
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
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		return cnt;
	}
	
	
	
	
	
	// 단일 row sql 처리
	public int getEmpCnt(int deptno) {
		int cnt =0;
		//[핵심코드]
		String sql = "select count(*) cnt from emp where deptno ="+deptno;
		// 연결
		try {
			setConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			//하나의 데이터 결과 처리이기에 바로 처리	
			//[핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			rs.close();
			stmt.close();
			con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(con!=null) {
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
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		return cnt;
	}
/*
String sql = "select count(*) cnt from emp where deptno ="+deptno;
select count(*) cnt from emp where deptno = 10;
select * from emp where deptno = 10;
String sql = "select count(*) cnt from emp where job ='"+job+"'";
job - '"job+"'" : 변동되는 문자열 job에 다른 sql 결과를 얻기 위해서 이런 형식이 필요하다.
select xount(*) cnt from emp where job = 'CLERK';
select * from emp where job = 'CLERK';
*/
	// 단일 row sql 처리
	public int getEmpCnt(String job) {
		int cnt =0;
		//[핵심코드]
		String sql = "select count(*) cnt from emp where job ='"+job+"'";
		System.out.println(sql);
		// 연결
		try {
			setConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			//하나의 데이터 결과 처리이기에 바로 처리	
			//[핵심코드]
			if(rs.next());
				cnt = rs.getInt("cnt");
			rs.close();
			stmt.close();
			con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(con!=null) {
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
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		return cnt;
	}
	public static void main(String[] args) {
		// 실제는 외부에서 위 DAO의 특정한 객체를 호출하는데, 
		// 그전에 테스트로 main()에서 객체를 생성해본다.
		A02_DAO dao = new A02_DAO();
		//dao.showEmp();
		System.out.println("사원정보의 갯수:" + dao.getEmpCnt());
		System.out.println("사원정보의 갯수(부서):" + dao.getEmpCnt(10));
		System.out.println("사원정보의 갯수(직책):" + dao.getEmpCnt("SALESMAN"));
	}

}
