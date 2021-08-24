package com.test.news.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matcher

fun assertDisplayed(@IdRes id: Int) {
    onView(withId(id)).check(matches(isDisplayed()))
}

fun assertDisplayed(string: String) {
    onView(withText(string)).check(matches(isDisplayed()))
}

fun assertDisplayed(matcher: Matcher<View>) {
    onView(matcher).check(matches(isDisplayed()))
}
