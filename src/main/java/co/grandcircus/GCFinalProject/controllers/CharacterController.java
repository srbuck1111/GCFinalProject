package co.grandcircus.GCFinalProject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Classes;

@Controller
public class CharacterController {
	
	RestTemplate rt = new RestTemplate();

	@RequestMapping("new-character")
	public ModelAndView newCharacter() {
		ModelAndView mv = new ModelAndView("character-create");
		String url;
		List<Classes> classes = new ArrayList<>();
		for (int i = 1; i < 12; i++) {
			url = "http://dnd5eapi.co/api/classes/" + i;
			classes.add(rt.getForObject(url, Classes.class));
		}
		mv.addObject("classes", classes);
		return mv;
	}
	
}
