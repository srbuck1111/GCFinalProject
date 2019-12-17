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
		Integer id = 1;
		Double userLat = 42.3359;
		Double userLong = -83.049825;
		
		User user = userRepo.findById(id).orElse(null);
		
		if (session.getAttribute("userLat") != null) {
			userLat = (Double) session.getAttribute("userLat");
		}
		if (session.getAttribute("userLong") != null) {
			userLong = (Double) session.getAttribute("userLong");
		}
		
		int searchRadius = 250;
		
		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + userLat + "," + userLong + "&radius=" + searchRadius + "&types=park&name=&key=" + mapKey;
		
		Place response = rt.getForObject(url, Place.class);
		String responseString = rt.getForObject(url, String.class);
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
		session.setAttribute("userLat", parsedLat);
		session.setAttribute("userLng" ,parsedLng);
		
		System.out.println(characterId);
		
		cr.findById(characterId);
		PlayerCharacter currentP = cr.findById(characterId).orElse(null);
		
		session.setAttribute("playerCharacter", currentP);
		
		ModelAndView mv = new ModelAndView("redirect:/get-results");
		
		return mv;
	}
	
	@RequestMapping("inventory-list")
	public ModelAndView viewInventory(int characterId) {
		PlayerCharacter pc = new PlayerCharacter();
		
		return new ModelAndView("Inventory");
	}

}
	
