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

	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
	}
	
	// Use to add
	public User(String name, String password) {
		super();
		this.username = name;
		this.password = password;
	}

	public User(Integer id, List<PlayerCharacter> playerCharacters, String username, String password) {
		super();
		this.id = id;
		this.playerCharacters = playerCharacters;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<PlayerCharacter> getPlayerCharacters() {
		return playerCharacters;
	}

	public void setPlayerCharacters(List<PlayerCharacter> playerCharacters) {
		this.playerCharacters = playerCharacters;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}

