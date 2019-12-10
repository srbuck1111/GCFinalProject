package co.grandcircus.GCFinalProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {
	/*
	 * int sides = 6; int die1 = (int) (Math.random() * sides) + 1; int die2 = (int)
	 * (Math.random() * sides) + 1;
	 */

	
	
	@RequestMapping("/event-result")
	public ModelAndView diceRoll(Integer die1Sides, Integer die2Sides) {
		Integer die1Roll = (int)(Math.random() * 6) + 1;  //die1Sides
		Integer die2Roll = (int)(Math.random() * 6) + 1; //die2Sides
		Integer dieTotal = die1Roll + die2Roll;
		ModelAndView mv = new ModelAndView("Eventresult", "dieTotal", dieTotal);

		return mv;
	}
	
	
	
	/*
	 * <input type="hidden" id="die1Sides" name="die1Sides" value=""/> <input
	 * type="hidden" id="die2Sides" name="die2Sides" value=""/>
	 */
	
	
	
	
}
