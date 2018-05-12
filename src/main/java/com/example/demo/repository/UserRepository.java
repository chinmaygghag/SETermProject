package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
	Users findByUsername(String username);

	Users findByEmail(String email);

	Users findUsersById(long id);

	List<Users> findAll();
}
