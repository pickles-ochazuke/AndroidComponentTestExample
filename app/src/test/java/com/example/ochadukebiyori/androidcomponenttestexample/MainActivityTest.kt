package com.example.ochadukebiyori.androidcomponenttestexample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.core.app.launchActivity

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun 起動したらHelloWorldが表示されるべき() {
        val scenario = launchActivity<MainActivity>()
        onView(withId(R.id.helloWorld))
            .check(matches(withText("Hello World!")))
        scenario.close()
    }
}