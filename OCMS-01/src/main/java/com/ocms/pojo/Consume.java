package com.ocms.pojo;

import com.ocms.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class Consume {
    private int conId;
    private String conName;
    private int conNum;
    private String conFactory;
    private Date conIndate;
    private boolean conIsReplenish;

    public Consume() {
    }

    public Consume(int conId, String conName, int conNum, String conFactory, Date conIndate, boolean conIsReplenish) {
        this.conId = conId;
        this.conName = conName;
        this.conNum = conNum;
        this.conFactory = conFactory;
        this.conIndate = conIndate;
        this.conIsReplenish = conIsReplenish;
    }

    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public int getConNum() {
        return conNum;
    }

    public void setConNum(int conNum) {
        this.conNum = conNum;
    }

    public String getConFactory() {
        return conFactory;
    }

    public void setConFactory(String conFactory) {
        this.conFactory = conFactory;
    }

    public Date getConIndate() {
        return conIndate;
    }

    public void setConIndate(Date conIndate) {
        this.conIndate = conIndate;
    }

    public boolean isConIsReplenish() {
        return conIsReplenish;
    }

    public void setConIsReplenish(boolean conIsReplenish) {
        this.conIsReplenish = conIsReplenish;
    }

    @Override
    public String toString() {
        return "Consume{" +
                "conId=" + conId +
                ", conName='" + conName + '\'' +
                ", conNum=" + conNum +
                ", conFactory='" + conFactory + '\'' +
                ", conIndate=" + conIndate +
                ", conIsReplenish=" + conIsReplenish +
                '}';
    }

    public String listConsume(){
        return StringUtils.center(String.valueOf(conId), 5) +
                "    " + StringUtils.leftPad(conName, 5) +
                "    " + StringUtils.leftPad(String.valueOf(conNum), 5) +
                "    " + DateUtils.dateToString(conIndate) +
                "    " + StringUtils.leftPad(conFactory, 5) +
                "    " + StringUtils.rightPad(String.valueOf(conIsReplenish?1:0), 5);
    }
}
