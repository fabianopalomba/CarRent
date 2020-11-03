package com.rentfegh.servlet;

import com.rentfegh.dao.RentDAO;
import com.rentfegh.dao.RentDAOInterface;
import com.rentfegh.model.Rent;
import com.rentfegh.model.RentPK;
import com.rentfegh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import static java.lang.Integer.parseInt;

@WebServlet("/RentServlet")
public class RentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RentDAOInterface rentDAOInterface = RentDAO.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = parseInt(request.getParameter("selected"));
        String dataini = (String)request.getSession().getAttribute("dataini");
        String datafine = (String)request.getSession().getAttribute("datafine");
        String email = (String)request.getSession().getAttribute("email");
        Date dateinit = Date.valueOf(dataini);
        Date datefinish = Date.valueOf(datafine);
        System.out.println(id + " " + dataini + " " + dateinit + " " + datafine + " " + datefinish + " " + email + " ");
        rentDAOInterface.saveRent(email,id,dateinit,datefinish);
        response.sendRedirect("index.jsp");
    }
}
