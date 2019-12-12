package co.grandcircus.GCFinalProject.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Encounter;
import co.grandcircus.GCFinalProject.dndpojos.Unit;

@Controller
public class DndController {
	
	@Autowired
	HttpSession session;

	@RequestMapping("unit-info")
	public ModelAndView unitInfo() {
		Unit unit = new Unit();
		return new ModelAndView("character-info", "unit", unit);
	}
	
	
	@RequestMapping("encounter")
	public ModelAndView encounter() {
		ModelAndView view = new ModelAndView("test");
		//eventually reads from database of encounters by encounterId
		Unit player = new Unit();
		Unit enemy1 = new Unit();
		Unit enemy2 = new Unit();
		List<Unit> enemies = new ArrayList<>();
		enemies.add(enemy1);
		enemies.add(enemy2);
		Encounter e = new Encounter(player, enemies);
		e.rollInitiative();
		session.setAttribute("encounter", e);
		session.setAttribute("test2", "test value 2");
		return view;
	}
	
	@RequestMapping("encounter/fight")
	public ModelAndView fight(Encounter encounter) {
		return null;
	}
	
	public ModelAndView playerChoice(Encounter encounter) {
		return null;
	}
	
}
