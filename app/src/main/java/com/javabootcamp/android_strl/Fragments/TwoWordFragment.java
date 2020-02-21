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
import androidx.fragment.app.Fragment;

import com.javabootcamp.android_strl.Checkable;
import com.javabootcamp.android_strl.R;
import com.javabootcamp.android_strl.WordsActivity;

import java.util.List;

public class TwoWordFragment extends Fragment {
    private final List<String> words;
    private final Checkable checker;
    private List <Integer> ridwords;
    private List <Integer> ridtargets;
    private TextView word1,word2,target1,target2;
    int i=0;


    public TwoWordFragment(List<String> words, Checkable checker) {
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
        return inflater.inflate(R.layout.fragment_two_word, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        word1= view.findViewById(R.id.twoWord1);
        word2=view.findViewById(R.id.twoWord2);


        target1 = view.findViewById(R.id.twoTarget1);
        target2 = view.findViewById(R.id.twoTarget2);

        word1.setOnTouchListener(touchListener);
        word2.setOnTouchListener(touchListener);


        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);


        word1.setText(words.get(0));
        word2.setText(words.get(1));


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
                    view.setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                    if (view.getVisibility() != View.GONE)
                        view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:

                    if(view.getId() == R.id.twoWord1 && v.getId() == R.id.twoTarget1){
                        target1.setText(word1.getText());
                        target1.setBackgroundColor(Color.parseColor("#00FF00"));
                        word1.setVisibility(View.GONE);
                        i++;
                    }
                    if(view.getId() == R.id.twoWord2 && v.getId() == R.id.twoTarget2){
                        target2.setText(word2.getText());
                        target2.setBackgroundColor(Color.parseColor("#00FF00"));
                        word2.setVisibility(View.GONE);
                        i++;
                    }
                    if (i==2) {
                        Toast.makeText(getActivity(),"Pareizi!", Toast.LENGTH_SHORT).show();
                        checker.checkCompleted();
                    }
                    break;
            }
            return true;
        }
    };
    public void doSomething(TextView word,TextView target, View view, View v){
        }

    }




