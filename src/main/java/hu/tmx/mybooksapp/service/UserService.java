package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.entity.User;

public interface UserService {

    User getUserByUsername(String username);
}
