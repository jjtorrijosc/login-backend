package com.jjtorri.login.back.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection="sesiones")
@Data
public class UserSession {

	
	@Id private String id;
	
	private String username;
	private Date sessionDate;
	
	public UserSession(String username) {
		this.username = username;
		this.sessionDate = new Date();
	}
	
}
