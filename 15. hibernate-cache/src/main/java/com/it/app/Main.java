package com.it.app;

import com.it.model.User;
import com.it.util.HibernateUtil;
import org.hibernate.Session;

public class Main {

    public static void main(String[] arguments) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            User transientUser = new User();
            transientUser.setName("John Doe");
            transientUser.setAge(33);
            session.save(transientUser);

            User persistentUser = session.get(User.class, 1L);
            persistentUser.setName("USER");
            persistentUser = session.get(User.class, 1L);
            persistentUser.setName("ANONYMOUS");

            session.update(persistentUser);
            session.update(persistentUser);
            //ONLY ONE INSERT WILL BE DONE
        }
    }
}
