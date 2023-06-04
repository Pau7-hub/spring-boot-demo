package com.example.springbootdemo.repositories;

import com.example.springbootdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <User, Long> {
    User findByEmail(String email);

}
