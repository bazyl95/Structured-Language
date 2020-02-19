package com.example.android_strl;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.android_strl.Fragments.EightWordFragment;
import com.example.android_strl.Fragments.FiveWordFragment;
import com.example.android_strl.Fragments.FourWordFragment;
import com.example.android_strl.Fragments.NineWordFragment;
import com.example.android_strl.Fragments.OneWordFragment;
import com.example.android_strl.Fragments.SevenWordFragment;
import com.example.android_strl.Fragments.SixWordFragment;
import com.example.android_strl.Fragments.TenWordFragment;
import com.example.android_strl.Fragments.ThreeWordFragment;
import com.example.android_strl.Fragments.TwoWordFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsActivity extends AppCompatActivity {
    public static String TAG = WordsActivity.class.getSimpleName();
    private int mTopicNumber;
    private List<String> mPhrases;
    private int currentPhraseIndex;
    private FragmentManager fragMan;
    private List<String> currentPhrase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        Intent intent = getIntent();
        mTopicNumber = intent.getIntExtra(MainActivity.TOPIC_INDEX, -1);
        // Getting all phrases for particular chosen topic.
        mPhrases = getPhrases();
        currentPhrase = getPhraseAsList(mPhrases.get(0));
        currentPhraseIndex = 0;
        // Initial Fragment creation
        if (savedInstanceState == null) {
            fragMan = getSupportFragmentManager();
            fragMan.beginTransaction()
                    .add(R.id.fragmentWords, getFragmentObject(currentPhrase.size(), currentPhrase))
                    .commit();
        } else {
            // TODO: Implement retrieving saved data after destruction of activity. IF needed.
        }
    }

    /**
     * Method which is called when fragment with next word needed to be attached.
     */
    public void nextWord() {
        if (currentPhraseIndex < mPhrases.size() - 1) {
            List<String> nextPhrase = getPhraseAsList(mPhrases.get(currentPhraseIndex + 1));
            fragMan.beginTransaction()
                    .replace(R.id.fragmentWords, getFragmentObject(nextPhrase.size(), nextPhrase))
                    .commit();
            currentPhraseIndex++;
        } else {
            // TODO: Implement calling to CongratulationsActivity and closing this activity.
        }
    }

    /**
     * Method sets phrases from resources for chosen topic
     * @return ArrayList <String> - List with phrases fetched from resources.
     */
    private List<String> getPhrases() {
        Resources res = getResources();
        return new ArrayList<>(Arrays.asList(res.getStringArray(getIdOfPhrasesResource())));
    }

    /**
     * Method which returns id of string-array element from resources by index of chosen topic.
     * @return int - id of string-array element from resources.
     */
    private int getIdOfPhrasesResource() {
        switch(mTopicNumber) {
            case 0:
                return R.array.rits;
            case 1:
                return R.array.brokastis;
            case 2:
                return R.array.gerbsanas;
            case 3:
                return R.array.pastaiga;
            case 4:
                return R.array.skola;
            case 5:
                return R.array.pecpusdiena;
            case 6:
                return R.array.speles;
            case 7:
                return R.array.vakars;
            case 8:
                return R.array.jauna_diena;
            case 9:
                return R.array.pec_skolas;
            case 10:
                return R.array.likumi;
            case 11:
                return R.array.sarunas;
            case 12:
                return R.array.iedrosinajums;
            default:
                Log.d(TAG, "Topic was not fetched from strings.xml");
        }
        return -1;
    }

    /**
     * Method to transform given phrase into separate words.
     * @param phrase - Input phrase.
     * @return ArrayList<String> - Output List of words in a phrase.
     */
    private List<String> getPhraseAsList(String phrase) {
        return new ArrayList<>(Arrays.asList(phrase.split("\\s")));
    }

    /**
     * Method returns required fragment object, based on required amount of words
     * @param wordAmount - Amount of words in a given phrase
     * @param words List<String> - List of words in one phrase.
     * @return Fragment - Returns a specific custom Fragment object.
     */
    private Fragment getFragmentObject(int wordAmount, List<String> words) {
        switch (wordAmount) {
            case 1: return new OneWordFragment(words);
            case 2: return new TwoWordFragment(words);
            case 3: return new ThreeWordFragment(words);
            case 4: return new FourWordFragment(words);
            case 5: return new FiveWordFragment(words);
            case 6: return new SixWordFragment(words);
            case 7: return new SevenWordFragment(words);
            case 8: return new EightWordFragment(words);
            case 9: return new NineWordFragment(words);
            case 10: return new TenWordFragment(words);
            default:Log.d(TAG, "Cannot initialize correct fragment");
        }
        return new Fragment();
    }
}
