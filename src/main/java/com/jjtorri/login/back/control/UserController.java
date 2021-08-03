package com.jjtorri.login.back.control;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jjtorri.login.back.exceptions.UserAlreadyExistsException;
import com.jjtorri.login.back.model.Usuario;
import com.jjtorri.login.back.service.UserService;

import io.swagger.annotations.Api;

@CrossOrigin
@Api(value = "User API")
@RestController
public class UserController {

	@Autowired 
	UserService userService;
	
	@RequestMapping("/login")
    public boolean login(@RequestParam(value="username") String username,
    					@RequestParam(value="password") String password) {
    	return userService.login(new Usuario(username, password));
    }
    
    @RequestMapping(value="/usuario/sign-up", method = RequestMethod.POST)
    public ResponseEntity<String> signUp(@RequestBody(required=true) Usuario user) {
    	
    	ResponseEntity<String> response = null;
    	
    	if (user==null) {
    		response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario no se ha informado");
    	} else {
        	try {
        		if (userService.signup(user)) {
        			response = ResponseEntity.ok("OK");
        		} else {
        			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se ha podido llevar a cabo el alta");
        		}
        	} catch (UserAlreadyExistsException e) {
        		response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya existe");	
        	}
        }
    	return response;
    }
    
    @RequestMapping("usuario/list")
    public List<Usuario> getList() {
    	return userService.userList().stream()
    				.peek(e -> e.setPassword(null)).collect(Collectors.toList());
    }
}
