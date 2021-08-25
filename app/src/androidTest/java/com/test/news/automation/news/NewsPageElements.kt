package com.test.news.automation.news

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.test.news.R
import com.test.news.utils.matchers.childAtPosition
import org.hamcrest.Matcher
import org.hamcrest.Matchers

class NewsPageElements {
    
    companion object {
        private val recyclerView = R.id.recyclerViewNews
        private val image = R.id.imageView
        fun cardImage(imagePosition: Int): Matcher<View> = Matchers.allOf(
            withId(image),
            isDescendantOfA(
                childAtPosition(withId(recyclerView), imagePosition)
            )
        )
    }
}
