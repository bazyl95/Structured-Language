package com.javabootcamp.android_strl.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.javabootcamp.android_strl.Checkable;
import com.javabootcamp.android_strl.R;

import java.util.ArrayList;
import java.util.List;

public class OneWordFragment extends WordFragment {

    public OneWordFragment(List<String> words, Checkable checker) {
        super(words, checker);
    }

    @Override
    void setUpFragment(View v) {
        listOfWordsIds = new ArrayList<>();
        listOfWordsIds.add(R.id.oneWord1);

        listOfTargetsIds = new ArrayList<>();
        listOfTargetsIds.add(R.id.oneTarget1);

        listOfWordViews = getWordTextViews(v);
        listOfTargetViews = getTargetTextViews(v);

        setOnTouchListeners(touchListener);
        setOnDragListenets(dragListener);

        setWordsRandomly();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpFragment(view);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one_word, container, false);
    }
}
