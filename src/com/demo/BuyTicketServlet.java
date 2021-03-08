package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.ov.Coach;
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

@WebServlet(name = "BuyTicketServlet", urlPatterns = {"/content/BuyTicketServlet"})
public class BuyTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Train train = (Train) session.getAttribute("buy-train");
        Coach coach = (Coach) session.getAttribute("buy-coach");
        User user = (User) session.getAttribute("user");

        UserService userService = ServiceFactory.getUserServiceImpl();
        coach = userService.findCoachByIDAndGrade(coach.getID(), coach.getGrade());
//        train = userServiec.getTrainByID(train.getID());

        int flag = userService.addBook(user.getAccount(), train.getID(), coach.getSit_name());
        if(coach.getSit_total() > 0 && flag == 1) {
            boolean result = userService.subTicketNumber(coach.getID(), coach.getGrade());
            request.setAttribute("buy-message", "出票成功，请前往信息查看！");
        } else if(flag == 0){
            request.setAttribute("buy-message", "余票不足，请重新选购！");
        } else if(flag == 2){
            request.setAttribute("buy-message", "您已购买过该列车车票！");
        }
        request.getRequestDispatcher("buyying.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
