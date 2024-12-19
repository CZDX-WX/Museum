package com.czdxwx.museum.ui.login;

import com.czdxwx.museum.data.Result;
import com.czdxwx.museum.data.db.dao.UserDao;
import com.czdxwx.museum.data.db.entities.User;

public class LoginDataSource {
    private final UserDao userDao;

    public LoginDataSource(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 登录方法
     * @param username 用户名
     * @param password 密码
     * @return 登录结果（成功或失败）
     */
    public Result<LoggedInUser> login(String username, String password) {
        try {
            // 从本地数据库中查找用户
            User user = userDao.getUserByUsername(username);

            // 验证用户名和密码
            if (user != null && user.getPassword().equals(password)) {
                // 登录成功，返回用户信息
                LoggedInUser loggedInUser = new LoggedInUser(user.getId(), user.getUsername());
                return new Result.Success<>(loggedInUser);
            } else {
                // 登录失败
                return new Result.Error(new Exception("Invalid username or password"));
            }
        } catch (Exception e) {
            // 出现错误
            return new Result.Error(e);
        }
    }

    /**
     * 退出登录（如果需要，比如清除缓存等操作）
     */
    public void logout() {
        // 暂无具体逻辑
    }
}



