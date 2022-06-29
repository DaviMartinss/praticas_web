package com.web.server.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.server.server.model.UserAccountModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends 
	JpaRepository<UserAccountModel, Integer>{

	List<UserAccountModel> findUserByNameOrEmail(String name, String email);
	
	Optional<UserAccountModel> findUserByUsername(String username);

}

