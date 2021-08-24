package com.test.news

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.test.news.features.login.presentation.LoginActivity
import com.test.news.utils.*
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.endsWith
import org.junit.Rule
import org.junit.Test

private const val FIRST_POSITION = 0
private const val VALID_USER_NAME = "user1"
private const val VALID_USER_PASSWORD = "password"
private const val INVALID_USER_NAME = "uuuser1"
private const val INVALID_USER_PASSWORD = "pppassword"


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
                childAtPosition(withId(recyclerView), FIRST_POSITION)
            )
        )

        typeTextOn(editTextUserName, VALID_USER_NAME)
        typeTextOn(editTextPassword, VALID_USER_PASSWORD)
        clickOn(buttonLogin)

        firstImage.awaitUntilDisplayed()
    }

    @Test
    fun testLoginFailsWithWrongCredentials() {
        val editTextUserName = R.id.editTextUserName
        val editTextPassword = R.id.editTextPassword
        val buttonLogin = R.id.buttonLogin
        val wrongLabelPopup: Matcher<View> =
            withClassName(
                endsWith("AppCompatTextView")
            )

        typeTextOn(editTextUserName, VALID_USER_NAME)
        typeTextOn(editTextPassword, INVALID_USER_PASSWORD)
        clickOn(buttonLogin)

        wrongLabelPopup.awaitUntilDisplayed()

        typeTextOn(editTextUserName, INVALID_USER_NAME)
        typeTextOn(editTextPassword, VALID_USER_PASSWORD)
        clickOn(buttonLogin)

        wrongLabelPopup.awaitUntilDisplayed()
    }
}
