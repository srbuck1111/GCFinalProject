package co.grandcircus.GCFinalProject.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.GCFinalProject.model.User;
import co.grandcircus.GCFinalProject.repo.UserRepo;


@Controller
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("/add-gold")
	public ModelAndView addGold(Integer id) {
		id = 1;
		User user = userRepo.findById(id).orElse(null);
		user.setGold(user.getGold() + 10);
		userRepo.save(user);
		ModelAndView mv = new ModelAndView("Eventresult", "gold", user.getGold());
		return mv;
	}

	
	@RequestMapping("/add-user") //HAVE TO ADD AUTOWIRED AND OBJECT ABOVE FOR IT TO WORK
	public ModelAndView addUser(User addUser) {
		userRepo.save(addUser);
		return new ModelAndView("redirect:/team-admin");
		
	}
	
}
