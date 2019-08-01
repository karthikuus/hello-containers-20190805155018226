package com.baabbee.iframex.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.User;
import com.baabbee.iframex.service.UserService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers() throws EntityNotFoundException {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable("id") Long id) throws EntityNotFoundException {
		return userService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ResponseEntity<Object>  addUser(@RequestBody User user)  throws EntityNotFoundException  {
		user.setCreatedDate(new Date());
		user.setLastModifiedDate(new Date());
		User userResponse = userService.addUser(user);
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<Object>(userResponse, responseHeaders,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Long id) throws EntityNotFoundException {
		user.setLastModifiedDate(new Date());
		user.setId(id);
		User userRes = userService.updateUser(id, user);
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<Object>(userRes, responseHeaders,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) throws EntityNotFoundException {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
