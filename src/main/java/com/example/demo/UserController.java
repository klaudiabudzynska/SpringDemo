package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    private Map<Long, UserEntity> users = new HashMap<Long, UserEntity>();

    @RequestMapping("/users")
    @ResponseBody
    public Object getUsers() {
        return users;
    }

    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public Object getUser(
            @PathVariable Long id
    ) {
        return users.get(id);
    }

    @RequestMapping("/users/{id}/remove")
    @ResponseBody
    public Object removeUser(
            @PathVariable Long id
    ) {
        UserEntity userToRemove = users.get(id);
        users.remove(id);
        return userToRemove;
    }

    @RequestMapping("/users/add")
    @ResponseBody
    public Object addUser(
            @RequestParam String name,
            @RequestParam Short age
    ) {
        UserEntity newUser = new UserEntity(name, age);
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        users.putIfAbsent(timestamp, newUser);

        return newUser;
    }
}