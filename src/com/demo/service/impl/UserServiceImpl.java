package com.demo.service.impl;

import com.demo.dao.UserDAO;
import com.demo.factory.DAOFactory;
import com.demo.ov.Book;
import com.demo.ov.Coach;
import com.demo.ov.Train;
import com.demo.ov.User;
import com.demo.service.UserService;
import com.demo.util.DBConnection;

import java.sql.Connection;
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
    public int addBook(String account, String id, String sitName) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        boolean flag = false;
        try {
            flag = userDAO.insertBook(account, id, sitName);
        } catch (Exception e) {
//            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
            return 2;
        }
        return flag ? 1 : 0;
    }

    @Override
    public boolean subTicketNumber(String id, int grade) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        boolean flag = false;
        try {
            flag = userDAO.updateSubSitTotalByTrainID(id, grade);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public Coach findCoachByIDAndSitName(String train_id, String sit_name) {
        Coach coach = new Coach();
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        try {
            coach = userDAO.selectCoachByIDAndSitName(train_id, sit_name);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return coach;
    }

    @Override
    public int subBook(String account, String id, String sit_name) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        boolean flag = false;
        try {
            flag = userDAO.dropBook(account, id, sit_name);
        } catch (Exception e) {
//            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
            return 2;
        }
        return flag ? 1 : 0;
    }

    @Override
    public boolean addTicketNumber(String id, int grade) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        boolean flag = false;
        try {
            flag = userDAO.updateAddSitTotalByTrainID(id, grade);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public Book findBookByID(String id) {
        Book book = null;
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        try {
            book = userDAO.selectBookByID(id);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return book;
    }

    @Override
    public Book findBookByAccountAndTrainID(String account, String id) {
        Book book = null;
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        try {
            book = userDAO.selectBookByAccountAndTrainID(account, id);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return book;
    }

    @Override
    public Coach findCoachByIDAndGrade(String id, int grade) {
        Coach coach = new Coach();
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        try {
            coach = userDAO.selectCoachByIDAndGrade(id, grade);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return coach;
    }

    @Override
    public List<Coach> findCoachByID(String id) {
        List<Coach> coaches = null;
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        try {
            coaches = userDAO.selectCoachByID(id);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return coaches;
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
    public List<Train> getLastBookingByAccount(String account) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        List<Train> trains = null;
        try {
            trains = userDAO.selectLastTrainByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return trains;
    }

    @Override
    public List<Train> getNowBookingByAccount(String account) {
        Connection conn = dbc.getConnection();
        UserDAO userDAO = DAOFactory.getUserDAOImpl(conn);
        List<Train> trains = null;
        try {
            trains = userDAO.selectNowTrainByAccount(account);
        } catch (Exception e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return trains;
    }

}
