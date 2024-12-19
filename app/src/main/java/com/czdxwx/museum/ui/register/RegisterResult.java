package com.czdxwx.museum.ui.register;

public class RegisterResult {
    private final String successMessage;
    private final String errorMessage;

    public RegisterResult(String successMessage) {
        this.successMessage = successMessage;
        this.errorMessage = null;
    }

    public RegisterResult(String errorMessage, boolean isError) {
        this.successMessage = null;
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
