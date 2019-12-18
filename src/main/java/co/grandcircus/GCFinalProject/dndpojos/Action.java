package co.grandcircus.GCFinalProject.dndpojos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Action implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("damage_bonus")
	private int damageBonus;
	@JsonProperty("damage_dice")
	private String damageDice;
	@JsonProperty("attack_bonus")
	private int attackBonus;
	private String desc;
	private String name;
	
	public Action() {
		super();
	}

	public Action(int attackBonus, String desc, String name) {
		super();
		this.attackBonus = attackBonus;
		this.desc = desc;
		this.name = name;
		this.damageDice = null;
		}

	public Action(int damageBonus, String damageDice, int attackBonus, String desc, String name) {
		super();
		this.damageBonus = damageBonus;
		this.damageDice = damageDice;
		this.attackBonus = attackBonus;
		this.desc = desc;
		this.name = name;
	}

	public int getDamageBonus() {
		return damageBonus;
	}

	public void setDamageBonus(int damageBonus) {
		this.damageBonus = damageBonus;
	}

	public String getDamageDice() {
		return damageDice;
	}

	public void setDamageDice(String damageDice) {
		this.damageDice = damageDice;
	}

	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getRolledDamage() {
		String[] strngDmg = damageDice.split("d");
		int numDice = Integer.parseInt(strngDmg[0]);
		int diceValue = Integer.parseInt(strngDmg[1]);
		int dmg = 0;
		for (int i = 0; i < numDice; i++) {
			dmg += Dice.roll(diceValue);
		}
		dmg += damageBonus;
		return dmg;
	}
	
}
