package com.funstuff.dogTracker.restcontroller;

import com.funstuff.dogTracker.entities.User;
//import com.funstuff.dogTracker.services.UserService;
import com.funstuff.dogTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class DogParkAdminController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PostMapping("/login/{username}/{password}")
    public void login(@PathVariable String username, String password) {
        //TODO
    }
}
