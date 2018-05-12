package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Friends;
import com.example.demo.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FriendRepository friendRepository;
	
	public ArrayList<Users> getAllUsers(){
		ArrayList<Users> users = (ArrayList<Users>) userRepository.findAll();
		return users;
	}
	
	public Users findUserByName(String username) {
		Users user = userRepository.findByUsername(username);
		return user;
	}
	
	public boolean findUserExists(long id) {
		Users user = userRepository.findUsersById(id);
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}


	public boolean findFriendsExists(long id,long userId){
		if(friendRepository.existsByFriendId(id)) {
			Friends friends = friendRepository.findByFriendId(id);
			if (friends.getUserId() == userId){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}

	}
	
	public void saveUser(Users user) {
		if(userRepository.findUsersById(user.getId()) == null) {
			userRepository.save(user);
		}
	}


	public Users findByEmail(String email){
		Users user = userRepository.findByEmail(email);
		return user;
	}


	public void saveFriend(Friends friend,long userId){
//		if (!findFriendsExists(friend.getFriendId(),userId)) {
			friendRepository.save(friend);
//		}
	}

	public List<Friends> getFriendByUsername(long userId){
		List<Friends> friendsList = friendRepository.findFriendsByUserId(userId);
		return friendsList;
	}

}
