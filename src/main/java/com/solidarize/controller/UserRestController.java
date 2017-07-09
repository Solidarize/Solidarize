package com.solidarize.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.math.BigInteger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.solidarize.model.Event;
import com.solidarize.model.User;
import com.solidarize.service.EventService;
import com.solidarize.service.UserService;

@RestController
public class UserRestController {

	private UserService userService;
	private EventService eventService;
	private HttpSession session;

	@Autowired
	public UserRestController(UserService userService, EventService eventService) {
		this.userService = userService;
		this.eventService = eventService;
	}

	@RequestMapping(path = "/user/{id}", method = GET)
	public User getUserById(@PathVariable("id") BigInteger id) {
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
	public void deleteUser(@PathVariable("id") BigInteger id) {
		User user = userService.findUserById(id);
		userService.deleteUser(user);
	}

	@CrossOrigin(origins = { "http://solidarize-web-dev.herokuapp.com" })
	@RequestMapping(path = "/user/subscribeToEvent", method = PUT)
	@ResponseStatus(OK)
	public void subscribeEvent(@RequestBody Event event) {
		User loggedUser = getUserInSession();
		Event eventThatWillBeSubscribed = eventService.getEventById(event.getId());

		if (loggedUser.getEvents().contains(eventThatWillBeSubscribed)) {
			loggedUser.getEvents().remove(eventThatWillBeSubscribed);
		} else {
			loggedUser.getEvents().add(eventThatWillBeSubscribed);
		}

		userService.saveUser(loggedUser);
	}

	@RequestMapping(path = "/user/login", method = POST)
	public User login(@RequestBody User user, HttpSession httpSession) {
		session = httpSession;
		User loggedUser = userService.findUserById(user.getId());

		if (loggedUser == null) {
			loggedUser = userService.saveUser(user);
		}

		httpSession.setAttribute("loggedUser", loggedUser);

		return loggedUser;
	}

	@RequestMapping(path = "/user/login", method = GET)
	public User getLoggedUser() {
		return getUserInSession();
	}

	@RequestMapping(path = "/user/subscribedToEvent/{id}", method = GET)
	public Boolean getUserById(@PathVariable("id") Integer id) {
		User loggedUser = getUserInSession();
		Event eventToVerify = eventService.getEventById(id);

		return loggedUser.getEvents().contains(eventToVerify);
	}

	private User getUserInSession() {
		User loggedUser = (User) session.getAttribute("loggedUser");
		return userService.findUserById(loggedUser.getId());
	}
}