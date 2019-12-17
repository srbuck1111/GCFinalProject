package co.grandcircus.GCFinalProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.GCFinalProject.dndpojos.Inventory;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

	
	Inventory findByPlayerCharacter(PlayerCharacter playerCharacter);
	
}
