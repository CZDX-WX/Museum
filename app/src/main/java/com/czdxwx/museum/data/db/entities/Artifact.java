package com.czdxwx.museum.data.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(tableName = "artifacts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artifact {
    @PrimaryKey(autoGenerate = true)
    private int id; // 主键，文物ID

    @ColumnInfo(name = "name")
    private String name;// 文物名称

    @ColumnInfo(name = "category")
    private String category;// 类别

    @ColumnInfo(name = "era")
    private String era;// 所属年代

    @ColumnInfo(name = "description")
    private String description;// 描述

    @ColumnInfo(name = "image_url")
    private String imageUrl;// 图片URL


}

