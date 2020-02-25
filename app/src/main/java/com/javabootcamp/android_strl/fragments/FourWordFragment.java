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

public class FourWordFragment extends WordFragment {

    @Override
    void setUpFragment(View v) {
        listOfWordsIds = new ArrayList<>();
        listOfWordsIds.add(R.id.fourWord1);
        listOfWordsIds.add(R.id.fourWord2);
        listOfWordsIds.add(R.id.fourWord3);
        listOfWordsIds.add(R.id.fourWord4);

        listOfTargetsIds = new ArrayList<>();
        listOfTargetsIds.add(R.id.fourTarget1);
        listOfTargetsIds.add(R.id.fourTarget2);
        listOfTargetsIds.add(R.id.fourTarget3);
        listOfTargetsIds.add(R.id.fourTarget4);

        listOfWordViews = getWordTextViews(v);
        listOfTargetViews = getTargetTextViews(v);

        setOnTouchListeners(touchListener);
        setOnDragListenets(dragListener);

        setWordsRandomly();
    }

    public FourWordFragment(List<String> words, Checkable checker) {
        super(words, checker);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_four_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpFragment(view);
    }
}
