package com.javabootcamp.android_strl;

import android.content.Intent;
import android.view.MenuItem;

//import androidx.test.rule.ActivityTestRule;

import com.javabootcamp.android_strl.Adapters.TopicRecyclerViewAdapter;
import com.javabootcamp.android_strl.ExternalDb.Corpus;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void ExternalDB_Corpus_searchName_getResult() {
        assertFalse(Corpus.searchName("skola").isEmpty());
    }

    @Test
    public void ExternalDB_Corpus_searchName_throwExceptionForEmpty() {
        try {
            List<String> list = Corpus.searchName("");
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }


}
