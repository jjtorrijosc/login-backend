package com.jjtorri.login.back.dao;

import java.util.List;

import com.jjtorri.login.back.model.UserSession;

public interface SessionsDao {

	public void saveSession(UserSession userSession);
	public List<UserSession> getUserSessions(String username);
}
