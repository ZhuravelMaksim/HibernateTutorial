package com.it.app;

import com.it.dao.UserDAO;
import com.it.dao.impl.UserDAOImpl;
import com.it.model.User;
import com.it.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] arguments) {
        UserDAO userDAO = UserDAOImpl.getInstance();

        User transientUser = new User();
        transientUser.setName("User");
        transientUser.setAge(10);
        userDAO.save(transientUser);

        User persistentUser = userDAO.getOne(1L);

        persistentUser.setName("Admin");
        userDAO.update(persistentUser);

        userDAO.delete(1L);
    }
}
