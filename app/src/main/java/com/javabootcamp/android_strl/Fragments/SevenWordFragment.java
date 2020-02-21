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

public class SevenWordFragment extends WordFragment {

    @Override
    void setUpFragment(View v) {
        listOfWordsIds = new ArrayList<>();
        listOfWordsIds.add(R.id.sevenWord1);
        listOfWordsIds.add(R.id.sevenWord2);
        listOfWordsIds.add(R.id.sevenWord3);
        listOfWordsIds.add(R.id.sevenWord4);
        listOfWordsIds.add(R.id.sevenWord5);
        listOfWordsIds.add(R.id.sevenWord6);
        listOfWordsIds.add(R.id.sevenWord7);

        listOfTargetsIds = new ArrayList<>();
        listOfTargetsIds.add(R.id.sevenTarget1);
        listOfTargetsIds.add(R.id.sevenTarget2);
        listOfTargetsIds.add(R.id.sevenTarget3);
        listOfTargetsIds.add(R.id.sevenTarget4);
        listOfTargetsIds.add(R.id.sevenTarget5);
        listOfTargetsIds.add(R.id.sevenTarget6);
        listOfTargetsIds.add(R.id.sevenTarget7);

        listOfWordViews = getWordTextViews(v);
        listOfTargetViews = getTargetTextViews(v);

        setOnTouchListeners(touchListener);
        setOnDragListenets(dragListener);

        setWordsRandomly();
    }

    public SevenWordFragment(List<String> words, Checkable checker) {
        super(words, checker);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_seven_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpFragment(view);
    }
}
