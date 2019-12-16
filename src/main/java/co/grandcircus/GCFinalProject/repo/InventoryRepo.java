package co.grandcircus.GCFinalProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.GCFinalProject.dndpojos.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

}
