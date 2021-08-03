package com.jjtorri.login.back.dao;

import java.util.List;

import com.jjtorri.login.back.model.Usuario;

public interface UsersDao {

	public boolean save(Usuario user);
	public Usuario getUser(String username);
	public List<Usuario> getAllUsers();
	public boolean existsUsername(String username);
}
