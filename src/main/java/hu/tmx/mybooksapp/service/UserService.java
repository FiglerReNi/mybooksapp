package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.entity.User;
import javassist.NotFoundException;

public interface UserService {

    public User findByUsername(String username);

    public void registerUser(User user);

    public void userActivation(String code) throws NotFoundException;
}
