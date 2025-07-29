package com.ffryczek.user_validator.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ffryczek.user_validator.DTO.LoginRequest;
import com.ffryczek.user_validator.Entity.User;
import com.ffryczek.user_validator.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    //Constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Crud methods
    @PostMapping
    public User postUser(@RequestBody User entity) {
        return this.userService.insert(entity);
    }
    
    @GetMapping("by-email/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        try{
        return this.userService.fetchByEmail(email);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable("id") UUID userID) {
        try{
            return this.userService.fetchById(userID);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.fetchAll();
    }

    @PutMapping("/{id}")
    public User putUser(@PathVariable("id") UUID userID, @RequestBody User entity) {
        try {
            return this.userService.update(userID, entity);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID userID) {
        this.userService.delete(userID);
    }
    
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return this.userService.login(request.getEmail(), request.getPassword());
    }
    
    
    

}
