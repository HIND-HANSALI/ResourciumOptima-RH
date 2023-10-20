package com.resourciumoptimarh.services;


import com.resourciumoptimarh.model.User;
import com.resourciumoptimarh.repositories.UserRepository;
import jakarta.inject.Inject;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

public class UserService {

    @Inject
    private UserRepository userRepository=new UserRepository();

    public User save(User user){
        User existingUser = userRepository.getUserByEmail(user);
        if (existingUser == null) {
            userRepository.save(user);
            return user;
        } else {
            return null; // Return null when the user already exists
        }
    }

    public User CheckExistenceUserByEmail(User user){
        User user1 = userRepository.getUserByEmail(user);
        if (user1 != null && BCrypt.checkpw(user.getMotDePasse(), user1.getMotDePasse())) {
            return user1;
        } else {
            return null;
        }
    }
}
