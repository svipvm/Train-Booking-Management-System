package com.demo.dao;

import com.demo.ov.Train;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public abstract List<Train> selectTrainByDemand(String beginPos, String endPos, String dateStr) throws SQLException;
}
