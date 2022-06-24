package com.airbnb.androi.white.us

import com.airbnb.androi.white.Quest

object Quiz {
    fun getQues(): ArrayList<Quest> {

        val quesList = ArrayList<Quest>()

        val ques1 = Quest(1, "How many times a day do you eat?",
            "One", "Two", "Three and more", "I don't know")

        quesList.add(ques1)

        val ques2 = Quest(2, "What do you do in your free time?",
            "Outdoor activities", "Party/ eating out", "Sometimes", "Nope")

        quesList.add(ques2)

        val ques3 = Quest(3, "Do you exercise?",
            "Sometimes I get up from the couch", "What is free time?", "Surfing the Internet", "Eating out")

        quesList.add(ques3)

        return quesList
    }
}