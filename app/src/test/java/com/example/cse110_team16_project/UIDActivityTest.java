package com.example.cse110_team16_project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.UUID;

@RunWith(RobolectricTestRunner.class)
public class UIDActivityTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    // Test for Story 5 Scenario 1
    @Test
    public void testInvisibleToVisible(){
        String public_code = UUID.randomUUID().toString();
        var preferences = RuntimeEnvironment.getApplication()
                .getSharedPreferences("user_info", Context.MODE_PRIVATE);
        var editor = preferences.edit();
        editor.putString("public_code", public_code);
        editor.apply();

        var scenario = ActivityScenario.launch(UIDActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);
        scenario.onActivity(activity -> {
            Button UID_Btn = activity.findViewById(R.id.UID_Btn);
            TextView UID_display = activity.findViewById(R.id.UID_display);
            UID_display.setVisibility(View.INVISIBLE);
            assertEquals(View.INVISIBLE, UID_display.getVisibility());

            UID_Btn.performClick();
            assertEquals(View.VISIBLE, UID_display.getVisibility());
            assertEquals(public_code, UID_display.getText().toString());
        });
    }

    // Test for Story 5 Scenario 1
    @Test
    public void testVisibleToInvisible(){
        String public_code = UUID.randomUUID().toString();
        var preferences = RuntimeEnvironment.getApplication()
                .getSharedPreferences("user_info", Context.MODE_PRIVATE);
        var editor = preferences.edit();
        editor.putString("public_code", public_code);
        editor.apply();

        var scenario = ActivityScenario.launch(UIDActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);
        scenario.onActivity(activity -> {
            Button UID_Btn = activity.findViewById(R.id.UID_Btn);
            TextView UID_display = activity.findViewById(R.id.UID_display);
            UID_display.setVisibility(View.VISIBLE);
            assertEquals(View.VISIBLE, UID_display.getVisibility());
            assertEquals(public_code, UID_display.getText().toString());

            UID_Btn.performClick();
            assertEquals(View.INVISIBLE, UID_display.getVisibility());
        });
    }
}
