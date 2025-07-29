package com.ffryczek.user_validator.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffryczek.user_validator.Entity.User;


public interface UserRepository extends JpaRepository<User,UUID>{

    public Optional<User> findByEmail(String email);
}
