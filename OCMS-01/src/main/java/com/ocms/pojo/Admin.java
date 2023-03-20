package com.ocms.pojo;

public class Admin {
    private int adminId;
    private String adminAccount;
    private String adminPasswd;

    public Admin() {
    }

    public Admin(int adminId, String adminAccount, String adminPasswd) {
        this.adminId = adminId;
        this.adminAccount = adminAccount;
        this.adminPasswd = adminPasswd;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPasswd() {
        return adminPasswd;
    }

    public void setAdminPasswd(String adminPasswd) {
        this.adminPasswd = adminPasswd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminAccount='" + adminAccount + '\'' +
                ", adminPasswd='" + adminPasswd + '\'' +
                '}';
    }
}
