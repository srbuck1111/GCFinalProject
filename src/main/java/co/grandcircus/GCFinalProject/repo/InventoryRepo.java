package co.grandcircus.GCFinalProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.GCFinalProject.dndpojos.Inventory;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

	List<Inventory> findByPlayerCharacter(PlayerCharacter playerCharacter);

}
