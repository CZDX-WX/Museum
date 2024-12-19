package com.czdxwx.museum.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.czdxwx.museum.data.db.entities.Artifact;

import java.util.List;

@Dao
public interface ArtifactDao {
    // 批量插入文物数据
    @Insert
    void insertArtifacts(List<Artifact> artifacts);

    @Insert
    void insertArtifact(Artifact artifact);

    // 删除所有文物数据
    @Query("DELETE FROM artifacts")
    void deleteAllArtifacts();

    // 获取所有文物数据
    @Query("SELECT * FROM artifacts")
    LiveData<List<Artifact>> getLiveArtifacts();

    // 获取所有文物数据（非 LiveData）
    @Query("SELECT * FROM artifacts")
    List<Artifact> getAllArtifacts();


}
