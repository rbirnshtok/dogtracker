package com.funstuff.dogTracker.controller;

import com.funstuff.dogTracker.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public User getUser(@RequestParam(value = "firstname", defaultValue = "Wilma") String firstname,
                        @RequestParam(value = "lastname", defaultValue = "Kisser") String lastname,
                        @RequestParam(value = "age", defaultValue = "2") int age){
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);
        return user;

    }

    @PostMapping("/user")
    public User postUser(User user){
        System.out.println("User firstname:" + user.getFirstname());
        return user;
    }
}
