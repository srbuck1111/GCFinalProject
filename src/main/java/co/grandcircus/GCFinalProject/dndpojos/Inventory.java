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

}
