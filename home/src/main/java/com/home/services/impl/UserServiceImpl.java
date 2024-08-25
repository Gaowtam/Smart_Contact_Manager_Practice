package com.home.services.impl;

import com.home.entites.User;
import com.home.services.UserService;
import com.home.services.repositories.UserRepo;
import org.springframework.stereotype.Service;

 import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        //user id:have to generate
        // System.out.println("This is UserServiceImpl");
        String userId=UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepo.save(user);
    }

}
