package com.jjtorri.login.back.service;

import java.util.List;

import com.jjtorri.login.back.exceptions.UserAlreadyExistsException;
import com.jjtorri.login.back.model.Usuario;

public interface UserService {

	public boolean login(Usuario user);
	public boolean signup(Usuario user) throws UserAlreadyExistsException;
	public List<Usuario> userList();
}
