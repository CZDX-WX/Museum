package com.czdxwx.museum.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.czdxwx.museum.data.db.entities.Order;

import java.util.List;



@Dao
public interface OrderDao {
    // 批量插入订单数据
    @Insert
    void insertOrders(List<Order> orders);

    // 删除所有订单数据
    @Query("DELETE FROM orders")
    void deleteAllOrders();

    // 获取所有订单数据
    @Query("SELECT * FROM orders")
    LiveData<List<Order>> getLiveOrders();

    // 获取所有订单数据（非 LiveData）
    @Query("SELECT * FROM orders")
    List<Order> getAllOrders();

}
