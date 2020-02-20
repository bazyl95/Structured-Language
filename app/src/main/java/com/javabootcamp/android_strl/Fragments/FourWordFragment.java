package com.javabootcamp.android_strl.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.javabootcamp.android_strl.Checkable;
import com.javabootcamp.android_strl.R;

import java.util.List;

public class FourWordFragment extends Fragment {
    private final List<String> words;
    private Checkable checker;

    public FourWordFragment(List<String> words, Checkable checker) {
        this.words = words;
        this.checker = checker;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_four_word, container, false);
    }
}
