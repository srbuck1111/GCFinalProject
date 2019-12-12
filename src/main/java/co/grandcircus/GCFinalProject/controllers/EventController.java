package co.grandcircus.GCFinalProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.model.User;
import co.grandcircus.GCFinalProject.repo.UserRepo;

@Controller
public class EventController {

	@Autowired
	UserRepo userRepo;

	@RequestMapping("/event")
	public ModelAndView event() {
		ModelAndView mv = new ModelAndView("Event");
		return mv;
	}

	@RequestMapping("/event-result")
	public ModelAndView diceRoll(Integer die1Sides, Integer die2Sides) {
		Integer die1Roll = (int) (Math.random() * 6) + 1; // die1Sides
		// Integer die2Roll = (int) (Math.random() * 6) + 1; // die2Sides
		Integer dieTotal = die1Roll;
		ModelAndView mv = new ModelAndView("Eventresult", "dieTotal", dieTotal);

		return mv;
	}

	@RequestMapping("/fight")
	// public ModelAndView fight(Integer d) {
	public ModelAndView fight() {
		Integer dieRoll = (int) (Math.random() * 20) + 1;
		// Integer dieRoll = Dice.roll(d)

		if (dieRoll >= 10) {
			int id = 1;
			User user = userRepo.findById(id).orElse(null);
			user.setGold(user.getGold() + 10);
			userRepo.save(user);
			ModelAndView mv = new ModelAndView("Eventresult", "fightWin",
					"You rolled a " + dieRoll + "; you killed him and you have " + user.getGold() + " goooooolddddddd");
			return mv;
		} else {
			int id = 1;
			User user = userRepo.findById(id).orElse(null);
			user.setGold(user.getGold() - 5);
			userRepo.save(user);
			ModelAndView mv = new ModelAndView("Eventresult", "fightLose",
					"You rolled a " + dieRoll + "; you're dead, and you have " + user.getGold() + " gooooooldddddd");
			return mv;
		}
	}

	@RequestMapping("/flee")
	public ModelAndView flee() {
		ModelAndView mv = new ModelAndView("main", "flee", "You ran away!");
		return mv;
	}

	@RequestMapping("/friend")
	public ModelAndView friend() {
		Integer dieRoll = (int) (Math.random() * 20) + 1;
		if (dieRoll >= 6 && dieRoll <= 15) {

			ModelAndView mv = new ModelAndView("Eventresult", "friend", "You rolled" + dieRoll + " and Gobs are besties now!");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("Eventresult", "friend", "You rolled" + dieRoll + " Gobs ate you.");
			return mv;
		}
	}

	/*
	 * <input type="hidden" id="die1Sides" name="die1Sides" value=""/> <input
	 * type="hidden" id="die2Sides" name="die2Sides" value=""/>
	 */

}
