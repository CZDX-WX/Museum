package com.czdxwx.museum.ui.artifact;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.czdxwx.museum.R;
import com.czdxwx.museum.databinding.FragmentArtifactBinding;

public class ArtifactFragment extends Fragment {

    private ArtifactViewModel artifactViewModel;
    private FragmentArtifactBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // 使用 ViewBinding 绑定布局
        binding = FragmentArtifactBinding.inflate(inflater, container, false);
        artifactViewModel = new ViewModelProvider(this).get(ArtifactViewModel.class);

        // TODO: 处理文物展示逻辑（如展示文物列表）

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // 清理 ViewBinding
    }
}
