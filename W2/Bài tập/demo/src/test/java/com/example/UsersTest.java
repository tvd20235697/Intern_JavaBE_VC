package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersTest {
    @Autowired 
    private UserService userService;

    @Test 
    public void testCreateUser() {
        User user = userService.createUser("Duy");
        User foundUser = userService.getUserById(user.getId());
        assertEquals("Duy", foundUser.getName());
        assertNotNull(foundUser.getId());
    }
    @Test 
    public void shouldThrowExceptionWhenUserMissingId() {
        User user = userService.createUser("UserWithoutId");
        Long missingId = user.getId() + 1;
        assertThrows( IllegalArgumentException.class, () -> {
            userService.getUserById(missingId);
        });
    }
    @Test 
    public void shouldThrowExceptionWhenUserEmptyName() {
        System.out.println("May co chay tao khong");
        assertThrows( IllegalArgumentException.class, () -> {
            userService.createUser("");
        });
    }
}
