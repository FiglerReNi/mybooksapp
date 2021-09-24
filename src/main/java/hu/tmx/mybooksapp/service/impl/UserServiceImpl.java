package hu.tmx.mybooksapp.service.impl;

import hu.tmx.mybooksapp.entity.User;
import hu.tmx.mybooksapp.repository.UserRepo;
import hu.tmx.mybooksapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
