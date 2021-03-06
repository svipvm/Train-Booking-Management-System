package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.ov.Train;
import com.demo.ov.User;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserLoginServlet", urlPatterns = {"/content/UserLoginServlet"})
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        UserService userService = ServiceFactory.getUserServiceImpl();
        boolean flag = false;
        flag = userService.login(account, password);

        if (flag) {
            HttpSession session = request.getSession();
            User user = userService.getUserByAccount(account);
            session.setAttribute("user", user);
//            List<Train> nowBooking = userService.getNowBookingByAccount(account);
//            session.setAttribute("now-booking", nowBooking);
            session.setAttribute("user-login", "success");
            userService.updateLoginTimeByAccount(account);
            response.sendRedirect("message.jsp");
        } else {
            request.setAttribute("user-message", "账号、密码错误！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
