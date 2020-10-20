package com.example.user.managment.service;

import com.example.user.managment.model.Rights;
import com.example.user.managment.model.SimpleUser;
import com.example.user.managment.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

  List<User> simpleUsers;

  public UserService(List<User> simpleUsers) {
    this.simpleUsers = simpleUsers;
  }

  public List<User> getUsers(Rights rights) {
    if (!rights.equals(Rights.SIMPLE_USER)) {
      System.out.println("User doesn't have proper rights");
      return null;
    }
    System.out.println("Founded users");
    simpleUsers.stream()
        .forEach(System.out::println);

    return simpleUsers;
  }

  public String getAboutInfo(User simpleUser, Rights rights) {
    if (!rights.equals(Rights.SIMPLE_USER)) {
      System.out.println("User doesn't have proper rights");
      return null;
    }
    if(simpleUsers.contains(simpleUser)) {
      System.out.println("INFO ABOUT USER:\n " + "NAME: " + simpleUser.getName() + "\n ROLE: " + simpleUser.getRole());
      return simpleUser.getName() + simpleUser.getRole();
    } else{
      System.out.println("User " +simpleUser.getName()+ " hasn't been found in the list");
      return null;
    }
  }

  public List<User> createUser(User simpleUser, Rights rights) {
    if (!rights.equals(Rights.ADMIN)) {
      System.out.println("User doesn't have rights");
    }
    simpleUsers.add(simpleUser);
    System.out.println("Simple user " + simpleUser.getName() + " has been created ");
    return simpleUsers;
  }

  public void deleteUser(User simpleUser, Rights rights) {
    if (!rights.equals(Rights.ADMIN)) {
      System.out.println("User doesn't have rights");
      return;
    }
    simpleUsers.remove(simpleUser);
    System.out.println("User " + simpleUser.getName() + " has been deleted");
  }

  public void giveRights(User simpleUser, Rights rights) {
    if (!rights.equals(Rights.ADMIN)) {
      System.out.println("User doesn't have rights");
      return;
    }
    simpleUser.setRole(Rights.ADMIN);
    System.out.println("New ROLE is " + simpleUser.getRole());
  }

}
