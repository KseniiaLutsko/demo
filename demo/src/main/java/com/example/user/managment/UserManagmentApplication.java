package com.example.user.managment;

import com.example.user.managment.controller.UserController;
import com.example.user.managment.model.AdminUser;
import com.example.user.managment.model.Rights;
import com.example.user.managment.model.SimpleUser;
import com.example.user.managment.service.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.user.managment"})
@ComponentScan({"com.example.user.managment"})
public class UserManagmentApplication {

  public static void main(String[] args) {
    List<SimpleUser> simpleUsers = new ArrayList<>();
    UserController user = new UserController(new UserService(simpleUsers));
    AdminUser quacker = new AdminUser();
    quacker.setName("Quacker");
    quacker.setRole(Rights.ADMIN);

    SimpleUser tom = new SimpleUser();
    tom.setName("Tom");
    tom.setRole(Rights.SIMPLE_USER);

    SimpleUser jerry = new SimpleUser();
    jerry.setName("Jerry");
    jerry.setRole(Rights.SIMPLE_USER);

    SimpleUser topsy = new SimpleUser();
    topsy.setName("Topsy");
    topsy.setRole(Rights.SIMPLE_USER);

    user.createUser(jerry, quacker.getRole());
    user.createUser(tom, quacker.getRole());
    user.createUser(topsy, quacker.getRole());
    //user.deleteUser(jerry, quacker.getRole());
    user.getAboutInfo(jerry, jerry.getRole());
    user.giveUserRights(jerry, quacker.getRole());
    user.getAboutInfo(jerry, jerry.getRole());
    user.getUsers(tom.getRole());
  }

}
