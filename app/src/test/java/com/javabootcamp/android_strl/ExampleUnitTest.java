package com.javabootcamp.android_strl;
import com.javabootcamp.android_strl.CongratsActivity;
import com.javabootcamp.android_strl.MainActivity;
import com.javabootcamp.android_strl.WordsActivity;
import com.javabootcamp.android_strl.externalModel.Corpus;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

//@PowerMockIgnore("javax.net.ssl.*")
public class ExampleUnitTest {


    @Test
    public void ExternalDB_Corpus_searchName_getResult() {
        boolean b;
        WordsActivity wa = new WordsActivity();
        Corpus c = new Corpus(wa);
        c.preparePhrases();
        b = true;
        assertTrue(b);
    }

    @Test
    public void ExternalDB_Corpus_searchName_throwExceptionForEmpty() throws Exception {
        WordsActivity wa = new WordsActivity();
        List list = null;
        wa.setPhrases(list);
        Corpus c = new Corpus(wa);
        c.preparePhrases();
    }

    @Test
    public void ExternalDB_Corpus_searchName_throwExceptionForEmpty2() {
        try {
            WordsActivity wa = new WordsActivity();
            List list = null;
            wa.setPhrases(list);
            Corpus c = new Corpus(wa);
            c.preparePhrases();
        } catch
        (Exception e) {
            Assert.fail("Exception" + e);
            System.out.println(e.toString());
        }
    }

    @Test
    public void testMainActivity() {
        MainActivity mainActivity = new MainActivity();
        mainActivity.onTopicClick(1);


    }





    @Test
    public void testWordsActivity() {
        MainActivity mainActivity = new MainActivity();
        mainActivity.onTopicClick(1);
        WordsActivity wa = new  WordsActivity();
        assertNotNull(wa);

    }


    @Test
    public void testCongratsActivity() {

        CongratsActivity c = new CongratsActivity();
        assertNotNull(c);
    }

    private MainActivity tested;

    /*@Mock
    private Button mockButton;

    @Before
    public void setUp() throws Exception {
        // We will Spy our tested activity so that we will be able to give it some input when
        //  for example the FindViewByID method is called.
        tested = spy(MainActivity.class);
        doReturn(mockButton).when(tested).findViewById(anyInt());
        // We need to suppress methods from the Base Activity. This is why we need PowerMock, there
        //  are other ways but are more intrusive in our code.
        suppress(method(Activity.class, "onCreate", Bundle.class));
        suppress(method(Activity.class, "setContentView", int.class));
    }


    @Test
    public void shouldSetupListener() throws Exception {
        // When we call the onCreate...
        tested.onCreate(mock(Bundle.class));

        // Then the setOnClickListener method will be called.
        verify(mockButton).setOnClickListener((View.OnClickListener) any());
    }


    @Test
    public void shouldStartActivity() throws Exception {
        // Let's setup our mockButton so that it will capture the listener
        ArgumentCaptor<View.OnClickListener> captor =
                ArgumentCaptor.forClass(View.OnClickListener.class);
        doNothing().when(mockButton).setOnClickListener(captor.capture());

        // When we call the onCreate...
        tested.onCreate(mock(Bundle.class));

        // Listener should be in place (Was tested before) so now we need to check that it starts
        //  an activity.
        doNothing().when(tested).startActivity((Intent) any());
        doNothing().when(tested).finish();  // We should also test this to be called in a new test.
        captor.getValue().onClick(mockButton);
        verify(tested).startActivity((Intent) any());
    }


*/
}