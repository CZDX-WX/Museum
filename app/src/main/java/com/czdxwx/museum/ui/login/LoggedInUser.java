package com.czdxwx.museum.ui.login;


import lombok.Data;

@Data
public class LoggedInUser {
    private int userId;
    private String displayName;

    public LoggedInUser(int userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }


}
