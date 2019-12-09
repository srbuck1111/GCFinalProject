package co.grandcircus.GCFinalProject.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.mappojos.Place;
import co.grandcircus.GCFinalProject.mappojos.Results;

@Controller
public class HomeController {
	
	@Value("${map.key}")
	String mapKey;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/get-results")
	public ModelAndView placesAPITest() {
		HttpHeaders headers = new HttpHeaders();
		
		Double userLat = 42.3359;
		Double userLong = -83.049825;
		
		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + userLat + "," + userLong + "&radius=200&types=park&name=&key=" + mapKey;
		
		Place response = rt.getForObject(url, Place.class);
		ModelAndView mv = new ModelAndView("placestest", "listOfResults", response);
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
	
