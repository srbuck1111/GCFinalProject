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
