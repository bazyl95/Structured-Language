package com.javabootcamp.android_strl;

import android.content.Context;
import android.util.Log;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
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
    //   public ActivityTestRule<MainActivity> topicActivityTestRuleFirst = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void clickOnMainScreenRecycledViewFirstChoice() {


        // Click item at position 3
        topicActivityTestRule.getActivity();
        onView(withId(R.id.recyclerViewTopics))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        Log.i("cliclRecycledView", "item 1");


       onView(withId(R.id.fragmentWords))            // withId(R.id.my_view) is a ViewMatcher
                .perform(click())               // click() is a ViewAction
                .check(matches(isDisplayed())); //

        onView(withId(R.id.fragmentWords))
                .perform(ViewActions.swipeUp());

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void clickOnMainScreenRecycledView() {
        // Click item at position 3
        onView(withId(R.id.recyclerViewTopics))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        Log.i("cliclRecycledView", "item 3");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
