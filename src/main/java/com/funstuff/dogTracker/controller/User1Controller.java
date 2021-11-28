package com.funstuff.dogTracker.controller;

import com.funstuff.dogTracker.model.User1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User1Controller {
    @GetMapping("/User1")
    public User1 getUser1(@RequestParam(value = "firstname", defaultValue = "Wilma") String firstname,
                        @RequestParam(value = "lastname", defaultValue = "Kisser") String lastname,
                        @RequestParam(value = "age", defaultValue = "2") int age){
        User1 User1 = new User1();
        User1.setFirstname(firstname);
        User1.setLastname(lastname);
        User1.setAge(age);
        return User1;

    }

    @PostMapping("/User1")
    public User1 postUser1(User1 User1){
        System.out.println("User1 firstname:" + User1.getFirstname());
        return User1;
    }
}
