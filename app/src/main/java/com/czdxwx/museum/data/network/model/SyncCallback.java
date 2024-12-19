package com.czdxwx.museum.data.network.model;

public interface SyncCallback {
    void onSyncComplete(boolean isSuccess, String message);
}
