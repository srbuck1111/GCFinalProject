package co.grandcircus.GCFinalProject.dndpojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArmorClass {

	private int base;
	@JsonProperty("dex_bonus")
	private boolean dexBonus;
	@JsonProperty("max_bonus")
	private Integer maxBonus;
	
	
	public ArmorClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArmorClass(int base, boolean dexBonus, Integer maxBonus) {
		super();
		this.base = base;
		this.dexBonus = dexBonus;
		this.maxBonus = maxBonus;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public boolean isDexBonus() {
		return dexBonus;
	}

	public void setDexBonus(boolean dex_bonus) {
		this.dexBonus = dex_bonus;
	}

	public Integer getMaxBonus() {
		return maxBonus;
	}

	public void setMaxBonus(Integer max_bonus) {
		this.maxBonus = max_bonus;
	}
	
}
