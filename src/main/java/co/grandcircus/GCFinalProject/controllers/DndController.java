package co.grandcircus.GCFinalProject.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Unit;

@Controller
public class DndController {

	@RequestMapping("unit-info")
	public ModelAndView unitInfo() {
		Unit unit = new Unit();
		return new ModelAndView("character-info", "unit", unit);
	}
	
	@RequestMapping("encounter")
	private ModelAndView encounter(Unit player, List<Unit> enemies) {
		ModelAndView view = new ModelAndView("battle");
		view.addObject("enemies", enemies);
		view.addObject("player", player);
		return view;
	}
	
}
