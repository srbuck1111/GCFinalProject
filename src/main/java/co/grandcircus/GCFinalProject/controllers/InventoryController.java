package co.grandcircus.GCFinalProject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Inventory;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;

@Controller
public class InventoryController {

	HttpSession session;
	
	@RequestMapping("inventory-list")
	public ModelAndView viewInventory() {
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		List <Inventory> inventoryList = pc.getInventory();
		return new ModelAndView("InventoryList", "inventoryList", inventoryList);
	}
	
}
