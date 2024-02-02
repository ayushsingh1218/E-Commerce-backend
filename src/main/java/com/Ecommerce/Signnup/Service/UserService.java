package com.Ecommerce.Signnup.Service;

import com.Ecommerce.Signnup.Entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ecommerce.Signnup.Repo.UserRepo;
import lombok.NonNull;

@Service
public class UserService {
    
    
    @Autowired
    private UserRepo userRepo;


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(@NonNull Long id) {
        return userRepo.findById(id);
    }

    public User createUser(@NonNull User user) {
        return userRepo.save(user);
    }
   
    public User updateUser(@NonNull Long id, User userDetails) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepo.save(user);
    }

    public void deleteUser(@NonNull Long id) {
        userRepo.deleteById(id);
    }

    //Sign-in
    public boolean authenticateUser(String email, String password) {
        Optional<User> userOptional = userRepo.findByEmailAndPassword(email, password);
        return userOptional.isPresent();
    }

    
}
