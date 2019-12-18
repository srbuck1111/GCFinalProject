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
import co.grandcircus.GCFinalProject.mappojos.Location;
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
		
		PlayerCharacter currentP = cr.findById(characterId).orElse(null);
		
		session.setAttribute("playerCharacter", currentP);
		
		ModelAndView mv = new ModelAndView("redirect:/get-results");
		
		return mv;
	}
	
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

	@RequestMapping("add-character")
	public ModelAndView addCharacter(PlayerCharacter pc) {
		User loggedUser = (User) session.getAttribute("loggedUser");
		pc.setArmorId(39);
		pc.updateAc();
		pc.setGold(100);
		pc.updateHpMax();
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
