package com.solidarize.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.hateoas.Resource;

import com.solidarize.model.User;
import com.solidarize.service.EventService;
import com.solidarize.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {

    @Mock
    private UserService service;
    
    @Mock
    private EventService eventService;

    private UserRestController restController;

    @Before
    public void setUp() throws Exception {
        restController = new UserRestController(service, eventService);
    }

    @Test
    public void shouldBeAbeToGetUserById() throws Exception {
    	BigInteger id = BigInteger.ONE;
        User user = new User("Instituicao", "123456",  1,"");
        when(service.findUserById(eq(id))).thenReturn(user);
        User response = restController.getUserById(id);
        assertEquals(user, response);
    }

    @Test
    public void shouldBeAbeToGetUsers() throws Exception {
    	Iterable<User> user = Arrays.asList(new User("Colaborador","654321",2,""));
        when(service.allUsers()).thenReturn(user);
        Iterable<User> response = restController.getUsers();
        assertEquals(user, response);
    }

    @Test
    public void shouldBeAbleToCreateUser() throws Exception {
        User user = new User("Colaborador2","123789",2,"");
        when(service.saveUser(eq(user))).thenReturn(user);
        Resource<User> resource = restController.createUser(user);
        assertEquals(user, resource.getContent());
    }

    @Test
    public void shouldBeAbleToSearchUser() throws Exception {
    	String login = "Instituicao2";
        User user = new User("Instituicao2","789456",1,"");
        when(service.findUserByLogin(eq(login))).thenReturn(user);
        Resource<User> resource = restController.searchUser(login);
        assertEquals(user, resource.getContent());
    }
    
    @Test
    public void shouldBeAbleToUpdateUser() throws Exception {
        User user = new User("Instituicao3","654110",1,"");
        when(service.saveUser(eq(user))).thenReturn(user);
        Resource<User> resource = restController.updateUser(user);
        assertEquals(user, resource.getContent());
    }
}
