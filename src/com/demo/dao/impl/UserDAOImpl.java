package com.demo.dao.impl;

import com.demo.dao.UserDAO;
import com.demo.ov.Book;
import com.demo.ov.Coach;
import com.demo.ov.Train;
import com.demo.ov.User;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class UserDAOImpl implements UserDAO {
    Connection conn = null;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean insertBook(String account, String id, String sitName) throws SQLException {
        PreparedStatement psmt = null;
        String sql = "insert into book values(?, ?, ?, ?)";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, id + account);
        psmt.setString(2, id);
        psmt.setString(3, account);
        psmt.setString(4, sitName);
        int flag = psmt.executeUpdate();
        return flag != 0;
    }

    @Override
    public List<Coach> selectCoachByID(String id) throws SQLException {
        List<Coach> coaches = new LinkedList<>();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from coach where ID=? order by grade";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, id);
        rsts = psmt.executeQuery();
        while(rsts.next()) {
            Coach coach = new Coach();
            coach.setID(rsts.getString("ID"));
            coach.setGrade(rsts.getInt("grade"));
            coach.setSit_name(rsts.getString("sit_name"));
            coach.setSit_total(rsts.getInt("sit_total"));
            coach.setSit_price(rsts.getFloat("sit_price"));
            coaches.add(coach);
        }
        return coaches;
    }

    @Override
    public Coach selectCoachByIDAndSitName(String train_id, String sit_name) throws SQLException {
        Coach coach = new Coach();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from coach where ID=? and sit_name=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, train_id);
        psmt.setString(2, sit_name);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            coach.setID(rsts.getString("ID"));
            coach.setGrade(rsts.getInt("grade"));
            coach.setSit_name(rsts.getString("sit_name"));
            coach.setSit_total(rsts.getInt("sit_total"));
            coach.setSit_price(rsts.getFloat("sit_price"));
        }
        return coach;
    }

    @Override
    public boolean dropBook(String account, String id, String sit_name) throws SQLException {
        PreparedStatement psmt = null;
        String sql = "delete from book where account=? and train_ID=? and sit_name=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        psmt.setString(2, id);
        psmt.setString(3, sit_name);
        int flag = psmt.executeUpdate();
        return flag != 0;
    }

    @Override
    public boolean updateAddSitTotalByTrainID(String id, int grade) throws SQLException {
        PreparedStatement psmt = null;
        String sql = "update coach set sit_total = sit_total + 1 where ID=? and grade=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, id);
        psmt.setInt(2, grade);
        int flag = psmt.executeUpdate();
        return flag != 0;
    }

    @Override
    public Book selectBookByID(String id) throws SQLException {
        Book book = new Book();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from book where ID=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, id);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            book.setID(rsts.getString("ID"));
            book.setTrain_ID(rsts.getString("train_ID"));
            book.setAccount(rsts.getString("account"));
            book.setSit_name(rsts.getString("sit_name"));
        }
        return book;
    }

    @Override
    public Book selectBookByAccountAndTrainID(String account, String id) throws SQLException {
        Book book = new Book();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from book where account=? and train_ID=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        psmt.setString(2, id);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            book.setID(rsts.getString("ID"));
            book.setTrain_ID(rsts.getString("train_ID"));
            book.setAccount(rsts.getString("account"));
            book.setSit_name(rsts.getString("sit_name"));
        }
        return book;
    }

    @Override
    public Coach selectCoachByIDAndGrade(String id, int grade) throws SQLException {
        Coach coach = new Coach();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from coach where ID=? and grade=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, id);
        psmt.setInt(2, grade);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            coach.setID(rsts.getString("ID"));
            coach.setGrade(rsts.getInt("grade"));
            coach.setSit_name(rsts.getString("sit_name"));
            coach.setSit_total(rsts.getInt("sit_total"));
            coach.setSit_price(rsts.getFloat("sit_price"));
        }
        return coach;
    }

    @Override
    public List<Train> selectTrainByDemand(String beginPos, String endPos, String dateStr) throws SQLException {
        List<Train> trains = new LinkedList<>();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from train where begin_pos=? and end_pos=? and begin_time>? limit 0, 10000";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, beginPos);
        psmt.setString(2, endPos);
        psmt.setString(3, dateStr);
        rsts = psmt.executeQuery();
//        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        while(rsts.next()) {
            Train train = new Train();
            train.setID(rsts.getString("ID"));
            train.setKind(rsts.getString("kind"));
            train.setBegin_pos(rsts.getString("begin_pos"));
            train.setEnd_pos(rsts.getString("end_pos"));
            Timestamp begin_time = rsts.getTimestamp("begin_time");
            train.setBegin_time(new java.util.Date(begin_time.getTime()));
            Timestamp end_time = rsts.getTimestamp("end_time");
            train.setEnd_time(new java.util.Date(end_time.getTime()));
            trains.add(train);
        }
        rsts.close();
        psmt.close();
        return trains;
    }

    @Override
    public boolean equalAccountPassword(String account, String password) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rtst = null;
        String sql = "select * from user where account=? and password=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        psmt.setString(2, password);
        rtst = psmt.executeQuery();
