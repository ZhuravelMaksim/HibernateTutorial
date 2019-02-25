package com.it.app;

import com.it.dao.UserDAO;
import com.it.dao.impl.UserDAOImpl;
import com.it.model.User;

public class Main {
    private static final UserDAO userDAO = UserDAOImpl.getInstance();

    public static void main(String[] arguments) {
        secondLevelCache();
    }

    private static void secondLevelCache() {
        User user = userDAO.getOne(1L);
        if (user == null) {
            createUser("John Doe", 33);
        }
        User persistentUser = userDAO.getOne(1L);

        persistentUser.setName("James Doe");
        userDAO.update(persistentUser);

        User cachedUser = userDAO.getOne(1L);
        cachedUser = userDAO.getOne(cachedUser.getId());

        persistentUser.setName("John Doe");
        userDAO.update(persistentUser);

        cachedUser = userDAO.getOne(1L);
    }

    private static void createUser(String name, Integer age) {
        User transientUser = new User();
        transientUser.setName(name);
        transientUser.setAge(age);
        userDAO.save(transientUser);
    }
}
