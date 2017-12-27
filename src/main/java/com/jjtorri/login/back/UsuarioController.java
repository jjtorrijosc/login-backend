package com.jjtorri.login.back;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	
	
    @RequestMapping("/login")
    public boolean login(@RequestParam(value="username") String username,
    					@RequestParam(value="password") String password) {
        boolean login = false;
        if (username!=null && password!=null) {
        	Usuario user = null;
        	user = usuarioRepo.findByUsername(username);
        	
	        if (user!=null && username.equals(user.getUsername()) 
	       			&& password.equals(user.getPassword())) {
	        	login = true;
	        }
        }
    	return login;
    }
    
    @RequestMapping(value="/usuario/sign-up", method = RequestMethod.POST)
    public ResponseEntity<String> signUp(@RequestBody(required=true) Usuario user) {
    	
    	if (user==null) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario no se ha informado");
    	} else if (usuarioRepo.findByUsername(user.getUsername())!=null) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya existe");
        } else {
        	user = usuarioRepo.save(user);
        	return ResponseEntity.ok(JSONObject.quote("OK"));
        }
    }
    
    @RequestMapping("usuario/list")
    public List<Usuario> getList() {
    	return usuarioRepo.findAll();
    }
    
}