package com.javabootcamp.android_strl.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javabootcamp.android_strl.R;

import java.util.List;

public class TopicRecyclerViewAdapter extends RecyclerView.Adapter<TopicRecyclerViewAdapter.TopicViewHolder> {
    final static String TAG = TopicRecyclerViewAdapter.class.getSimpleName();
    private List<String> topics;
    private OnTopicListener onTopicListener;

    public TopicRecyclerViewAdapter(List<String> topics, OnTopicListener onTopicListener) {
        this.topics = topics;
        this.onTopicListener = onTopicListener;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.topic_list_item, parent, false);
        Log.d(TAG, "ViewHolder created.");
        return new TopicViewHolder(view, onTopicListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        holder.mTopicName.setText(topics.get(position));
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTopicName;
        OnTopicListener onTopicListener;


        public TopicViewHolder(@NonNull final View itemView, OnTopicListener onTopicListener) {
            super(itemView);
            mTopicName = itemView.findViewById(R.id.topicTextView);
            this.onTopicListener = onTopicListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTopicListener.onTopicClick(getAdapterPosition());
        }
    }
    // Interface between MainActivity and this adapter. To call OnClick method of MainActivity.
    public interface OnTopicListener {
        void onTopicClick(int position);
    }
}
