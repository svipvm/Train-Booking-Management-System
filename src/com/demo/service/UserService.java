package com.demo.service;

import com.demo.ov.Book;
import com.demo.ov.Coach;
import com.demo.ov.Train;
import com.demo.ov.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public abstract void close();
    public abstract List<Train> findAllByDemand(String beginPos, String endPos, String dateStr);
    public abstract boolean login(String account, String password);
    public abstract User getUserByAccount(String account);
    public abstract void updateLoginTimeByAccount(String account);
    public abstract List<Train> getNowBookingByAccount(String account);
    public abstract List<Train> getLastBookingByAccount(String account);
    public abstract Train getTrainByID(String id);
    public abstract boolean subTicketNumber(String id, int grade);
    public abstract int addBook(String account, String id, String sitName);
    public abstract List<Coach> findCoachByID(String id);
    public abstract Coach findCoachByIDAndGrade(String id, int grade);
    public abstract Book findBookByAccountAndTrainID(String account, String id);
    public abstract Book findBookByID(String id);
    public abstract Coach findCoachByIDAndSitName(String train_id, String sit_name);
    public abstract int subBook(String account, String id, String sit_name);
    public abstract boolean addTicketNumber(String id, int grade);
}
