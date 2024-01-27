package model;

public class CharacterDTO {

	private static final int MAX_LEVEL = 5; // 최종 레벨

	private String Nick;
	private int Level = 1; // 레벨
	private int Exp; // 경험치
	private int Hp; // 체력
	private int Yg; // 요구르트개수

	public CharacterDTO(String nick, int level, int exp, int hp) {
		super();
		this.Nick = nick;
		Level = level;
		Exp = exp;
		Hp = hp;

	}

	public String getNick() {
		return Nick;
	}

	public int getHp() {
		return Hp;
	}

	public int getLevel() {
		return Level;
	}

	public int getExp() {
		return Exp;
	}

	public void setHp(int Hp) {
		this.Hp = Hp;
	}

	public void setLevel(int Level) {
		this.Level = Level;
	}

	public void setExp(int Exp) {
		this.Exp = Exp;
	}
}
