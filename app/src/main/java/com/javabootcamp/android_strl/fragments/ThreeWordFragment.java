package com.javabootcamp.android_strl.fragments;

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

public class ThreeWordFragment extends WordFragment {

    public ThreeWordFragment(List<String> words, Checkable checker) {
        super(words, checker);
    }

    @Override
    void setUpFragment(View v) {
        listOfWordsIds = new ArrayList<>();
        listOfWordsIds.add(R.id.threeWord1);
        listOfWordsIds.add(R.id.threeWord2);
        listOfWordsIds.add(R.id.threeWord3);


        listOfTargetsIds = new ArrayList<>();
        listOfTargetsIds.add(R.id.threeTarget1);
        listOfTargetsIds.add(R.id.threeTarget2);
        listOfTargetsIds.add(R.id.threeTarget3);

        listOfWordViews = getWordTextViews(v);
        listOfTargetViews = getTargetTextViews(v);

        setOnTouchListeners(touchListener);
        setOnDragListenets(dragListener);

        setWordsRandomly();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_three_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpFragment(view);
    }
}
