package model;

import java.util.Random;

public class Yg {
	private int exp;

    public Yg(int characterLevel) {
        Random random = new Random();
        int bonusExp = random.nextInt(6);  // 0부터 5까지의 보너스 경험치
        int sign = random.nextBoolean() ? 1 : -1;  // 양수 또는 음수

        // 아이템의 경험치는 캐릭터 레벨에 따라 결정됩니다.
        exp = characterLevel + bonusExp * sign;
    }

    public int getExp() {
        return exp;
    }
}

