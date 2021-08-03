package com.jjtorri.login.back.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jjtorri.login.back.model.Usuario;

@Repository
public interface UsersMongoRepo extends MongoRepository<Usuario, String>{

	@SuppressWarnings("unchecked")
	public Usuario save(Usuario usuario);
	
	public Usuario findByUsername(String username);
	public boolean existsByUsername(String username);

}
