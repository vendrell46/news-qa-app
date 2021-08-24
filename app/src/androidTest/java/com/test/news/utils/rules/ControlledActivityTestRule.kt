package com.test.news.utils.rules

import android.app.Activity
import androidx.test.rule.ActivityTestRule

class ControlledActivityTestRule<T : Activity?>(activityClass: Class<T>?) :
    ActivityTestRule<T>(activityClass, false) {

    fun relaunchActivity() {
        finishActivity()
        launchActivity(activityIntent)
    }
}
