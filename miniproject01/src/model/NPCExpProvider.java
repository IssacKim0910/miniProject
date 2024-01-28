package model;

public class NPCExpProvider {
	Random1 r = new Random1();

    public void giveExperience(CharacterDTO character, String npcName) {
        String randomNpcName = r.random2(0); // 메서드 호출하여 NPC 이름을 가져옴

        if (randomNpcName.equals("유리")) {
            // NPC 이름이 일치할 경우에만 경험치 제공
            int Exp = calculateExperience(character.getLevel()); // 경험치 계산
            character.setExp(character.getExp() + Exp); // 경험치 증가
        }
        if (randomNpcName.equals("훈발놈")) {
            int Exp = calculateExperience(character.getLevel());
            character.setExp(character.getExp() + Exp);
        }
        if (randomNpcName.equals("철수")) {
            int Exp = calculateExperience(character.getLevel());
            character.setExp(character.getExp() + Exp);
        }
        if (randomNpcName.equals("맹구")) {
            int Exp = calculateExperience(character.getLevel());
            character.setExp(character.getExp() + Exp);
        }
        if (randomNpcName.equals("원장님")) {
            int Exp = calculateExperience(character.getLevel());
            character.setExp(character.getExp() + (Exp * 2));
        }
        if (randomNpcName.equals("치타")) {
             int Exp = calculateExperience(character.getLevel());
            character.setExp(character.getExp() - Exp);
        }
        if (randomNpcName.equals("이슬이누나")) {
         	int Exp = calculateExperience(character.getLevel());
        	character.setExp(character.getExp() + Exp);
        }
        if (randomNpcName.equals("미소이모")) {
        	int Exp = calculateExperience(character.getLevel());
        	character.setExp(character.getExp() + Exp);
        }
        if (randomNpcName.equals("철수")) {
        	int Exp = calculateExperience(character.getLevel());
        	character.setExp(character.getExp() + Exp);
        }
        if (randomNpcName.equals("맹구")) {
        	int Exp = calculateExperience(character.getLevel());
        	character.setExp(character.getExp() + Exp);
        }
        if (randomNpcName.equals("원장님")) {
        	int Exp = calculateExperience(character.getLevel());
        	character.setExp(character.getExp() + (Exp * 2));
        }
        if (randomNpcName.equals("치타")) {
        	int Exp = calculateExperience(character.getLevel());
        	character.setExp(character.getExp() - Exp);
        }
    }

    private int calculateExperience(int level) {
        // 경험치 계산 로직 작성
        switch (level) {
            case 1:
                return 10;
            case 2:
                return 10;
            case 3:
                return 10;
            case 4:
                return 10;
            case 5:
                return 10;
            default:
                return 10;
        }
    }
}