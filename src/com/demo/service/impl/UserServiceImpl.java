package com.demo.service.impl;

import com.demo.dao.UserDAO;
import com.demo.factory.DAOFactory;
import com.demo.ov.Train;
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
}
