package za.ac.cput.linkup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.service.UserService;
/* UserController.java
Author: SH Kgomokaboya (222152672)
Date: .
*/

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/read/{name}")
    public User readUser(@PathVariable String name) {
        return userService.findByFirstName(name).orElse(null);
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }
}
