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

public class SixWordFragment extends WordFragment {

    @Override
    void setUpFragment(View v) {
        listOfWordsIds = new ArrayList<>();
        listOfWordsIds.add(R.id.sixWord1);
        listOfWordsIds.add(R.id.sixWord2);
        listOfWordsIds.add(R.id.sixWord3);
        listOfWordsIds.add(R.id.sixWord4);
        listOfWordsIds.add(R.id.sixWord5);
        listOfWordsIds.add(R.id.sixWord6);

        listOfTargetsIds = new ArrayList<>();
        listOfTargetsIds.add(R.id.sixTarget1);
        listOfTargetsIds.add(R.id.sixTarget2);
        listOfTargetsIds.add(R.id.sixTarget3);
        listOfTargetsIds.add(R.id.sixTarget4);
        listOfTargetsIds.add(R.id.sixTarget5);
        listOfTargetsIds.add(R.id.sixTarget6);

        listOfWordViews = getWordTextViews(v);
        listOfTargetViews = getTargetTextViews(v);

        setOnTouchListeners(touchListener);
        setOnDragListenets(dragListener);

        setWordsRandomly();
    }

    public SixWordFragment(List<String> words, Checkable checker) {
        super(words, checker);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_six_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpFragment(view);
    }
}
