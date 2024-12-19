package com.czdxwx.museum.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.czdxwx.museum.data.db.entities.CreativeProduct;

import java.util.List;

@Dao
public interface CreativeProductDao {

    // 批量插入文创商品数据
    @Insert
    void insertCreativeProducts(List<CreativeProduct> creativeProducts);

    // 删除所有文创商品数据
    @Query("DELETE FROM creative_products")
    void deleteAllCreativeProducts();

    // 获取所有文创商品数据
    @Query("SELECT * FROM creative_products")
    LiveData<List<CreativeProduct>> getLiveCreativeProducts();

    // 获取所有文创商品数据（非 LiveData）
    @Query("SELECT * FROM creative_products")
    List<CreativeProduct> getAllCreativeProducts();

}
