package com.demo.ov;

import java.sql.Timestamp;
import java.util.Date;

public class Train {
    private String ID;
    private int super_s;
    private float super_p;
    private int first_s;
    private float first_p;
    private int second_s;
    private float second_p;
    private String kind;
    private String begin_pos;
    private String end_pos;
    private java.util.Date begin_time;
    private java.util.Date end_time;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getSuper_s() {
        return super_s;
    }

    public void setSuper_s(int super_s) {
        this.super_s = super_s;
    }

    public float getSuper_p() {
        return super_p;
    }

    public void setSuper_p(float super_p) {
        this.super_p = super_p;
    }

    public int getFirst_s() {
        return first_s;
    }

    public void setFirst_s(int first_s) {
        this.first_s = first_s;
    }

    public float getFirst_p() {
        return first_p;
    }

    public void setFirst_p(float first_p) {
        this.first_p = first_p;
    }

    public int getSecond_s() {
        return second_s;
    }

    public void setSecond_s(int second_s) {
        this.second_s = second_s;
    }

    public float getSecond_p() {
        return second_p;
    }

    public void setSecond_p(float second_p) {
        this.second_p = second_p;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBegin_pos() {
        return begin_pos;
    }

    public void setBegin_pos(String begin_pos) {
        this.begin_pos = begin_pos;
    }

    public String getEnd_pos() {
        return end_pos;
    }

    public void setEnd_pos(String end_pos) {
        this.end_pos = end_pos;
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(java.util.Date  begin_time) {
        this.begin_time = begin_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(java.util.Date  end_time) {
        this.end_time = end_time;
    }
}
