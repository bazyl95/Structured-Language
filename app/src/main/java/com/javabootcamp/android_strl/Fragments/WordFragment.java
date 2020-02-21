package com.javabootcamp.android_strl.Fragments;

import android.content.ClipData;
import android.graphics.Color;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.javabootcamp.android_strl.Checkable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class WordFragment extends Fragment {
    private static final String TAG = "WordFragment";

    abstract void setUpFragment(View v);
    protected final List<String> words;
    protected List<Integer> listOfWordsIds;
    protected List<Integer> listOfTargetsIds;
    protected List<TextView> listOfWordViews;
    protected List<TextView> listOfTargetViews;
    protected Checkable checker;

    public WordFragment(List<String> words, Checkable checker) {
        this.words = words;
        this.checker = checker;
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
            TextView thisTextViewOriginal = getSameIdWordView(view.getId());
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_STARTED:
                    thisTextViewOriginal.setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if (thisTextViewOriginal.getVisibility() != View.GONE)
                        thisTextViewOriginal.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    checkForCorrectDrop(v, view);
                    if (listOfTargetViews.size() == 0) {
                        checker.checkCompleted();
                    }
                    break;
            }
            return true;
        }
    };

    void checkForCorrectDrop(View v, View view) {
        TextView word = (TextView) view;
        for (int j = 0; j < listOfTargetViews.size(); j++) {
            if(word.getText().equals(words.get(j)) && v.getId() == listOfTargetsIds.get(j)) {
                listOfTargetViews.get(j).setText(word.getText());
                listOfTargetViews.get(j).setBackgroundColor(Color.parseColor("#00FF00"));
                getSameIdWordView(word.getId()).setVisibility(View.GONE);
                listOfTargetViews.remove(j);
                words.remove(j);
                listOfTargetsIds.remove(j);
            }
        }
    }

    protected TextView getSameIdWordView(int id) {
        for (TextView view : listOfWordViews) {
            if (view.getId() == id)
                return view;
        }
        return null;
    }

    protected List<TextView> getWordTextViews(View view) {
        List<TextView> list = new ArrayList<>();
        for (int id : listOfWordsIds) {
            list.add((TextView)view.findViewById(id));
        }
        return list;
    }

    protected List<TextView> getTargetTextViews(View view) {
        List<TextView> list = new LinkedList<>();
        for (int id : listOfTargetsIds) {
            list.add((TextView)view.findViewById(id));
        }
        return list;
    }

    protected void setOnTouchListeners(View.OnTouchListener listener) {
        for (TextView view : listOfWordViews) {
            view.setOnTouchListener(listener);
        }
    }

    protected void setOnDragListenets(View.OnDragListener listener) {
        for (TextView view : listOfTargetViews) {
            view.setOnDragListener(listener);
        }
    }

    protected void setWordsRandomly() {
        List<String> copyOfWords = new ArrayList<>(words);
        List<String> randomWords = new ArrayList<>();
        while (randomWords.size() < words.size()) {
            Random rand = new Random();
            int randomInt = rand.nextInt(copyOfWords.size());
            randomWords.add(copyOfWords.get(randomInt));
            copyOfWords.remove(randomInt);
        }
        Log.d(TAG, randomWords.toString());
        for (int i = 0; i < listOfWordViews.size(); i++) {
            listOfWordViews.get(i).setText(randomWords.get(i));
        }
    }
}
