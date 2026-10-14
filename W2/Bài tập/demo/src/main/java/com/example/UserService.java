package com.example;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional 
    public User createUser(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        User user = new User(name);
        return userRepository.save(user);
    }

    @Transactional 
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("User not found with id: " + id));
    }
}
