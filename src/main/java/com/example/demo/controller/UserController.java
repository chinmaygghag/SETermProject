package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.models.Friends;
import com.example.demo.models.Notifications;
import com.example.demo.services.NotificationService;
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

	@Autowired
	private NotificationService notificationService;

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
		System.out.print("Friends : "+friends);

		if(!username.equalsIgnoreCase("Postcrud TestUser Five")) {

			if (!userService.findUserExists(Long.parseLong(id))) {
				user.setId(Long.parseLong(id));
				user.setEmail(email);
				user.setUsername(username);
				saveFriends(friends, user.getId());
				userService.saveUser(user);
				return new ModelAndView("create_profile");
			} else if (userService.findUserExists(Long.parseLong(id))) {
				user = userService.findUserByName(username);
				saveFriends(friends, user.getId());
				return new ModelAndView("redirect:/view_timeline");
			} else {
				return new ModelAndView("error");
			}
		}else{
			return new ModelAndView("admin");
		}
	}
	
	
	@RequestMapping(value = "/friends")
	public ModelAndView getFriends(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		ModelAndView modelAndView = new ModelAndView();
		Users users = userService.findUserByName(username);
		List<Friends> friendsList = userService.getFriendByUsername(users.getId());
		modelAndView.addObject(friendsList);
		modelAndView.setViewName("friends");

		return modelAndView;
	}
	


	public void saveFriends(String friends,long userId){
		String[] eachFriend = friends.split(":");

		List<Friends> friendsList = new ArrayList<>();

			for (int i = 0; i < eachFriend.length; i++) {
				String[] friendsName = eachFriend[i].split("/");
				Friends f = new Friends();
				if(!userService.findFriendsExists(f.getFriendId(),userId)) {
					f.setFriendId(Long.parseLong(friendsName[0]));
					f.setName(friendsName[1]);
					f.setUserId(userId);
					if (!f.getName().equalsIgnoreCase("Postcrud TestUser Five")) {
						friendsList.add(f);
					}
					userService.saveFriend(f, userId);
				}
			}
//		}
	}

	@GetMapping("/showNotifications")
	public ModelAndView showNotifications(HttpServletRequest request){

		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Users users = userService.findUserByName(username);
		List<Notifications> received = notificationService.getNotificationsForUser(users.getId());

		List<Notifications> toBeDisplayed = new ArrayList<>();

		for (int i=0;i<received.size();i++){
			if(!received.get(i).isVisited()){
				toBeDisplayed.add(received.get(i));
			}

		}

		modelAndView.addObject("list",toBeDisplayed);

		modelAndView.setViewName("notifications");
		return modelAndView;


	}
	
	
}
