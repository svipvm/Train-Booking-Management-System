package com.demo.dao.impl;

import com.demo.dao.UserDAO;
import com.demo.ov.Train;
import com.demo.ov.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    Connection conn = null;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Train> selectTrainByDemand(String beginPos, String endPos, String dateStr) throws SQLException {
        List<Train> trains = new LinkedList<>();
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        String sql = "select * from train where begin_pos=? and end_pos=? and begin_time>? limit 0, 20000";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, beginPos);
        psmt.setString(2, endPos);
        psmt.setString(3, dateStr);
        rsts = psmt.executeQuery();
//        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        while(rsts.next()) {
            Train train = new Train();
            train.setID(rsts.getString("ID"));
            train.setSuper_p(rsts.getFloat("super_p"));
            train.setSuper_s(rsts.getInt("super_s"));
            train.setFirst_p(rsts.getFloat("first_p"));
            train.setFirst_s(rsts.getInt("first_s"));
            train.setSecond_p(rsts.getFloat("second_p"));
            train.setSecond_s(rsts.getInt("second_s"));
            train.setBegin_pos(rsts.getString("begin_pos"));
            train.setEnd_pos(rsts.getString("end_pos"));
            train.setKind(rsts.getString("kind"));
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
            train.setSuper_p(rsts.getFloat("super_p"));
            train.setSuper_s(rsts.getInt("super_s"));
            train.setFirst_p(rsts.getFloat("first_p"));
            train.setFirst_s(rsts.getInt("first_s"));
            train.setSecond_p(rsts.getFloat("second_p"));
            train.setSecond_s(rsts.getInt("second_s"));
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
    public List<Train> selectNowTrainByAccount(String account) {
        PreparedStatement psmt = null;
        ResultSet rsts = null;
        List<Train> trains = new LinkedList<>();
        String sql = "";
        return null;
    }
}
