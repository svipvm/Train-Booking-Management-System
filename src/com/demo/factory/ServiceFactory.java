package com.demo.factory;

import com.demo.service.impl.UserServiceImpl;

public class ServiceFactory {
    public static UserServiceImpl getUserServiceImpl() {
        return new UserServiceImpl();
    }
}
