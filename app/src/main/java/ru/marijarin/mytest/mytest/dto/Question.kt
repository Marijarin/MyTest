package ru.marijarin.mytest.mytest.dto

data class Question(
    val number: Long,
    val task: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctOption: String,
)