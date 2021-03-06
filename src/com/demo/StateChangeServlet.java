package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StateChangeServlet", urlPatterns = {"/content/StateChangeServlet"})
public class StateChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String loginState = (String) session.getAttribute("user-login");

//        System.out.println(account + " - " + password);
        if ("success".equals(loginState)) {
            response.sendRedirect("message.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
