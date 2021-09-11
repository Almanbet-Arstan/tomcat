package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface userDao {
    User saveUser(User user);
    List<User> getAll();
}
