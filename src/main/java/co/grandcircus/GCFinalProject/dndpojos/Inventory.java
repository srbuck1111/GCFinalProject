package co.grandcircus.GCFinalProject.dndpojos;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Inventory {

	@ManyToOne
	private PlayerCharacter playerCharacter;
	private int equipmentId;
	private int qty;
	
}
