package com.resourciumoptimarh.services;

import com.resourciumoptimarh.model.Role;
import com.resourciumoptimarh.model.User;
import com.resourciumoptimarh.repositories.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserServiceTest {
    private UserRepository userRepository=new UserRepository();

    @Test
    public void test_null_email() {

        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService();
        //userService.setUserRepository(userRepository);
        Role role1=new Role("Employee");
        User user = new User("John", "Doe", null, "password",role1);

        // Act & Assert
        Exception msg = assertThrows(IllegalArgumentException.class, () -> userService.save(user), "Email is required");
        System.out.println(msg.getMessage());
       // verify(userRepository, never()).save(user);
    }

}