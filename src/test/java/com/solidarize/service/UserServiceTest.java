package com.solidarize.service;


import com.solidarize.model.User;
import com.solidarize.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository repository;
    private UserService service;

    @Before
    public void setUp() throws Exception {
        service = new UserService(repository);
    }

    @Test
    public void shouldBeAbleToFindUserByID() throws Exception {
        int id = 1;
        User user = new User("Instituicao", "123456", 1,"");
        when(repository.findById(eq(id))).thenReturn(user);
        User response = service.findUserById(id);
        assertEquals(user, response);
    }

    @Test
    public void shouldBeAbleToFindUserByLogin() throws Exception {
        String login = "Instituicao2";
        User user = new User("Instituicao2", "789456", 1,"");
        when(repository.findByLogin(eq(login))).thenReturn(user);
        User response = service.findUserByLogin(login);
        assertEquals(user, response);
    }

    @Test
    public void shouldBeAbleToSaveUser() throws Exception {
        User user = new User("Colaborador", "123456", 2,"");
        when(repository.save(eq(user))).thenReturn(user);
        User response = service.saveUser(user);
        assertEquals(user, response);
    }

    @Test
    public void shouldBeAbleToDeleteUser() throws Exception {
        int id = 1;
        User user = service.findUserById(id);
        service.deleteUser(user);
        verify(repository).delete(user);
    }

    @Test
    public void shouldBeAbeToAllUsers() throws Exception {
        Iterable<User> user = Arrays.asList(new User("Colaborador2", "654321", 2,""));
        when(repository.findAll()).thenReturn(user);
        Iterable<User> response = service.allUsers();
        assertEquals(user, response);
    }
}

