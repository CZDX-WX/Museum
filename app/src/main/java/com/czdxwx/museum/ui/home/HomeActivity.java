package com.czdxwx.museum.ui.home;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.czdxwx.museum.R;
import com.czdxwx.museum.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private NavController navController;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 使用 ViewBinding 绑定布局
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化 Navigation Controller
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // 设置底部导航栏的监听
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int Id=item.getItemId();
            if(Id == R.id.action_artifact){
                navController.navigate(R.id.fragment1);
                return true;
            }else if(Id == R.id.action_creative){
                navController.navigate(R.id.fragment2);
                return true;
            }else if (Id==R.id.action_cart){
                navController.navigate(R.id.fragment3);
                return true;
            }else if (Id==R.id.action_profile){
                navController.navigate(R.id.fragment4);
                return true;
            }
            return false;
        });

        // 设置默认显示的 fragment
        if (savedInstanceState == null) {
            navController.navigate(R.id.fragment1); // 默认跳转到文物展示页面
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null; // 清理 ViewBinding
    }
}
