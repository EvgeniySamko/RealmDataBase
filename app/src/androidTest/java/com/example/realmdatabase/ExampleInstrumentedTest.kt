package com.example.realmdatabase

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAllComponentIsVisible_isSuccess() {
        Espresso.onView(ViewMatchers.withId(R.id.fabAddContact))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        val name = "Ivan"

        Espresso.onView(ViewMatchers.withId(R.id.etName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(name))
            .check(ViewAssertions.matches(ViewMatchers.withText(name)))// набирает текст

        val surname = "Ivanov"

        Espresso.onView(ViewMatchers.withId(R.id.etSurname))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(surname))
            .check(ViewAssertions.matches(ViewMatchers.withText(surname)))

        val phone = "+79501111111"

        Espresso.onView(ViewMatchers.withId(R.id.etNumber))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(phone))
            .check(ViewAssertions.matches(ViewMatchers.withText(phone)))

        Espresso.onView(ViewMatchers.withId(R.id.btnSave))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())


        Espresso.onView(ViewMatchers.withId(R.id.rvContacts))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    1,
                    clickChildViewWithId(R.id.tvEdit)
                )
            )


        val newName = "Evgeniy"

        Espresso.onView(ViewMatchers.withId(R.id.etName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(setTextInTextView(newName))
            .check(ViewAssertions.matches(ViewMatchers.withText(newName)))// набирает текст

        val newSurname2 = "Samko"
        Espresso.onView(ViewMatchers.withId(R.id.etSurname))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(setTextInTextView(newSurname2))
            .check(ViewAssertions.matches(ViewMatchers.withText(newSurname2)))

        val newPhone = "+79500000000"

        Espresso.onView(ViewMatchers.withId(R.id.etNumber))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(setTextInTextView(newPhone))
            .check(ViewAssertions.matches(ViewMatchers.withText(newPhone)))

        Espresso.onView(ViewMatchers.withId(R.id.btnSaveChanges))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.fabAddContact))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        val nameToAdd = "Petr"

        Espresso.onView(ViewMatchers.withId(R.id.etName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(nameToAdd))
            .check(ViewAssertions.matches(ViewMatchers.withText(nameToAdd)))// набирает текст

        val surnameToAdd = "Petrov"

        Espresso.onView(ViewMatchers.withId(R.id.etSurname))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(surnameToAdd))
            .check(ViewAssertions.matches(ViewMatchers.withText(surnameToAdd)))

        val phoneToAdd = "+79502222222"

        Espresso.onView(ViewMatchers.withId(R.id.etNumber))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(phoneToAdd))
            .check(ViewAssertions.matches(ViewMatchers.withText(phoneToAdd)))

        Espresso.onView(ViewMatchers.withId(R.id.btnSave))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.rvContacts))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    2,
                    clickChildViewWithId(R.id.tvEdit)
                )
            )

        Espresso.onView(ViewMatchers.withId(R.id.btnDelete))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.rvContacts))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

}