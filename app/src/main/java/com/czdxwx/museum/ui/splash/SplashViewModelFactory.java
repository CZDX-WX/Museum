package com.czdxwx.museum.ui.splash;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SplashViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;

    public SplashViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            return (T) new SplashViewModel(context);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
