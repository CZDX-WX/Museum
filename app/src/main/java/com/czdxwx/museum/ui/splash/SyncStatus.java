package com.czdxwx.museum.ui.splash;

public class SyncStatus {
    private final boolean isSuccess;
    private final String message;

    public SyncStatus(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}
