package com.rentfegh.servlet;

import com.rentfegh.dao.RentDAO;
import com.rentfegh.dao.RentDAOInterface;
import com.rentfegh.dao.UserDAO;
import com.rentfegh.dao.UserDAOInterface;
import com.rentfegh.model.Rent;
import com.rentfegh.model.User;
import com.rentfegh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAOInterface userDAOInterface = UserDAO.getInstance();
    private final RentDAOInterface rentDAOInterface = RentDAO.getInstance();
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String)request.getSession().getAttribute("email");
        if(email.equals("") ||email==null){
            request.getRequestDispatcher("registration.jsp").forward(request,response);
        }
        else{
            User user = userDAOInterface.viewUser(email);
            List<Rent> rents = rentDAOInterface.rentByEmail(email);
            Session session = this.sessionFactory.openSession();
            System.out.println(rents);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("view-data.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
