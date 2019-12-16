package co.grandcircus.GCFinalProject.dndpojos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import co.grandcircus.GCFinalProject.model.User;

@Entity
public class PlayerCharacter {

	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer characterId;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy="playerCharacter")
	private List<Inventory> inventory;
	private String firstName;
	private String lastName;
	private int levelId;
	private int classId;
	private int gold;
	private int hpMax;
	private int hp;
	private int ac;
//	private int str;
//	private int dex;
//	private int con;
//	private int intel;
//	private int wis;
//	private int cha;
	
	public PlayerCharacter() {
		super();
	}

	public PlayerCharacter(Integer characterId, User user, List<Inventory> inventory, String firstName, String lastName,
			int levelId, int classId, int gold, int hpMax, int hp, int ac) {
		super();
		this.characterId = characterId;
		this.user = user;
		this.inventory = inventory;
		this.firstName = firstName;
		this.lastName = lastName;
		this.levelId = levelId;
		this.classId = classId;
		this.gold = gold;
		this.hpMax = hpMax;
		this.hp = hp;
		this.ac = ac;
	}

	public Integer getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Integer characterId) {
		this.characterId = characterId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}

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

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
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
	
}
