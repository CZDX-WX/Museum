package com.czdxwx.museum.ui.register;


import androidx.lifecycle.MutableLiveData;
import com.czdxwx.museum.data.db.AppDatabase;
import com.czdxwx.museum.data.db.entities.User;
import com.czdxwx.museum.data.repository.UserRepository;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;


public class RegisterViewModel extends AndroidViewModel {

    private final UserRepository userRepository;
    public MutableLiveData<Boolean> registrationResult = new MutableLiveData<>();

    public RegisterViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(application);
        userRepository = new UserRepository(database.userDao());
    }

    public void registerUser(String username, String password, String role) {
        User user = new User(username, password, role); // 根据选择的角色创建用户
        boolean isInserted = userRepository.insertUser(user);
        registrationResult.setValue(isInserted);
    }
}

