package javaexp.a13_database;
// javaexp.a13_database.A05_PreDAO

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javaexp.z03_vo.Dept;
import javaexp.z03_vo.Emp;
import javaexp.z03_vo.Emp10;
import javaexp.z03_vo.EmpDept;


//  DAO(database access object)
//  전화기와 동일 : 연결/대화/결과를통해 받은 데이터/종료-자원해제,예외처리
public class A05_PreDAO {
	private Connection con; // 연결객체
	private PreparedStatement pstmt; // 대화객체
	private ResultSet rs; // data를 받는 결과 객체 select sql의 처리 결과로 활용

	public void setConn() throws SQLException { // 예외를 외부에 던전 한번에 처리할 수 있게함.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("클래스 에러:" + e.getMessage());
		}
	}

	// 3. 각 기능별 메서드
	// 1) emp를 출력하는 기능메서드
	public void showEmp() {
		// 선언한 공통 연결메서드 호출
		try {
			// 1. 필드에 선언된 private Connection con; 에 객체가 생성이 된다.
			setConn();
			// 2. 대화객체선언..
			// 1) sql 문 작성
			String sql = "select * from emp01 ";
//					2) 대화객체 생성.
			pstmt = con.prepareStatement(sql);
			// 3) 대화객체를 통해 결과객체 생성, 매개변수로 sql문을 할당 처리한다.
			rs = pstmt.executeQuery();
			// 4) 전체 데이터 가져오기
//			//         저장된 갯수만큼 next()를 호출..
			/*
			 * -- ResulSet 으로 아래 내용이 할당이 된다. -- .next() : 행단위로 이동 처리함. - 그 행에 데이터가 있으면
			 * true/없으면 false -- .getString("컬럼명") : 해당 row에 상단에 선언된 column명을 기준으로 데이터를
			 * 가져온다. -- 주의 select @@ 최종 컬럼명이기 alias가 있으면 alias명으로 호출하여야 한다. -- .get테이터유형()
			 * -- ex) rs.getInt("empno"), rs.getDate("hiredate"), sal의 경우 number(4,2)로
			 * 실수형이기에 -- rs.getDouble("sal")
			 */

			int cnt = 1;
			while (rs.next()) { // 행단위로 이동 되게 한다.
				System.out.print(cnt + "행\t" + rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getDouble("sal") + "\t");
				System.out.print(rs.getDouble("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
				cnt++;
			}
			// 자원해제(열린순서 반대 방향)
			rs.close();
			pstmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * # return 객체 설정과 키워드 검색
	 * 
	 15:05에 진행하겠습니다.
	 
	 */
	public ArrayList<Emp> getEmpList(Map<String, String> map) {
		ArrayList<Emp> empList = new ArrayList<Emp>();
		try {
			setConn();
			String sql = "SELECT *\r\n" + "from emp01 \r\n" 
						+ "WHERE ename LIKE '%'|| ? ||'%'\n"
						+ "AND job LIKE '%'|| ? ||'%' "; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, map.get("ename"));
			pstmt.setString(2, map.get("job"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				empList.add(new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
						rs.getDate("hiredate"), rs.getDouble("sal"), rs.getDouble("comm"), rs.getInt("deptno")));
			}
			System.out.println();
			// 자원해제(열린순서 반대 방향)
			//
			rs.close();
			pstmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return empList;
	}

	/*
	 * # return 객체 설정과 키워드 검색
	 */
	public ArrayList<Emp> getEmpList2(String ename) {
		ArrayList<Emp> empList = new ArrayList<Emp>();
		try {
			setConn();
			String sql = "SELECT *\r\n" + "from emp01 \r\n" + "WHERE ename LIKE '%'|| ? ||'%'"; // 주의 '?' (X>
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ename);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				empList.add(new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
						rs.getDate("hiredate"), rs.getDouble("sal"), rs.getDouble("comm"), rs.getInt("deptno")));
			}
			// 자원해제(열린순서 반대 방향)
			rs.close();
			pstmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return empList;
	}

	/*
	 * # return 객체 설정과 키워드 검색
	 * 
	 * select * from emp01 where sal between ? and ? and deptno = ? -- 매개변수 3개, 리턴형식
	 * ArrayList<Emp>
	 * 
	 */
	public ArrayList<Emp10> getEmpList3(double start, double end, int deptno) {
		ArrayList<Emp10> empList = new ArrayList<Emp10>();
		try {
			setConn();
			String sql = "	select empno no, ename name, job, sal salary, \r\n"
					+ "				to_char(hiredate, 'Q') hireq, deptno dno" + "		from emp01 \r\n"
					+ "		where sal between ? and ?\r\n" + "		and deptno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, start);
			pstmt.setDouble(2, end);
			pstmt.setInt(3, deptno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// Emp10(int no, String name, String job, double salary, String hireq, int dno)
				empList.add(new Emp10(rs.getInt("no"), rs.getString("name"), rs.getString("job"),
						rs.getDouble("salary"), rs.getString("hireq"), rs.getInt("dno")));
			}
			// 자원해제(열린순서 반대 방향)
			rs.close();
			pstmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return empList;
	}

	/*
	 * select dname, ename, empno, sal from emp01 e, dept d where e.deptno =
	 * d.deptno and dname like '%'||?||'%' and ename like '%'||?||'%'
	 * 
	 */
	public ArrayList<EmpDept> getEmpList4(String dname, String ename) {
		ArrayList<EmpDept> empList = new ArrayList<EmpDept>();
		try {
			setConn();
			String sql = "	select dname, ename, empno, sal\r\n" + "	from emp01  e, dept d\r\n"
					+ "	where e.deptno = d.deptno\r\n" + "	and dname like '%'||?||'%'\r\n"
					+ "	and ename like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, ename);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				empList.add(new EmpDept(rs.getString("dname"), rs.getString("ename"), rs.getInt("empno"),
						rs.getDouble("sal")));
			}
			// 자원해제(열린순서 반대 방향)
			rs.close();
			pstmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return empList;
	}

	/*
	 * from dept where dname like '%'||?||'%' and loc like '%'||?||'%'
	 * 
	 */
	public ArrayList<Dept> getDeptList(String dname, String loc) {
		ArrayList<Dept> deptList = new ArrayList<Dept>();
		try {
			setConn();
			String sql = "	select * \r\n" + "from dept \r\n" + "where dname like '%'||?||'%' \r\n"
					+ "and loc like '%'||?||'%'";
			// ? 가 들어갈 부분에 '?'로 처리하면 안된다.
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				deptList.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
			}
			// 자원해제(열린순서 반대 방향)
			rs.close();
			pstmt.close();
			con.close();
			// 예외 처리.
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
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

	/*
	 * # return 객체 설정과 키워드 검색 INSERT INTO emp01 values(1001,'마길동','대리',7780,
	 * to_date('2010-10-10','YYYY-MM-DD'),3500,100,10)
	 * 
	 */
	public void insertEmp(Emp ins) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "INSERT INTO emp01 values(?,?,?,?,\r\n" + "	to_date(?,'YYYY-MM-DD'),?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ins.getEmpno());
			pstmt.setString(2, ins.getEname());
			pstmt.setString(3, ins.getJob());
			pstmt.setInt(4, ins.getMgr());
			pstmt.setString(5, ins.getHiredate_s());
			pstmt.setDouble(6, ins.getSal());
			pstmt.setDouble(7, ins.getComm());
			pstmt.setInt(8, ins.getDeptno());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리..
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * # return 객체 설정과 키워드 검색 INSERT INTO emp01 values(1001,'마길동','대리',7780,
	 * to_date('2010-10-10','YYYY-MM-DD'),3500,100,10)
	 * 
	 */
	public void updateEmp(Emp ins) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "UPDATE EMP01 \r\n"
					+ "	SET ename=?,\r\n"
					+ "		job = ?,\r\n"
					+ "		mgr = ?,\r\n"
					+ "		hiredate = to_date(?,'YYYY-MM-DD'),\r\n"
					+ "		sal = ?,\r\n"
					+ "		comm = ?,\r\n"
					+ "		deptno=?\r\n"
					+ "WHERE empno=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ins.getEname());
			pstmt.setString(2, ins.getJob());
			pstmt.setInt(3, ins.getMgr());
			pstmt.setString(4, ins.getHiredate_s());
			pstmt.setDouble(5, ins.getSal());
			pstmt.setDouble(6, ins.getComm());
			pstmt.setInt(7, ins.getDeptno());
			pstmt.setInt(8, ins.getEmpno());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리..
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void deleteEmp(int empno) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "delete from emp01 where empno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리..
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * # return 객체 설정과 키워드 검색 INSERT INTO emp01 values(1001,'마길동','대리',7780,
	 * to_date('2010-10-10','YYYY-MM-DD'),3500,100,10)
	 * 
	 */
	public void updateDept(Dept upt) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "update dept01\r\n"
					+ "	set dname = ?,\r\n"
					+ "		loc = ?\r\n"
					+ "where  deptno = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upt.getDname());
			pstmt.setString(2, upt.getLoc());
			pstmt.setInt(3, upt.getDeptno());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리..
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * # return 객체 설정과 키워드 검색 INSERT INTO emp01 values(1001,'마길동','대리',7780,
	 * to_date('2010-10-10','YYYY-MM-DD'),3500,100,10)
	 * 
	 */
	public void deleteDept(int deptno) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "delete from dept01\n"
					+ "where  deptno = ? ";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, deptno);
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리..
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * # return 객체 설정과 키워드 검색 INSERT INTO emp01 values(1001,'마길동','대리',7780,
	 * to_date('2010-10-10','YYYY-MM-DD'),3500,100,10)
	 * 
	 */
	public void insertDept(Dept ins) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "INSERT INTO dept01 values(?,?,?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ins.getDeptno());			
			pstmt.setString(2, ins.getDname());
			pstmt.setString(3, ins.getLoc());

			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러:" + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리..
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 예외 상관없이 처리할 내용.
			if (con != null) {
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
		A05_PreDAO dao = new A05_PreDAO();
		dao.insertDept(new Dept(50,"인사","인천"));
		//dao.updateDept(new Dept(40,"회계","서울"));
		//dao.deleteDept(40);
		/*
		 * public Emp(int empno, String ename, String job, int mgr, String hiredate_s,
		 * double sal, double comm, int deptno)
		 */
		/*
		dao.insertEmp(new Emp(1005, "이영철", "과장", 7780, "2022-06-01", 3500, 100, 10));
		dao.updateEmp(new Emp(1005, "오영철", "과장", 7780, "2022-07-01", 4500, 200, 20));
		dao.deleteEmp(1004);
		dao.showEmp();
		*/
		
		/*
		 * System.out.println("사원 정보의 갯수:"+dao.getEmpCnt());
		 * System.out.println("사원 정보의 갯수(부서):"+dao.getEmpCnt(10));
		 * System.out.println("사원 정보의 갯수(직책):"+dao.getEmpCnt("SALESMAN"));
		 */
		/*
		Map<String, String> sch = new HashMap<String, String>();
		sch.put("ename", "A");
		sch.put("job", "");
		ArrayList<Emp> empList = dao.getEmpList(sch); 
		for(Emp e:empList) {
			System.out.print(e.getEmpno()+"\t"); System.out.print(e.getEname()+"\t");
			System.out.print(e.getJob()+"\t"); System.out.print(e.getMgr()+"\t");
			System.out.print(e.getHiredate()+"\t"); System.out.print(e.getComm()+"\t");
			System.out.print(e.getDeptno()+"\n"); 
		}
		 */
		/*
		 * for(Emp10 e:dao.getEmpList3(1000, 4000, 10)) {
		 * System.out.print(e.getNo()+"\t"); System.out.print(e.getName()+"\t");
		 * System.out.print(e.getJob()+"\t"); System.out.print(e.getSalary()+"\t");
		 * System.out.print(e.getDno()+"\n"); }
		 */
		/*
		 * for(EmpDept ed:dao.getEmpList4("", "")) {
		 * System.out.print(ed.getEname()+"\t"); System.out.print(ed.getDname()+"\t");
		 * System.out.print(ed.getEmpno()+"\t"); System.out.print(ed.getSal()+"\n"); }
		 * for(Dept d:dao.getDeptList("", "")) { System.out.print(d.getDeptno()+"\t");
		 * System.out.print(d.getDname()+"\t"); System.out.print(d.getLoc()+"\n"); }
		 */
	}

}
