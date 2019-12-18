package co.grandcircus.GCFinalProject.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Equipment;
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

		List<Inventory> inventory = inventoryRepo.findByPlayerCharacter(pc);
		String url;
		ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
		for (Inventory i : inventory) {
			url = "http://dnd5eapi.co/api/equipment/" + i.getEquipmentId();
			Equipment charEquipment = rt.getForObject(url, Equipment.class);
			equipmentList.add(charEquipment);
		}
		return new ModelAndView("InventoryList", "equipmentList", equipmentList);

	}

	@RequestMapping("equip")
	public ModelAndView equipItem(String eCategory, Integer eId) {
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		if (eCategory.equals("Weapon")) {
			pc.setWeaponId(eId);
			characterRepo.save(pc);
			session.setAttribute("playerCharacter", pc);
			return new ModelAndView("redirect:/inventory-list", "weaponSet", "Weapon Equipped!");
		} else
			return new ModelAndView("redirect:/inventory-list", "weaponSet", "Not Equipped");
	}

}
