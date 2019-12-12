package co.grandcircus.GCFinalProject.controllers;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Unit;
import co.grandcircus.GCFinalProject.mappojos.Place;
import co.grandcircus.GCFinalProject.model.User;
import co.grandcircus.GCFinalProject.repo.UserRepo;

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
		User user = userRepo.findById(id).orElse(null);
		
		Double userLat = 42.3359;
		Double userLong = -83.049825;
		int searchRadius = 200;
		
		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + userLat + "," + userLong + "&radius=" + searchRadius + "&types=park&name=&key=" + mapKey;
		
		Place response = rt.getForObject(url, Place.class);
		ModelAndView mv = new ModelAndView("main", "listOfResults", response);
		mv.addObject("userUser", user);
		System.out.println(response.getResult().get(0).getName());
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
	
	
	

}
	
