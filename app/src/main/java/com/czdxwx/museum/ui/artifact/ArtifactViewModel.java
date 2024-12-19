package com.czdxwx.museum.ui.artifact;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArtifactViewModel extends ViewModel {
    private MutableLiveData<List<ArtifactItem>> artifactItems;

    public ArtifactViewModel() {
        artifactItems = new MutableLiveData<>();
        // TODO: 初始化数据，加载文物列表
    }

    public LiveData<List<ArtifactItem>> getMuseumItems() {
        return artifactItems;
    }

    // TODO: 添加获取文物数据的方法
}