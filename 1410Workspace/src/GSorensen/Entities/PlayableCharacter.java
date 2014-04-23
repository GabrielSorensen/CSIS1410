package Entities;

import java.io.Serializable;

public class PlayableCharacter extends AbstractMoveableEntitty implements Serializable{
	
	private static final long serialVersionUID = 666L;
	
	private int HP;
	private int MP;
	private int XP;
	
	private int STR;
	private int INT;
	private int CON;
	private int LCK;
	
	private int ATK;
	private int DEF;
	
	private int Money;
	
	private static final int maxXPMoney = 1000000000;
	private static final int maxHpMp = 9999;
	private static final int maxStat = 999;
	
	

	public PlayableCharacter(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	public PlayableCharacter(double x, double y, double width, double height, 
			int HP, int MP, int XP, int ATK, int DEF, int STR, int INT, int CON, int LCK, int Money) {
		super(x, y, width, height);
		setHP(HP);
		setMP(MP);
		setXP(XP);
		setATK(ATK);
		setDEF(DEF);
		setSTR(STR);
		setINT(INT);
		setCON(CON);
		setLCK(LCK);
		setMoney(Money);
		
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		if (hP<maxHpMp) {
			HP = hP;
		} else {
			HP = maxHpMp;
		}
	}
	public int getMP() {
		return MP;
	}
	public void setMP(int mP) {
		if (mP<maxHpMp) {
			MP = mP;
		} else {
			MP = maxHpMp;
		}
	}
	public int getXP() {
		return XP;
	}
	public void setXP(int xP) { // adding negative xp to decrease lvls????
		if (xP < maxXPMoney) {
			XP = xP;
		} else {
			XP = maxXPMoney;
		}
	}
	public int getSTR() {
		return STR;
	}
	public void setSTR(int sTR) {
		if (sTR < maxStat) {
			STR = sTR;
		} else {
			STR = maxStat;
		}
	}
	public int getDEF() {
		return DEF;
	}
	public void setDEF(int dEF) {
		if (dEF < maxStat) {
			DEF = dEF;
		} else {
			DEF = maxStat;
		}
	}
	public int getINT() {
		return INT;
	}
	public void setINT(int iNT) {
		if (iNT < maxStat) {
			INT = iNT;
		} else {
			INT = maxStat;
		}
	}
	public int getCON() {
		return CON;
	}
	public void setCON(int cON) {
		if (cON < maxStat) {
			CON = cON;
		} else {
			CON = maxStat;
		}
	}
	public int getLCK() {
		return LCK;
	}
	public void setLCK(int lCK) {
		if (lCK < maxStat) {
			LCK = lCK;
		} else {
			LCK = maxStat;
		}
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		if (money < maxXPMoney) {
			Money = money;
		} else {
			Money = maxXPMoney;
		}
	}
	public int getATK() {
		return ATK;
	}
	public void setATK(int aTK) {
		if (aTK < maxStat) {
			ATK = aTK;
		} else {
			ATK = maxStat;
		}
	}
	@Override
	public void draw() {
		
	}
}
