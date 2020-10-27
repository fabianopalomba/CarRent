package com.rentfegh.servlet;

import com.rentfegh.dao.UserDAO;
import com.rentfegh.dao.UserDAOInterface;
import com.rentfegh.model.Car;
import com.rentfegh.model.Rent;
import com.rentfegh.model.User;
import com.rentfegh.util.HibernateUtil;
import javafx.concurrent.Task;
import org.hibernate.*;
import org.hibernate.Criteria;
import com.rentfegh.model.Car;
import com.rentfegh.model.Rent;
import com.rentfegh.model.RentPK;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = this.sessionFactory.openSession();
        String dataini = request.getParameter("dataini");
        String datafine = request.getParameter("datafine");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateinit = formatter.parse(dataini);
            Date datefinish = formatter.parse(datafine);
            if (datefinish.after(dateinit) && dateinit.after(new Date())) {
                try {
                    Criteria criteria = session.createCriteria(Rent.class);
                    criteria.add(Restrictions.and((Restrictions.lt("initDate",dateinit)),(Restrictions.gt("finDate",dateinit))));
                    Criteria criteria1 = session.createCriteria(Rent.class);
                    criteria1.add(Restrictions.and((Restrictions.lt("initDate",datefinish)),(Restrictions.gt("finDate",datefinish))));
                    Projection p = Projections.property("id");
                    List<Integer> rent = criteria.setProjection(p).list();
                    rent.addAll(criteria1.setProjection(p).list());
                    List<Car> car = session.createCriteria(Car.class).add(Restrictions.not(Restrictions.in("id",rent))).list();
                    request.getSession().setAttribute("cars",car);
                    request.getSession().setAttribute("dataini",dataini);
                    request.getSession().setAttribute("datafine",datafine);
                    response.sendRedirect("select-car.jsp");
                }
                catch (Exception exc){
                    exc.printStackTrace();
                }

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
