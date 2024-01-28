package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharacterDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 떡잎 마을 배달

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
		character.setHp(character.getHp() + 3);

		CharacterDTO cDTO = new CharacterDTO("null", 0, 0, 0);
		DTO dto = new DTO("id", "pw", "nick");
		String sql = "UPDATE JJANG SET HP = HP+ ? WHERE NICK = ?";

		int a = cDTO.getHp() + 3;
		try {
			connection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, a);
			psmt.setString(2, dto.getNick());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}
	
	
	// 판매-진행중
//	public void sellYg();
//
//	{
//
<<<<<<< HEAD
//
//       return Exp;
//    }
//
//	if(Exp>0)
//	{
//		System.out.println("아이템을 판매하여 경험치 " + Exp + "를 획득하였습니다.");
//	}else if(Exp<0)
//	{
//		System.out.println("마이너스 경험치를 얻었습니다. 경험치가 " + Math.abs(Exp) + "만큼 감소하였습니다.");
//
//	}}
//
//	branch'master'
//	of https:// github.com/2021-SMHRD-KDT-AI-18/fouthrepo.git
=======
//		if (Exp > 0) {
//			System.out.println("아이템을 판매하여 경험치 " + Exp + "를 획득하였습니다.");
//		} else if (Exp < 0) {
//			System.out.println("마이너스 경험치를 얻었습니다. 경험치가 " + Math.abs(Exp) + "만큼 감소하였습니다.");
//
//		}
//	}

>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-AI-18/fouthrepo.git
	// 경험치 누적
	private static final int EXP_FOR_LEVEL_UP = 100;
	private CharacterDTO character;

	public void increaseExp(int exp) {
	    int currentExp = character.getExp();
	    character.setExp(currentExp + exp);
	    checkLevelUp(character);
	    saveCharacterExp(character);
	}

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

	// 레벨업
<<<<<<< HEAD
	private void checkLevelUp(CharacterDTO character) {
		CharacterDTO cDTO = new CharacterDTO("null", 0, 0, 0);
		DTO dto = new DTO("id", "pw", "nick");
		String sql = "UPDATE JJANG SET LV = LV + ? WHERE NICK = ?";
	
		if (character.getExp() >= 100) {
			int currentLevel = character.getLevel();
			int newLevel = currentLevel + 1;

			if (newLevel <= 5) {
				character.setLevel(newLevel);
				character.setExp(0);
				System.out.println("레벨이 증가했습니다! 현재 레벨: " + newLevel);
			} else {
				System.out.println("최대 레벨에 도달했습니다!");
			}
		}
	}
=======

>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-AI-18/fouthrepo.git

	public DTO login(String id, String pw) {

		DTO info = null;

		try {
			connection();
			String sql = "SELECT * FROM JJANG WHERE ID = ? AND PW = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next() == true) {
				String login_id = rs.getString(1);
				String login_pw = rs.getString(2);
				String login_nick = rs.getString(3);

				info = new DTO(login_id, login_pw, login_nick);

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