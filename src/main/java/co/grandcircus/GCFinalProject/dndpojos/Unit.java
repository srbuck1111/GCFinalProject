package co.grandcircus.GCFinalProject.dndpojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

//@Entity
public class Unit {
	@Autowired
	HttpSession session;

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@ManyToOne
	private Integer userId;
	private String firstName;
	private String lastName;
	private int str;
	private int dex;
	private int con;
	private int intel;
	private int wis;
	private int cha;
	private int maxHp;
	private int hp;
	private int ac;
	private int initiative;
	private Weapon weapon;
	private UnitClass unitClass;

	static List<Weapon> weapons = new ArrayList<>();
	static {
		weapons.add(new Weapon("club", 4, false, false));
		weapons.add(new Weapon("dagger", 4, false, false));
		weapons.add(new Weapon("greatclub", 8, false, false));
		weapons.add(new Weapon("handaxe", 6, false, false));
		weapons.add(new Weapon("javelin", 6, false, false));
		weapons.add(new Weapon("light hammer", 4, false, false));
		weapons.add(new Weapon("mace", 6, false, false));
		weapons.add(new Weapon("quarterstaff", 6, false, false));
		weapons.add(new Weapon("sickle", 4, false, false));
		weapons.add(new Weapon("spear", 6, false, false));
		weapons.add(new Weapon("light crossbow", 8, false, true));
		weapons.add(new Weapon("dart", 4, false, true));
		weapons.add(new Weapon("shortbow", 6, false, true));
		weapons.add(new Weapon("sling", 4, false, true));
		weapons.add(new Weapon("battleaxe", 8, true, false));
		weapons.add(new Weapon("flail", 8, true, false));
		weapons.add(new Weapon("glaive", 10, true, false));
		weapons.add(new Weapon("greataxe", 12, true, false));
		weapons.add(new Weapon("greatsword", 6, 2, true, false));
		weapons.add(new Weapon("halberd", 10, true, false));
		weapons.add(new Weapon("lance", 12, true, false));
		weapons.add(new Weapon("longsword", 8, true, false));
		weapons.add(new Weapon("maul", 6, 2, true, false));
		weapons.add(new Weapon("morningstar", 8, true, false));
		weapons.add(new Weapon("pike", 10, true, false));
		weapons.add(new Weapon("rapier", 8, true, false));
		weapons.add(new Weapon("scimitar", 6, true, false));
		weapons.add(new Weapon("shortsword", 6, true, false));
		weapons.add(new Weapon("trident", 6, true, false));
		weapons.add(new Weapon("war pick", 8, true, false));
		weapons.add(new Weapon("warhammer", 8, true, false));
		weapons.add(new Weapon("whip", 4, true, false));
		weapons.add(new Weapon("blowgun", 1, true, true));
		weapons.add(new Weapon("crossbow", 6, true, true));
		weapons.add(new Weapon("heavy crossbow", 10, true, true));
		weapons.add(new Weapon("longbow", 8, true, true));
		weapons.add(new Weapon("fist", 4, false, false));

	}

	static List<UnitClass> unitClasses = new ArrayList<>();
	static {
		unitClasses.add(new UnitClass("Fighter", true, 0));
		unitClasses.add(new UnitClass("Barbarian", true, 0));
		unitClasses.add(new UnitClass("Wizard", false, 8));
		unitClasses.add(new UnitClass("Cleric", false, 5));
		unitClasses.add(new UnitClass("Paladin", true, 3));
		unitClasses.add(new UnitClass("Ranger", true, 2));
		unitClasses.add(new UnitClass("Rogue", false, 0));
		unitClasses.add(new UnitClass("Sorcerer", false, 7));
		unitClasses.add(new UnitClass("Warlock", false, 6));
		unitClasses.add(new UnitClass("Druid", false, 4));
		unitClasses.add(new UnitClass("Monk", false, 0));
		unitClasses.add(new UnitClass("Bard", false, 1));
	}

	static int[][] weaponChoice = { { 14, 16, 18, 21, 22 }, { 3, 6, 14, 17, 18, 22, 30 }, { 1, 6 }, { 0, 1, 6, 23 },
			{ 13, 14, 16, 17, 18, 20, 21, 28 }, { 10, 12, 33, 34, 35 }, { 1, 12, 25 }, { 1, 6, 23 }, { 1, 6, 23, 27 },
			{ 0, 2, 7, 8 }, { 36 }, { 12, 25, 27, 35 } };

	static int[] hitDie = { 10, 12, 8, 8, 10, 8, 8, 8, 8, 10, 10, 8 };

