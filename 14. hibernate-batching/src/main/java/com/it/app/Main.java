package com.it.app;

import com.it.model.User;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] arguments) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Long time = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                User user = new User();
                user.setName("User" + i);
                session.save(user);
                if (i % 50 == 0) {
                    session.flush();
                    session.clear();
                    time = getDeltaTime(time, i);
                }
            }
            transaction.commit();
        }
    }

    private static Long getDeltaTime(Long time, int i) {
        Long currentTime;
        currentTime = System.currentTimeMillis();
        Long delta = currentTime - time;
        if (delta > 1) {
            System.out.println("TIME:" + i + ":" + delta);
        }
        time = currentTime;
        return time;
    }
}
