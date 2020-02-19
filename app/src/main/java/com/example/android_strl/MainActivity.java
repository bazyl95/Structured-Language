package com.example.android_strl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android_strl.Adapters.TopicRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerViewTopics;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager lm;
    private List<String> listOfTopics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listOfTopics = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.topics)));
        // Initialize recyclerView
        mRecyclerViewTopics = findViewById(R.id.recyclerViewTopics);
        // Configuring flag that it will be fixed size list
        mRecyclerViewTopics.setHasFixedSize(true);
        // Initializing LayoutManager and custom adapter for RecyclerView
        lm = new LinearLayoutManager(this);
        mAdapter = new TopicRecyclerViewAdapter(listOfTopics);
        // assigning LayoutManager and Adapter to RecyclerView
        mRecyclerViewTopics.setLayoutManager(lm);
        mRecyclerViewTopics.setAdapter(mAdapter);
        // Adding separator between items in list
        mRecyclerViewTopics.addItemDecoration(new DividerItemDecoration(mRecyclerViewTopics.getContext(), LinearLayoutManager.VERTICAL));
    }

}
