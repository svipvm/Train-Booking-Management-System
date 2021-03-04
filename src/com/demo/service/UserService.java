package com.demo.service;

import com.demo.ov.Train;

import java.util.List;

public interface UserService {
    public abstract void close();
    public abstract List<Train> findAllByDemand(String beginPos, String endPos, String dateStr);
}
