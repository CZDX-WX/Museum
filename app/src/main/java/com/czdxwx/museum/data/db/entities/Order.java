package com.czdxwx.museum.data.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(tableName = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "user_id")
    private int userId;

    @ColumnInfo(name = "total_price")
    private double totalPrice;

    @ColumnInfo(name = "status")
    private String status;


}

