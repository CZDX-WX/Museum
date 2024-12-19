package com.czdxwx.museum.ui.login;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.czdxwx.museum.R;
import com.czdxwx.museum.databinding.ActivityLoginBinding;
import com.czdxwx.museum.ui.home.HomeActivity;
import com.czdxwx.museum.ui.register.RegisterActivity;


public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 使用 ViewBinding
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        // 初始化 ViewModel
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory(getApplication()))
                .get(LoginViewModel.class);

        // 监听表单状态变化
        loginViewModel.getLoginFormState().observe(this, loginFormState -> {
            if (loginFormState == null) return;

            binding.login.setEnabled(loginFormState.isDataValid());

            if (loginFormState.getUsernameError() != null) {
                binding.username.setError(getString(loginFormState.getUsernameError()));
            }
            if (loginFormState.getPasswordError() != null) {
                binding.password.setError(getString(loginFormState.getPasswordError()));
            }
        });

        // 监听登录结果变化
        loginViewModel.getLoginResult().observe(this, loginResult -> {
            if (loginResult != null) {
                if (loginResult.getSuccess() != null) {
                    // 显示错误信息
                    showLoginFailed();
                } else {
                    // 登录成功跳转到主页
                    navigateToHome();
                }
            }
        });

        // 表单输入监听
        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(
                        binding.username.getText().toString(),
                        binding.password.getText().toString()
                );
            }
        };
        binding.username.addTextChangedListener(afterTextChangedListener);
        binding.password.addTextChangedListener(afterTextChangedListener);

        // 登录按钮点击事件
        binding.login.setOnClickListener(v ->
                loginViewModel.login(binding.username.getText().toString(),
                        binding.password.getText().toString()));

        //提示按钮跳转到注册页面
        binding.tvTip.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }


    private void navigateToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void showLoginFailed() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
    }
}


