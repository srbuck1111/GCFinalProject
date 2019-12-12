package co.grandcircus.GCFinalProject.dndpojos;

import java.util.List;

public class Encounter {

	Unit player;
	List<Unit> enemies;
	
	public Encounter(Unit player, List<Unit> enemies) {
		super();
		this.player = player;
		this.enemies = enemies;
	}

	public Encounter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Unit getPlayer() {
		return player;
	}

	public void setPlayer(Unit player) {
		this.player = player;
	}

	public List<Unit> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Unit> enemies) {
		this.enemies = enemies;
	}
	
	public void rollInitiative() {
		player.setInitiative(Dice.roll(20) + Unit.getModFor(player.getDex()));
		for (Unit u : enemies) {
			u.setInitiative(Dice.roll(20) + Unit.getModFor(u.getDex()));
		}
	}
	
}
