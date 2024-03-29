package co.grandcircus.GCFinalProject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.EncounterInfo;
import co.grandcircus.GCFinalProject.dndpojos.Inventory;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;
import co.grandcircus.GCFinalProject.repo.InventoryRepo;

@Controller
public class VicinityController {
	
	@Autowired
	InventoryRepo ir;
	
	@Autowired
	HttpSession session;

	@RequestMapping("test")
	public ModelAndView test(String userLat, String userLng, String placeLat, String placeLng) {
		double parsedLat = Double.parseDouble(userLat);
		double parsedLng = Double.parseDouble(userLng);
		double parsedPlaceLat = Double.parseDouble(placeLat);
		double parsedPlaceLng = Double.parseDouble(placeLng);
		session.setAttribute("userLat", userLat);
		session.setAttribute("userLng" ,userLng);
		if (theseAreClose(parsedLat, parsedLng, parsedPlaceLat, parsedPlaceLng)) {
			EncounterInfo ei = new EncounterInfo("", 2);
			session.setAttribute("encounterInfo", ei);
			PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
			for (Inventory i : ir.findByPlayerCharacter(pc)) {
				if (i.getEquipmentId() == 129) {
					ei.setPotions(1);
					break;
				}
			}
			session.setAttribute("encounterInfo", ei);
			return new ModelAndView("redirect:/encounter/create");
		}
		return new ModelAndView("redirect:/get-results?error=true");
	}
	
	public boolean theseAreClose(double lat1, double lng1, double lat2, double lng2) {
		System.out.println(distanceBetween(lat1, lng1, lat2, lng2));
		if (distanceBetween(lat1, lng1, lat2, lng2) <= 100/*km*/) {
			return true;
		}
		return false;
	}
	
	public double distanceBetween(double lat1, double lng1, double lat2, double lng2) {

		double p = 0.017453292519943295; // Math.PI / 180
		double a = 0.5 - Math.cos((lat2 - lat1) * p) / 2 + Math.cos(lat1 * p) * Math.cos(lat2 * p)
				* (1 - Math.cos((lng2 - lng1) * p)) / 2;
		return 12742 * Math.asin(Math.sqrt(a)); // 2 * R; R = 6371 km
	}
}
