package com.example.user.managment.service;

import com.example.user.managment.model.Rights;
import com.example.user.managment.model.SimpleUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

  List<SimpleUser> simpleUsers;

  public UserService(List<SimpleUser> simpleUsers) {
    this.simpleUsers = simpleUsers;
  }

  public List<SimpleUser> getUsers(Rights rights) {
    if (!rights.equals(Rights.SIMPLE_USER)) {
      System.out.println("User doesn't have proper rights");
      return null;
    }
    System.out.println("Founded users");
    simpleUsers.stream()
        .forEach(System.out::println);

    return simpleUsers;
  }

  public String getAboutInfo(SimpleUser simpleUser, Rights rights) {
    if (!rights.equals(Rights.SIMPLE_USER)) {
      System.out.println("User doesn't have proper rights");
      return null;
    }
    System.out.println("INFO ABOUT USER:\n " + "NAME: " + simpleUser.getName() + "\n ROLE: " + simpleUser.getRole());
    return simpleUser.getName() + simpleUser.getRole();
  }

  public List<SimpleUser> createUser(SimpleUser simpleUser, Rights rights) {
    if (!rights.equals(Rights.ADMIN)) {
      System.out.println("User doesn't have rights");
    }
    simpleUsers.add(simpleUser);
    System.out.println("Simple user " + simpleUser.getName() + " has been created ");
    return simpleUsers;
  }

  public void deleteUser(SimpleUser simpleUser, Rights rights) {
    if (!rights.equals(Rights.ADMIN)) {
      System.out.println("User doesn't have rights");
      return;
    }
    simpleUsers.remove(simpleUser);
    System.out.println("User " + simpleUser.getName() + " has been deleted");
  }

  public void giveRights(SimpleUser simpleUser, Rights rights) {
    if (!rights.equals(Rights.ADMIN)) {
      System.out.println("User doesn't have rights");
      return;
    }
    simpleUser.setRole(Rights.ADMIN);
    System.out.println("ROLE is " + simpleUser.getRole());
  }

}
