package com.webonise.redisdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webonise.cache.CacheService;
import com.webonise.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	CacheService cacheService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	
		
		return "home";
	}
	
	
	@RequestMapping(value = "/user/set", method = RequestMethod.GET)
	public String addUser() {
	
	
		cacheService.save();
		
		return "home";
	}
	
	@RequestMapping(value = "/user/get", method = RequestMethod.GET)
	public String getUser(Model model) {
	

		User user = cacheService.retrieve();
		model.addAttribute("user", user);
		return "user";
	}
	
	@RequestMapping(value = "/user/update", method = RequestMethod.GET)
	public String updatetUser(Model model) {
	

		User user = cacheService.update();
		model.addAttribute("user", user);
		return "user";
	}
}
