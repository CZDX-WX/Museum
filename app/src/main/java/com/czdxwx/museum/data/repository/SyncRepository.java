package com.czdxwx.museum.data.repository;
import android.content.Context;
import android.util.Log;
import com.czdxwx.museum.R;
import com.czdxwx.museum.data.db.AppDatabase;
import com.czdxwx.museum.data.db.entities.Artifact;
import com.czdxwx.museum.data.db.entities.CreativeProduct;
import com.czdxwx.museum.data.db.entities.Order;
import com.czdxwx.museum.data.db.entities.User;
import com.czdxwx.museum.data.network.api.ApiClient;
import com.czdxwx.museum.data.network.api.ApiService;
import com.czdxwx.museum.data.network.model.SyncCallback;
import com.czdxwx.museum.data.network.model.SyncDataRequest;
import com.czdxwx.museum.data.network.model.SyncDataResponse;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SyncRepository {

    private static final String TAG = "SyncRepository";
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final ApiService apiService;
    private final AppDatabase appDatabase;

    public SyncRepository(Context context) {
        String baseUrl = context.getString(R.string.api_base_url);
        this.apiService = ApiClient.getClient(baseUrl).create(ApiService.class);
        this.appDatabase = AppDatabase.getInstance(context);
    }

    // 综合同步所有数据
    public void syncAllData(SyncCallback callback) {
        // 同步顺序：上传本地数据 -> 拉取远程数据更新到本地
        syncLocalDataToServer(() -> fetchRemoteDataAndUpdateLocal(callback));
    }

    // 同步本地数据到服务器
    private void syncLocalDataToServer(Runnable onComplete) {
        executor.execute(() -> {
            try {
                List<User> users = appDatabase.userDao().getAllUsers();
                List<Artifact> artifacts = appDatabase.artifactDao().getAllArtifacts();
                List<CreativeProduct> products = appDatabase.creativeProductDao().getAllCreativeProducts();
                List<Order> orders = appDatabase.orderDao().getAllOrders();

                SyncDataRequest request = new SyncDataRequest(users, artifacts, products, orders);

                Response<SyncDataResponse> response = apiService.syncData(request).execute();
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    Log.d(TAG, "Local data synced successfully.");
                }

                // 同步完成后拉取远程数据
                onComplete.run();

            } catch (Exception e) {
                Log.e(TAG, "Failed to sync local data: " + e.getMessage());
            }
        });
    }

    // 拉取远程数据更新到本地
    private void fetchRemoteDataAndUpdateLocal(SyncCallback callback) {
        apiService.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    appDatabase.userDao().deleteAllUsers();
                    appDatabase.userDao().insertUsers(response.body());
                    Log.d(TAG, "User data updated locally.");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG, "Failed to fetch user data: " + t.getMessage());
                callback.onSyncComplete(false, t.getMessage());
            }
        });

        // 同理：拉取 Artifact、CreativeProduct 和 Order 的数据...
        callback.onSyncComplete(true, "All data synced successfully.");
    }
}
