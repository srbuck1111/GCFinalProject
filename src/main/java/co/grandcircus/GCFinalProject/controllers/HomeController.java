package co.grandcircus.GCFinalProject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Equipment;
import co.grandcircus.GCFinalProject.dndpojos.Inventory;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;
import co.grandcircus.GCFinalProject.mappojos.Location;
import co.grandcircus.GCFinalProject.mappojos.Place;
import co.grandcircus.GCFinalProject.model.User;
import co.grandcircus.GCFinalProject.repo.CharacterRepo;
import co.grandcircus.GCFinalProject.repo.InventoryRepo;
import co.grandcircus.GCFinalProject.repo.UserRepo;

@Controller
public class HomeController {
	
	@Autowired
	InventoryRepo inventoryRepo;
	
	@Autowired
	CharacterRepo cr;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	HttpSession session;
	
	@Value("${map.key}") //Google Places API key
	String mapKey;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/get-results")
	public ModelAndView placesAPITest() {
		Double userLat = 0.0;
		Double userLng = 0.0;
		User user = (User) session.getAttribute("loggedUser");
		Location userLocation = (Location) session.getAttribute("userLocation");
		
		if (userLocation != null) {
			userLat = userLocation.getLat();
			userLng = userLocation.getLng();
		} else {
			//userLat = 42.3359; test coords for Grand Circus		
			//userLng = -83.049825;
		}
		//Below coords are for central park in NY
		userLat = 38.8976763;
		userLng = -77.0365298;
		
		int searchRadius = 250; //in meters
		
		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + userLat + "," + userLng + "&radius=" + searchRadius + "&types=park&name=&key=" + mapKey;
		
		Place response = rt.getForObject(url, Place.class);
		
		//String responseString = rt.getForObject(url, String.class);
		
		//Place curatedResponseList = new Place();
		
		for (int i = 0; i < response.getResult().size()-1; i++) {
			if (theseAreClose(response.getResult().get(i).getGeometry().getLocation().getLat(), response.getResult().get(i).getGeometry().getLocation().getLng(), response.getResult().get(i+1).getGeometry().getLocation().getLat(), response.getResult().get(i+1).getGeometry().getLocation().getLng()  ))
					response.getResult().remove(i+1); //Checks if the next item on the list is close to the current item. If so, removes second item from the list
		}


		ModelAndView mv = new ModelAndView("main", "listOfResults", response);
		mv.addObject("userUser", user);
		
		/*
		System.out.println(responseString);
		System.out.println(response.getResult().get(0).getName());
		
		MonsterMash test = new MonsterMash();
		test.generateMonsterByLevel(8);
		*/
		
		return mv;
	}
	
	@RequestMapping("/buy-potion")
	public ModelAndView addPotion() {
		
		//User user = (User) session.getAttribute("loggedUser");
		PlayerCharacter currentP = (PlayerCharacter) session.getAttribute("playerCharacter");
		currentP.getGold();
		if (currentP.getGold() > (30 - currentP.getCha())) {
			currentP.setGold(currentP.getGold() - (30 - currentP.getCha()));
			//List<Inventory> playerInv = currentP.getInventory();
			//String potionURL = "http://www.dnd5eapi.co/api/equipment/129";
			Inventory potion = new Inventory(currentP, 129, 1);
			//Equipment potion = rt.getForObject(potionURL, Equipment.class);
			//currentP.setInventory(currentP.getInventory().add(potion));
			//currentP.addInventory(potion);
			inventoryRepo.save(potion);
			System.out.println("got here!");
			cr.save(currentP);
			session.setAttribute("playerCharacter", currentP);
			ModelAndView mv = new ModelAndView("redirect:/get-results");
			return mv;
			//redirect to get-results
		} else {
			ModelAndView mv = new ModelAndView("redirect:/get-results");
			return mv;
		}
		
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
	
