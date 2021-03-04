package com.demo.factory;

import com.demo.dao.impl.UserDAOImpl;

import java.sql.Connection;


public class DAOFactory {
    public static UserDAOImpl getUserDAOImpl(Connection conn) {
        return new UserDAOImpl(conn);
    }
}
