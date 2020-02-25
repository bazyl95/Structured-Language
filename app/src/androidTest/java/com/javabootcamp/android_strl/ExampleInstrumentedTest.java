package com.javabootcamp.android_strl;

import android.content.Context;
import android.content.Intent;
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
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
   //public ActivityTestRule<WordsActivity> wordsActivityTestRule = new ActivityTestRule<>(WordsActivity.class);

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
      //  wordsActivityTestRule.getActivity();
      // onView(withId(R.id.fragmentWords))            // withId(R.id.my_view) is a ViewMatcher
              //  .perform(click()).check(matches(isDisplayed()));
       // topicActivityTestRule.getActivity().getApplication().onCreate();
       // Intent int1 = new Intent(Intent.ACTION_MAIN);

      //  onView(withId(R.id.fragmentWords)).perform(click());
      //  wordsActivityTestRule.getActivity();
       // onView(withId(R.id.fragmentWords))
         //       .perform(ViewActions.click());
      //  onView(withText(endsWith("1"))).check(matches(isDisplayed()));

        //onView(withText(containsString("Word"))).check(matches(isDisplayed()));
       // onView(withId(R.id.oneWord1)).perform(click());
        onView(withText(containsString("Adapter"))).perform(click());

    }

}
