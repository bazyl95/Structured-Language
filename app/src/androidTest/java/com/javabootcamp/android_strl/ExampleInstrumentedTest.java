package com.javabootcamp.android_strl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;

import com.javabootcamp.android_strl.fragments.OneWordFragment;
import com.javabootcamp.android_strl.fragments.WordFragment;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasSibling;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static java.security.AccessController.getContext;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@LargeTest // Emulation mode
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)// Android GUI Test
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.javabootcamp.android_strl", appContext.getPackageName());
    }


    @Rule
    public ActivityTestRule<MainActivity> topicActivityTestRule = new ActivityTestRule<>(MainActivity.class);

  //  @Rule
  //  public IntentsTestRule<MainActivity> intentsTestRuleMain =
        //    new IntentsTestRule<>(MainActivity.class);


    //@Rule
    // public ActivityTestRule<WordsActivity> wordsActivityTestRule = new ActivityTestRule<>(WordsActivity.class);

    @Test
    public void testRecycledListView() {
        topicActivityTestRule.getActivity();
        onView(withId(R.id.recyclerViewTopics))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        Log.i("cliclRecycledView", "item 1");

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWordsActivity() {

        try {
            Thread.sleep(800);
            topicActivityTestRule.getActivity().onTopicClick(1);
            onView(withId(R.id.fragmentWords)).perform(click());
            //Asserting that a view is displayed
            onView(withId(R.id.fragmentWords)).check(matches(isDisplayed()));
            Thread.sleep(800);

             Looper.prepare();
             //WordsActivity wa =(WordsActivity)l.get(0);
             WordsActivity wa = (WordsActivity) getActivityInstance();
             wa.prepareStaticPhrases();
            wa.addFragment();

            onView(withId(R.id.fragmentWords)).check(matches(isDisplayed()));
            onView(withId(R.id.fragmentWords));

            FragmentManager fragmentManager = getActivityInstance().getFragmentManager();
            Fragment fr = (Fragment)fragmentManager.getFragments().get(0);
            onView(allOf(withId(R.id.fragmentWords), withText("EJAM, BROKASTĪS.")));

            Log.i("-----------currentFragmentCountXXXXXXXXXXXXXXx",fr.toString());

            Log.i("-----------currentFragmentCountXXXXXXXXXXXXXXx",Integer.toString(fragmentManager.getFragments().size()));



        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }



    private Activity getActivityInstance(){
        final Activity[] currentActivity = {null};

        getInstrumentation().runOnMainSync(new Runnable(){
            public void run(){
                Collection<Activity> resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                Iterator<Activity> it = resumedActivity.iterator();
                currentActivity[0] = it.next();
            }
        });

        return currentActivity[0];
    }

}
