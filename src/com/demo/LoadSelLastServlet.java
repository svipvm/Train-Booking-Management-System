package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.ov.Book;
import com.demo.ov.Coach;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoadSelLastServlet", urlPatterns = {"/content/LoadSelLastServlet"})
public class LoadSelLastServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ID = request.getParameter("bookID");
        HttpSession session = request.getSession();
        UserService userService = ServiceFactory.getUserServiceImpl();
        Book book = userService.findBookByID(ID);
        Coach coach = userService.findCoachByIDAndSitName(book.getTrain_ID(), book.getSit_name());

//        System.out.println(coach.getID());
//        Train train = (Train) session.getAttribute("buy-train");
//        session.setAttribute("");
        session.setAttribute("delete-coach", coach);

        response.sendRedirect("dTicket.jsp");
    }
}
