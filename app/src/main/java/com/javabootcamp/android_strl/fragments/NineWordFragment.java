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

public class NineWordFragment extends WordFragment {

    @Override
    void setUpFragment(View v) {
        listOfWordsIds = new ArrayList<>();
        listOfWordsIds.add(R.id.nineWord1);
        listOfWordsIds.add(R.id.nineWord2);
        listOfWordsIds.add(R.id.nineWord3);
        listOfWordsIds.add(R.id.nineWord4);
        listOfWordsIds.add(R.id.nineWord5);
        listOfWordsIds.add(R.id.nineWord6);
        listOfWordsIds.add(R.id.nineWord7);
        listOfWordsIds.add(R.id.nineWord8);
        listOfWordsIds.add(R.id.nineWord9);

        listOfTargetsIds = new ArrayList<>();
        listOfTargetsIds.add(R.id.nineTarget1);
        listOfTargetsIds.add(R.id.nineTarget2);
        listOfTargetsIds.add(R.id.nineTarget3);
        listOfTargetsIds.add(R.id.nineTarget4);
        listOfTargetsIds.add(R.id.nineTarget5);
        listOfTargetsIds.add(R.id.nineTarget6);
        listOfTargetsIds.add(R.id.nineTarget7);
        listOfTargetsIds.add(R.id.nineTarget8);
        listOfTargetsIds.add(R.id.nineTarget9);

        listOfWordViews = getWordTextViews(v);
        listOfTargetViews = getTargetTextViews(v);

        setOnTouchListeners(touchListener);
        setOnDragListenets(dragListener);

        setWordsRandomly();
    }

    public NineWordFragment(List<String> words, Checkable checker) {
        super(words, checker);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nine_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpFragment(view);
    }
}
