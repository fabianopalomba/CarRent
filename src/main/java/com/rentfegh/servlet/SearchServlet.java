package com.rentfegh.servlet;

import com.rentfegh.model.Car;
import com.rentfegh.model.Rent;
import com.rentfegh.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
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
                    List<Car> car = session.createCriteria(Car.class).list();
                            //.add(Restrictions.not(Restrictions.in("id",rent))).list();
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
