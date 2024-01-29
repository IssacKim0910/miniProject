package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controller.Controller;

public class CharacterDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	Controller controller = new Controller();

	// 떡잎 마을 배달

	// 배달 했을때
	public void delivery(CharacterDTO character) {
		String selectSql = "SELECT LIFE FROM JJANG WHERE NICK = ?";
		String updateSql = "UPDATE JJANG SET LIFE = ? WHERE NICK = ?";

		try {
			connection();
			psmt = conn.prepareStatement(selectSql);
			psmt.setString(1, character.getNick());

			rs = psmt.executeQuery();
			if (rs.next()) {
				int life = rs.getInt("Life");
				int updatedLife = life - 1;

				psmt = conn.prepareStatement(updateSql);
				psmt.setInt(1, updatedLife);
				psmt.setString(2, character.getNick());

				// Update 쿼리 실행
				int rowsAffected = psmt.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("캐릭터의 Life이 성공적으로 업데이트되었습니다.");
				} else {
					System.out.println("캐릭터의 Life 업데이트에 실패했습니다.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

//	public void delivery(CharacterDTO character) {
//	    String selectSql = "SELECT LIFE FROM JJANG WHERE NICK = ?";
//	    String updateSql = "UPDATE JJANG SET LIFE = LIFE - 1 WHERE NICK = ?";
//
//	    try {
//	        connection();
//
//	        // 쿼리 실행 전에 ResultSet을 초기화합니다.
//	        psmt = conn.prepareStatement(selectSql);
//	        psmt.setString(1, character.getNick());
//	        rs = psmt.executeQuery();
//
//	        // Update 쿼리 실행
//	        psmt = conn.prepareStatement(updateSql);
//	        psmt.setString(1, character.getNick());
//	        int rowsAffected = psmt.executeUpdate();
//
//	        if (rowsAffected > 0) {
//	            System.out.println("캐릭터의 LIFE가 성공적으로 업데이트되었습니다.");
//	        } else {
//	            System.out.println("캐릭터의 LIFE 업데이트에 실패했습니다.");
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        close();
//	    }
//	}

	// 유치원 배달

	// 잠잘때 미구현
	public void sleep(CharacterDTO character) {
		if (character.getLevel() == 1) {
			character.setHp(10);
		} else if (character.getLevel() == 2) {
			character.setHp(20);
		} else if (character.getLevel() == 3) {
			character.setHp(30);
		} else if (character.getLevel() == 4) {
			character.setHp(40);
		} else {
			character.setHp(50);
		}
//		String sql = "UPDATE JJANG SET HP = ? WHERE NICK = ?";
//		DTO dto = new DTO("id", "pw", "nick");
//
//		try {
//		connection();
//			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, character.getHp());
//			psmt.setString(2, dto.getNick());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//		close();
	}

	// 초코비 먹을때

	public void eat(CharacterDTO character) {
		String selectSql = "SELECT * FROM JJANG WHERE NICK = ?";
		String updateSql = "UPDATE JJANG SET HP = ? , CB = ? ,LIFE =? WHERE NICK = ?";

		try {
			connection();
			psmt = conn.prepareStatement(selectSql);
			psmt.setString(1, character.getNick());

			rs = psmt.executeQuery();
			if (rs.next()) {
				int hp = rs.getInt("HP");
				int cb = rs.getInt("CB");
				int updatedHp = hp + 3;
				int updateCb = cb - 1;
				int life = rs.getInt("Life");
				int updatedLife = life + 1;
				
				psmt = conn.prepareStatement(updateSql);
				psmt.setInt(1, updatedHp);
				psmt.setInt(2, updateCb);
				psmt.setInt(3, updatedLife);
				psmt.setString(4, character.getNick());

				// Update 쿼리 실행
				int rowsAffected = psmt.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("캐릭터의 체력이 성공적으로 업데이트되었습니다.");
				} else {
					System.out.println("캐릭터의 체력 업데이트에 실패했습니다.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

//	public void eat(CharacterDTO character) {
//
//		String sql1 = "SELECT HP FROM JJANG WHERE NICK = ?";
//
//		String sql = "UPDATE JJANG SET HP = ? + 3 WHERE NICK = ?";
//
//		try {
//			connection();
//			psmt = conn.prepareStatement(sql1);
//			psmt.setString(1, character.getNick());
//
//			rs = psmt.executeUpdate();
//			if (rs.next()) {
//				int hp = rs.getInt("HP");
//
//				psmt = conn.prepareStatement(sql);
//				psmt.setInt(1, hp);
//				psmt.setString(2, character.getNick());
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//
//	}

	// 경험치 누적
	private static final int EXP_FOR_LEVEL_UP = 100;
	private CharacterDTO character;

	public void increaseExp(int exp) {
		int currentExp = character.getExp();
		character.setExp(currentExp + exp);
		checkLevelUp(character);
		saveCharacterExp(character);
	}

	// 경험치를 db로
	private void saveCharacterExp(CharacterDTO character) {
		try {
			connection(); // 데이터베이스 연결
			String sql = "UPDATE JJANG SET EXP = ? WHERE NICK = ?"; // 경험치 값을 업데이트하는 SQL 쿼리
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, character.getExp());
			psmt.setString(2, character.getNick());

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 레벨업
	public void checkLevelUp(CharacterDTO character) {
		CharacterDTO cDTO = new CharacterDTO("null", 0, 0, 0);
		DTO dto = new DTO("id", "pw", "nick");
		String sql = "UPDATE JJANG SET LV = LV + ? WHERE NICK = ?";
		int currentExp = character.getExp();
		if (currentExp >= EXP_FOR_LEVEL_UP) {
			int currentLevel = character.getLevel();
			if (currentLevel < 5) {
				character.setLevel(currentLevel + 1);
				character.setExp(currentExp - EXP_FOR_LEVEL_UP);
				System.out.println("레벨이 증가했습니다! 현재 레벨: " + character.getLevel());

				try {
					connection();
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1, 1); // 레벨 업 증가량 설정
					psmt.setString(2, character.getNick());
					psmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close();
				}
			} else {
				System.out.println("최대 레벨에 도달했습니다!");
			}
		}
	}

	public CharacterDTO login(String id, String pw) {

		CharacterDTO info = null;

		try {
			connection();
			String sql = "SELECT * FROM JJANG WHERE ID = ? AND PW = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next() == true) {

				String login_id = rs.getString("ID");
				String login_pw = rs.getString("PW");
				String login_nick = rs.getString("NICK");
				int Lv = rs.getInt(4);
				int Hp = rs.getInt(5);
				int Exp = rs.getInt(6);
				int Cb = rs.getInt(7);
				int Life = rs.getInt(8);

				info = new CharacterDTO(login_id, login_pw, login_nick, Lv, Hp, Exp, Cb, Life);

			}

		} catch (Exception e) { // TODO Auto-generated catch block
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