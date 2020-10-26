package com.rentfegh.dao;

import com.rentfegh.model.Car;
import com.rentfegh.model.User;
import com.rentfegh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.rentfegh.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserDAO implements UserDAOInterface {

    private static UserDAO userDAO = null;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Override
    public void saveUser(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(String email) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, email);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User viewUser(String email) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, email);
        transaction.commit();
        session.close();
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> userList = session.createCriteria(User.class).list();
        transaction.commit();
        session.close();
        return userList;
    }

    @SuppressWarnings("unchecked")
    public List<Car> findAllCars() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Car> carList = session.createCriteria(Car.class).list();
        transaction.commit();
        session.close();
        return carList;
    }


    public static UserDAOInterface getInstance() {
        if (userDAO == null)
            userDAO = new UserDAO();
        return userDAO;
    }

    public boolean validate(String email, String password) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        transaction.commit();
        return false;
    }
}
