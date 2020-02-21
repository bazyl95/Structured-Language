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

public class EightWordFragment extends WordFragment {

    @Override
    void setUpFragment(View v) {
        listOfWordsIds = new ArrayList<>();
        listOfWordsIds.add(R.id.eightWord1);
        listOfWordsIds.add(R.id.eightWord2);
        listOfWordsIds.add(R.id.eightWord3);
        listOfWordsIds.add(R.id.eightWord4);
        listOfWordsIds.add(R.id.eightWord5);
        listOfWordsIds.add(R.id.eightWord6);
        listOfWordsIds.add(R.id.eightWord7);
        listOfWordsIds.add(R.id.eightWord8);

        listOfTargetsIds = new ArrayList<>();
        listOfTargetsIds.add(R.id.eightTarget1);
        listOfTargetsIds.add(R.id.eightTarget2);
        listOfTargetsIds.add(R.id.eightTarget3);
        listOfTargetsIds.add(R.id.eightTarget4);
        listOfTargetsIds.add(R.id.eightTarget5);
        listOfTargetsIds.add(R.id.eightTarget6);
        listOfTargetsIds.add(R.id.eightTarget7);
        listOfTargetsIds.add(R.id.eightTarget8);

        listOfWordViews = getWordTextViews(v);
        listOfTargetViews = getTargetTextViews(v);

        setOnTouchListeners(touchListener);
        setOnDragListenets(dragListener);

        setWordsRandomly();
    }

    public EightWordFragment(List<String> words, Checkable checker) {
        super(words, checker);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_eight_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpFragment(view);
    }
}
