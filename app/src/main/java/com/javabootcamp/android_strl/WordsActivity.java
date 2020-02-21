package com.javabootcamp.android_strl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.javabootcamp.android_strl.Fragments.EightWordFragment;
import com.javabootcamp.android_strl.Fragments.FiveWordFragment;
import com.javabootcamp.android_strl.Fragments.FourWordFragment;
import com.javabootcamp.android_strl.Fragments.NineWordFragment;
import com.javabootcamp.android_strl.Fragments.OneWordFragment;
import com.javabootcamp.android_strl.Fragments.SevenWordFragment;
import com.javabootcamp.android_strl.Fragments.SixWordFragment;
import com.javabootcamp.android_strl.Fragments.TenWordFragment;
import com.javabootcamp.android_strl.Fragments.ThreeWordFragment;
import com.javabootcamp.android_strl.Fragments.TwoWordFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsActivity extends AppCompatActivity implements Checkable {
    public static final String TAG = WordsActivity.class.getSimpleName();
    private static final String TOPIC_INDEX = "TOPIC_INDEX";
    private static final String PHRASE_INDEX = "PHRASE_INDEX";
    private int mTopicNumber;
    private List<String> mPhrases;
    private int currentPhraseIndex;
    private FragmentManager fragMan;
    private List<String> currentPhrase;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        Intent intent = getIntent();
        mTopicNumber = intent.getIntExtra(MainActivity.TOPIC_INDEX, -1);
        // Getting all phrases for particular chosen topic.
        mPhrases = getPhrases();

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        if (sharedPreferences.getInt(TOPIC_INDEX, -1) == mTopicNumber &&
            sharedPreferences.getInt(PHRASE_INDEX, -1) != mPhrases.size() -1) {
            currentPhraseIndex = sharedPreferences.getInt(PHRASE_INDEX, -1);
            currentPhrase = getPhraseAsList(mPhrases.get(currentPhraseIndex));
        } else {
            currentPhrase = getPhraseAsList(mPhrases.get(0));
            currentPhraseIndex = 0;
        }

        ActionBar bar = getSupportActionBar();
        bar.setTitle(Arrays.asList(getResources().getStringArray(R.array.topics)).get(mTopicNumber));
        // Initial Fragment creation
        fragMan = getSupportFragmentManager();
        fragMan.beginTransaction()
                .add(R.id.fragmentWords, getFragmentObject(currentPhrase.size(), currentPhrase))
                .commit();
        fragMan.popBackStack();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PHRASE_INDEX, currentPhraseIndex);
        editor.putInt(TOPIC_INDEX, mTopicNumber);
        editor.commit();
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
            case 1: return new OneWordFragment(words, this);
            case 2: return new TwoWordFragment(words, this);
            case 3: return new ThreeWordFragment(words, this);
            case 4: return new FourWordFragment(words, this);
            case 5: return new FiveWordFragment(words, this);
            case 6: return new SixWordFragment(words, this);
            case 7: return new SevenWordFragment(words, this);
            case 8: return new EightWordFragment(words, this);
            case 9: return new NineWordFragment(words, this);
            case 10: return new TenWordFragment(words, this);
            default:Log.d(TAG, "Cannot initialize correct fragment");
        }
        return new Fragment();
    }

    /**
     * Method which loads next fragment, is being called from fragment when task is finished.
     */
    @Override
    public void checkCompleted() {
        Handler handler = new Handler();
        final Context c = this;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentPhraseIndex < mPhrases.size() - 1) {
                    currentPhraseIndex++;
                    currentPhrase = getPhraseAsList(mPhrases.get(currentPhraseIndex));
                    fragMan.beginTransaction()
                        .replace(R.id.fragmentWords, getFragmentObject(currentPhrase.size(), currentPhrase))
                        .commit();
                    fragMan.popBackStack();
                } else {
                    Intent intent = new Intent(c, CongratsActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1000);
    }
}