	static String[] firstNames = { "Arthur", "Andrew", "Arnold", "Amber", "Boran", "Barthan", "Bangar", "Charles",
			"Chris", "Dover", "Dendro", "Doran", "Dom", "Efretti", "Eigra", "Erin", "Fargo", "Ferdinand", "Fife",
			"Gerard", "Gary", "Graig", "Heldon", "Harvey", "Ingres", "Jerald", "James", "Jake", "Kyle", "Karvo",
			"Kevin", "Larry", "Lodon", "Mary", "Mark", "Miles", "Null", "Norman", "Opal", "Orgran", "Paul", "Petra",
			"Peter", "Q.", "Quarzon", "Renald", "Rakkmire", "Senter", "Sister", "Tenser", "Toldrin", "Terrance",
			"Ungol", "Vordon", "Whamshire", "Xol", "Yolmir", "Zax" };
	static String[] lastNames = { "Andrin", "Bartholemuel", "Consentus", "Davien", "Entri", "FarLander", "GodBorn",
			"Highfel", "Ingles", "Juston", "Kepton", "Lundo", "Martyr", "Nile", "Oprajion", "Parson", "Quartin",
			"Ribin", "SeaFarer", "Tugon", "Ungrth", "Vulcan", "Wonson", "Xartex", "Yobur", "Zevron" };

	// Constructors
	public Unit(int level) {
		this.ac = 10;
		this.str = 10;
		this.dex = 10;
		this.con = 10;
		this.intel = 10;
		this.wis = 10;
		this.cha = 10;
		this.initiative = 0;
		assignClass();
		assignWeapon();
		assignName();
		assignMaxHp(level);
		this.hp = this.maxHp;
	}

	public Unit(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.str = 10;
		this.dex = 10;
		this.con = 10;
		this.intel = 10;
		this.wis = 10;
		this.cha = 10;
		this.initiative = 0;
	}

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public int getIntel() {
		return intel;
	}

	public void setIntel(int intel) {
		this.intel = intel;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getCha() {
		return cha;
	}

	public void setCha(int cha) {
		this.cha = cha;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public UnitClass getUnitClass() {
		return unitClass;
	}

	public void setUnitClass(UnitClass unitClass) {
		this.unitClass = unitClass;
	}
	
	//method start

	public Unit hit(Unit target, int toHit) {
		if (toHit > target.getAc()) {
			this.dealWeaponDamageTo(target);
		}
		return target;
	}

	public Unit dealWeaponDamageTo(Unit target) {
		target.setHp(target.getHp() - this.weapon.getDmg());
		return target;
	}

	public void assignClass() {
		int rand = Dice.roll(100);
		if (rand <= 3) {
			unitClass = unitClasses.get(11);
		} else if (rand <= 6) {
			unitClass = unitClasses.get(10);
		} else if (rand <= 10) {
			unitClass = unitClasses.get(9);
		} else if (rand <= 15) {
			unitClass = unitClasses.get(8);
		} else if (rand <= 20) {
			unitClass = unitClasses.get(7);
		} else if (rand <= 25) {
			unitClass = unitClasses.get(6);
		} else if (rand <= 30) {
			unitClass = unitClasses.get(5);
		} else if (rand <= 40) {
			unitClass = unitClasses.get(4);
		} else if (rand <= 50) {
			unitClass = unitClasses.get(3);
		} else if (rand <= 60) {
			unitClass = unitClasses.get(2);
		} else if (rand <= 80) {
			unitClass = unitClasses.get(1);
		} else if (rand <= 100) {
			unitClass = unitClasses.get(0);
		}
	}

	public void assignWeapon() {
		weapon = weapons.get(weaponChoice[unitClasses.indexOf(unitClass)][Dice
				.roll(weaponChoice[unitClasses.indexOf(unitClass)].length) - 1]);
	}

	public void assignName() {
		firstName = firstNames[(Dice.roll(firstNames.length) - 1)];
		lastName = lastNames[(Dice.roll(lastNames.length) - 1)];
	}

	public void assignMaxHp(int level) {
		int hitDice = hitDie[unitClasses.indexOf(unitClass)];
		for (int i = 0; i < level; i++) {
			int hpIncrease = Dice.roll(hitDice);
			if (hpIncrease > ((hitDice / 2) + 1)) {
				maxHp += hpIncrease; 
			} else {
				maxHp += ((hitDice / 2) + 1);
			}
		}
	}
	
	public static int getModFor(int modValue) {
		return (int) Math.floor((modValue / 2) - 5);
	}

	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "<br> Class: " + unitClass.getClassName() + "<br> Weapon: "
				+ weapon.getName() + "<br> HP: " + hp + " <br> AC:" + ac;
	}
}