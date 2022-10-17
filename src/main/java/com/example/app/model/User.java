package com.example.app.model;

public class User {
    private String userName;
    private String userSurname;
    private String userPhonenumber;
    private String userCity;
    private String userLogin;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User() { }

    public User(String userName, String userSurname, String userPhonenumber, String userCity, String userLogin, String userPassword) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPhonenumber = userPhonenumber;
        this.userCity = userCity;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }
}
