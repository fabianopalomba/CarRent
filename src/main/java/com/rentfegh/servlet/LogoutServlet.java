package com.rentfegh.servlet;

import com.rentfegh.dao.UserDAO;
import com.rentfegh.dao.UserDAOInterface;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;
    private final UserDAOInterface userDAOInterface = UserDAO.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("email")!=null  && request.getSession().getAttribute("email")!=""){
            request.getSession().removeAttribute("email");
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
