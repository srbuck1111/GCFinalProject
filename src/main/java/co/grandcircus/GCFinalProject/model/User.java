package co.grandcircus.GCFinalProject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy = "user")
	List<PlayerCharacter> playerCharacters;
	private String username;
	private String password;

	public User() {
		super();
	}

	// Use to add
	public User(String name, String password) {
		super();
		this.username = name;
		this.password = password;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public List<PlayerCharacter> getPlayerCharacters() {
		return playerCharacters;
	}

	public void setPlayerCharacters(List<PlayerCharacter> playerCharacters) {
		this.playerCharacters = playerCharacters;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + "]";
	}

}

/*
 * 
 * @Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy = "userId")
	List<Unit> units;
	private String name;
	private double gold;
	private String visited;

	public User() {
		super();
	}

	// Use to edit
	public User(String name, double gold, String visited) {
		super();
		this.name = name;
		this.gold = gold;
		this.visited = visited;

	}

	// Use to add
	public User(Integer id, String name, double gold, String visited) {
		super();
		this.id = id;
		this.name = name;
		this.gold = gold;
		this.visited = visited;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGold() {
		return gold;
	}

	public void setGold(double gold) {
		this.gold = gold;
	}

	public String getVisited() {
		return visited;
	}

	public void setVisited(String visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gold=" + gold + ", visited=" + visited + "]";
	}

}
*/
