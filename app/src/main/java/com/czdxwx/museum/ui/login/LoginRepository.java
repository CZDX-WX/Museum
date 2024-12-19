package com.czdxwx.museum.ui.login;

import com.czdxwx.museum.data.Result;
import com.czdxwx.museum.data.db.dao.UserDao;
import com.czdxwx.museum.data.db.entities.User;


public class LoginRepository {
    private static volatile LoginRepository instance;
    private final LoginDataSource dataSource;

    // 私有构造函数
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            synchronized (LoginRepository.class) {
                if (instance == null) {
                    instance = new LoginRepository(dataSource);
                }
            }
        }
        return instance;
    }

    public Result<LoggedInUser> login(String username, String password) {
        return dataSource.login(username, password);
    }

    public void logout() {
        dataSource.logout();
    }
}



