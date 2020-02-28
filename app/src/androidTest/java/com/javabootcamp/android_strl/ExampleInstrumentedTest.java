package com.javabootcamp.android_strl;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Looper;
import android.util.Log;


import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


import java.util.Collection;
import java.util.Iterator;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@LargeTest // Emulation mode
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4ClassRunner.class)// Android GUI Test
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.javabootcamp.android_strl", appContext.getPackageName());
    }


    @Rule
    public ActivityTestRule<MainActivity> topicActivityTestRule = new ActivityTestRule<>(MainActivity.class);


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

            onView(allOf(withId(R.id.fragmentWords), withText("EJAM, BROKASTĪS.")));




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
