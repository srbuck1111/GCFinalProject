package co.grandcircus.GCFinalProject.dndpojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.client.RestTemplate;

import co.grandcircus.GCFinalProject.model.User;

@Entity
public class PlayerCharacter implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer characterId;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "playerCharacter", orphanRemoval=true)
	private List<Inventory> inventory;
	private String imageUrl;
	private String firstName;
	private String lastName;
	private int weaponId;
	private int armorId;
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
	private int wins;
	private int losses;
	private int flees;

	public PlayerCharacter() {
		super();
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
		this.wins = 0;
		this.losses = 0;
		this.flees = 0;
		assignImage();
	}
	
	public PlayerCharacter(Integer characterId, User user, List<Inventory> inventory, String imageUrl, String firstName,
			String lastName, int weaponId, int armorId, int levelId, int classId, int gold, int hpMax, int hp, int ac,
			int str, int dex, int con, int intel, int wis, int cha, int wins, int losses, int flees) {
		super();
		this.characterId = characterId;
		this.user = user;
		this.inventory = inventory;
		this.imageUrl = imageUrl;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weaponId = weaponId;
		this.armorId = armorId;
		this.levelId = levelId;
		this.classId = classId;
		this.gold = gold;
		this.hpMax = hpMax;
		this.hp = hp;
		this.ac = ac;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.intel = intel;
		this.wis = wis;
		this.cha = cha;
		this.wins = wins;
		this.losses = losses;
		this.flees = flees;
	}


	public String getImageUrl() {
		if (imageUrl == null) {
			assignImage();
			
		}
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
	
	public void addInventory(Inventory i) {
		this.inventory.add(i);
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

	public int getArmorId() {
		return armorId;
	}

	public void setArmorId(int armorId) {
		this.armorId = armorId;
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

	public void updateHpMax() {
		RestTemplate rt = new RestTemplate();
		String url = "http://www.dnd5eapi.co/api/classes/" + classId;
		Classes clss = rt.getForObject(url, Classes.class);
		this.hpMax = clss.getHitDie() + Dice.roll(clss.getHitDie()) + 2 * getModFor(con);
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

	public void updateAc() {
		RestTemplate rt = new RestTemplate();
		String url = "http://www.dnd5eapi.co/api/equipment/" + armorId;
		Equipment armor = rt.getForObject(url, Equipment.class);
		if (armor.getArmorClass().isDexBonus()) {
			this.ac = armor.getArmorClass().getBase() + getModFor(dex);			
		} else {
			this.ac = armor.getArmorClass().getBase();
		}
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

	public int getWins() {
		return wins;
	}


	public void setWins(int wins) {
		this.wins = wins;
	}


	public int getLosses() {
		return losses;
	}


	public void setLosses(int losses) {
		this.losses = losses;
	}


	public int getFlees() {
		return flees;
	}


	public void setFlees(int flees) {
		this.flees = flees;
	}


	public static int getModFor(int modValue) {
		return (int) Math.floor((modValue / 2) - 5);
	}

	public void assignImage() {	
		
		String image1Barbarian = "http://theclubgaming-dnd.weebly.com/uploads/2/5/8/4/25842993/__________7865239.jpg";
		String image2Bard = "https://i.imgur.com/q3hCNFH.png?1";
		String image3Cleric = "https://i.pinimg.com/474x/f0/61/f0/f061f0fd6e54c0ce039d2a027f49ad7f.jpg";
		String image4Druid = "https://cdn.shopify.com/s/files/1/0149/6074/files/2878a3e23fda623c014101fef9b68f7d_large.jpg?16434614543346989591";
		String image5Fighter = "https://images-na.ssl-images-amazon.com/images/I/91vhxVAAm3L._SY500_.jpg";
		String image6Monk = "https://i.pinimg.com/originals/36/59/2f/36592fd42f169c1a2bf1fffc6e497f04.jpg";
		String image7Paladin = "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_500/https://www.nonfictiongaming.com/wp-content/uploads/2019/03/Paladin-Oath.jpg";
		String image8Ranger = "https://66.media.tumblr.com/f15337277637c931ad7e5c9c317a6ea8/tumblr_pghws3NiQh1xr1wnro1_400.jpg";
		String image9Rogue = "https://artfiles.alphacoders.com/613/thumb-6138.jpg";
		String image10Sorcerer = "https://2static.fjcdn.com/pictures/Character_299e4d_5838805.jpg";
		String image11Warlock = "https://i.pinimg.com/originals/8a/58/a9/8a58a964b2fa14a844ad18c5d5f3056f.jpg";
		String image12Wizard = "https://i.pinimg.com/474x/8f/d0/87/8fd0878d7e43b85da2342a1fbad4af8f.jpg";
		
		if (getClassId()==1) {
			setImageUrl(image1Barbarian);
		}
		if ( getClassId()==2) {
			 setImageUrl(image2Bard);
		}
		if ( getClassId()==3) {
			 setImageUrl(image3Cleric);
		}
		if ( getClassId()==4) {
			 setImageUrl(image4Druid);
		}
		if ( getClassId()==5) {
			 setImageUrl(image5Fighter);
		}
		if ( getClassId()==6) {
			 setImageUrl(image6Monk);
		}
		if ( getClassId()==7) {
			 setImageUrl(image7Paladin);
		}
		if ( getClassId()==8) {
			 setImageUrl(image8Ranger);
		}
		if ( getClassId()==9) {
			 setImageUrl(image9Rogue);
		}
		if ( getClassId()==10) {
			 setImageUrl(image10Sorcerer);
		}
		if ( getClassId()==11) {
			 setImageUrl(image11Warlock);
		}
		if ( getClassId()==12) {
			 setImageUrl(image12Wizard);
		}
		
	}

}
