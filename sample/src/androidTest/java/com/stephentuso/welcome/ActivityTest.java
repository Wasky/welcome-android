package com.stephentuso.welcome;

import static org.junit.Assert.assertNotNull;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;

import com.stephentuso.welcomeexample.TestActivity;

import org.junit.After;
import org.junit.Before;

/**
 * Created by stephentuso on 10/10/16.
 */

/**
 * Extend this class to have access to an activity in unit tests
 */
public class ActivityTest {

    protected Activity activity;
    protected Instrumentation instrumentation;

    @Before
    public void initActivity() {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(TestActivity.class.getName(), null, false);
        instrumentation.addMonitor(monitor);

        Intent intent = new Intent(instrumentation.getTargetContext(), TestActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        instrumentation.startActivitySync(intent);

        activity = instrumentation.waitForMonitor(monitor);
        assertNotNull(activity);
    }

    @After
    public void finishActivity() {
        if (activity != null) {
            activity.finish();
        }
    }

}