//        if (rtst.next())
        boolean flag = rtst.next();
        rtst.close();
        psmt.close();
        return flag;
    }

    @Override
    public User selectUserByAccount(String account) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rtst = null;
        String sql = "select * from user where account=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        User user = null;
        rtst = psmt.executeQuery();
        if(rtst.next()) {
            user = new User();
            user.setAccount(rtst.getString("account"));
            user.setPassword(rtst.getString("password"));
            user.setName(rtst.getString("name"));
            user.setSex(rtst.getString("sex"));
            Timestamp reTime = rtst.getTimestamp("register_time");
            user.setRegister_time(new java.util.Date(reTime.getTime()));
            user.setID_card(rtst.getString("ID_card"));
            user.setPhone_number(rtst.getString("phone_number"));
            Timestamp loTime = rtst.getTimestamp("last_login");
            user.setLast_login(new java.util.Date(loTime.getTime()));
        }
        rtst.close();
        psmt.close();
        return user;
    }

    @Override
    public boolean updateLastLoginTime(String account) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "update user set last_login=? where account=?";
        psmt = conn.prepareStatement(sql);
        Timestamp dateTime = new Timestamp(new Date().getTime());
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = formatter.format(new Date().getTime());
        psmt.setTimestamp(1, dateTime);
        psmt.setString(2, account);
        return psmt.executeUpdate() == 1;
    }

    @Override
    public Train selectTrainByID(String id) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        Train train = new Train();
        String sql = "select * from train where ID=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, id);
        rsts = psmt.executeQuery();
        if(rsts.next()) {
            train.setID(rsts.getString("ID"));
            train.setBegin_pos(rsts.getString("begin_pos"));
            train.setEnd_pos(rsts.getString("end_pos"));
            train.setKind(rsts.getString("kind"));
            Timestamp begin_time = rsts.getTimestamp("begin_time");
            train.setBegin_time(new java.util.Date(begin_time.getTime()));
            Timestamp end_time = rsts.getTimestamp("end_time");
            train.setEnd_time(new java.util.Date(end_time.getTime()));
        }
        return train;
    }

    @Override
    public boolean updateSubSitTotalByTrainID(String id, int grade) throws SQLException {
        PreparedStatement psmt = null;
        String sql = "update coach set sit_total = sit_total - 1 where ID=? and grade=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, id);
        psmt.setInt(2, grade);
        int flag = psmt.executeUpdate();
        return flag != 0;
    }

    @Override
    public List<Train> selectLastTrainByAccount(String account) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        List<Train> trains = new LinkedList<>();
        Timestamp nowTime = new Timestamp(new Date().getTime());
        String sql = "select * from train where ID in (select train_ID from book where account=?) and begin_time<=? order by begin_time";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        psmt.setTimestamp(2, nowTime);
        rsts = psmt.executeQuery();
        while(rsts.next()) {
            Train train = new Train();
            train.setID(rsts.getString("ID"));
            train.setBegin_pos(rsts.getString("begin_pos"));
            train.setEnd_pos(rsts.getString("end_pos"));
            train.setKind(rsts.getString("kind"));
            Timestamp begin_time = rsts.getTimestamp("begin_time");
            train.setBegin_time(new java.util.Date(begin_time.getTime()));
            Timestamp end_time = rsts.getTimestamp("end_time");
            train.setEnd_time(new java.util.Date(end_time.getTime()));
            trains.add(train);
        }
        return trains;
    }

    @Override
    public List<Train> selectNowTrainByAccount(String account) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        List<Train> trains = new LinkedList<>();
        Timestamp nowTime = new Timestamp(new Date().getTime());
        String sql = "select * from train where ID in (select train_ID from book where account=?) and begin_time>? order by begin_time";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, account);
        psmt.setTimestamp(2, nowTime);
        rsts = psmt.executeQuery();
        while(rsts.next()) {
            Train train = new Train();
            train.setID(rsts.getString("ID"));
            train.setBegin_pos(rsts.getString("begin_pos"));
            train.setEnd_pos(rsts.getString("end_pos"));
            train.setKind(rsts.getString("kind"));
            Timestamp begin_time = rsts.getTimestamp("begin_time");
            train.setBegin_time(new java.util.Date(begin_time.getTime()));
            Timestamp end_time = rsts.getTimestamp("end_time");
            train.setEnd_time(new java.util.Date(end_time.getTime()));
            trains.add(train);
        }
        return trains;
    }
}
