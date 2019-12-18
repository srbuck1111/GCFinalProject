package co.grandcircus.GCFinalProject.dndpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Equipment {

	@JsonProperty("_id")
	private String id;
	private int index;
	private String name;
	@JsonProperty("equipment_category")
	private String equipmentCategory;
	private double weight;
	private String url;
	private Cost cost;
	// private List<Property> properties;

	// Weapon variables
	@JsonProperty("weapon_category")
	private String weaponCategory;
	@JsonProperty("weapon_range")
	private String weaponRange;
	@JsonProperty("category_range")
	private String categoryRange;
	private Damage damage;
	// private Range range;

	// Armor variables
	@JsonProperty("armor_category")
	private String armorCategory;
	@JsonProperty("armor_class")
	private ArmorClass armorClass;
	@JsonProperty("str_minimum")
	private int strMinimum;
	@JsonProperty("stealth_disadvantage")
	private boolean stealthDisadvantage;
	
	//Gear variables
	@JsonProperty("gear_category")
	private String gearCategory;
	private String healDice;
	
	

	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipment(String id, int index, String name, String equipmentCategory, double weight, String url,
			Cost cost, String weaponCategory, String weaponRange, String categoryRange, Damage damage) {
		super();
		this.id = id;
		this.index = index;
		this.name = name;
		this.equipmentCategory = equipmentCategory;
		this.weight = weight;
		this.url = url;
		this.cost = cost;
		this.weaponCategory = weaponCategory;
		this.weaponRange = weaponRange;
		this.categoryRange = categoryRange;
		this.damage = damage;
	}

	public Equipment(String id, int index, String name, String equipmentCategory, double weight, String url,
			Cost cost, String armorCategory, ArmorClass armorClass, int strMinimum, boolean stealthDisadvantage) {
		super();
		this.id = id;
		this.index = index;
		this.name = name;
		this.equipmentCategory = equipmentCategory;
		this.weight = weight;
		this.url = url;
		this.cost = cost;
		this.armorCategory = armorCategory;
		this.armorClass = armorClass;
		this.strMinimum = strMinimum;
		this.stealthDisadvantage = stealthDisadvantage;
	}
	
	

	public Equipment(String id, int index, String name, String equipmentCategory, String gearCategory) {
		super();
		this.healDice= "2d4";
		this.id = id;
		this.index = index;
		this.name = name;
		this.equipmentCategory = equipmentCategory;
		this.gearCategory = gearCategory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEquipmentCategory() {
		return equipmentCategory;
	}

	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

	public String getWeaponCategory() {
		return weaponCategory;
	}

	public void setWeaponCategory(String weaponCategory) {
		this.weaponCategory = weaponCategory;
	}

	public String getWeaponRange() {
		return weaponRange;
	}

	public void setWeaponRange(String weaponRange) {
		this.weaponRange = weaponRange;
	}

	public String getCategoryRange() {
		return categoryRange;
	}

	public void setCategoryRange(String categoryRange) {
		this.categoryRange = categoryRange;
	}

	public Damage getDamage() {
		return damage;
	}

	public void setDamage(Damage damage) {
		this.damage = damage;
	}

	public String getArmorCategory() {
		return armorCategory;
	}

	public void setArmorCategory(String armorCategory) {
		this.armorCategory = armorCategory;
	}

	public ArmorClass getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(ArmorClass armorClass) {
		this.armorClass = armorClass;
	}

	public int getStrMinimum() {
		return strMinimum;
	}

	public void setStrMinimum(int strMinimum) {
		this.strMinimum = strMinimum;
	}

	public boolean isStealthDisadvantage() {
		return stealthDisadvantage;
	}

	public void setStealthDisadvantage(boolean stealthDisadvantage) {
		this.stealthDisadvantage = stealthDisadvantage;
	}

	public String getGearCategory() {
		return gearCategory;
	}

	public void setGearCategory(String gearCategory) {
		this.gearCategory = gearCategory;
	}

	public String getHealDice() {
		return healDice;
	}

	public void setHealDice(String healDice) {
		this.healDice = healDice;
	}

}
