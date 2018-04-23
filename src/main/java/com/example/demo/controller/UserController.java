package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Profile;
import com.example.demo.models.Users;
import com.example.demo.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Value("${DB_USER}")
	String secretKey;

	@GetMapping(value = "/")
	public ModelAndView renderPage() {
		System.out.print(secretKey);
		ModelAndView indexPage = new ModelAndView();
		indexPage.setViewName("index");
		return indexPage;
	}

	@PostMapping(value = "/facebooksavedetails")
	public ModelAndView saveUser(@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "friends", required = true) String friends,
			@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "id", required = true) String id,
			HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		Users user = new Users();
		if (!userService.findUserExists(username)) {
			user.setUsername(username);
			user.setCurrentNotifications(new ArrayList<>());
			user.setFriends(friends);
			user.setProfile(new Profile());
			userService.saveUser(user);
			return new ModelAndView("create_profile");
		} else if(userService.findUserExists(username)){
			user = userService.findUserByName(username);
			user.setFriends(friends);
			return new ModelAndView("drawer");
		}else {
			return new ModelAndView("error");
		}
	}
	
	
	@RequestMapping(value = "/friends")
	public ModelAndView getFriends(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		ModelAndView modelAndView = new ModelAndView();
		
		List<Users> users = userService.getAllUsers();
		List<String> friendList = new ArrayList<>();
		String friends = null;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getUsername().equals(username)) {
				friends = users.get(i).getFriends();
				String[] splitted = friends.split("/");
				for(int j=0;i<splitted.length;i++) {
					friendList.add(splitted[i]);
				}
				break;
			}
		}
		modelAndView.addObject(friendList);
		modelAndView.setViewName("friends");
		return modelAndView;
	}
	
	
	
	
}
