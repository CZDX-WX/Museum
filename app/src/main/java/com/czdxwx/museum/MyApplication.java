package com.czdxwx.museum;

import android.app.Application;

import androidx.room.Room;

import com.czdxwx.museum.data.db.AppDatabase;

import lombok.Getter;

public class MyApplication extends Application {
    // 获取 Application 实例
    @Getter
    private static MyApplication instance;
    // 获取数据库实例
    @Getter
    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // 初始化 Room 数据库
        database = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "my_database")
                .fallbackToDestructiveMigration() // 如果需要允许破坏性迁移
                .build();
    }

}
