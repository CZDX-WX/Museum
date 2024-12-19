package com.czdxwx.museum.ui.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.czdxwx.museum.data.network.model.SyncCallback;
import com.czdxwx.museum.data.repository.SyncRepository;
import com.czdxwx.museum.databinding.ActivitySplashBinding;
import com.czdxwx.museum.ui.login.LoginActivity;



@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    private SyncRepository syncRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 初始化 ViewBinding
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化 SyncRepository
        syncRepository = new SyncRepository(getApplicationContext());

        // 显示动画或加载画面
        showSplashAnimation();

        // 开始同步数据
        syncDataWithServer();
    }

    private void showSplashAnimation() {
        // 如果需要添加动画，可以在这里实现。
        // 例如淡入动画或者等待一定的时间再进行下一步操作。
    }

    private void syncDataWithServer() {
        syncRepository.syncAllData(new SyncCallback() {
            @Override
            public void onSyncComplete(boolean isSuccess, String message) {
                if (isSuccess) {
                    Toast.makeText(SplashActivity.this, "同步成功：" + message, Toast.LENGTH_SHORT).show();
                    navigateToLogin();
                } else {
                    Toast.makeText(SplashActivity.this, "同步失败：" + message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    private void navigateToLogin() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

