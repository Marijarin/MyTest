package ru.marijarin.mytest.mytest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.marijarin.mytest.mytest.entity.AnswerEntity


@Dao
    interface AnswerDao {
        @Query("SELECT * FROM AnswerEntity ORDER BY number ASC")
        fun getAll(): Flow<List<AnswerEntity>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(answer: AnswerEntity)

        @Query("DELETE FROM AnswerEntity")
        suspend fun clean()
    }
