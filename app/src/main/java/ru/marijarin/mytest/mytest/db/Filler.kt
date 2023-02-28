package ru.marijarin.mytest.mytest.db

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException
import ru.marijarin.mytest.R
import ru.marijarin.mytest.mytest.entity.QuestionEntity
import java.io.BufferedReader

class Filler(private val context: Context): RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        CoroutineScope(Dispatchers.IO).launch {
            fillWithQuestions(context)
        }
    }
    private suspend fun fillWithQuestions(context: Context){
        val questionDao = AppDb.getInstance(context).questionDao()
        try {
            val questions = loadJSONArray(context)
            for (i in 0 until questions.length()){
                val item = questions.getJSONObject(i)
                val number = item.getLong("number")
                val task = item.getString("task")
                val optionOne = item.getString("optionOne")
                val optionTwo= item.getString("optionTwo")
                val optionThree= item.getString("optionThree")
                val optionFour= item.getString("optionFour")
                val correctOption= item.getString("correctOption")
                val questionEntity = QuestionEntity(
                    number,
                    task,
                    optionOne,
                    optionTwo,
                    optionThree,
                    optionFour,
                    correctOption
                )
                questionDao.insert(questionEntity)
            }
        }
        catch (e: JSONException) {
            Log.e("***Loading from json***","fillWithQuestions: $e")
        }
    }

    private fun loadJSONArray(context: Context): JSONArray {
        //obtain input byte
        val inputStream = context.resources.openRawResource(R.raw.questions)
        //using Buffered reader to read the inputstream byte
        BufferedReader(inputStream.reader()).use {
            return JSONArray(it.readText())
        }
    }
}