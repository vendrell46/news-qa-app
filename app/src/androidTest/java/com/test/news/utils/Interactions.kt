package com.test.news.utils

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId

fun clickOn(@IdRes id: Int) {
    onView(withId(id)).perform(click())
}

fun typeTextOn(@IdRes id: Int, text: String) {
    onView(withId(id)).perform(clearText())
    onView(withId(id)).perform(typeText(text))
}
