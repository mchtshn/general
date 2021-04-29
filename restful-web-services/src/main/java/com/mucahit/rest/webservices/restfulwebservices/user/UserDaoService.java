package com.mucahit.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();

    private static int userCount = 3;

    static {
        userList.add(new User(1, "Mucahit", new Date()));
        userList.add(new User(2, "Fatih", new Date()));
        userList.add(new User(3, "Kamil", new Date()));
    }

    public List<User> findAll() {
        return userList;
    }

    public User save(User user) {
        if (user.getId() == null)
            user.setId(++userCount);
        userList.add(user);

        return user;
    }

    public User findOne(int id) {
        for (User user : userList) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
