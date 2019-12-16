package co.grandcircus.GCFinalProject.dndpojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryId;
	@ManyToOne
	private PlayerCharacter playerCharacter;
	private int equipmentId;
	private int qty;
	
	public Inventory() {
		super();
	}

	public Inventory(int inventoryId, PlayerCharacter playerCharacter, int equipmentId, int qty) {
		super();
		this.inventoryId = inventoryId;
		this.playerCharacter = playerCharacter;
		this.equipmentId = equipmentId;
		this.qty = qty;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public PlayerCharacter getPlayerCharacter() {
		return playerCharacter;
	}

	public void setPlayerCharacter(PlayerCharacter playerCharacter) {
		this.playerCharacter = playerCharacter;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
