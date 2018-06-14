package com.rss.keshava.controller;

import com.rss.keshava.domain.Role;
import com.rss.keshava.domain.Status;
import com.rss.keshava.domain.User;
import com.rss.keshava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Status create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{uid}")
    public Status update(@Valid @RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping
    public Status delete(@PathVariable String uuid) {
        return userService.delete(uuid);
    }

    @GetMapping(path = "/{uid}")
    public User get(@PathVariable String uid) {
        return userService.getByUid(uid);
    }

    @PostMapping(path = "/login")
    public Status login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping(path = "/")
    public Iterable<User> getAll() {
        //get Role  and get the details
        return userService.getAll(Role.ADMIN.name());
    }
}
