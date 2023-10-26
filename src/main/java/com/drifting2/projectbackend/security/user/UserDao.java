package com.drifting2.projectbackend.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}