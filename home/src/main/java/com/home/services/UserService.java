package com.home.services;

import com.home.entites.User;

public interface UserService {
    //method
    User saveUser(User user);
    // Optional<User> getUserById(String id);
    // Optional<User> updateUser(User user);
    // void deleteUser(String id);
    // boolean isUserExist(String userId);
    // boolean isUserExitByEmail(String email);//UserName
    // List<User>getAlUsers();

    User getUserByEmail(String email);

    //add more methods here related user service[logic]
}