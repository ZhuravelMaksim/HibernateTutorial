package com.it.dao.impl;

import com.it.dao.UserDAO;
import com.it.model.User;

public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {
    private static UserDAOImpl instance;

    private UserDAOImpl() {
        super(User.class);
    }

    synchronized public static UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }
}
