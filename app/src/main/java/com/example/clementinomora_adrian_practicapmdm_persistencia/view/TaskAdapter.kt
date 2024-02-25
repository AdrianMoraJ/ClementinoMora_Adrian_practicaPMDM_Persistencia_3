package com.example.clementinomora_adrian_practicapmdm_persistencia.view

import YourTasks.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clementinomora_adrian_practicapmdm_persistencia.module_BD.Task

class TaskAdapter(private var tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.bind(task)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
    fun addTask(task: Task) {
        val updatedTasks = tasks.toMutableList()
        updatedTasks.add(task)
        tasks = updatedTasks.toList()
        notifyItemInserted(tasks.size - 1)
    }


    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskNameTextView: TextView = itemView.findViewById(R.id.textViewTaskName)
        private val taskDescriptionTextView: TextView = itemView.findViewById(R.id.textViewTaskDescription)
        private val taskDueDateTextView: TextView = itemView.findViewById(R.id.textViewTaskDueDate)
        private val taskPriorityTextView: TextView = itemView.findViewById(R.id.textViewTaskPriority)

        fun bind(task: Task) {
            taskNameTextView.text = task.name
            taskDescriptionTextView.text = task.description
            taskDueDateTextView.text = task.dueDate
            taskPriorityTextView.text = task.priority
        }
    }
}
