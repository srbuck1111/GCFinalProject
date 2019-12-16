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

	@RequestMapping("add-user")
	public ModelAndView createNewUser(String username, String password) {
		for (User u : userRepo.findAll()) {
			if (u.getUsername().equals(username)) {
				System.out.println("taken.");
				return new ModelAndView("new-user", "error", "username taken, sorry!");
			}
		}
		User newUser = new User(username, password);
		System.out.println(newUser);
		userRepo.save(newUser);
		session.setAttribute("loggedUser", newUser);
		return new ModelAndView("character-create");
	}

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
		//	user.setGold(user.getGold() + 10);
			userRepo.save(user);
			combatResultMessage = "Congratulations! You have brutally murdered " + enemyFullName + "! You  now have "
					+ health + " HP";
			lootChange = "+ 10 Gold! Don't spend it all in one place!";
			combatResultImage = "https://us.123rf.com/450wm/jagcz/jagcz1703/jagcz170300036/73559722-champion-golden-trophy-isolated-on-black-background-concept-of-success-and-achievement-.jpg?ver=6";
		}

		else {

		//	mv.addObject(user.getGold() - 10);
		userRepo.save(user);
			combatResultMessage = "You have been shamefully defeated in combat by " + enemyFullName
					+ " and their trusty " + enemyWeapon + ". And " + enemyFName + " only had " + enemyHP
					+ " health remaining. Shame!";
			lootChange = "- 10 Gold...";
			combatResultImage = "https://carlisletheacarlisletheatre.org/images/headstone-clipart-1.png";
			e.getPlayer().setHp(e.getPlayer().getMaxHp());
		}
		mv.addObject("combatMessage", combatResultMessage);
		mv.addObject("lootMessage", lootChange);
		mv.addObject("URL", combatResultImage);

		return mv;
	}

	@RequestMapping("/new-user")
	public ModelAndView newUserView(String userName, String userPassword) {
		return new ModelAndView("new-user");
	}

	@RequestMapping("add-user")
	public ModelAndView addUser(String userName, String userPassword) {
		User user = new User();
		if (userRepo.findByUsername(userName) != null) {
			return new ModelAndView("new-user", "userExists", "User already exists, please try a different username");
		} else {
			user.setUsername(userName);
			user.setPassword(userPassword);
			userRepo.save(user);
			return new ModelAndView("index", "userInfo", "Welcome " + user.getUsername() + "!");
		}

	}

	@RequestMapping("login")
	public ModelAndView login(String userName, String userPassword) {

		if (userRepo.findByUsername(userName).getPassword().equals(userPassword)) {
			User loggedUser = userRepo.findByUsername(userName);
			session.setAttribute("loggedUser", loggedUser);
			return new ModelAndView("redirect:/characterSelect");
		} else {
			return new ModelAndView("index", "wrongPassword", "Incorrect Password");
		}

	}


	

}
