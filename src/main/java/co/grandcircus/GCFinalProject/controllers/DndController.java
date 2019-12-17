package co.grandcircus.GCFinalProject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.dndpojos.Monster;
import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;
import co.grandcircus.GCFinalProject.universalMethods.MonsterMash;

@Controller
public class DndController {

	@Autowired
	HttpSession session;
	
	RestTemplate rt = new RestTemplate();
	
	MonsterMash mm = new MonsterMash();
	
	@RequestMapping("encounter")
	public ModelAndView encounter() {
		PlayerCharacter pc = (PlayerCharacter) session.getAttribute("playerCharacter");
		Integer playerLevel = pc.getLevelId();
		ModelAndView mv = new ModelAndView("encounter");
		Monster m = new Monster();
		if (playerLevel != null) {
			m = mm.generateMonsterByLevel(playerLevel);
		} 
		session.setAttribute("monster", m);
		mv.addObject(m);
		return mv;
	}
	
	/*
	@RequestMapping("unit-info")
	public ModelAndView unitInfo() {
		return null;
	}
	 
	@RequestMapping("generate")
	public ModelAndView generateMonster() {
		//Going to pull monsters from the API. API pull will be curated. Not all monsters will be possible. 
		Integer monsterNum = 1;
		String url = "http://dnd5eapi.co/api/monster/" + monsterNum + "/";
		//Monster response = rt.getForObject(url, Monster.class);
		String response = rt.getForObject(url, String.class);
		
		ModelAndView mv = new ModelAndView("index", "monsterCall", response);
		System.out.println(response);
		return mv;
	}

	@RequestMapping("encounter")
	public ModelAndView encounter() {
		// eventually reads from database of encounters by encounterId
		Unit player = (Unit) session.getAttribute("player");
		Unit enemy1 = new Unit(3);
		Unit enemy2 = new Unit(3);
		List<Unit> enemies = new ArrayList<>();
		enemies.add(enemy1);
		enemies.add(enemy2);
		Encounter e = new Encounter(player, enemies);
		session.setAttribute("encounter", e);
		return new ModelAndView("Event");
	}

	@RequestMapping("encounter/fight")
	public ModelAndView fight() {
		ModelAndView view = new ModelAndView("encounter");
		Encounter e = (Encounter) session.getAttribute("encounter");
		System.out.println(e.getPlayer().getHp());
		if (e.getPlayer().getHp() > 0) {
			int playerToHit = Dice.roll(20) + Unit.getModFor(e.getPlayer().getStr());
			view.addObject("playerDieRoll", playerToHit);
			if (playerToHit > e.getEnemies().get(0).getAc()) {
				int playerDmg = Dice.roll(e.getPlayer().getWeapon().getDmg()) + Unit.getModFor(e.getPlayer().getStr());
				e.getEnemies().get(0).setHp(e.getEnemies().get(0).getHp() - playerDmg);
				view.addObject("playerDmg", playerDmg);
			} else {
				view.addObject("playerMissed", "That doesn't hit!");
			}
		} else {
			return new ModelAndView("redirect:/event-end?win=false");
		}
		if (e.getEnemies().get(0).getHp() > 0) {
			int enemyToHit = Dice.roll(20) + Unit.getModFor(e.getEnemies().get(0).getStr());
			view.addObject("enemyDieRoll", enemyToHit);
			if (enemyToHit > e.getPlayer().getAc()) {
				int enemyDmg = Dice.roll(e.getEnemies().get(0).getWeapon().getDmg()) + Unit.getModFor(e.getEnemies().get(0).getStr());
				e.getPlayer().setHp(e.getPlayer().getHp() - enemyDmg);
				view.addObject("enemyDmg", enemyDmg);
			} else {
				view.addObject("enemyMissed", e.getEnemies().get(0).getFirstName() + " doesn't hit!");
			}
		} else {
			return new ModelAndView("redirect:/event-end?win=true");
		}
		session.setAttribute("encounter", e);
		return view;
	}
	
	@RequestMapping("event/walk")
	public ModelAndView walk() {
		return new ModelAndView("redirect:/get-results");
	}
	*/

}
