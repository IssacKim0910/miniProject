package model;

public class CharacterDAO {
	


	//떡잎 마을 배달
	
	//유치원 배달
	
	//잠잘때
	public void sleep() {
		
	}
	//초코비 먹을때
	
	//삥뜯길때	

	// 판매
	public int sellItem(Yg Yg) {
        int Exp = Yg.getExp();

        if (Exp > 0) {
            System.out.println("아이템을 판매하여 경험치 " + Exp + "를 획득하였습니다.");
        } else if (Exp < 0) {
            System.out.println("마이너스 경험치를 얻었습니다. 경험치가 " + Math.abs(Exp) + "만큼 감소하였습니다.");
        } else {
            System.out.println("아이템을 판매하여 경험치를 얻지 못했습니다.");
        }

        return Exp;
    }
	
	// 경험치 누적
	private CharacterDTO character;

    public CharacterDAO(CharacterDTO character) {
        this.character = character;
    }

    public void increaseExp(int exp) {
        character.setExp(character.getExp() + exp);
        if (character.getExp() >= 20) {
            levelUp();
        }
    }

    public void levelUp() {
        if (character.getLevel() < 5) {
            character.setLevel(character.getLevel() + 1);
            character.setExp(character.getExp() - 20);
        }}
    
	//레벨업
	private void checkLevelUp(CharacterDTO character) {
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
}