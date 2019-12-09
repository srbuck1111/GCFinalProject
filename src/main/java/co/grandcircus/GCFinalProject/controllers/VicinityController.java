package co.grandcircus.GCFinalProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VicinityController {

	@RequestMapping("test")
	public ModelAndView test(String userLat, String userLng) {
		return new ModelAndView("test", "test", userLat + userLng + "");
	}
	
}
