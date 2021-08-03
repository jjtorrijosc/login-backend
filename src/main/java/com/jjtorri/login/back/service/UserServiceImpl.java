package com.jjtorri.login.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjtorri.login.back.dao.SessionsDao;
import com.jjtorri.login.back.dao.UsersDao;
import com.jjtorri.login.back.exceptions.UserAlreadyExistsException;
import com.jjtorri.login.back.model.UserSession;
import com.jjtorri.login.back.model.Usuario;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersDao userDao;
	
	@Autowired
	SessionsDao sessionsDao;
	
	@Override
	public boolean login(Usuario user) {
		
		boolean login = Boolean.FALSE;
		Usuario userBD = this.userDao.getUser(user.getUsername());
		if (user.equals(userBD)) {
			sessionsDao.saveSession(new UserSession(user.getUsername()));
			login = Boolean.TRUE;
		}
		return login;
	}

	@Override
	public boolean signup(Usuario user) throws UserAlreadyExistsException {
		boolean signup = Boolean.FALSE;
		if (userDao.existsUsername(user.getUsername())) {
			throw new UserAlreadyExistsException();
		} else {
			userDao.save(user);
			sessionsDao.saveSession(new UserSession(user.getUsername()));
			signup = Boolean.TRUE;
		}
		return signup;
	}

	@Override
	public List<Usuario> userList() {
		return userDao.getAllUsers();
	}

	
	
}
