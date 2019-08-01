

package com.baabbee.iframex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.User;
import com.baabbee.iframex.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public User getUser(Long id) throws EntityNotFoundException {
		User user= null;
		try {
		  user = userRepository.findById(id).get();	 
		} catch(Exception e) {
			if (user == null) {
            throw new EntityNotFoundException(User.class, "id", id.toString());
			}
		}
		return user;
	}
	
	public User addUser(User user) {
		return userRepository.save(user);		
	}
	
	public User updateUser(Long id, User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
