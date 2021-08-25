package com.test.news.automation.login

import com.test.news.automation.login.LoginPageElements.Companion.buttonLogin
import com.test.news.automation.login.LoginPageElements.Companion.editTextPassword
import com.test.news.automation.login.LoginPageElements.Companion.editTextUserName
import com.test.news.automation.login.LoginPageElements.Companion.wrongLabelPopup
import com.test.news.utils.awaitUntilDisplayed
import com.test.news.utils.clickOn
import com.test.news.utils.typeTextOn

private const val VALID_USER_NAME = "user1"
private const val VALID_USER_PASSWORD = "password"

class LoginPageActions {

    companion object {
        fun logIn(user: String = VALID_USER_NAME, password: String = VALID_USER_PASSWORD) {
            typeTextOn(editTextUserName, user)
            typeTextOn(editTextPassword, password)
            clickOn(buttonLogin)
        }

        fun validateErrorIsDisplayed() {
            wrongLabelPopup.awaitUntilDisplayed()
        }
    }
}
