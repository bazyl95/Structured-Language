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

public class TenWordFragment extends WordFragment {

    @Override
    void setUpFragment(View v) {
        listOfWordsIds = new ArrayList<>();
        listOfWordsIds.add(R.id.tenWord1);
        listOfWordsIds.add(R.id.tenWord2);
        listOfWordsIds.add(R.id.tenWord3);
        listOfWordsIds.add(R.id.tenWord4);
        listOfWordsIds.add(R.id.tenWord5);
        listOfWordsIds.add(R.id.tenWord6);
        listOfWordsIds.add(R.id.tenWord7);
        listOfWordsIds.add(R.id.tenWord8);
        listOfWordsIds.add(R.id.tenWord9);
        listOfWordsIds.add(R.id.tenWord10);

        listOfTargetsIds = new ArrayList<>();
        listOfTargetsIds.add(R.id.tenTarget1);
        listOfTargetsIds.add(R.id.tenTarget2);
        listOfTargetsIds.add(R.id.tenTarget3);
        listOfTargetsIds.add(R.id.tenTarget4);
        listOfTargetsIds.add(R.id.tenTarget5);
        listOfTargetsIds.add(R.id.tenTarget6);
        listOfTargetsIds.add(R.id.tenTarget7);
        listOfTargetsIds.add(R.id.tenTarget8);
        listOfTargetsIds.add(R.id.tenTarget9);
        listOfTargetsIds.add(R.id.tenTarget10);

        listOfWordViews = getWordTextViews(v);
        listOfTargetViews = getTargetTextViews(v);

        setOnTouchListeners(touchListener);
        setOnDragListenets(dragListener);

        setWordsRandomly();
    }

    public TenWordFragment(List<String> words, Checkable checker) {
        super(words, checker);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ten_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpFragment(view);
    }
}
