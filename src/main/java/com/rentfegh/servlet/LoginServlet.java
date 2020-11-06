package com.rentfegh.servlet;

import com.rentfegh.dao.UserDAO;
import com.rentfegh.dao.UserDAOInterface;
import com.rentfegh.model.Rent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;
    private final UserDAOInterface userDAOInterface = UserDAO.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (userDAOInterface.validate(username,password)){
            request.getSession().setAttribute("email", username);
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("login-failed.jsp");
        }

    }
}
