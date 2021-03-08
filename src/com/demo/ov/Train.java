package com.demo.ov;

import java.sql.Timestamp;
import java.util.Date;

public class Train {
    private String ID;
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
