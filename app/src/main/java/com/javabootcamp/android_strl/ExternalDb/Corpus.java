package com.javabootcamp.android_strl.ExternalDb;





import org.json.simple.JSONArray;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.URL;

import java.util.ArrayList;

import java.util.List;

public class Corpus {

    public static List<String> searchName(String name){

        String data;

        List<String> results = new ArrayList<> ();

        String url_string = "http://nosketch.korpuss.lv/run.cgi/first?corpname=LVK2018&reload=&iquery="+name+"&queryselector=iqueryrow&lemma=&phrase=&word=&char=&cql=&default_attr=word&fc_lemword_window_type=both&fc_lemword_wsize=5&fc_lemword=&fc_lemword_type=all&usesubcorp=&fsca_doc.id=&fsca_doc.reference;format=json";

        try {

            URL url = new URL(url_string);

            InputStream stream = url.openStream();

            InputStreamReader isr = new InputStreamReader(stream);

            BufferedReader reader = new BufferedReader(isr);

            // json data receiving

            data = reader.readLine(); // json data are on the first line

            // now, in the 'data' variable, there is a json string

            // that can be parsed for json syntax
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder b = new StringBuilder();
            String input;

            while ((input = br.readLine()) != null){
                b.append(input);
            }

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(b.toString());


            JSONArray lineItems = (JSONArray) json.get("Lines");

            for (Object lineObject : lineItems) {

                JSONObject jsonLineItem = (JSONObject) lineObject;

                JSONArray kwic = (JSONArray) jsonLineItem.get ("Kwic");

                for(Object kwicObject : kwic){

                    JSONObject kwicItem = (JSONObject) kwicObject;

                    if(!kwicItem.get ("str").toString ().contains ("/")) {

                        if(!results.contains (kwicItem.get ("str"))) {

                            results.add ((String) kwicItem.get ("str"));

                       }

                    }

                }

            }

        }

        catch(Exception e) {

            e.printStackTrace();

        }

        return results;

    }

    public static void main(String[] args) {

        System.out.println (searchName("skola"));

    }

}

