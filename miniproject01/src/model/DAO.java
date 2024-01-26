package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public int join(DTO dto) {

		String id = dto.getId();
		String pw = dto.getPw();
		String nick = dto.getNick();

		int cnt = 0;
		// JDBC - 회원등록
		// 1.드라이버 로드(동적로딩)
		// - 컴파일러가 아래 코드를 보고 해당 드라이버를 찾아가서 적용하기때문
		try {
			connection();

			// 3.SQL문장 실행
			// - PreparedStatement

			String sql = "INSERT INTO MEMBER VALUES(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);

			// executeUpdate()는 실행한 문장의 개수를 반환
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public DTO login(String id, String pw) {

		DTO info = null;
		
		try {
			// DB연동해주는 메소드
			connection();

			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PW = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			// CRUD : CREATE/READ/UPDATE/DELETE
			// executeUpdate() : 삽입(INSERT), 수정(UPDATE), 삭제(DELETE)
			// -> 실행에 성공했을때 수행된 row 수를 반환(int)
			// executeQuery() : 조회(SELECT)
			// -> ResultSet : 커서 객체

			rs = psmt.executeQuery();

			if (rs.next() == true) {
				String login_id = rs.getString(1);
				String login_pw = rs.getString(2);
				String login_nick = rs.getString(3);
		
				
				info = new DTO(login_id, login_pw, login_nick); 
			
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		} 
		return info;

	}
	

	
	
	private void connection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String db_url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String db_id = "campus_23K_AI18_p1_6";
			String db_pw = "smhrd6";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

			if (conn != null) {
				System.out.println("Connection 연결 성공");
			} else {
				System.out.println("Connection 연결 실패");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void close() {
	
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
