package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.ov.User;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserModifyServlet", urlPatterns = {"/content/UserModifyServlet"})
public class UserModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String name = request.getParameter("uname");
        String sex = request.getParameter("usex");
        String ID_card = request.getParameter("uidcard");
        String phone_number = request.getParameter("uphone");
        String old_password = request.getParameter("password");
        String password = request.getParameter("modifypwd");

        UserService userService = ServiceFactory.getUserServiceImpl();
        boolean flag = userService.login(user.getAccount(), old_password);
        String message = "";

        if(flag) {
            if(!"".equals(name)) {
                userService.modifyInform(user.getAccount(), "name", name);
            }
            if(!"".equals(sex)) {
                userService.modifyInform(user.getAccount(), "sex", sex);
            }
            if(!"".equals(ID_card)) {
                userService.modifyInform(user.getAccount(), "ID_card", ID_card);
            }
            if(!"".equals(phone_number)) {
                userService.modifyInform(user.getAccount(), "phone_number", phone_number);
            }
            if(!"".equals(password)) {
                userService.modifyInform(user.getAccount(), "password", password);
            }
            message = "修改成功！";
        } else {
            message = "原密码错误，请重新输入！";
        }
        request.setAttribute("user-message", message);
        request.getRequestDispatcher("modify.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
