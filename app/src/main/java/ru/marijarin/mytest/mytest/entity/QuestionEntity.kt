package ru.marijarin.mytest.mytest.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.marijarin.mytest.mytest.dto.Question


@Entity
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    val number: Long,
    val task: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctOption: String,
) {
    fun toDto() = Question(
        number,
        task,
        optionOne,
        optionTwo,
        optionThree,
        optionFour,
        correctOption
    )

    companion object {
        fun fromDto(dto: Question) =
            QuestionEntity(
                dto.number,
                dto.task,
                dto.optionOne,
                dto.optionTwo,
                dto.optionThree,
                dto.optionFour,
                dto.correctOption
            )
    }
}

fun List<QuestionEntity>.toDto(): List<Question> = map(QuestionEntity::toDto)
fun List<Question>.toEntity(): List<QuestionEntity> = map(QuestionEntity::fromDto)