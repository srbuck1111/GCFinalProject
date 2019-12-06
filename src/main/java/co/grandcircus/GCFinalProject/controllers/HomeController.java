package co.grandcircus.GCFinalProject.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Value("${map.key}")
	String mapKey;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/")
	public ModelAndView home() {
		HttpHeaders headers = new HttpHeaders();
		String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=food&name=harbour&key=" + mapKey;
		
		String test = rt.getForObject(url, String.class);
		ModelAndView mv = new ModelAndView("index", "apitest", url);
		System.out.println(test);
		return mv;
	}
	
	
	

}
	
