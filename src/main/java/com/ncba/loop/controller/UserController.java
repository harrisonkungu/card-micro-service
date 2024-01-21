package com.ncba.loop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncba.loop.model.User;
import com.ncba.loop.repository.UserRepository;

import io.swagger.v3.oas.annotations.Hidden;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@Hidden
@RestController
@RequestMapping("/users")
public class UserController {

	/* I have advertently excluded this controller from the swagger UI. I don't need the user Model Controller for this particular assessment
	 * I just created this with JWT authentication in mind
	 * Since this goes out of scope, I won't proceed with API authentication
	 * This will also make testing a bit more easier with no need for authentication
	 * For a production ready api, I would highly recommend a bearer token authentication
	 * 
	 * */
	
  @Autowired
  private UserRepository userRepository;

  //ping - custom request to check whether the service is running
  //not necessary for this particular assessment
  
  
  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }
  
  @GetMapping
  public List<User> getAllUsers() {
    return userRepository.findAll();
  } 

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return userRepository.findById(id).get();
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }
  
  @PutMapping("/{id}")
  public User updateUser(@PathVariable Long id, @RequestBody User user) {
    User user_to_update = userRepository.findById(id).get();
    user_to_update.setName(user.getName());
    user_to_update.setEmail(user.getEmail());
    user_to_update.setPassword(user.getPassword());
    return userRepository.save(user_to_update);
  }

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable Long id) {
    try {
      userRepository.findById(id).get();
      userRepository.deleteById(id);
      return "User deleted successfully";
    } catch (Exception e) {
      return "User not found";
    }
  }
  
}
