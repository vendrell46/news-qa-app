package com.test.news.automation.news

import com.test.news.automation.news.NewsPageElements.Companion.cardImage
import com.test.news.utils.awaitUntilDisplayed
import com.test.news.utils.clickOn
import com.test.news.utils.swipeLeft
import com.test.news.utils.whenDisplayed

const val FIRST_POSITION = 0
const val SECOND_POSITION = 1

class NewsPageActions {

    companion object {
        fun newsPageLoaded() {
            cardImage(FIRST_POSITION).awaitUntilDisplayed()
        }

        fun swipeImageLeft(position: Int) {
            swipeLeft(cardImage(position))
        }

        fun clickOnFirstImage() {
            cardImage(FIRST_POSITION).whenDisplayed { clickOn(this) }
        }
    }
}
