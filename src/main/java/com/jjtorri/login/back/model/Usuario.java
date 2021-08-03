package com.jjtorri.login.back.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection="usuarios")
@Data
public class Usuario {

	
	@Id private String id;
	@Indexed private String username;
	private String password;

	
	public Usuario (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public boolean equals(Object o) {
		
		boolean iguales = Boolean.FALSE;
		
		if (o == this) {
			iguales = Boolean.TRUE;
		} else if (o instanceof Usuario) {
			Usuario usuario = (Usuario) o;
			if (usuario != null 
					&& this.getUsername() !=null
					&& this.getPassword() != null
					&& usuario.getUsername() != null
					&& usuario.getPassword() != null
					&& usuario.getUsername().equals(this.getUsername())
					&& usuario.getPassword().equals(this.getPassword())
					) {
				iguales = Boolean.TRUE;
			}
		}
		return iguales;		
	}

	
}
