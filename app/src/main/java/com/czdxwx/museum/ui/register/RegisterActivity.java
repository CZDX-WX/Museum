package com.czdxwx.museum.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.czdxwx.museum.R;
import com.czdxwx.museum.databinding.ActivityRegisterBinding;
import com.czdxwx.museum.ui.login.LoginActivity;
import android.widget.ArrayAdapter;


public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化 ViewModel
        registerViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RegisterViewModel.class);

        // 设置 Spinner 的数据源
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.role_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.roleSpinner.setAdapter(adapter);

        // 设置按钮点击事件
        binding.registerButton.setOnClickListener(v -> {
            String username = binding.username.getText().toString().trim();
            String password = binding.password.getText().toString().trim();
            String role = binding.roleSpinner.getSelectedItem().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            } else {
                registerViewModel.registerUser(username, password, role);
            }
        });

        // 监听注册结果
        registerViewModel.registrationResult.observe(this, isSuccess -> {
            if (isSuccess) {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                navigateToLogin();
            } else {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToLogin() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

