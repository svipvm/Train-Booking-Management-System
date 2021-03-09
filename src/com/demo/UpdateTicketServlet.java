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
import java.util.List;

@WebServlet(name = "UpdateTicketServlet", urlPatterns = {"/content/UpdateTicketServlet"})
public class UpdateTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = ServiceFactory.getUserServiceImpl();
        User user = (User) session.getAttribute("user");

        if(user != null && userService.login(user.getAccount(), user.getPassword())) {
            String sitName = (String) request.getParameter("sit");
            List<Train> trains = (List<Train>) session.getAttribute("trains");
            List<List<Coach>> coaches = (List<List<Coach>>) session.getAttribute("coaches");

            int index = sitName.indexOf("-", 0);
            int x = Integer.parseInt(sitName.substring(0, index));
            int y = Integer.parseInt(sitName.substring(index + 1));

//          assert train != null;
            Train train = trains.get(x);
            session.setAttribute("buy-train", train);
            List<Coach> coach = (List<Coach>) userService.findCoachByID(train.getID());
            session.setAttribute("buy-coach", coach.get(y));

            request.getRequestDispatcher("bTicket.jsp").forward(request, response);
        } else {
            request.setAttribute("user-message", "请登录后购票！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
