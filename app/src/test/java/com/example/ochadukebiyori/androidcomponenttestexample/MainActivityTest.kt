package com.example.ochadukebiyori.androidcomponenttestexample
// android
import android.app.Activity
import android.app.Instrumentation
import android.content.Intent

// androidx
import androidx.test.ext.junit.runners.AndroidJUnit4

// espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule

import org.hamcrest.Matchers

// junit
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val rule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun 起動したらHelloWorldが表示されるべき() {
        onView(withId(R.id.helloWorld))
            .check(matches(withText("Hello World!")))
    }

    @Test
    fun ボタンを押すとOtherActivityが起動するべき() {
        onView(withId(R.id.button)).perform(click())

        intended(
            Matchers.allOf(
                hasComponent(OtherActivity::class.java.name)
            )
        )
    }

    @Test
    fun OtherActivityから受け取った結果がテキストに反映されるべき() {
        val intent = Intent().apply {
            this.putExtra("greeting", "Hi World!")
        }

        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, intent)
        intending(hasComponent(OtherActivity::class.java.name)).respondWith(result)

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.helloWorld)).check(matches(withText("Hi World!")))
    }
}