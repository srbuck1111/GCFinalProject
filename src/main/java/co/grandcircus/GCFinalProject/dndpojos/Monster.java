package co.grandcircus.GCFinalProject.dndpojos;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Monster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer index;
	private String name;
	private String size;
	private String type;
	private String alignment;

	@JsonProperty("armor_class")
	private Integer ac;

	@JsonProperty("hit_points")
	private Integer hp;

	@JsonProperty("hit_dice")
	private String hitDice;

	private Integer strength;
	private Integer dexterity;
	private Integer constitution;
	private Integer intelligence;
	private Integer wisdom;
	private Integer charisma;
	private String imageUrl;

	@JsonProperty("damage_vulnerabilities")
	private String damageVulnerabilities;

	@JsonProperty("damage_resistances")
	private String damageResistances;

	@JsonProperty("damage_immunities")
	private String damageImmunities;

	@JsonProperty("challenge_rating")
	private Integer challengeRating;
	
	private List<Action> actions;
	
	private List<Integer> lootTable;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public Integer getAc() {
		return ac;
	}

	public void setAc(Integer ac) {
		this.ac = ac;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public String getHitDice() {
		return hitDice;
	}

	public void setHitDice(String hitDice) {
		this.hitDice = hitDice;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDamageVulnerabilities() {
		return damageVulnerabilities;
	}

	public void setDamageVulnerabilities(String damageVulnerabilities) {
		this.damageVulnerabilities = damageVulnerabilities;
	}

	public String getDamageResistances() {
		return damageResistances;
	}

	public void setDamageResistances(String damageResistances) {
		this.damageResistances = damageResistances;
	}

	public String getDamageImmunities() {
		return damageImmunities;
	}

	public void setDamageImmunities(String damageImmunities) {
		this.damageImmunities = damageImmunities;
	}

	public Integer getChallengeRating() {
		return challengeRating;
	}

	public void setChallengeRating(Integer challengeRating) {
		this.challengeRating = challengeRating;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Integer> getLootTable() {
		return lootTable;
	}

	public void setLootTable(List<Integer> lootTable) {
		this.lootTable = lootTable;
	}

	public Monster(Integer index, String name, String size, String type, String alignment, Integer ac, Integer hp,
			String hitDice, Integer strength, Integer dexterity, Integer constitution, Integer intelligence,
			Integer wisdom, Integer charisma, String damageVulnerabilities, String damageResistances,
			String damageImmunities, Integer challengeRating, List<Action> actions) {
		super();
		this.index = index;
		this.name = name;
		this.size = size;
		this.type = type;
		this.alignment = alignment;
		this.ac = ac;
		this.hp = hp;
		this.hitDice = hitDice;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.damageVulnerabilities = damageVulnerabilities;
		this.damageResistances = damageResistances;
		this.damageImmunities = damageImmunities;
		this.challengeRating = challengeRating;
		this.actions = actions;
	}

	public Monster() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Monster [index=" + index + ", name=" + name + ", size=" + size + ", type=" + type + ", alignment="
				+ alignment + ", ac=" + ac + ", hp=" + hp + ", hitDice=" + hitDice + ", strength=" + strength
				+ ", dexterity=" + dexterity + ", constitution=" + constitution + ", intelligence=" + intelligence
				+ ", wisdom=" + wisdom + ", charisma=" + charisma + ", damageVulnerabilities=" + damageVulnerabilities
				+ ", damageResistances=" + damageResistances + ", damageImmunities=" + damageImmunities
				+ ", challengeRating=" + challengeRating + "]";
	}
	
	public Action getDamagingAction() {
		for (Action a : actions) {
			if (a.getDamageDice() != null) {
				return a;
			}
		}
		return null;
	}

}
