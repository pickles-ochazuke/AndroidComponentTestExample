package com.example.ochadukebiyori.androidcomponenttestexample

// androidx
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.rules.activityScenarioRule

// espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4

// junit
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var rule= activityScenarioRule<MainActivity>()

    @Test
    fun 起動したらHelloWorldが表示されるべき() {
        onView(withId(R.id.helloWorld))
            .check(matches(withText("Hello World!")))
    }
}