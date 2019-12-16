package co.grandcircus.GCFinalProject.unuseddndpojos;

public class UnitClass{

	private String className;
	private boolean canUseMartial;
	private int spellcasterLevel;

	//Constructors
	public UnitClass() {
		className = null;
		canUseMartial = false;
		spellcasterLevel = 0;
	}
	public UnitClass(String className, boolean canUseMartial, int spellcasterLevel) {
		this.className = className;
		this.canUseMartial = canUseMartial;
		this.spellcasterLevel = spellcasterLevel;
	}
	
	//Getters and Setters
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public boolean isCanUseMartial() {
		return canUseMartial;
	}
	public void setCanUseMartial(boolean canUseMartial) {
		this.canUseMartial = canUseMartial;
	}
	public int getSpellcasterLevel() {
		return spellcasterLevel;
	}
	public void setSpellcasterLevel(int spellcasterLevel) {
		this.spellcasterLevel = spellcasterLevel;
	}
	
}

