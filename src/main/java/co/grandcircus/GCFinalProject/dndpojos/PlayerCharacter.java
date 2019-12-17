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
	@OneToMany(mappedBy = "playerCharacter")
	private List<Inventory> inventory;
	private String imageUrl;
	private String firstName;
	private String lastName;
	private int weaponId;
	private int levelId;
	private int classId;
	private int gold;
	private int hpMax;
	private int hp;
	private int ac;
	private int str;	
	private int dex;
	private int con;
	
	private int intel;
	private int wis;
	private int cha;

	public PlayerCharacter() {
		super();
	}

	public PlayerCharacter(Integer characterId, User user, List<Inventory> inventory, String firstName, String lastName,
			int weaponId, int levelId, int classId, int gold, int hpMax, int hp, int ac, int str, int dex, int con) {
		super();
		this.characterId = characterId;
		this.user = user;
		this.inventory = inventory;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weaponId = weaponId;
		this.levelId = levelId;
		this.classId = classId;
		this.gold = gold;
		this.hpMax = hpMax;
		this.hp = hp;
		this.ac = ac;
		this.str = str;
		this.dex = dex;
		this.con = con;
	}
	
	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
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
	
	public static int getModFor(int modValue) {
		return (int) Math.floor((modValue / 2) - 5);
	}
	
	
	public PlayerCharacter(String firstName, String lastName, int classId, int str, int dex, int con, int intel,
			int wis, int cha) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.classId = classId;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.intel = intel;
		this.wis = wis;
		this.cha = cha;
	}

	public void ImageUrl(PlayerCharacter playChar) {
		
		playChar.setImageUrl(playChar.getClassId());
		
		String image1Barbarian = "https://i.pinimg.com/originals/79/e8/e7/79e8e7927401d5e3d18a40e3d92fbf5a.jpg";
		String image2Bard = "https://i.pinimg.com/originals/b7/67/06/b76706585d4902f560e0a7c475011581.jpg";
		String image3Cleric = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/ebd4f388-fdcd-4303-86da-31396215c27a/d73s117-ff32a473-9bc9-4476-9a27-553034047925.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2ViZDRmMzg4LWZkY2QtNDMwMy04NmRhLTMxMzk2MjE1YzI3YVwvZDczczExNy1mZjMyYTQ3My05YmM5LTQ0NzYtOWEyNy01NTMwMzQwNDc5MjUuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.v8Moou75IVWe4xwQ867TtW9tHEKug6GM1vCe71OEdV8";
		String image4Druid = "https://cdn.inprnt.com/thumbs/2b/c6/2bc66e5566d1a9cec38ed09b2972829a.jpg?response-cache-control=max-age=2628000";
		String image5Fighter = "https://i.pinimg.com/originals/ab/c5/5e/abc55e9762ab0ff3c74e9535f173f20e.jpg";
		String image6Monk = "https://i.pinimg.com/originals/36/59/2f/36592fd42f169c1a2bf1fffc6e497f04.jpg";
		String image7Paladin = "https://i.pinimg.com/originals/5f/b9/b5/5fb9b5ba8efb5131ba7e17b15127fcdc.jpg";
		String image8Ranger = "https://i.pinimg.com/736x/c1/ca/1a/c1ca1a34ff6d691379a50d6cf92461ff.jpg";
		String image9Rogue = "https://qph.fs.quoracdn.net/main-qimg-6b0073cd73a77f8ea5527212e93259b6";
		String image10Sorcerer = "https://art.ngfiles.com/images/728000/728595_tyrellesmithart_dnd-star-sorcerer-commission.jpg?f1544651079";
		String image11Warlock = "https://i.pinimg.com/originals/8a/58/a9/8a58a964b2fa14a844ad18c5d5f3056f.jpg";
		String image12Wizard = "https://gamemakerstuff.files.wordpress.com/2014/12/moiraine-damodred-by-westling.jpg";
		
		
	}

}
