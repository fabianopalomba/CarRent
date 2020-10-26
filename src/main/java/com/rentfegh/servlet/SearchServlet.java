package com.rentfegh.servlet;

import com.rentfegh.dao.UserDAO;
import com.rentfegh.dao.UserDAOInterface;
import com.rentfegh.model.Car;
import com.rentfegh.model.User;
import com.rentfegh.util.HibernateUtil;
import org.hibernate.*;

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
        System.out.println(dataini);
        String datafine = request.getParameter("datafine");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateinit = formatter.parse(dataini);
            Date datefinish = formatter.parse(datafine);
            if (datefinish.after(dateinit) && dateinit.after(new Date())) {
                try {
                    String hql = "select A.cars_id,A.brand,A.model from feghrent.cars as A join feghrent.rent as P on A.cars_id=P.id where A.CARS_ID NOT IN (" +
                            "SELECT C.CARS_ID FROM feghrent.cars as c  left join feghrent.rent as r on c.cars_id=r.id where :dateinit  BETWEEN R.INITDATE AND R.FINDATE UNION"+
                    " SELECT C.CARS_ID FROM feghrent.cars as c  left join feghrent.rent as r on c.cars_id=r.id where :datefinish  BETWEEN R.INITDATE AND R.FINDATE ) UNION" +
                    " SELECT C.cars_id,C.brand,C.model FROM feghrent.cars as c  left join feghrent.rent as r on c.cars_id=r.id where initDate is null and finDate is null";
                    SQLQuery query = session.createSQLQuery(hql);
                    query.setParameter("dateinit", dateinit);
                    query.setParameter("datefinish", datefinish);
                    query.addEntity(Car.class);
                     List<Car> results = query.list();
                    request.getSession().setAttribute("cars",results);
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
