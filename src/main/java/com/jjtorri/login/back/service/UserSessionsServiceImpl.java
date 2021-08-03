package com.jjtorri.login.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjtorri.login.back.dao.SessionsDao;
import com.jjtorri.login.back.model.UserSession;

@Service
public class UserSessionsServiceImpl implements UserSessionService {

	@Autowired
	SessionsDao sessionsDao;
	
	@Override
	public List<UserSession> getUserSessions(String username) {
		return sessionsDao.getUserSessions(username);
	}

}
