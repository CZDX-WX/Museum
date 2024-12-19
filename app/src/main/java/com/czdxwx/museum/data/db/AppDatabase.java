package com.czdxwx.museum.data.db;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.czdxwx.museum.data.db.dao.ArtifactDao;
import com.czdxwx.museum.data.db.dao.CreativeProductDao;
import com.czdxwx.museum.data.db.dao.OrderDao;
import com.czdxwx.museum.data.db.dao.UserDao;
import com.czdxwx.museum.data.db.entities.Artifact;
import com.czdxwx.museum.data.db.entities.CreativeProduct;
import com.czdxwx.museum.data.db.entities.Order;
import com.czdxwx.museum.data.db.entities.User;

@Database(entities = {User.class, Artifact.class, CreativeProduct.class, Order.class,OrderDetail.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE; // 使用 volatile 关键字保证多线程安全

    public abstract UserDao userDao();
    public abstract ArtifactDao artifactDao();
    public abstract CreativeProductDao creativeProductDao();
    public abstract OrderDao orderDao();
    public abstract OrderDetailDao orderDetailDao();

    // 获取数据库实例（使用双重锁检查，线程安全）
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "museum_db")
                            .fallbackToDestructiveMigration() // 如果数据库版本不匹配，销毁并重建数据库
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

