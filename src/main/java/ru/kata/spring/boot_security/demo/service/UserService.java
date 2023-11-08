package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findByUsername(String username);

    User findUserById(Long id);

    void update(User user);

    void saveUser(User user);

    boolean deleteUserById(Long id);

}