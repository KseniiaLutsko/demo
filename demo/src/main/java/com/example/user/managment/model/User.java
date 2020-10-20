package com.example.user.managment.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class User {

  @Column(nullable = false)
  private String name;
  @Column
  private Rights role;

  @Override
  public String toString() {
    return "User{" + "name='" + name + '\'' + ", role=" + role + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name) && role == user.role;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, role);
  }
}
