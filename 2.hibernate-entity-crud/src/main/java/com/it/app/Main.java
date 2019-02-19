package com.it.app;

import com.it.dao.UserDAO;
import com.it.dao.impl.UserDAOImpl;
import com.it.model.User;
import com.it.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    private static final UserDAO userDAO = UserDAOImpl.getInstance();

    public static void main(String[] arguments) {
        performUserOperations();
    }


    private static void performUserOperations() {
        User user = userDAO.getOne(1L);
        if (user == null) {
            createUser("John Doe", 33);
        }
        User persistentUser = userDAO.getOne(1L);
        updateUserName(persistentUser, "James Doe");
        userDAO.delete(1L);
    }

    private static void updateUserName(User persistentUser, String name) {
        persistentUser.setName(name);
        userDAO.update(persistentUser);
    }

    private static void createUser(String name, Integer age) {
        User transientUser = new User();
        transientUser.setName(name);
        transientUser.setAge(age);
        userDAO.save(transientUser);
    }
}
