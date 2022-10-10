package javaexp.a13_database;

import java.sql.*;
public class A01_Connection {
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public void setConn() throws SQLException { // 예외를 외부에 던져 한번에 처리할수 있게함.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 : "+e.getMessage());
		}
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info,"scott","tiger");
		System.out.println("접속성공!");
	}
	
	public void showEmp() {
		try {
			setConn();
			String sql = "select * from emp";
			//sql문 안에 (;)을 붙이지 않는다.
			//	2) 대화객체 생성
			stmt = con.createStatement();
			//	3) 대화객체를 통해 결과 객체 생성, 매개변수로 sql문을 할당 처리한다.
			rs = stmt.executeQuery(sql);
			//	4) 전체 데이터 가져오기
			//		저장된 갯수만큼 next()를 호출
			int cnt = 1;
			while(rs.next()) {
				System.out.print(rs.getInt("empno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("job")+"\t");
				System.out.print(rs.getString("mgr")+"\t");
				System.out.print(rs.getDate("hiredate")+"\t");
				System.out.print(rs.getDouble("sal")+"\t");
				System.out.print(rs.getDouble("comm")+"\t");
				System.out.print(rs.getInt("deptno")+"\n");
				cnt++;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("일반 예외 : "+ e.getMessage());
		}finally {
			//예외 상관없이 처리할 내용
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
	}

	//  1) select * from salgrade (출력만)
		
		public void showSalgrad() {
			try {
				setConn();
				String sql = "select * from salgrade";
				//sql문 안에 (;)을 붙이지 않는다.
				//	2) 대화객체 생성
				stmt = con.createStatement();
				//	3) 대화객체를 통해 결과 객체 생성, 매개변수로 sql문을 할당 처리한다.
				rs = stmt.executeQuery(sql);
				//	4) 전체 데이터 가져오기
				//		저장된 갯수만큼 next()를 호출
				int cnt = 1;
				System.out.println("grade\tlosal\thisal");
				while(rs.next()) {
					System.out.print(rs.getInt("grade")+"\t");
					System.out.print(rs.getInt("losal")+"\t");
					System.out.print(rs.getInt("hisal")+"\n");
					cnt++;
				}
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(Exception e) {
				System.out.println("일반 예외 : "+ e.getMessage());
			}finally {
				//예외 상관없이 처리할 내용
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
		}
		//    2) 부서별 최고급여자 (출력만)

			public void showMaxSal() {
				try {
					setConn();
					String sql = "SELECT * FROM emp WHERE (deptno,sal) in(SELECT deptno, max(sal) sal FROM EMP GROUP BY deptno)";
					//sql문 안에 (;)을 붙이지 않는다.
					//	2) 대화객체 생성
					stmt = con.createStatement();
					//	3) 대화객체를 통해 결과 객체 생성, 매개변수로 sql문을 할당 처리한다.
					rs = stmt.executeQuery(sql);
					//	4) 전체 데이터 가져오기
					//		저장된 갯수만큼 next()를 호출
					int cnt = 1;
					while(rs.next()) {
						System.out.print(rs.getInt("empno")+"\t");
						System.out.print(rs.getString("ename")+"\t");
						System.out.print(rs.getString("job")+"\t");
						System.out.print(rs.getString("mgr")+"\t");
						System.out.print(rs.getDate("hiredate")+"\t");
						System.out.print(rs.getDouble("sal")+"\t");
						System.out.print(rs.getDouble("comm")+"\t");
						System.out.print(rs.getInt("deptno")+"\n");
						cnt++;
					}
					rs.close();
					stmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch(Exception e) {
					System.out.println("일반 예외 : "+ e.getMessage());
				}finally {
					//예외 상관없이 처리할 내용
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
			}
			//    3) 부서번호가 20인 최고연봉 (리턴유형 double)
				
				public double showdept20() {
					double maxsal = 0.0;
					try {
						setConn();
						String sql = "SELECT max(sal) FROM EMP WHERE deptno = 20";
						//sql문 안에 (;)을 붙이지 않는다.
						//	2) 대화객체 생성
						stmt = con.createStatement();
						//	3) 대화객체를 통해 결과 객체 생성, 매개변수로 sql문을 할당 처리한다.
						rs = stmt.executeQuery(sql);
						//	4) 전체 데이터 가져오기
						//		저장된 갯수만큼 next()를 호출
						rs.next();
						maxsal = rs.getDouble("maxsal");
						rs.close();
						stmt.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch(Exception e) {
						System.out.println("일반 예외 : "+ e.getMessage());
					}finally {
						//예외 상관없이 처리할 내용
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
					return maxsal;
				}
				//    4) 사원명이 JONES인 사원정보(출력만)				
					
					public void showenamejones() {
						try {
							setConn();
							String sql = "SELECT * FROM emp WHERE ename = 'JONES'";
							//sql문 안에 (;)을 붙이지 않는다.
							//	2) 대화객체 생성
							stmt = con.createStatement();
							//	3) 대화객체를 통해 결과 객체 생성, 매개변수로 sql문을 할당 처리한다.
							rs = stmt.executeQuery(sql);
							//	4) 전체 데이터 가져오기
							//		저장된 갯수만큼 next()를 호출
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
							stmt.close();
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch(Exception e) {
							System.out.println("일반 예외 : "+ e.getMessage());
						}finally {
							//예외 상관없이 처리할 내용
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
					}

					//    5) 분기별 최고 급여자(출력만)
						
						public void showQmaxsal() {
							try {
								setConn();
								String sql = "SELECT empno, ename, job, mgr, hiredate, sal, to_char(hiredate,'Q'), comm, deptno FROM EMP WHERE (sal, to_char(hiredate,'Q')) in( SELECT max(sal) sal, to_char(hiredate,'Q') FROM EMP GROUP BY to_char(hiredate,'Q')) ORDER BY to_char(hiredate,'Q')";
								//sql문 안에 (;)을 붙이지 않는다.
								//	2) 대화객체 생성
								stmt = con.createStatement();
								//	3) 대화객체를 통해 결과 객체 생성, 매개변수로 sql문을 할당 처리한다.
								rs = stmt.executeQuery(sql);
								//	4) 전체 데이터 가져오기
								//		저장된 갯수만큼 next()를 호출
								while(rs.next()) {
									System.out.print(rs.getString("ename")+"\t");
									System.out.print(rs.getDate("hiredate")+"\t");
									System.out.print(rs.getInt("to_char(hiredate,'Q')")+"\t");
									System.out.print(rs.getDouble("sal")+"\n");
								}
								rs.close();
								stmt.close();
								con.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}catch(Exception e) {
								System.out.println("일반 예외 : "+ e.getMessage());
							}finally {
								//예외 상관없이 처리할 내용
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
						}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A01_Connection con = new A01_Connection();
		//con.showEmp();
		//con.showSalgrad();
		//con.showMaxSal();
		//con.showdept20();
		//con.showenamejones();
		con.showQmaxsal();
	}

}
