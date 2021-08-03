package com.jjtorri.login.back.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jjtorri.login.back.model.UserSession;

@Repository
public class SessionsDaoImpl implements SessionsDao {

	@Autowired
	SessionsMongoRepo sesionsRepo;

	@Override
	public void saveSession(UserSession userSession) {
		sesionsRepo.save(userSession);
	}
	
	@Override
	public List<UserSession> getUserSessions(String username) {
		return sesionsRepo.findByUsername(username);
	}

}
