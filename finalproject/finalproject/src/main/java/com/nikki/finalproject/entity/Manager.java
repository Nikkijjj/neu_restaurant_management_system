package com.nikki.finalproject.entity;

public class Manager {

    private String managerName;
    private String LoginPwd;

    public Manager(){
    }

    public String toString(){
        return "Manager Name: "+managerName+"\nLogin Pwd: "+LoginPwd;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getLoginPwd() {
        return LoginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        LoginPwd = loginPwd;
    }
}
