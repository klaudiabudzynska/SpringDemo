package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/users")
    @ResponseBody
    public Object getUsers(
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize
    ) {
        List<UserEntity> users = new ArrayList<>();

        users.add(new UserEntity(1L, "John"));
        users.add(new UserEntity(2L, "Matt"));
        users.add(new UserEntity(3L, "Chris"));

        return users;
    }

    @RequestMapping("/users/{id}")
    @ResponseBody
    public Object getUsers(
            @PathVariable Long id
    ) {
        return new UserEntity(id, "John-" + id);
    }

    @RequestMapping("/users/add")
    @ResponseBody
    public Object addUser(
            @RequestParam String name,
            @RequestParam Integer age
    ) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return new UserEntity(timestamp.getTime(), name, age);
    }
}