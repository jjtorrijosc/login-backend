package com.jjtorri.login.back.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jjtorri.login.back.model.UserSession;
import com.jjtorri.login.back.service.UserSessionService;

import io.swagger.annotations.Api;

@CrossOrigin
@Api(value = "Session API")
@RestController
public class SessionController {

	@Autowired
	UserSessionService userSessionService;
	
    @GetMapping("user-sessions")
    public List<UserSession> getSessionList(@RequestParam(value="username") String username) {
    	return userSessionService.getUserSessions(username);
    }
}
