package com.demo.dao.impl;

import com.demo.dao.UserDAO;
import com.demo.ov.Train;

import java.sql.*;
import java.text.SimpleDateFormat;
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
        return trains;
    }
}
