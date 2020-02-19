package com.example.android_strl.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_strl.R;
import com.example.android_strl.WordsActivity;

import java.util.List;

public class TopicRecyclerViewAdapter extends RecyclerView.Adapter<TopicRecyclerViewAdapter.TopicViewHolder> {
    final static String TAG = TopicRecyclerViewAdapter.class.getSimpleName();
    private List<String> topics;

    public TopicRecyclerViewAdapter(List<String> topics) {
        this.topics = topics;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.topic_list_item, parent, false);
        Log.d(TAG, "ViewHolder created.");
        return new TopicViewHolder(view, parent.getContext());
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
        private Context parentContext;

        public TopicViewHolder(@NonNull final View itemView, final Context parentContext) {
            super(itemView);
            mTopicName = itemView.findViewById(R.id.topicTextView);
            this.parentContext = parentContext;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(parentContext, WordsActivity.class);
                    intent.putExtra("TOPIC",getAdapterPosition());
                    parentContext.startActivity(intent);
                }
            });
        }
    }
}
