package co.grandcircus.GCFinalProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
