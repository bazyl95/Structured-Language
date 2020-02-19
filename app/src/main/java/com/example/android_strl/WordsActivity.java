package com.example.android_strl;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsActivity extends AppCompatActivity {
    public static String TAG = WordsActivity.class.getSimpleName();
    private int mTopicNumber;
    private List<String> mPhrases;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        mTopicNumber = intent.getIntExtra("TOPIC", -1);

        setPhrases();
        // next code is just for testing purposes.
            StringBuilder sb = new StringBuilder();
            for (String word : getPhraseAsList(mPhrases.get(1))) {
                sb.append(word).append("\n");
            }
            textView.setText(sb.toString());
        // End of testing
    }

    /**
     * Method sets phrases from resources for chosen topic
     */
    private void setPhrases() {
        mPhrases = new ArrayList<>();
        String[] resorcePhrases = {};
        Resources res = getResources();
        resorcePhrases = res.getStringArray(getPhrasesId());
        mPhrases.addAll(Arrays.asList(resorcePhrases));
    }

    /**
     * Method which returns id of string-array element from resources by index of chosen topic.
     * @return int - id of string-array element from resources.
     */
    private int getPhrasesId() {
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
}
