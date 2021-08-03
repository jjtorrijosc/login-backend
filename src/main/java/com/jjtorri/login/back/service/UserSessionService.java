package com.jjtorri.login.back.service;

import java.util.List;

import com.jjtorri.login.back.model.UserSession;

public interface UserSessionService {

	public List<UserSession> getUserSessions(String username);
	
}
