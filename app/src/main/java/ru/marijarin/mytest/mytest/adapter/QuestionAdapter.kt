package ru.marijarin.mytest.mytest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.marijarin.mytest.databinding.QuestionBinding
import ru.marijarin.mytest.mytest.dto.Question

class QuestionAdapter : ListAdapter<Question, QuestionViewHolder>(QuestionDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = QuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)


        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = getItem(position)
        holder.bind(question)
    }
}

class QuestionViewHolder(
    private val binding: QuestionBinding,

    ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(question: Question) {
        binding.apply {
            number.text = question.number.toString()
            task.text = question.task
            option1.text = question.optionOne
            option2.text = question.optionTwo
            option3.text = question.optionThree
            option4.text = question.optionFour
            
            radioGroup.setOnCheckedChangeListener { group, checkedId ->  }
        }
        
    }
}

class QuestionDiffCallback : DiffUtil.ItemCallback<Question>() {
    override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
        return oldItem == newItem
    }
}
