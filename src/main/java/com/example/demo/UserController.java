package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private Map<Long, UserEntity> users = new HashMap<Long, UserEntity>();


    private UserController() {
        for (int i = 0; i < 40; i++) {
            this.users.put((long) i, new UserEntity("sd", (short) 3));
        }
    }

    @RequestMapping("/api/users")
    @ResponseBody
    public Object getUsersWithPagination(
            @RequestParam(name="page-number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name="page-size", defaultValue = "20") Integer pageSize
    ) {
        //TODO: dodać walidację

        //TODO: paginacja

        UserPage page = new UserPage();

        page.setPageNumber(pageNumber);
        page.setPagesCount(1); //TODO
        page.setPageSize(pageSize);
        page.setTotalCount(1); //TODO
        page.setUsers(this.users.values());

        return page;
    }

    @RequestMapping("/api/users/{id}/get")
    @ResponseBody
    public Object getUser(
            @PathVariable Long id
    ) {
        return users.get(id);
    }

    @RequestMapping("/api/users/{id}/remove")
    @ResponseBody
    public Object removeUser(
            @PathVariable Long id
    ) {
        UserEntity userToRemove = users.get(id);
        users.remove(id);
        return userToRemove;
    }

    @PostMapping(
            value = "/api/user/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public UserEntity createUser(@RequestBody UserEntity user) {
        //TODO: odwołanie do serwisu
        return user;
    }
}