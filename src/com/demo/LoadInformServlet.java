package com.demo;

import com.demo.factory.ServiceFactory;
import com.demo.ov.Book;
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
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "LoadInformServlet", urlPatterns = {"/content/LoadInformServlet"})
public class LoadInformServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Train> trains_now = null;
        List<Train> trains_last = null;
        List<Book> books_now = new LinkedList<>();
        List<Book> books_last = new LinkedList<>();
        User user = (User) session.getAttribute("user");

        UserService userService = ServiceFactory.getUserServiceImpl();
        trains_now = userService.getNowBookingByAccount(user.getAccount());
        for(Train train : trains_now) {
            books_now.add(userService.findBookByAccountAndTrainID(user.getAccount(), train.getID()));
        }
        trains_last = userService.getLastBookingByAccount(user.getAccount());
        for(Train train : trains_last) {
            books_last.add(userService.findBookByAccountAndTrainID(user.getAccount(), train.getID()));
        }

        request.setAttribute("ticket-now", trains_now);
        request.setAttribute("book-now", books_now);
        request.setAttribute("ticket-last", trains_last);
        request.setAttribute("book-last", books_last);
    }
}
