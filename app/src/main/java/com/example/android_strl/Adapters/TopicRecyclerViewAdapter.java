package com.example.android_strl.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_strl.R;

import java.util.List;

public class TopicRecyclerViewAdapter extends RecyclerView.Adapter<TopicRecyclerViewAdapter.TopicViewHolder> {
    private List<String> topics;

    public TopicRecyclerViewAdapter(List<String> topics) {
        this.topics = topics;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_list_item, parent, false);
        TopicViewHolder vh = new TopicViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        holder.mTopicName.setText(topics.get(position));
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    class TopicViewHolder extends RecyclerView.ViewHolder {
        private TextView mTopicName;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
           mTopicName = itemView.findViewById(R.id.topicTextView);
        }
    }
}
