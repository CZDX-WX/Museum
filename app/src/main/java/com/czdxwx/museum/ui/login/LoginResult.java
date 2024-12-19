package com.czdxwx.museum.ui.login;

import androidx.annotation.Nullable;


public class LoginResult {
    private final LoggedInUserView success;
    private final String error;

    public LoginResult(LoggedInUserView success) {
        this.success = success;
        this.error = null;
    }

    public LoginResult(String error) {
        this.success = null;
        this.error = error;
    }

    public LoggedInUserView getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }
}
