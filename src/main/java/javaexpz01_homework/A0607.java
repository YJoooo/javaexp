package javaexpz01_homework;

import java.sql.SQLException;

public class A0607 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-06-07
//		[1단계:개념] 1. PreparedStament를 사용하는 이유를 기술하세요
		// 가독성과 효율성이 좋아진다.
		// Statement 객체의 SQL은 실행될 때 매번 서버에서 분석해야 하는 반면, PreparedStatement 객체는 한 번 분석되면 재사용이 용이하다.
		// 동일한 SQL문을 특정 값만 바꾸어서 여러 번 실행해야 할 때, 인수가 많아서 SQL문을 정리해야 될 필요가 있을 때 사용하면 유용하다.
//		[1단계:개념] 2. PreparedStament 를 활용하여 기존에 Statement와 비교하여 변경되는 code를 예제를 통해 기술하세요.
		/*
		public void showEmp() {
		try {
			setConn();
			String sql = "select * from emp";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				출력할 내용
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
		 */
		/*
		# PreparedStament활용 변경
		public void showEmp() {
		try {
			setConn();
			String sql = "select * from emp where ";
			pstmt = con.PreparedStament(sql);
			pstmt.set데이터유형(순번, 데이터)
			rs = pstmt.executeQuery();
			while(rs.next()) {
				출력할 내용
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("일반 예외 : "+ e.getMessage());
		}finally {
			if(con!=null) {
				try {
					con.close();
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
		 */
//		[1단계:확인] 3. 연봉이 범위(@@~@@) 사이이고, 부서별로 검색하는 사원 정보를 PreparedStament 로 처리하여 결과를 출력하세요
		/*
			1) sql 작성
				select *
				from emp
				where sal between ? and ?
				and deptno = ?
				매개변수 3개 리턴형식 ArrayList<Emp>
				
				select emp no, ename name, job, sal salary, to_char(hiredate,'Q')hireq, deptno dno
				from emp
				where sal between ? and ?
				and deptno = ?
				==> private int NO;
					private String name;
					private String job;
					private double salary;
					private String hireq;
					private int dno;
				
			2) dao 기능메서드 선언
				- vo 생성확인
				- 리턴값 매개변수 확인
			3) 기본 메서드 복사
			4) sql 선언, pstmt.setXXXX() 설정
			5) resultSet 선언.	
		*/	
//		[1단계:확인] 4. 사원명과 부서명을 키워드검색(like,%활용)하여, 부서명, 사원명, 사원번호, 급여를 출력 하게 하세요.
//					(PreparedStament)
		/*
		select dname, ename, empno, sal
		from emp e, dept d
		where e.deptno = d.deptno
		and dname like '%'||''||'%'
		and loc like '%'||''||'%'
		
		private String dname;
		private String ename;
		private int empno;
		private double sal;
		
		select dname, ename, empno, sal
		from emp e, dept d
		where e.deptno = d.deptno
		and dname like '%'||?||'%'
		and loc like '%'||?||'%'
		 */
//		[1단계:확인] 5. select * from dept where dname like '%'||''||'%' and loc like '%'||''||'%' 를 이용해서
//        리턴 ArrayList<Dept>로 처리해서 main()에서 확인하세요.
		/*
		select *
		
		 */
		
//		[1단계:확인] 6. 오늘 webprj2로 프로젝트 만들고, 톰캣연동하는 부분을 ppt 자료를 만들어서 캡쳐해서, 제출하세요.
	}

}
