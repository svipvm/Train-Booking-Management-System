package com.demo.service.impl;

import com.demo.dao.UserDAO;
import com.demo.factory.DAOFactory;
import com.demo.ov.Train;
import com.demo.ov.User;
import com.demo.service.UserService;
import com.demo.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
    private final DBConnection dbc = new DBConnection();

    @Override
    public void close() {
        dbc.close();
    }

    @Override
    public List<Train> findAllByDemand(String beginPos, String endPos, String dateStr) {
        List<Train> trains = new LinkedList<>();
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        try {
            trains = userDAO.selectTrainByDemand(beginPos, endPos, dateStr);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return trains;
    }

    @Override
    public Train getTrainByID(String id) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        Train train = null;
        try {
            train = userDAO.selectTrainByID(id);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return train;
    }

    @Override
    public boolean login(String account, String password) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        boolean flag = false;
        try {
            flag = userDAO.equalAccountPassword(account, password);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public User getUserByAccount(String account) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        User user = null;
        try {
            user = userDAO.selectUserByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }

    @Override
    public void updateLoginTimeByAccount(String account) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        boolean flag = false;
        try {
            flag = userDAO.updateLastLoginTime(account);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<Train> getNowBookingByAccount(String account) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        List<Train> trains = userDAO.selectNowTrainByAccount(account);

        return null;
    }

}
