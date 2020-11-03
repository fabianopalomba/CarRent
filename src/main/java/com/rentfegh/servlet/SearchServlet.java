package com.rentfegh.servlet;

import com.rentfegh.dao.RentDAO;
import com.rentfegh.dao.RentDAOInterface;
import com.rentfegh.model.Car;
import com.rentfegh.model.Rent;
import com.rentfegh.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;

import javax.security.auth.login.Configuration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.rentfegh.util.HibernateUtil.getSessionFactory;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RentDAOInterface rentDAOInterface = RentDAO.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String dataini = request.getParameter("dataini");
        String datafine = request.getParameter("datafine");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateinit = formatter.parse(dataini);
            Date datefinish = formatter.parse(datafine);
            if (datefinish.after(dateinit) && dateinit.after(new Date())) {
                List<Car> car = rentDAOInterface.rentByDate(dateinit,datefinish);
                    request.getSession().setAttribute("cars",car);
                    request.getSession().setAttribute("dataini",dataini);
                    request.getSession().setAttribute("datafine",datafine);
                    response.sendRedirect("select-car.jsp");
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
