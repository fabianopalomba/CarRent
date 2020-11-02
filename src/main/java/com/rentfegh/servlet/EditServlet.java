package com.rentfegh.servlet;

import com.rentfegh.dao.UserDAO;
import com.rentfegh.dao.UserDAOInterface;
import com.rentfegh.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAOInterface userDAOInterface = UserDAO.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(firstName, lastName, phone, email, password);
        userDAOInterface.updateUser(user);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
