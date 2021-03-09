package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.ov.User;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegisterServlet", urlPatterns = {"/content/UserRegisterServlet"})
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String account = request.getParameter("account");
        String sex = request.getParameter("usex");
        String password = request.getParameter("password");
        String uidcard = request.getParameter("uidcard");
        String uphone = request.getParameter("uphone");

        UserService userService = ServiceFactory.getUserServiceImpl();
        boolean flag = userService.equalUserAccount(account);
        String message = "";

        System.out.println(account);

        if(flag) {
            User user = new User();
            user.setAccount(account);
            user.setName(account);
            user.setSex(sex);
            user.setPassword(password);
            user.setID_card(uidcard);
            user.setPhone_number(uphone);
            flag = userService.addUser(user);
            if(flag) {
                message = "注册成功，请返回登录！";
            } else {
                message = "注册失败，请重新注册！";
            }
        } else {
            message = "该用户已被注册，请更改账号！";
        }
        request.setAttribute("user-message", message);
        request.getRequestDispatcher("register.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
