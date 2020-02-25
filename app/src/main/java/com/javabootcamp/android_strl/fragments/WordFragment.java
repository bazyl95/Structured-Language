package com.javabootcamp.android_strl.fragments;

import android.content.ClipData;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.javabootcamp.android_strl.Checkable;
import com.javabootcamp.android_strl.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class WordFragment extends Fragment {
    private static final String TAG = "WordFragment";

    /**
     * Method where listOfWordsIds and listOfTargetsIds are being initialized differently in every fragment,
     * that's why this method is abstract, different implementation for different fragment, but with same logic behind it
     * @param v View - view of a whole activity
     */
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
    // Initialization of touchListener.
    View.OnTouchListener touchListener = new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);
            return true;
        }

    };
    // Initialization of dargListener
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

    /**
     * Checks whether dropped view was dropped correctly
     * @param v View - view which was dragged
     * @param view View - view which was dropped
     */
    private void checkForCorrectDrop(View v, View view) {
        TextView word = (TextView) view;
        for (int j = 0; j < listOfTargetViews.size(); j++) {
            if(word.getText().equals(words.get(j)) && v.getId() == listOfTargetsIds.get(j)) {
                listOfTargetViews.get(j).setText(word.getText());
                listOfTargetViews.get(j).setBackgroundResource(R.drawable.rounded_target_complete);
                getSameIdWordView(word.getId()).setVisibility(View.GONE);
                listOfTargetViews.remove(j);
                words.remove(j);
                listOfTargetsIds.remove(j);
                break;
            }
        }
    }

    /**
     * Method returns reference to word TextView object with given id
     * @param id int - id of searched TextView
     * @return TextView - if found(and it meant to be found every time) returns this TextView
     */
    protected TextView getSameIdWordView(int id) {
        for (TextView view : listOfWordViews) {
            if (view.getId() == id)
                return view;
        }
        return null;
    }

    /**
     * Method fills listOfWordViews with TextViews found using list of WordIds
     * @param view View - View of whole layout of fragment
     * @return list List<TextView> - filled list with TextViews
     */
    protected List<TextView> getWordTextViews(View view) {
        List<TextView> list = new ArrayList<>();
        for (int id : listOfWordsIds) {
            list.add((TextView)view.findViewById(id));
        }
        return list;
    }

    /**
     * Method fills listOfTargetViews with TextViews found using list of TargetIds
     * @param view View - View of whole layout of fragment
     * @return list List<TextView> - filled list with TextViews
     */
    protected List<TextView> getTargetTextViews(View view) {
        List<TextView> list = new LinkedList<>();
        for (int id : listOfTargetsIds) {
            list.add((TextView)view.findViewById(id));
        }
        return list;
    }

    /**
     * Method assigns to all element in listOfWordViews with passed onTouchListener
     * @param listener - onTouchListener initialized in this class.
     */
    protected void setOnTouchListeners(View.OnTouchListener listener) {
        for (TextView view : listOfWordViews) {
            view.setOnTouchListener(listener);
        }
    }

    /**
     * Method assigns to all element in listOfTargetViews with passed onDragListener
     * @param listener - onDragListener initialized in this class.
     */
    protected void setOnDragListenets(View.OnDragListener listener) {
        for (TextView view : listOfTargetViews) {
            view.setOnDragListener(listener);
        }
    }

    /**
     * Method randomly assigns values to elements of listOfWordsViews from given to class list of words.
     */
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
