package com.test.news.automation.news

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.test.news.automation.login.LoginPageActions.Companion.logIn
import com.test.news.automation.news.NewsPageActions.Companion.clickOnFirstImage
import com.test.news.automation.news.NewsPageActions.Companion.newsPageLoaded
import com.test.news.automation.news.NewsPageActions.Companion.swipeImageLeft
import com.test.news.features.login.presentation.LoginActivity
import org.junit.Rule
import org.junit.Test

class NewsPageTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun testListImagesScrollableHorizontally() {
        logIn()
        newsPageLoaded()

        swipeImageLeft(FIRST_POSITION)
        swipeImageLeft(SECOND_POSITION)
    }

    @Test
    fun testUserRedirectedToBrowserOnImageClick() {
        logIn()
        clickOnFirstImage()
    }
}