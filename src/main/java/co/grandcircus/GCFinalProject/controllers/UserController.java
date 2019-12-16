package co.grandcircus.GCFinalProject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.model.User;
import co.grandcircus.GCFinalProject.repo.UserRepo;
import co.grandcircus.GCFinalProject.unuseddndpojos.Encounter;


@Controller
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/event-end")
	public ModelAndView addGold(boolean win) {
		Encounter e = (Encounter) session.getAttribute("encounter");
		Integer id = 1;
		User user = userRepo.findById(id).orElse(null);
		ModelAndView mv = new ModelAndView("Eventresult");
		String combatResultMessage;
		String lootChange;
		String combatResultImage;
		String enemyFName = e.getEnemies().get(0).getFirstName();
		String enemyLName = e.getEnemies().get(0).getLastName();
		Integer enemyHP = e.getEnemies().get(0).getHp();
		String enemyWeapon = e.getEnemies().get(0).getWeapon().getName();
		String enemyFullName = enemyFName + " " + enemyLName;
		String health = e.getPlayer().getHp() + " / " + e.getPlayer().getMaxHp();
		
		if (win) {
		user.setGold(user.getGold() + 10);
		userRepo.save(user);
		combatResultMessage = "Congratulations! You have brutally murdered " + enemyFullName + "! You  now have " + health + " HP";
		lootChange = "+ 10 Gold! Don't spend it all in one place!";
		combatResultImage = "https://us.123rf.com/450wm/jagcz/jagcz1703/jagcz170300036/73559722-champion-golden-trophy-isolated-on-black-background-concept-of-success-and-achievement-.jpg?ver=6";
		}
		
		else {
			
		mv.addObject(user.getGold() - 10);
		userRepo.save(user);
		combatResultMessage = "You have been shamefully defeated in combat by " + enemyFullName + " and their trusty " + enemyWeapon + ". And " + enemyFName + " only had " + enemyHP + " health remaining. Shame!";
		lootChange = "- 10 Gold...";
		combatResultImage = "https://carlisletheacarlisletheatre.org/images/headstone-clipart-1.png";
		e.getPlayer().setHp(e.getPlayer().getMaxHp());
		}
		mv.addObject("combatMessage", combatResultMessage);
		mv.addObject("lootMessage", lootChange);
		mv.addObject("URL", combatResultImage);
		
		return mv;
	}

	
	@RequestMapping("/add-user") //HAVE TO ADD AUTOWIRED AND OBJECT ABOVE FOR IT TO WORK
	public ModelAndView addUser(User addUser) {
		userRepo.save(addUser);
		return new ModelAndView("redirect:/team-admin");
		
	}
	
}
