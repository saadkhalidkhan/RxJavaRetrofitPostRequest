package com.example.saadkhan.retrofitrxjava;

/**
 * Created by Saad Khan on 20/03/2018.
 */

public class PGC_TokenRequest {
    private String UserName;
    private String UserPassword;
    private String UserMacAddress;

    public String getUserMacAddress() {
        return UserMacAddress;
    }

    public void setUserMacAddress(String userMacAddress) {
        UserMacAddress = userMacAddress;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
}
