package com.example.eCommDemo.service;

import com.example.eCommDemo.entity.Users;
import com.example.eCommDemo.repository.UserRepository;
import com.example.eCommDemo.request.NewUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passEncode;
    public String addNewUser(NewUserRequest req){

        Users us = userRepo.findByEmail(req.getEmail());
        if(us == null){

            Users users = new Users();
            users.setName(req.getName());
            users.setEmail(req.getEmail());
            users.setUsername(req.getEmail());
            users.setUserType(req.getUserType());
            users.setStatus("active");
            users.setPassword(passEncode.encode(req.getPassword()));

            userRepo.save(users);
            return "User added successfully";
        }

        return null;
    }

}
