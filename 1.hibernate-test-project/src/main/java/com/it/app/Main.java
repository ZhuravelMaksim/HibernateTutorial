package com.it.app;

import com.it.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] arguments) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println(session.toString());
        }
    }
}
