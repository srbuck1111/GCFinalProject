package co.grandcircus.GCFinalProject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Action;
import co.grandcircus.GCFinalProject.dndpojos.Dice;
import co.grandcircus.GCFinalProject.dndpojos.EncounterInfo;
import co.grandcircus.GCFinalProject.dndpojos.Equipment;
import co.grandcircus.GCFinalProject.dndpojos.Inventory;
import co.grandcircus.GCFinalProject.dndpojos.Monster;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;
import co.grandcircus.GCFinalProject.repo.CharacterRepo;
import co.grandcircus.GCFinalProject.repo.InventoryRepo;
import co.grandcircus.GCFinalProject.repo.UserRepo;

@Controller
public class EventController {

	@Autowired
	InventoryRepo ir;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CharacterRepo cr;

	@Autowired
	HttpSession session;

	RestTemplate rt = new RestTemplate();

	@RequestMapping("encounter")
	public ModelAndView continueEncounter() {
		return new ModelAndView("encounter");
	}
	
	@RequestMapping("encounter/drink-potion")
	public ModelAndView drinkPotion() {
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		List<Inventory> inventory = ir.findByPlayerCharacter(pc);
		for (Inventory i : inventory) {
			if (i.getEquipmentId() == 129) {
				ir.delete(i);
				break;
			}
		}
		String text = "You drink a health potion!<br/>";
		int healValue = 0;
		for (int i = 0; i < 2; i++) {
			healValue += Dice.roll(4) + 1;
		}
		text += "It heals you for " + healValue + " hp!";
		EncounterInfo ei = new EncounterInfo(text, 1);
		for (Inventory i : ir.findByPlayerCharacter(pc)) {
			if (i.getEquipmentId() == 129) {
				ei.setPotions(1);
				break;
			}
		}
		session.setAttribute("encounterInfo", ei);
		return new ModelAndView("redirect:/encounter");
	}
	
	@RequestMapping("encounter/attack")
	public ModelAndView attack() {
		
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		Monster m = (Monster) session.getAttribute("monster");
		
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
			m.setHp(m.getHp() - dmg);
		} else {
			text += "With a " + toHit + " you are unable to hit the " + m.getName();
		}
		
		if (m.getHp() <= 0) {
			ModelAndView mvEnd = new ModelAndView("encounter-result");
			pc.setWins(pc.getWins() + 1);
			cr.save(pc);
			text = "With a " + toHit + " to hit, dealing " + dmg + ", you slayed the " + m.getName() + "!";
			mvEnd.addObject("win", true);
			
			//!LOOT GOES HERE!//
			
			int lootId = m.getLootTable().get(Dice.roll(5) - 1);
			Equipment loot = rt.getForObject("http://dnd5eapi.co/api/equipment/" + lootId, Equipment.class);
			mvEnd.addObject("loot", loot);
			ir.save(new Inventory(pc, lootId, 1));
			pc.setGold(pc.getGold() + 50 + PlayerCharacter.getModFor(pc.getWis()));
			
			//!LOOT GOES HERE!//
			
			return mvEnd;
		}
		
		EncounterInfo ei = new EncounterInfo(text, 0);
		session.setAttribute("monster", m);
		session.setAttribute("encounterInfo", ei);
		return new ModelAndView("redirect:/encounter");
	}

	@RequestMapping("encounter/defend")
	public ModelAndView defend() {
		
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		Monster m = (Monster) session.getAttribute("monster");
		
		Action a = m.getDamagingAction();
		String text = "The " + m.getName() + " rolls to hit you!<br/>";
		int dmg = 0;
		
		int toHit = Dice.roll(20) + a.getAttackBonus();
		text += "The " + m.getName() + " gets a " + toHit + " to attack you!<br/>";
		
		if (toHit > pc.getAc()) {
			dmg = a.getRolledDamage();
			text += "The " + a.getName() + " attack gets through, dealing " + dmg + " damage!";
			pc.setHp(pc.getHp() - dmg);
		} else {
			text += "Not enough to get through your defences!";
		}
		
		if (pc.getHp() <= 0) {
			pc.setHp(pc.getHpMax());
			pc.setLosses(pc.getLosses() + 1);
			cr.save(pc);
			ModelAndView mvEnd = new ModelAndView("encounter-result");
			text = "With a " + toHit + " to hit, dealing " + dmg + ", the" + m.getName() + " has slayed you.";
			mvEnd.addObject("resultText", text);
			mvEnd.addObject("win", false);
	
			//!LOSSES GO HERE!//
			
			//!LOSSES GO HERE!//
			
			return mvEnd;
		}
		
		cr.save(pc);
		session.setAttribute("playerCharacter", pc);
		EncounterInfo ei = new EncounterInfo(text, 2);
		session.setAttribute("encounterInfo", ei);
		
		return new ModelAndView("redirect:/encounter");
	}
	
	@RequestMapping("encounter/flee")
	public ModelAndView flee() {
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		pc.setFlees(pc.getFlees() + 1);
		cr.save(pc);
		return new ModelAndView("redirect:/get-results");
	}

}
