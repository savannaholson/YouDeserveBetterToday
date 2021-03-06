package com.nancyadam.ydbt.persistence;

import com.nancyadam.ydbt.entity.Users;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Nancy
 * @version 1.0 2/28/2016
 */
public class UsersDoaWithHibernate implements UsersDoa {
   // private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        return users;
    }

    @Override
    public void updateUser(Users user) {

    }

    @Override
    public void deleteUser(Users user) {

    }

    @Override
    public int addUser(Users user) {

        Session session = SessionFactoryProvider1.getSessionFactory().openSession();
        Transaction tx = null;
        Integer userId = 0;
        try {
            tx = session.beginTransaction();
            userId = (Integer) session.save("Users", user);
//            tx.commit();
            //log.info("Added user: " + user + " with id of: " + userId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userId;
    }

}
