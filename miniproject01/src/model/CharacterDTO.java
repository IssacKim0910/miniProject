package model;

public class CharacterDTO {

	private static final int MAX_LEVEL = 5;  // 최종 레벨

    
	private int Level = 1;	//레벨 
	private int Exp;	//경험치 
	private int Hp;		//체력 
	private int Yg;		//요구르트개수
	
	public int getHealth() {
        return Hp;
    }

    public int getLevel() {
        return Level;
    }

    public int getExp() {
        return Exp;
    }
	
    public void setHealth(int Hp) {
        this.Hp = Hp;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public void setExp(int Exp) {
        this.Exp = Exp;
    }
}
    
    
	
	

