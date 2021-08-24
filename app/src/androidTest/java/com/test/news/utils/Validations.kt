package com.test.news.utils

import android.view.View
import androidx.test.espresso.NoMatchingViewException
import org.hamcrest.Matcher

const val TIMEOUT_MILLIS = 20000L

inline fun <reified T, R> T.whenDisplayed(
    timeout: Long = TIMEOUT_MILLIS,
    action: T.() -> R
): R {
    var startTime = System.currentTimeMillis()
    val endTime = startTime + timeout
    var exception: NoMatchingViewException

    do {
        startTime = System.currentTimeMillis()

        try {
            isElementDisplayed(this)
            return action()
        } catch (e: NoMatchingViewException) {
            exception = e
            Thread.sleep(1000)
        }
    } while (startTime < endTime)

    throw exception
}

inline fun <reified T> T.awaitUntilDisplayed(timeout: Long = TIMEOUT_MILLIS) {
    this.whenDisplayed(timeout) { }
}

@Suppress("UNCHECKED_CAST")
fun <T> isElementDisplayed(arg: T) {
    when(arg) {
        is String -> assertDisplayed(arg as String)
        is Int -> assertDisplayed(arg as Int)
        else -> assertDisplayed(arg as Matcher<View>)
    }
}
