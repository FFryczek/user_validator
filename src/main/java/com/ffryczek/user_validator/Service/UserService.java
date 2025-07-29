package com.ffryczek.user_validator.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ffryczek.user_validator.Entity.User;
import com.ffryczek.user_validator.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    //Constructor
    public UserService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //CRUD
    public User insert(User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return this.userRepository.save(user);
    }

    public User fetchByEmail(String email) throws IllegalArgumentException{
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            throw new IllegalArgumentException("\nUnable to locate user with such Email\n");
        } else {
            return optionalUser.get();
        }
    }

    public List<User> fetchAll() {
        return this.userRepository.findAll();
    }

    public User fetchById(UUID userID) throws IllegalArgumentException {
        Optional<User> optionalUser = this.userRepository.findById(userID);
        if (!optionalUser.isPresent()) {
            throw new IllegalArgumentException("\nUnable to locate user with such ID\n");
        } else {
            return optionalUser.get();
        }
    }
    
    public User update(UUID userID, User newUser) throws IllegalArgumentException{
        Optional<User> optionalUser = this.userRepository.findById(userID);
        if (!optionalUser.isPresent()) {
            throw new IllegalArgumentException("\nUnable to locate user with such ID\n");
        } else {
            User fetchedUser = optionalUser.get();
            fetchedUser.setEmail(newUser.getEmail());
            
            fetchedUser.setPasswordHash(passwordEncoder.encode(newUser.getPasswordHash()));
            fetchedUser.setUserName(newUser.getUserName());

            return this.userRepository.save(fetchedUser);
        }
    }

    public void delete(UUID userID) {
        this.userRepository.deleteById(userID);
    }

    public User login(String email, String password) {
        User dbUser = this.fetchByEmail(email);
        if (!passwordEncoder.matches(password, dbUser.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return dbUser;
    }
    
}
