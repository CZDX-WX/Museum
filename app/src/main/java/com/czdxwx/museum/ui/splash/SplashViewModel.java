package com.czdxwx.museum.ui.splash;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.czdxwx.museum.data.network.model.SyncCallback;
import com.czdxwx.museum.data.repository.SyncRepository;

public class SplashViewModel extends ViewModel {

    private final SyncRepository syncRepository;
    private final MutableLiveData<SyncStatus> syncStatus = new MutableLiveData<>();

    public SplashViewModel(Context context) {
        syncRepository = new SyncRepository(context);
    }

    public LiveData<SyncStatus> getSyncStatus() {
        return syncStatus;
    }

    public void startSync() {
        syncRepository.syncAllData(new SyncCallback() {
            @Override
            public void onSyncComplete(boolean isSuccess, String message) {
                syncStatus.postValue(new SyncStatus(isSuccess, message));
            }
        });
    }
}
