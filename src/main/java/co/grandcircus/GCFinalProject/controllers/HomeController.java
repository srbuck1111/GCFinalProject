package co.grandcircus.GCFinalProject.controllers;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Classes;
import co.grandcircus.GCFinalProject.mappojos.Place;
import co.grandcircus.GCFinalProject.model.User;
import co.grandcircus.GCFinalProject.repo.UserRepo;
import co.grandcircus.GCFinalProject.universalMethods.MonsterMash;
import co.grandcircus.GCFinalProject.unuseddndpojos.Unit;

@Controller
public class HomeController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	HttpSession session;
	
	@Value("${map.key}")
	String mapKey;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/unit")
	public ModelAndView newUnit() {
		Integer id = 1;
		User user = userRepo.findById(id).orElse(null);
		Unit gUnit = new Unit(5);
		session.setAttribute("player", gUnit);		
		ModelAndView mv = new ModelAndView("redirect:/get-results");
		mv.addObject("userUser", user);
		return mv;
	}
	
	@RequestMapping("/get-results")
	public ModelAndView placesAPITest() {
		Integer id = 1;
		Double userLat = 42.3359;
		Double userLong = -83.049825;
		//Double userLat;
		//Double userLong;
		
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
		System.out.println(responseString);
		System.out.println(response.getResult().get(0).getName());
		
		
		//MonsterMash test = new MonsterMash();
		//test.generateMonsterByLevel(8);
		
		return mv;
	}
	
	@RequestMapping("save-location")
	public ModelAndView saveLocation(String userLat, String userLng) {
		double parsedLat = Double.parseDouble(userLat);
		double parsedLng = Double.parseDouble(userLng);
		session.setAttribute("userLat", parsedLat);
		session.setAttribute("userLng" ,parsedLng);
		
		ModelAndView mv = new ModelAndView("redirect:/get-results");
		return mv;
	}
	@RequestMapping("/characterSelect")
	public ModelAndView event() {
		Integer id = 1;
		User user = userRepo.findById(id).orElse(null);
		//use user.getCharacterList() to obtain the list of characters for this user
		ModelAndView mv = new ModelAndView("characterSelect");
		return mv;
	}

	
	@RequestMapping("/dnd")
	public ModelAndView dNDAPITest() {
		
		Random rand = new Random(); 
		Integer spellGet = rand.nextInt(100);
		String url = "http://dnd5eapi.co/api/spells/" + spellGet + "/";
		
		String test = rt.getForObject(url, String.class);
		ModelAndView mv = new ModelAndView("dnd", "dndapitest", test);
		System.out.println(test);
		return mv;
	}
	
	@RequestMapping("/dnd-classes")
	public ModelAndView dndClassTest() {
		Random rand = new Random(); 
		Integer classGet = rand.nextInt(12)+1;
		String url = "http://dnd5eapi.co/api/classes/" + classGet + "/";
	
		Classes response = rt.getForObject(url, Classes.class);
		ModelAndView mv = new ModelAndView("dnd", "dndclassapitest", response);
		System.out.println(response);
		return mv;
		
	}
	
	

}
	
