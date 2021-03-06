package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.ov.Train;
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
        List<Train> trains = (List<Train>) session.getAttribute("trains");

        if(trains == null) return;
        int index = 0;
        Train train = trains.get(index);
        while(train == null && index + 1 < trains.size()) {
            train = trains.get(++index);
        }

        UserService userService = ServiceFactory.getUserServiceImpl();
        assert train != null;
        train = userService.getTrainByID(train.getID());
        request.setAttribute("buy-train", train);

        request.getRequestDispatcher("buyying.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
