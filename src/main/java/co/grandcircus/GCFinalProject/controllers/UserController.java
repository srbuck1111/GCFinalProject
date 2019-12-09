package co.grandcircus.GCFinalProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.grandcircus.GCFinalProject.Dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao user;
	
	
}
