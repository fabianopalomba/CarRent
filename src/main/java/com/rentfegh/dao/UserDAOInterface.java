package com.rentfegh.dao;

import java.util.List;

import com.rentfegh.model.Car;
import com.rentfegh.model.User;

public interface UserDAOInterface {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(String email);
    User viewUser(String email);

    boolean validate(String userName, String password);
}
