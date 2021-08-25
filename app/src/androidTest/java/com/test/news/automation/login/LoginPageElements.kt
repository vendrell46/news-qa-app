package com.test.news.automation.login

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import com.test.news.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.endsWith

class LoginPageElements {

    companion object {
        val editTextUserName = R.id.editTextUserName
        val editTextPassword = R.id.editTextPassword
        val buttonLogin = R.id.buttonLogin
        val wrongLabelPopup: Matcher<View> =
            withClassName(
                endsWith("AppCompatTextView")
            )
    }
}
