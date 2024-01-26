package model;

public class DTO {

	private double exp = 0.0; // 경험치
	private int lv = 1; // 레벨
	private int hp = 40; // 체력
	private int yg = 1; // 요구르트
	
	public DTO(double exp, int lv, int hp, int yg) {
		super();
		this.exp = exp;
		this.lv = lv;
		this.hp = hp;
		this.yg = yg;
	}
	
	
}
