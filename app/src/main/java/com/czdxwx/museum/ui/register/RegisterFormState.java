package com.czdxwx.museum.ui.register;

public class RegisterFormState {
    private final boolean isDataValid;
    private final Integer usernameError;
    private final Integer passwordError;
    private final Integer emailError;
    private final Integer confirmPasswordError;

    public RegisterFormState(boolean isDataValid) {
        this.isDataValid = isDataValid;
        this.usernameError = null;
        this.passwordError = null;
        this.emailError = null;
        this.confirmPasswordError = null;
    }

    public RegisterFormState(Integer usernameError, Integer passwordError, Integer emailError, Integer confirmPasswordError) {
        this.isDataValid = false;
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.emailError = emailError;
        this.confirmPasswordError = confirmPasswordError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }

    public Integer getUsernameError() {
        return usernameError;
    }

    public Integer getPasswordError() {
        return passwordError;
    }

    public Integer getEmailError() {
        return emailError;
    }

    public Integer getConfirmPasswordError() {
        return confirmPasswordError;
    }
}
