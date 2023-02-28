package ru.marijarin.mytest.mytest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.marijarin.mytest.mytest.entity.QuestionEntity

@Dao
interface QuestionDao {
    @Query("SELECT * FROM QuestionEntity ORDER BY number ASC")
    fun getAll(): Flow<List<QuestionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(question: QuestionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(questions: List<QuestionEntity>)

    @Query("DELETE FROM QuestionEntity WHERE number = :number")
    suspend fun removeById(number: Long)
}