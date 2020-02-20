package com.javabootcamp.android_strl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.javabootcamp.android_strl.Adapters.TopicRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TopicRecyclerViewAdapter.OnTopicListener {
    public static final String TOPIC_INDEX = "TOPIC_INDEX";
    private RecyclerView mRecyclerViewTopics;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager lm;
    private List<String> mListOfTopics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListOfTopics = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.topics)));
        // Initialize recyclerView
        mRecyclerViewTopics = findViewById(R.id.recyclerViewTopics);
        // Configuring flag that it will be fixed size list
        mRecyclerViewTopics.setHasFixedSize(true);
        // Initializing LayoutManager and custom adapter for RecyclerView
        lm = new LinearLayoutManager(this);
        mAdapter = new TopicRecyclerViewAdapter(mListOfTopics, this);
        // assigning LayoutManager and Adapter to RecyclerView
        mRecyclerViewTopics.setLayoutManager(lm);
        mRecyclerViewTopics.setAdapter(mAdapter);
        // Adding separator between items in list
        mRecyclerViewTopics.addItemDecoration(new DividerItemDecoration(mRecyclerViewTopics.getContext(), LinearLayoutManager.VERTICAL));
    }

    @Override
    public void onTopicClick(int position) {
        Intent intent = new Intent(this, WordsActivity.class);
        intent.putExtra(TOPIC_INDEX, position);
        startActivity(intent);
    }
}
