package com.jjtorri.login.back.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jjtorri.login.back.model.UserSession;

@Repository
public interface SessionsMongoRepo extends MongoRepository<UserSession, String>{

	@SuppressWarnings("unchecked")
	public UserSession save(UserSession userSession);
	
	public List<UserSession> findByUsername(String username);
	
}
