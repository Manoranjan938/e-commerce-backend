package com.example.eCommDemo.service;

import com.example.eCommDemo.entity.Users;
import com.example.eCommDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        return user;
    }

    @Transactional
    public Users loadUserByUserId(Long userId) {

        Users user = userRepo.findById(userId).get();

        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        return user;
    }

}
