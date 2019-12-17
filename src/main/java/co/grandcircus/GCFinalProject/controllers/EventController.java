package co.grandcircus.GCFinalProject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Action;
import co.grandcircus.GCFinalProject.dndpojos.Dice;
import co.grandcircus.GCFinalProject.dndpojos.Equipment;
import co.grandcircus.GCFinalProject.dndpojos.Monster;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;
import co.grandcircus.GCFinalProject.repo.UserRepo;

@Controller
public class EventController {

	@Autowired
	UserRepo userRepo;

	@Autowired
	HttpSession session;

	RestTemplate rt = new RestTemplate();

	@RequestMapping("encounter/attack")
	public ModelAndView attack() {
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		Monster m = (Monster) session.getAttribute("monster");
		ModelAndView mv = new ModelAndView("encounter");
		String text = "You roll to hit the " + m.getName() + "!<br/>";
		int toHit = Dice.roll(20) + PlayerCharacter.getModFor(pc.getStr());
		int dmg = 0;
		if (toHit > m.getAc()) {
			Equipment weapon = rt.getForObject("http://dnd5eapi.co/api/equipment/" + pc.getWeaponId(), Equipment.class);
			dmg = 0;
			for (int i = 0; i <= weapon.getDamage().getDiceCount(); i++) {
				dmg += Dice.roll(weapon.getDamage().getDiceValue());
			}
			dmg += PlayerCharacter.getModFor(pc.getStr());
			text += "With a " + toHit + " you are able to deal " + dmg + " damage!";
		} else {
			text += "With a " + toHit + " you are unable to hit the " + m.getName();
		}
		if (m.getHp() < 0) {
			ModelAndView mvEnd = new ModelAndView("encounter-result");
			text = "With a " + toHit + " to hit, dealing " + dmg + ", you slayed the " + m.getName() + "!";
			mvEnd.addObject("win", true);
			return mvEnd;
		}
		mv.addObject("userTurn", false);
		mv.addObject("text", text);
		return mv;
	}

	@RequestMapping("encounter/defend")
	public ModelAndView defend() {
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		Monster m = (Monster) session.getAttribute("monster");
		ModelAndView mv = new ModelAndView("encounter");
		Action a = m.getDamagingAction();
		String text = "The " + m.getName() + " rolls to hit you!<br/>";
		int toHit = Dice.roll(20) + a.getAttackBonus();
		text += "The " + m.getName() + " gets a " + toHit + " to attack you!<br/>";
		int dmg = 0;
		if (toHit > pc.getAc()) {
			dmg = a.getRolledDamage();
			text += "The " + a.getName() + " attack gets through, dealing " + dmg + " damage!";
		} else {
			text += "Not enough to get through your defences!";
		}
		if (pc.getHp() < 0) {
			ModelAndView mvEnd = new ModelAndView("encounter-result");
			text = "With a " + toHit + " to hit, dealing " + dmg + ", the" + m.getName() + " has slayed you.";
			mvEnd.addObject("win", false);
			return mvEnd;
		}
		mv.addObject("userTurn", true);
		mv.addObject("text", text);
		return mv;
	}

	/*
	 * @RequestMapping("/event") public ModelAndView event() { ModelAndView mv = new
	 * ModelAndView("Event"); return mv; }
	 * 
	 * @RequestMapping("/event-result") public ModelAndView diceRoll(Integer
	 * die1Sides, Integer die2Sides) { Integer die1Roll = (int) (Math.random() * 6)
	 * + 1; // die1Sides // Integer die2Roll = (int) (Math.random() * 6) + 1; //
	 * die2Sides Integer dieTotal = die1Roll; ModelAndView mv = new
	 * ModelAndView("Eventresult", "dieTotal", dieTotal);
	 * 
	 * return mv; }
	 * 
	 * @RequestMapping("/fight") // public ModelAndView fight(Integer d) { public
	 * ModelAndView fight() { Integer dieRoll = (int) (Math.random() * 20) + 1; //
	 * Integer dieRoll = Dice.roll(d)
	 * 
	 * if (dieRoll >= 10) { int id = 1; User user =
	 * userRepo.findById(id).orElse(null); user.setGold(user.getGold() + 10);
	 * userRepo.save(user); ModelAndView mv = new ModelAndView("Eventresult",
	 * "fightWin", "You rolled a " + dieRoll + "; you killed him and you have " +
	 * user.getGold() + " goooooolddddddd"); return mv; } else { int id = 1; User
	 * user = userRepo.findById(id).orElse(null); user.setGold(user.getGold() - 5);
	 * userRepo.save(user); ModelAndView mv = new ModelAndView("Eventresult",
	 * "fightLose", "You rolled a " + dieRoll + "; you're dead, and you have " +
	 * user.getGold() + " gooooooldddddd"); return mv; } }
	 * 
	 * @RequestMapping("/flee") public ModelAndView flee() { ModelAndView mv = new
	 * ModelAndView("main", "flee", "You ran away!"); return mv; }
	 * 
	 * @RequestMapping("/friend") public ModelAndView friend() { Integer dieRoll =
	 * (int) (Math.random() * 20) + 1; if (dieRoll >= 6 && dieRoll <= 15) {
	 * 
	 * ModelAndView mv = new ModelAndView("Eventresult", "friend", "You rolled" +
	 * dieRoll + " and Gobs are besties now!"); return mv; } else { ModelAndView mv
	 * = new ModelAndView("Eventresult", "friend", "You rolled" + dieRoll +
	 * " Gobs ate you."); return mv; } }
	 * 
	 * /* <input type="hidden" id="die1Sides" name="die1Sides" value=""/> <input
	 * type="hidden" id="die2Sides" name="die2Sides" value=""/>
	 */

}
