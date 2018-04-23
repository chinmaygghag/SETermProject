package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

}
