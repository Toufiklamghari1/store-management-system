package com.stocker.stockerapp.controller;

import javax.validation.Valid;

import com.stocker.stockerapp.jwt.JwtAuthenticationResponse;
import com.stocker.stockerapp.jwt.JwtTokenProvider;
import com.stocker.stockerapp.utils.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/auth")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody() LoginRequest loginRequest, BindingResult bindingResult) {

    	if(bindingResult.hasErrors()) {
    		System.out.println("There is an internal error !");
    		return ResponseEntity.internalServerError().build();
    	}else {
    		 System.out.println("LoginRequest >>>"+loginRequest.getPassword());
    	        Authentication authentication = authenticationManager.authenticate(
    	                new UsernamePasswordAuthenticationToken(
    	                        loginRequest.getUsername(),
    	                        loginRequest.getPassword()
    	                )
    	        );

    	        SecurityContextHolder.getContext().setAuthentication(authentication);

    	        String jwt = jwtTokenProvider.generateToken(authentication);
    	        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    	}

    }
}