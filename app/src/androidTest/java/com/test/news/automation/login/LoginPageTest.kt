package com.test.news.automation.login

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.test.news.automation.login.LoginPageActions.Companion.logIn
import com.test.news.automation.login.LoginPageActions.Companion.validateErrorIsDisplayed
import com.test.news.automation.news.NewsPageActions.Companion.newsPageLoaded
import com.test.news.features.login.presentation.LoginActivity
import com.test.news.features.news.presentation.NewsActivity
import com.test.news.utils.*
import com.test.news.utils.rules.ControlledActivityTestRule
import org.junit.Rule
import org.junit.Test

private const val INVALID_USER_NAME = "uuuser1"
private const val INVALID_USER_PASSWORD = "pppassword"

class LoginPageTest {

    private val rule = ControlledActivityTestRule(NewsActivity::class.java)

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun testLoginSuccessfulWithValidCredentials() {
        logIn()
        newsPageLoaded()
    }

    @Test
    fun testLoginFailsWithWrongCredentials() {
        logIn(password = INVALID_USER_PASSWORD)
        validateErrorIsDisplayed()
        logIn(user = INVALID_USER_NAME)
        validateErrorIsDisplayed()
    }

    @Test
    fun testUserStillLoggedInAfterHardCloseAndRelaunch() {
        logIn()
        hardCloseAndRelaunchTheApp(rule)
        newsPageLoaded()
    }

    @Test
    fun testUserStillLoggedInAfterSoftCloseAndRelaunch() {
        logIn()
        softCloseUsingHomeButtonAndRelaunchTheApp()
        newsPageLoaded()
    }
}
