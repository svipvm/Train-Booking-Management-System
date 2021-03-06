package com.demo.service;

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
    public abstract Train getTrainByID(String id);
}
