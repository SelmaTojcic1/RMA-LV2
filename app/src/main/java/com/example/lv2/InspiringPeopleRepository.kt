package com.example.lv2

import com.example.lv2.model.InspiringPerson

object InspiringPeopleRepository {

    private val barackQuotes = mutableListOf("If you're walking down the right path and you're willing to keep walking, eventually you'll make progress.",
    "Money is not the only answer, but it makes a difference.")

    private val michelleQuotes = mutableListOf("We need to do a better job of putting ourselves higher on our own 'to do' list.",
    "Just try new things. Don't be afraid. Step out of your comfort zones and soar, all right?")

    private val inspiringPeople = mutableListOf<InspiringPerson>(

        InspiringPerson( "Barack Obama", "04/08/1961 - ","Barack Obama is " +
                "an American politician and attorney who served as the 44th president of the United " +
                "States from 2009 to 2017. A member of the Democratic Party, Obama was the first " +
                "African-American president of the United States.",
            "https://upload.wikimedia.org/wikipedia/commons/8/8d/President_Barack_Obama.jpg",
                barackQuotes),

        InspiringPerson( "Michelle Obama", "17/01/1964 - ", "Michelle Obama " +
                "is an American attorney and author who served as the First Lady of the " +
                "United States from 2009 to 2017. She was the first African-American woman " +
                "to serve in this position.",
            "https://upload.wikimedia.org/wikipedia/commons/4/4b/Michelle_Obama_2013_official_portrait.jpg",
                michelleQuotes)
    )

    fun getInspiringPeople(): List<InspiringPerson> = inspiringPeople
    fun getInspiringPerson(name: String) : InspiringPerson = inspiringPeople.first { it -> it.name == name}
    fun insert(inspiringPerson: InspiringPerson) = inspiringPeople.add(inspiringPerson)
    fun delete(inspiringPerson: InspiringPerson) = inspiringPeople.remove(inspiringPerson)
    fun deleteAll() = inspiringPeople.clear()
}