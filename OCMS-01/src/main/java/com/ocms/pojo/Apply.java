package com.ocms.pojo;

import java.util.Date;
import com.ocms.utils.*;
import org.apache.commons.lang3.StringUtils;

public class Apply {
    private int applyId;
    private int staId;
    private int adminId;
    Date applyTime = new Date();
    Date conTime = new Date();
    private int applyNum;
    String applyName;
    private boolean applyIsCheck;
    private int applyResult;
    String applyNote;

    public Apply() {
    }

    public Apply(int applyId, int staId, int adminId, Date applyTime, Date conTime, int applyNum, String applyName, boolean applyIsCheck, int applyResult, String applyNote) {
        this.applyId = applyId;
        this.staId = staId;
        this.adminId = adminId;
        this.applyTime = applyTime;
        this.conTime = conTime;
        this.applyNum = applyNum;
        this.applyName = applyName;
        this.applyIsCheck = applyIsCheck;
        this.applyResult = applyResult;
        this.applyNote = applyNote;
    }

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public int getStaId() {
        return staId;
    }

    public void setStaId(int staId) {
        this.staId = staId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getConTime() {
        return conTime;
    }

    public void setConTime(Date conTime) {
        this.conTime = conTime;
    }

    public int getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(int applyNum) {
        this.applyNum = applyNum;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public boolean isApplyIsCheck() {
        return applyIsCheck;
    }

    public void setApplyIsCheck(boolean applyIsCheck) {
        this.applyIsCheck = applyIsCheck;
    }

    public int getApplyResult() {
        return applyResult;
    }

    public void setApplyResult(int applyResult) {
        this.applyResult = applyResult;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyId=" + applyId +
                ", staId=" + staId +
                ", adminId=" + adminId +
                ", applyTime=" + applyTime +
                ", conTime=" + conTime +
                ", applyNum=" + applyNum +
                ", applyName='" + applyName + '\'' +
                ", applyIsCheck=" + applyIsCheck +
                ", applyResult=" + applyResult +
                ", applyNote='" + applyNote + '\'' +
                '}';
    }

    public String listApply(){
        return StringUtils.center(String.valueOf(applyId), 5) +
                "    " + DateUtils.dateToString(applyTime) +
                "    " + DateUtils.dateToString(conTime) +
                "    " + applyNum +
//                "    " + StringUtils.left(String.valueOf(applyIsCheck?1:0), 5) +
                "    " + StringUtils.leftPad(applyName, 5);
    }
}
