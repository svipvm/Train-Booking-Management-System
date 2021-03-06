package com.demo.dao;

import com.demo.ov.Train;
import com.demo.ov.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public abstract List<Train> selectTrainByDemand(String beginPos, String endPos, String dateStr) throws SQLException;
    public abstract boolean equalAccountPassword(String account, String password) throws SQLException;
    public abstract User selectUserByAccount(String account) throws SQLException;
    public abstract boolean updateLastLoginTime(String account) throws SQLException;
    public abstract List<Train> selectNowTrainByAccount(String account);
    public abstract Train selectTrainByID(String id) throws SQLException;
}
