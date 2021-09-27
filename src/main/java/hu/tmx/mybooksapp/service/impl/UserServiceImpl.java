package hu.tmx.mybooksapp.service.impl;

import hu.tmx.mybooksapp.entity.Role;
import hu.tmx.mybooksapp.entity.User;
import hu.tmx.mybooksapp.repository.RoleDao;
import hu.tmx.mybooksapp.repository.UserDao;
import hu.tmx.mybooksapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private final String USER_ROLE = "USER";

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public String registerUser(User user) {
        User userCheck = userDao.findByEmail(user.getEmail());
        if(userCheck != null) {
            return "alreadyExist";
        }
        Role userRole = roleDao.findByRole(USER_ROLE);
        if(userRole != null) {
            user.getRoles().add(userRole);
        }else {
            user.addRole(USER_ROLE);
        }
        user.setEnabled(false);
        user.setActivation(generatedKey());
        userDao.save(user);
        return "ok";
    }

    private String generatedKey() {
        Random random = new Random();
        char[] word = new char[16];
        for (int i = 0; i < word.length; i++) {
            word[i] = (char) ('a' + random.nextInt(26));
        }
        return new String(word);
    }

    @Override
    public String userActivation(String code) {
        User user = userDao.findByActivation(code);
        if(user == null) {
            System.out.println("hiba");
            return "noResult";
        }
        user.setEnabled(true);
        user.setActivation("");
        userDao.save(user);
        return "ok";
    }
}
