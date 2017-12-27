package com.jjtorri.login.back;


import org.springframework.data.mongodb.repository.MongoRepository;

//@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    public Usuario findByUsername(String username);
    
    @SuppressWarnings("unchecked")
	public Usuario save(Usuario user);

}