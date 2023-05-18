package com.webbooksolutions.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    static int userId = 0;
    static {
        users.add(new User(++userId, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userId, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userId, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User addUser(User user) {
        user.setId(++userId);
        users.add(user);
        return user;
    }

    public void deleteUserById(Integer id) {
        users.removeIf(user->user.getId().equals(id));
    }
}