package com.rentfegh.dao;

import com.rentfegh.model.Rent;
import com.rentfegh.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
    public void saveRent(Rent rent){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
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
        List<Rent> rent = session.createCriteria(Rent.class).add(Restrictions.eq("id",email)).list();
        transaction.commit();
        session.close();
        return rent;
    }
    @Override
    public List<Rent> rentByDate(Date date1, Date date2) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Rent.class);
        criteria.add(Restrictions.and((Restrictions.lt("initDate",date1)),(Restrictions.gt("finDate",date1))));
        Criteria criteria1 = session.createCriteria(Rent.class);
        criteria1.add(Restrictions.and((Restrictions.lt("initDate",date2)),(Restrictions.gt("finDate",date2))));
        List<Rent> list1 = criteria.list();
        list1.addAll(criteria1.list());
        return  list1;
    }
}
