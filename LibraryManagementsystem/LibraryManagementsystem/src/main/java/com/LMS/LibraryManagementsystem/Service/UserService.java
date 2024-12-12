package com.LMS.LibraryManagementsystem.Service;


import com.LMS.LibraryManagementsystem.Entity.User;
import com.LMS.LibraryManagementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    public Optional<User> findById(String id){
       return  userRepository.findById(id);
    }
    public void deleteById(String id){
      userRepository.deleteById(id);
    }

    public User updateUser(String id, User user) {
        // Find the user by ID
        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            // Update the fields you want to change
            existingUser.setName(user.getName());

            // Save the updated user
            return userRepository.save(existingUser);
        }

        return null;  // User not found
    }
}

