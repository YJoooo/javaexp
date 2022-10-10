package javaexpz01_homework;

public class A0603 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-06-03
//		[1단계:개념] 1. database 서버 연동에 필요한 기본 정보를 java에서 설정하는 방법을 기술하세요.
		/*
		1. 메서드 선언 : 리턴값, 매개변수
		2. 공통 연결 메서드 호출 : setConn();
		3. sql 문자열 선언 : String sql = "select * from emp";
		4. 대화객체 생성 : stmt = con.createStatement();
		5. 결과객체 생성 : rs = stmt.executeQuery(sql);
		public void  {
			try {
				setConn();
				String sql = sql문
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
		6. while()문을 통해 결과객체 출력
			while(r.next()){ // 행단위 호출
			rs.get데이터유옇("컬럼명1");
			}
		7. 자원해제 : rs.close(); stmt.close(), con.close();		
				rs.close();
				stmt.close();
				con.close();
		8. try{}catch문 예외처리 추가		
				} catch (SQLException e) {
					e.printStackTrace();
				}catch(Exception e) {
					System.out.println("일반 예외 : "+ e.getMessage());
				}finally {
					//예외 상관없이 처리할 내용
					if(con!=null) {
						try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
					}
					if(stmt!=null) {
						try {
							stmt.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
					}
					if(rs!=null) {
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		9. main()에서 기능 메서드 호출.
		*/
		
//		[1단계:확인] 2. A01_Connection 객체로 연동처리하여, 연동된 내용을 출력하세요.
		
//		[1단계:개념] 3. DAO 처리에서 사용하는 필드 Connection, Statement, ResultSet 객체의
//		      역할과, 각 객체의 상호 생성 메서드를 기본예제를 통해서 설명하세요.
/*		
		private Connection con; ==> Connection 연결객체 
		private Statement stmt; ==> Statement 실행객체
		private ResultSet rs; ==> ResultSet 결과객체	
 */
//		[1단계:개념] 4. ResultSet 객체의 기능 메서드 next(), getXXX() 메서드에 대하여 기본예제와 함께 설명하세요.
//		next() : 호출 횟수에 따라 행의 커서 위치시킴
//		ex) next() 2번 ==> 2번째행 위치
//		getXXX() -> get데이터유형(컬럼명) : 컬럼의 데이터를 출력
//		ex) getString(ename) ename의 데이터 출력
		
//		[1단계:확인] 5. 아래의 여러형태의 sql을 처리하는 기능 메서드를 만드세요.
		
//		      1) select * from salgrade (출력만)
//		      2) 부서별 최고급여자 (출력만)
//		      3) 부서번호가 20인 최고연봉 (리턴유형 double)
//		      4) 사원명이 JONES인 사원정보(출력만)
//		      5) 분기별 최고 급여자(출력만)

	}

}
