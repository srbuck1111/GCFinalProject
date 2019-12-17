package co.grandcircus.GCFinalProject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

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
	
	@Value("${map.key}")
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
			//userLat = 42.3359;			
			//userLng = -83.049825;
		}
		
		int searchRadius = 250;
		
		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + userLat + "," + userLng + "&radius=" + searchRadius + "&types=park&name=&key=" + mapKey;
		
		Place response = rt.getForObject(url, Place.class);
		
		//String responseString = rt.getForObject(url, String.class);

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
	
	@RequestMapping("/characterSelect")
	public ModelAndView charSelectPage() {
		
		User user = (User) session.getAttribute("loggedUser");
		List<PlayerCharacter> userList = user.getPlayerCharacters();
		ModelAndView mv = new ModelAndView("characterSelect", "displayCharacters", userList);
		return mv;
	}

	@RequestMapping("/character-select")
	public ModelAndView characterSelect(int characterId, String userLat, String userLng) {
		double parsedLat = Double.parseDouble(userLat);
		double parsedLng = Double.parseDouble(userLng);
		Location userLocation = new Location(parsedLat, parsedLng);
		session.setAttribute("userLocation", userLocation);
		
		System.out.println(characterId);
		
		cr.findById(characterId);
		PlayerCharacter currentP = cr.findById(characterId).orElse(null);
		
		session.setAttribute("playerCharacter", currentP);
		
		ModelAndView mv = new ModelAndView("redirect:/get-results");
		
		return mv;
	}
	
	

}
	
