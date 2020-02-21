package com.javabootcamp.android_strl.Fragments;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.javabootcamp.android_strl.Checkable;
import com.javabootcamp.android_strl.R;

import java.util.List;

public class OneWordFragment extends Fragment {
    private final List<String> words;
    private TextView word1,target1;
    int i=0;
    private Checkable checker;

    public OneWordFragment(List<String> words, Checkable checker) {
        this.words = words;
        this.checker = checker;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        word1= view.findViewById(R.id.oneWord1);



        target1 = view.findViewById(R.id.oneTarget1);

        word1.setOnTouchListener(touchListener);


        target1.setOnDragListener(dragListener);


        word1.setText(words.get(0));
    }

    View.OnTouchListener touchListener = new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);

            return true;
        }

    };
    View.OnDragListener dragListener = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_STARTED:
                    word1.setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if (word1.getVisibility() != View.GONE)
                        word1.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    if(view.getId() == R.id.oneWord1 && v.getId() == R.id.oneTarget1){
                        target1.setText(word1.getText());
                        target1.setBackgroundColor(Color.parseColor("#00FF00"));
                        word1.setVisibility(View.GONE);
                        i++;
                    }
                    if (i==1) {
                        Toast.makeText(getActivity(),"Pareizi!", Toast.LENGTH_SHORT).show();
                        checker.checkCompleted();
                    }
                    break;
            }
            return true;
        }
    };



}
