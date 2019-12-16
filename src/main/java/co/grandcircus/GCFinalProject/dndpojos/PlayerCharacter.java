package co.grandcircus.GCFinalProject.dndpojos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import co.grandcircus.GCFinalProject.model.User;

@Entity
public class PlayerCharacter {

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
	
}
