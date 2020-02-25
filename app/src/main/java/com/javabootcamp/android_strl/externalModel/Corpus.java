package com.javabootcamp.android_strl.externalModel;

import android.util.Log;

import com.javabootcamp.android_strl.WordsActivity;

import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Corpus {
    private static final String TAG = Corpus.class.getSimpleName();
    private WordsActivity activity;
    private List<String> phrases;

    public Corpus(WordsActivity activity) {
        this.activity = activity;
    }

    public void preparePhrases() {
        String url = "http://nosketch.korpuss.lv/run.cgi/view?q=atag%2C[lemma%3D%22vi%C5%86%C5%A1%22|lemma%3D%22vi%C5%86a%22|lemma%3D%22es%22][tag%3D%22v...p.*%22][lemma%3D%22m%C4%81ja%22|lemma%3D%22skola%22];fromp=1;corpname=LVK2018&attrs=word%2Ctag%2Clemma&ctxattrs=word&structs=p%2Cg&refs=%3Ddoc.id;format=json";
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(req);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "Response failed.", e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String json = response.body().string();
                if (response.isSuccessful()) {
                    transformJSON(json);
                } else {
                    Log.e(TAG, "Response was not succesfull");
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            activity.finish();
                        }
                    });
                }
            }
        });
    }

    private void transformJSON(String json) {
        JSONParser parser = new JSONParser();
        phrases = new ArrayList<>();
        try {
            JSONObject jObject = (JSONObject) parser.parse(json);
            JSONArray lineItems = (JSONArray) jObject.get("Lines");
            for (Object lineObject : lineItems) {
                JSONObject jsonLineItem = (JSONObject) lineObject;
                JSONArray kwic = (JSONArray) jsonLineItem.get("Kwic");
                String phrase = "";
                for (int i = 0; i < kwic.size(); i += 2) {
                    JSONObject kwicItem = (JSONObject) kwic.get(i);
                    phrase += kwicItem.get("str").toString();
                }
                phrase = phrase.toUpperCase();
                if (phrase.charAt(0) == ' ') {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < phrase.length(); i++) {
                        sb.append(phrase.charAt(i));
                    }
                    phrase = sb.toString();
                }
                if (!phrases.contains(phrase)) {
                    phrases.add(phrase);
                }
            }
            updateUi();
        } catch (ParseException e) {
            Log.e(TAG, "JSON Exception caught: ", e);
        } catch (Exception e) {
            Log.e(TAG, "Exception caught: ", e);
        }
    }

    private void updateUi() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.setPhrases(phrases);
                activity.getSavedProgress();
                activity.addFragment();
            }
        });
    }
}

