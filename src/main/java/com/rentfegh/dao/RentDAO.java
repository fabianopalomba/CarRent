package com.rentfegh.dao;

import com.rentfegh.model.Car;
import com.rentfegh.model.Rent;
import com.rentfegh.model.RentPK;
import com.rentfegh.model.User;
import com.rentfegh.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentDAO implements RentDAOInterface{
    private static RentDAO rentDAO = null;
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static RentDAOInterface getInstance() {
        if (rentDAO == null)
            rentDAO = new RentDAO();
        return rentDAO;
    }

    @Override
    public void saveRent(String email, int carsid, Date date1, Date date2){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car c = session.get(Car.class,carsid);
        User u = session.get(User.class,email);
        RentPK rent1 = new RentPK(c,u,date1);
        Rent rent = new Rent(rent1,date2);
        session.save(rent);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Rent> findAllRent(){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Rent> rent = session.createCriteria(Rent.class).list();
        transaction.commit();
        session.close();
        return rent;
    }
    @Override
    public List<Rent> rentByEmail(String email){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class,email);
        List <Rent> rent1 = user.getRents();
        System.out.println(rent1.toString());
        //List<Rent> rent = session.createCriteria(Rent.class).add(Restrictions.eq("primaryKey.user.email",email)).list();
        transaction.commit();
        session.close();
        return rent1;
    }
    @Override
    public List<Car> rentByDate(Date date1, Date date2) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Rent.class);
        criteria.add(Restrictions.and(Restrictions.lt("primaryKey.initDate",date1),Restrictions.gt("finDate",date1)));
        criteria.setProjection(Projections.distinct(Projections.property("primaryKey.car")));
        Criteria criteria1 = session.createCriteria(Rent.class);
        criteria1.add(Restrictions.and(Restrictions.lt("primaryKey.initDate",date2),Restrictions.gt("finDate",date2)));
        criteria1.setProjection(Projections.distinct(Projections.property("primaryKey.car")));
        List<Car> list1 = criteria.list();
        list1.addAll(criteria1.list());
        List<Car> list2 = session.createCriteria(Rent.class).setProjection(Projections.distinct(Projections.property("primaryKey.car"))).list();
        list2.removeAll(list1);
        System.out.println(list2);
        transaction.commit();
        session.close();
        return list2;
    }
}
