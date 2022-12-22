package com.example.eCommDemo.controller;

import com.example.eCommDemo.request.LoginRequest;
import com.example.eCommDemo.response.LoginResponse;
import com.example.eCommDemo.request.NewUserRequest;
import com.example.eCommDemo.security.SecurityConstants;
import com.example.eCommDemo.security.TokenProvider;
import com.example.eCommDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/new-user")
    public ResponseEntity<?> addNewUser(@RequestBody NewUserRequest userRequest){

        return new ResponseEntity<String>(userService.addNewUser(userRequest), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest logRequest) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(logRequest.getUsername(), logRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = SecurityConstants.TOKEN_PREFIX + tokenProvider.generateToken(auth);

        return ResponseEntity.ok(new LoginResponse(true, jwt));
    }

}
