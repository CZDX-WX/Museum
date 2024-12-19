package com.czdxwx.museum.data.repository;

import androidx.lifecycle.LiveData;

import com.czdxwx.museum.MyApplication;
import com.czdxwx.museum.data.db.AppDatabase;
import com.czdxwx.museum.data.db.dao.UserDao;
import com.czdxwx.museum.data.db.entities.User;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository {
    private final UserDao userDao;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean insertUser(User user) {
        try {
            executorService.submit(() -> userDao.insertUser(user)).get();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

