package ru.marijarin.mytest.mytest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.marijarin.mytest.mytest.dao.QuestionDao
import ru.marijarin.mytest.mytest.entity.AnswerEntity
import ru.marijarin.mytest.mytest.entity.QuestionEntity

@Database(entities = [QuestionEntity::class, AnswerEntity::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile
        private var instance: AppDb? = null

        fun getInstance(context: Context): AppDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDb::class.java, "app.db")
                .addCallback(Filler(context))
                .fallbackToDestructiveMigration()
                .build()
    }
}