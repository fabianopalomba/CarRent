package com.rentfegh.servlet;

import com.rentfegh.model.Car;
import com.rentfegh.model.Rent;
import com.rentfegh.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet("/RentServlet")
public class RentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = this.sessionFactory.openSession();
        Integer id = parseInt(request.getParameter("selected"));
        System.out.println(id);
        String dataini = (String)request.getSession().getAttribute("dataini");
        System.out.println(dataini);
        String datafine = (String)request.getSession().getAttribute("datafine");
        String email = (String)request.getSession().getAttribute("email");
        System.out.println(email);
        Date dateinit = Date.valueOf(dataini);
        Date datefinish = Date.valueOf(datafine);
        try {
            Rent rent = new Rent(email,id, dateinit, datefinish);
            Transaction transaction = session.beginTransaction();
            session.save(rent);
            transaction.commit();
            response.sendRedirect("index.jsp");
        }
        catch (Exception exc){
            exc.printStackTrace();
        }

    }
}
