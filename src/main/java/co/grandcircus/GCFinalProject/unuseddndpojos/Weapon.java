package co.grandcircus.GCFinalProject.unuseddndpojos;

public class Weapon {

	private int dmg;
	private int numDmgDice;
	private String name;
	private boolean ranged;
	private boolean martial;
	
	//Constructors
	public Weapon() {
		this.dmg = 0;
		this.name = null;
	}
	public Weapon(String name, int dmg, boolean martial, boolean ranged) {
		this.dmg = dmg;
		this.numDmgDice = 1;
		this.name = name;
		this.martial = martial;
		this.ranged = ranged;
	}
	public Weapon(String name, int dmg, int numDmgDice, boolean martial, boolean ranged) {
		this.dmg = dmg;
		this.numDmgDice = numDmgDice;
		this.name = name;
		this.martial = martial;
		this.ranged = ranged;
	}
	//Getters and Setters
 	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isRanged() {
		return ranged;
	}
	public void setRanged(boolean ranged) {
		this.ranged = ranged;
	}
	public boolean isMartial() {
		return martial;
	}
	public void setMartial(boolean martial) {
		this.martial = martial;
	}
	public int getNumDmgDice() {
		return numDmgDice;
	}
	public void setNumDmgDice(int numDmgDice) {
		this.numDmgDice = numDmgDice;
	}
	
}
