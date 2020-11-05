package com.wopiro.distri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wopiro.distri.entity.User;
import com.wopiro.distri.service.UserService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/user")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
		RepReference.setUserService(userService);
	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {

		User theUser = userService.findById(id);

		if (theUser == null) {
			throw new RuntimeException("User id not found - " + id);
		}

		return theUser;
	}

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		user.setId(0);
		return userService.save(user);
	}

	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return userService.save(user);
	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {

		User tempUser = userService.findById(id);

		if (tempUser == null) {
			throw new RuntimeException("User id not found - " + id);
		}
		userService.deleteById(id);

		return "Deleted user id - " + id;
	}

}
