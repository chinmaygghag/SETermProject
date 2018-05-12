package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Profile;
import com.example.demo.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	ProfileRepository repository;
	
	public void saveProfile(Profile profile) {
		if (repository.findProfileByUserId(profile.getUserId()) == null) {
			repository.save(profile);
		}
	}
	
	public Profile findProfile(String username) {
		return repository.findByUsername(username);
	}
	
}
