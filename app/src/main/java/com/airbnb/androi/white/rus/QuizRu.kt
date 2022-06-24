package com.airbnb.androi.white.rus

import com.airbnb.androi.white.Quest

object QuizRu {
    fun getQues(): ArrayList<Quest> {

        val quesList = ArrayList<Quest>()

        val ques1 = Quest(1, "Сколько у Вас приемов пищи за день?",
            "Один", "Два", "Три", "Я не считаю")

        quesList.add(ques1)

        val ques2 = Quest(2, "Вы ведете здоровый образ жизни?",
            "Пытаюсь, но не всегда получается", "Конечно", "Иногда", "Нет")

        quesList.add(ques2)

        val ques3 = Quest(3, "Вы занимаетесь физической активностью?",
            "Иногда встаю с дивана", "Занимаюсь", "Выхожу на пробежку раз в год", "Редко")

        quesList.add(ques3)

        return quesList
    }
}