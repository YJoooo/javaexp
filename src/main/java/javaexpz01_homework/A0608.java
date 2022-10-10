package javaexpz01_homework;

import java.sql.SQLException;

import javaexp.z03_vo.Dept;

public class A0608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2022-06-08
//		[1단계:개념] 1. 등록/수정/삭제시, 추가 삭제 필요한 코드를 예제로 기술하세요.
		/*등록
		public void insertMember01(Member ins) {
		try {
			setConn();
			con.setAutoCommit(false);
			//Member(Member클래스에 있는 등록할 데이터타입 컬럼명)
			String sql = "INSERT INTO 테이블명 values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Member 클래스 출력메서드);
			pstmt.setString(2, Member 클래스 출력메서드);
			pstmt.setString(3, Member 클래스 출력메서드);
			
			pstmt.executeQuery();
			con.commit();
			pstmt.close();
			con.close();
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
		수정
		public void updateMember(Member upd) {
		try {
			setConn();
			String sql = "UPDATE 테이블명\r\n"
					+ "	SET 수정할 컬럼명 = 데이터"
					+ "	WHERE 조건절";
			pstmt = con.prepareStatement(sql);
			pstmt.set데이터타입(1, 수정할 메서드);
			pstmt.set데이터타입(2, 수정할 메서드);
			pstmt.set데이터타입(3, 수정할 메서드);
			pstmt.executeQuery();
			con.commit();
			pstmt.close();
			con.close();
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
		삭제
		public void deleteMember(?에 들어갈 테이터타입 컬럼명) {
		try {
			setConn();
			String sql = "delete from Member where 컬럼명=?";
			pstmt = con.prepareStatement(sql);
			pstmt.set데이터타입(1, 컬럼명);
			pstmt.executeQuery();
			con.commit();
			pstmt.close();
			con.close();
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
		*/
//		[1단계:확인] 2. 복사테이블로 Dept01 을 만들고, 입력처리하는 메서드를 만드세요.
		
//		[1단계:확인] 3. Dept01부서정보를 전체 컬럼을 수정하세요.
		
//		[1단계:확인] 4. Dept01부서정보를 deptno기준으로 삭제하세요
		
//		[1단계:개념] 5. jsp페이지를 웹서버(WAS)에서 실행할 때, 기본예제로 기본 위치와 설정파일을 기술하세요.
		// 위치 : src\main\java\webapp
		// src\main\java\webapp\WEB-INF\lib ==> jsp,oracle6,servlet 위치
	}

}
