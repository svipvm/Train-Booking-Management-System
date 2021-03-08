package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.ov.Coach;
import com.demo.ov.User;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ReturnTicketServlet", urlPatterns = {"/content/ReturnTicketServlet"})
public class ReturnTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Coach coach = (Coach) session.getAttribute("return-coach");
        User user = (User) session.getAttribute("user");
        UserService userService = ServiceFactory.getUserServiceImpl();

        int flag = userService.subBook(user.getAccount(), coach.getID(), coach.getSit_name());
        if(coach.getSit_total() > 0 && flag == 1) {
            boolean result = userService.addTicketNumber(coach.getID(), coach.getGrade());
            request.setAttribute("rtn-message", "退票成功，欢迎下次选购！");
        } else if(flag == 0){
            request.setAttribute("rtn-message", "余票不足，请重新选购！");
        } else if(flag == 2){
            request.setAttribute("rtn-message", "您已购买过该列车车票！");
        }
        request.getRequestDispatcher("bTicket.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
