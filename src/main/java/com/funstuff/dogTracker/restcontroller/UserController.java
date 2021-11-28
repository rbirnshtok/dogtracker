package com.funstuff.dogTracker.restcontroller;

import com.funstuff.dogTracker.entities.User;
import com.funstuff.dogTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepository.save(newUser);
        return Status.SUCCESS;
    }

    @PostMapping("user/login")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        //String token = getJWTToken(username);
        User user = new User();
        user.setUsername(username);
        //user.setToken(token);
        return user;

    }

@PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody User userToLogin) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.equals(userToLogin)) {
                user.setLoggedIn(true);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User loggedInUser) {
        List<User> users = new ArrayList<>();//userRepository.findAll();
        for (User user : users) {
            if (user.equals(loggedInUser)) {
                user.setLoggedIn(false);
                //userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        //userRepository.deleteAll();
        return Status.SUCCESS;
    }

    public enum Status {
        SUCCESS,
        USER_ALREADY_EXISTS,
        FAILURE
    }

/*private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }*/

}
