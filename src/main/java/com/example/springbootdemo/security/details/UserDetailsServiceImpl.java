package com.example.springbootdemo.security.details;

import com.example.springbootdemo.models.User;
import com.example.springbootdemo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = usersRepository.findByEmail(email);

        if (user != null){
            return new UserDetailsImpl((org.apache.catalina.User) user);
        } else throw new UsernameNotFoundException("User not found");

    }

    @SpringBootApplication
    public static class SpringBootDemoApplication {

        public static void main(String[] args) {
            SpringApplication.run(SpringBootDemoApplication.class, args);
        }

    }
}
