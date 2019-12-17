package co.grandcircus.GCFinalProject.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Classes;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;
import co.grandcircus.GCFinalProject.model.User;
import co.grandcircus.GCFinalProject.repo.CharacterRepo;

@Controller
public class CharacterController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CharacterRepo cr;
	
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
	
	//character creation method that passes to character-select
	@RequestMapping("add-character")
	public ModelAndView addCharacter(PlayerCharacter pc) {
		ModelAndView mv = new ModelAndView("characterSelect");
		User loggedUser = (User) session.getAttribute("loggedUser");
		
		cr.save(pc);
		return mv;
	}
	
}
