package co.grandcircus.GCFinalProject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Inventory;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;
import co.grandcircus.GCFinalProject.repo.CharacterRepo;
import co.grandcircus.GCFinalProject.repo.InventoryRepo;

@Controller
public class InventoryController {

	@Autowired
	CharacterRepo characterRepo;

	@Autowired
	InventoryRepo inventoryRepo;

	@Autowired
	HttpSession session;

	RestTemplate rt = new RestTemplate();

	@RequestMapping("inventory-list")
	public ModelAndView viewInventory() {
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		// List<Equipment> equipmentList = new ArrayList<>();
		// System.out.println(pc.getInventory());
		/*
		 * for (Inventory i : pc.getInventory()) { String url =
		 * "http://dnd5eapi.co/api/equipment/" + i.getEquipmentId();
		 * equipmentList.add(rt.getForObject(url, Equipment.class)); }
		 */
		List<Inventory> inventory = inventoryRepo.findByPlayerCharacter(pc);

		
		return new ModelAndView("InventoryList", "equipmentList", inventory);
	}

}
