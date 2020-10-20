package com.example.user.managment.controller;

import com.example.user.managment.model.Rights;
import com.example.user.managment.model.SimpleUser;
import com.example.user.managment.model.User;
import com.example.user.managment.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getUsers(Rights rights)
  {
    return userService.getUsers(rights);
  }

  public String getAboutInfo(User simpleUser, Rights rights) {
    return userService.getAboutInfo(simpleUser, rights);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public List<User> createUser(User simpleUsers, Rights rights) {
    return userService.createUser(simpleUsers, rights);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void giveUserRights(User simpleUser, Rights rights) {
    userService.giveRights(simpleUser, rights);
  }

  @DeleteMapping
  public void deleteUser(User simpleUser, Rights rights) {
    userService.deleteUser(simpleUser, rights);
  }

}
