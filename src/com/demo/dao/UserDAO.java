package com.demo.dao;

import com.demo.ov.Book;
import com.demo.ov.Coach;
import com.demo.ov.Train;
import com.demo.ov.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public abstract List<Train> selectTrainByDemand(String beginPos, String endPos, String dateStr) throws SQLException;
    public abstract boolean equalAccountPassword(String account, String password) throws SQLException;
    public abstract User selectUserByAccount(String account) throws SQLException;
    public abstract boolean updateLastLoginTime(String account) throws SQLException;
    public abstract List<Train> selectNowTrainByAccount(String account) throws SQLException;
    public abstract Train selectTrainByID(String id) throws SQLException;
    public abstract boolean updateSubSitTotalByTrainID(String id, int grade) throws SQLException;
    public abstract boolean insertBook(String account, String id, String sitName) throws SQLException;
    public abstract List<Train> selectLastTrainByAccount(String account) throws SQLException;
    public abstract List<Coach> selectCoachByID(String id) throws SQLException;
    public abstract Coach selectCoachByIDAndGrade(String id, int grade) throws SQLException;
    public abstract Book selectBookByAccountAndTrainID(String account, String id) throws SQLException;
    public abstract Book selectBookByID(String id) throws SQLException;
    public abstract Coach selectCoachByIDAndSitName(String train_id, String sit_name) throws SQLException;
    public abstract boolean dropBook(String account, String id, String sit_name) throws SQLException;
    public abstract boolean updateAddSitTotalByTrainID(String id, int grade) throws SQLException;
}
