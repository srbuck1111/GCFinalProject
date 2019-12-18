package co.grandcircus.GCFinalProject.dndpojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inventoryId;
	@ManyToOne
	private PlayerCharacter playerCharacter;
	private Integer equipmentId;
	private Integer qty;
	
	public Inventory() {
		super();
	}

	
	public Inventory(PlayerCharacter playerCharacter, Integer equipmentId, Integer qty) {
		super();
		this.playerCharacter = playerCharacter;
		this.equipmentId = equipmentId;
		this.qty = qty;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public PlayerCharacter getPlayerCharacter() {
		return playerCharacter;
	}

	public void setPlayerCharacter(PlayerCharacter playerCharacter) {
		this.playerCharacter = playerCharacter;
	}

	public Integer getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", playerCharacter=" + playerCharacter + ", equipmentId="
				+ equipmentId + ", qty=" + qty + "]";
	}


	
	
	
}
