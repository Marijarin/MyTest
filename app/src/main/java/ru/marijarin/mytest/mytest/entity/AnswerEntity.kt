package ru.marijarin.mytest.mytest.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.marijarin.mytest.mytest.dto.Answer


@Entity
data class AnswerEntity(
    @PrimaryKey(autoGenerate = true)
    val number: Long,
    val question: String,
    val option: String,
) {
    fun toDto() = Answer(
        number,
        question,
        option
    )

    companion object {
        fun fromDto(dto: Answer) =
            AnswerEntity(
                dto.number,
                dto.question,
                dto.option,
            )
    }
}

fun List<AnswerEntity>.toDto(): List<Answer> = map(AnswerEntity::toDto)
fun List<Answer>.toEntity(): List<AnswerEntity> = map(AnswerEntity::fromDto)