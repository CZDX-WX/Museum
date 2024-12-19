package com.czdxwx.museum.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.czdxwx.museum.data.db.entities.CreativeProduct;
import com.czdxwx.museum.data.db.entities.User;

import java.util.List;

@Dao
public interface UserDao {
    // 获取所有文创商品数据
    @Query("SELECT * FROM users")
    LiveData<List<User>> getLiveUsers();

    // 获取所有文创商品数据（非 LiveData）
    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    //插入单个
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    //插入很多
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(List<User> users);

    //删除所有用户
    @Query("DELETE FROM users")
    void deleteAllUsers();

    //根据用户名查询用户
    @Query("SELECT * FROM users WHERE username = :username")
    User getUserByUsername(String username);

    //根据用户名和密码查询用户
    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    User getUserByCredentials(String username, String password);


}

