package com.solidarize.controller;

import com.solidarize.model.User;
import com.solidarize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/user/{id}", method = GET)
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    @RequestMapping(path = "users", method = GET)
    public Iterable<User> getUsers() {
        return userService.allUsers();
    }


    @RequestMapping(path = "/user", method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public Resource<User> createUser(@RequestBody User user) {
        return new Resource<>(userService.saveUser(user));
    }
    
    @RequestMapping(path = "/usersearch", method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Resource<User> searchUser(@RequestBody String login) {
        return new Resource<>(userService.findUserByLogin(login));
    }

    @RequestMapping(path = "/user", method = PUT, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Resource<User> updateUser(@RequestBody User user) {
        return new Resource<>(userService.saveUser(user));
    }

    @RequestMapping(path = "user/{id}", method = DELETE)
    @ResponseStatus(OK)
    public void deleteUser(@PathVariable("id") Integer id) {
    	User user = userService.findUserById(id);
        userService.deleteUser(user);
    }

}
