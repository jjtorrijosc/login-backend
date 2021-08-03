package com.jjtorri.login.back.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jjtorri.login.back.model.Usuario;

@Repository
public class UsersDaoImpl implements UsersDao {

	@Autowired
	UsersMongoRepo usersRepo;
	
	@Override
	public boolean save(Usuario user) {
		usersRepo.save(user);
		return Boolean.TRUE;
	}

	@Override
	public Usuario getUser(String username) {
		return usersRepo.findByUsername(username);
	}

	@Override
	public List<Usuario> getAllUsers() {
		return usersRepo.findAll();
	}

	@Override
	public boolean existsUsername(String username) {
		return usersRepo.existsByUsername(username);
	}

	
}
