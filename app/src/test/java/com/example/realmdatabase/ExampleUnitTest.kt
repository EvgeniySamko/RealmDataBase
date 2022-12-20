package com.example.realmdatabase

import com.example.realmdatabase.fakeObjects.FakeContact
import com.example.realmdatabase.fakeObjects.FakeContactRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val number = "+88002221111"
    val contact = FakeContact(
        name = "TestName",
        surname = "TestSurname",
        phone = "88002221111"
    )
    val contactRepository = FakeContactRepository()


    @Test
    fun testAddContact() {

        contactRepository.addContact(contact)
        val list = contactRepository.getAllContacts()
        val lastContact = list.last()

        assertEquals(contact, lastContact)
        assertNotEquals(number, lastContact.phone)
    }

    @Test
    fun testDeleteContact() {
        val contactfirst = FakeContact(
            name = "TestName",
            surname = "TestSurname",
            phone = "88002221111"
        )
        val contactSecond = FakeContact(
            name = "SecondTestName",
            surname = "SecondTestSurname",
            phone = "Second88002221111"
        )

        contactRepository.addContact(contactfirst)
        contactRepository.addContact(contactSecond)
        contactRepository.deleteContact(contactSecond)
        val list = contactRepository.getAllContacts()
        val lastContact = list.last()

        assertEquals(contactfirst, lastContact)

    }

    @Test
    fun testSearchContact() {
        val contactfirst = FakeContact(
            name = "111111",
            surname = "11111",
            phone = "11111111"
        )
        val contactSecond = FakeContact(
            name = "2222222",
            surname = "2222222",
            phone = "2222222"
        )
        val contactThird = FakeContact(
            name = "33333",
            surname = "33333",
            phone = "33333"
        )

        contactRepository.addContact(contactfirst)
        contactRepository.addContact(contactSecond)
        contactRepository.contactsShown("2")
        val list = contactRepository.contactsShown("2")
        assertEquals(1, list.size)
    }

}
