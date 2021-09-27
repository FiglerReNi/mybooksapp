package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.entity.User;

public interface UserService {

    public User findByUsername(String username);

    public String registerUser(User user);

    public String userActivation(String code);
}
