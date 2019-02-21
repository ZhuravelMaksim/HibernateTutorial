package com.it.app;

import com.it.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] arguments) {

        for (int i = 0; i < 100; i++) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Session:" + i + ":" + session);
        }
    }
}
