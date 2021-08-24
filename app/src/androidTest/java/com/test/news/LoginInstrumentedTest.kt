package com.test.news

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.test.news.features.login.presentation.LoginActivity
import com.test.news.utils.*
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

private const val VALID_USER_NAME = "user1"
private const val VALID_USER_PASSWORD = "password"

class LoginInstrumentedTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun testLoginSuccessfulWithValidCredentials() {
        val editTextUserName = R.id.editTextUserName
        val editTextPassword = R.id.editTextPassword
        val buttonLogin = R.id.buttonLogin
        val recyclerView = R.id.recyclerViewNews
        val image = R.id.imageView
        val firstImage: Matcher<View> = allOf(
            withId(image),
            isDescendantOfA(
                childAtPosition(withId(recyclerView), 0)
            )
        )

        typeTextOn(editTextUserName, VALID_USER_NAME)
        typeTextOn(editTextPassword, VALID_USER_PASSWORD)
        clickOn(buttonLogin)

        firstImage.awaitUntilDisplayed()
    }
}
