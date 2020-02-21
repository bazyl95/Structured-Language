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

public class FiveWordFragment extends WordFragment {

    @Override
    void setUpFragment(View v) {
        listOfWordsIds = new ArrayList<>();
        listOfWordsIds.add(R.id.fiveWord1);
        listOfWordsIds.add(R.id.fiveWord2);
        listOfWordsIds.add(R.id.fiveWord3);
        listOfWordsIds.add(R.id.fiveWord4);
        listOfWordsIds.add(R.id.fiveWord5);

        listOfTargetsIds = new ArrayList<>();
        listOfTargetsIds.add(R.id.fiveTarget1);
        listOfTargetsIds.add(R.id.fiveTarget2);
        listOfTargetsIds.add(R.id.fiveTarget3);
        listOfTargetsIds.add(R.id.fiveTarget4);
        listOfTargetsIds.add(R.id.fiveTarget5);

        listOfWordViews = getWordTextViews(v);
        listOfTargetViews = getTargetTextViews(v);

        setOnTouchListeners(touchListener);
        setOnDragListenets(dragListener);

        setWordsRandomly();
    }

    public FiveWordFragment(List<String> words, Checkable checker) {
        super(words, checker);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_five_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpFragment(view);
    }
}
