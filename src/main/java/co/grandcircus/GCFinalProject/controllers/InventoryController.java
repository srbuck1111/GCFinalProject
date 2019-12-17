package co.grandcircus.GCFinalProject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Inventory;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;
import co.grandcircus.GCFinalProject.repo.InventoryRepo;

@Controller
public class InventoryController {

	@Autowired
	InventoryRepo inventoryRepo;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("inventory-list")
	public ModelAndView viewInventory() {
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		
		
		
		Inventory inventoryList = inventoryRepo.findByPlayerCharacter(pc);		
		//User loggedUser = (User) userRepo.findByUsername(userName);
		
		
		return new ModelAndView("InventoryList", "inventoryList", inventoryList);
	}
	
}
