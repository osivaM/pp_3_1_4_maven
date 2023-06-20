package com.github.osivaM.pp_3_1_4_maven.services;

import com.github.osivaM.pp_3_1_4_maven.models.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    User getUserByName(String name);

    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

}
