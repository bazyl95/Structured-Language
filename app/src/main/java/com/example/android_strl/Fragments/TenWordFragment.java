package com.example.android_strl.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android_strl.R;

import java.util.List;

public class TenWordFragment extends Fragment {
    private final List<String> words;

    public TenWordFragment(List<String> words) {
        this.words = words;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ten_word, container, false);
    }
}
