package com.test.news.utils

import android.app.Activity
import android.os.RemoteException
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.test.news.utils.rules.ControlledActivityTestRule


fun hardCloseAndRelaunchTheApp(rule: ControlledActivityTestRule<out Activity>) {
    rule.relaunchActivity()
}

fun getUiDevice(): UiDevice {
    return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
}

fun softCloseUsingHomeButtonAndRelaunchTheApp() {
    getUiDevice().pressHome()
    pressRecentAppsTwoTimes()
}

private fun pressRecentAppsTwoTimes() {
    val device = getUiDevice()
    try {
        device.pressRecentApps()
        Thread.sleep(2000)
        device.pressRecentApps()
    } catch (e: RemoteException) {
        e.printStackTrace()
    }
}