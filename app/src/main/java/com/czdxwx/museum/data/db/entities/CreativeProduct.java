package com.czdxwx.museum.data.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(tableName = "creative_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreativeProduct {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "price")
    private double price;

    @ColumnInfo(name = "stock")
    private int stock;

    @ColumnInfo(name = "image_url")
    private String imageUrl;


}
