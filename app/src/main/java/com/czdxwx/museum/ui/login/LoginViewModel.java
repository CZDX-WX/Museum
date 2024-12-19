package com.czdxwx.museum.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.czdxwx.museum.MyApplication;
import com.czdxwx.museum.R;
import com.czdxwx.museum.data.Result;
import com.czdxwx.museum.data.db.AppDatabase;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginViewModel extends AndroidViewModel {
    private final LoginRepository loginRepository;
    private final MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();

    public LoginViewModel(Application application) {
        super(application);
        // 从全局 Application 获取数据库实例并初始化仓库
        AppDatabase db = MyApplication.getDatabase();
        loginRepository = LoginRepository.getInstance(new LoginDataSource(db.userDao()));
    }

    // 获取 LoginFormState 的 LiveData
    public LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    // 获取 LoginResult 的 LiveData
    public LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    // 登录方法
    public void login(String username, String password) {
        // 执行登录逻辑，并设置登录结果
        new Thread(() -> {
            Result<LoggedInUser> result = loginRepository.login(username, password);

            if (result instanceof Result.Success) {
                LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
                loginResult.postValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
            } else {
                loginResult.postValue(new LoginResult(String.valueOf(R.string.login_failed)));
            }
        }).start();
    }

    // 校验表单输入是否合法
    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // 校验用户名
    private boolean isUserNameValid(String username) {
        return username != null && username.trim().length() > 3;
    }

    // 校验密码
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}

