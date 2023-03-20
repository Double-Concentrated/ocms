package com.ocms.pojo;

import org.apache.commons.lang3.StringUtils;

public class Staff {
    private int staId;
    private String staName;
    private String staDept;
    private String staTele;

    public Staff(){}

    public Staff(int staId, String staName, String staDept, String staTele) {
        this.staId = staId;
        this.staName = staName;
        this.staDept = staDept;
        this.staTele = staTele;
    }

    public int getStaId() {
        return staId;
    }

    public void setStaId(int staId) {
        this.staId = staId;
    }

    public String getStaName() {
        return staName;
    }

    public void setStaName(String staName) {
        this.staName = staName;
    }

    public String getStaDept() {
        return staDept;
    }

    public void setStaDept(String staDept) {
        this.staDept = staDept;
    }

    public String getStaTele() {
        return staTele;
    }

    public void setStaTele(String staTele) {
        this.staTele = staTele;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staId=" + staId +
                ", staName='" + staName + '\'' +
                ", staDept='" + staDept + '\'' +
                ", staTele='" + staTele + '\'' +
                '}';
    }

    public String listStaff(){
        return StringUtils.center(String.valueOf(staId), 5) +
                "    " + StringUtils.leftPad(staDept, 10) +
                "    " + StringUtils.rightPad(staName, 10) +
                "    " + StringUtils.rightPad(staTele, 10);
    }
}
