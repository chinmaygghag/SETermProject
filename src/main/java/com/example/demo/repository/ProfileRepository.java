package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer>{
	
	Profile findByUsername(String username);

	Profile findProfileByUserId(long userId);

}
