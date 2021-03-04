package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.ov.Train;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryTrainServlet", urlPatterns = {"/content/QueryTrainServlet"})
public class QueryTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String beingPos = request.getParameter("begin-pos");
        String endPos = request.getParameter("end-pos");
        String dateStr = request.getParameter("date-sel");
//        System.out.println(beingPos + endPos + dateStr);

        request.setAttribute("begin-pos", beingPos);
        request.setAttribute("end-pos", endPos);
        request.setAttribute("date-sel", dateStr);
        request.setAttribute("isSearch", true);

        UserService userService = ServiceFactory.getUserServiceImpl();
        List<Train> trains = userService.findAllByDemand(beingPos, endPos, dateStr);
        userService.close();

        request.setAttribute("trains", trains);

        request.getRequestDispatcher("/content/booking.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
