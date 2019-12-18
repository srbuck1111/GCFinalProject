package co.grandcircus.GCFinalProject.dndpojos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Damage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("dice_count")
	private int diceCount;
	@JsonProperty("dice_value")
	private int diceValue;
//	@JsonProperty("damage_type")
//	private DamageType damageType;

	public Damage() {
		super();
	}

	public Damage(int diceCount, int diceValue) {
		super();
		this.diceCount = diceCount;
		this.diceValue = diceValue;
	}

	public int getDiceCount() {
		return diceCount;
	}

	public void setDiceCount(int diceCount) {
		this.diceCount = diceCount;
	}

	public int getDiceValue() {
		return diceValue;
	}

	public void setDiceValue(int diceValue) {
		this.diceValue = diceValue;
	}

}
