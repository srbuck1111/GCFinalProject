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
import co.grandcircus.GCFinalProject.repo.UserRepo;

@Controller
public class CharacterController {

	@Autowired
	HttpSession session;

	@Autowired
	CharacterRepo cr;

	@Autowired
	UserRepo ur;

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

	// character creation method that passes to character-select
	@RequestMapping("add-character")
	// public ModelAndView addCharacter(String firstName, String lastName, int
	// classIndex, int str, int con, int dex, int intel, int wis, int cha) {
	public ModelAndView addCharacter(PlayerCharacter pc) {
		User loggedUser = (User) session.getAttribute("loggedUser");
		pc.setAc(15);
		pc.setGold(100);
		pc.setHpMax(50);
		pc.setHp(pc.getHpMax());
		pc.setUser(loggedUser);
		pc.setWeaponId(1);
		pc.setLevelId(1);
		loggedUser.addPlayerCharacter(pc);
		cr.save(pc);
		session.setAttribute("loggedUser", loggedUser);
		return new ModelAndView("redirect:/characterSelect");
	}

}
