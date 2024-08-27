package com.home.services.impl;

import com.home.entites.User;
import com.home.helpers.AppConstats;
import com.home.services.UserService;
import com.home.services.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    // private Logger Logger=LoggerFactory.get

    private Logger logger=LoggerFactory.getLogger(this.getClass());


    @Override
    public User saveUser(User user) {
        //user id:have to generate
        // System.out.println("This is UserServiceImpl");
        String userId=UUID.randomUUID().toString();
        user.setUserId(userId);

        //password encode
        // user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setPassword(passwordEncoder.encode(user.getPassword()));


        //set the user role 
        // user.setRoleList(List.of("Admin"));

        user.setRoleList(List.of(AppConstats.ROLE_USER));

        logger.info(user.getProvider().toString());

        return userRepo.save(user);
    }

}
