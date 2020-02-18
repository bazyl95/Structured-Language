package com.example.android_strl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android_strl.Adapters.TopicRecyclerViewAdapter;

import java.util.ArrayList;
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
        listOfTopics = getTopics(getResources().getStringArray(R.array.topics));

        // Initialize recyclerView
        mRecyclerViewTopics = findViewById(R.id.recyclerViewTopics);
        // Configuring setting that it will be fixed size list
        mRecyclerViewTopics.setHasFixedSize(true);
        // Initializing LayoutManager
        lm = new LinearLayoutManager(this);
        mRecyclerViewTopics.setLayoutManager(lm);
        mAdapter = new TopicRecyclerViewAdapter(listOfTopics);
    }

    private List<String> getTopics(String[] topics) {
        List<String> listForReturn = new ArrayList<>();
        for (int i = 0; i < topics.length; i++) {
            listForReturn.add(topics[i]);
        }
        return listForReturn;
    }
}
