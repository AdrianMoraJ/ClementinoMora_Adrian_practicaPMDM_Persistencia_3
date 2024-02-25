package com.example.clementinomora_adrian_practicapmdm_persistencia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import YourTasks.R
import android.widget.Button
import android.widget.TextView

class TaskManagerFragment : Fragment() {

    private lateinit var rootView: View

    private lateinit var taskNameTextView: TextView
    private lateinit var taskDescriptionTextView: TextView
    private lateinit var taskDueDateTextView: TextView
    private lateinit var taskPriorityTextView: TextView
    private lateinit var editTaskButton: Button
    private lateinit var deleteTaskButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_task_manager, container, false)
        initViews()
        // Aquí puedes configurar los datos de la tarea en los elementos de la vista
        // por ejemplo:
        taskNameTextView.text = "Nombre de la Tarea"
        taskDescriptionTextView.text = "Descripción de la Tarea"
        taskDueDateTextView.text = "Fecha de Vencimiento: DD/MM/AAAA"
        taskPriorityTextView.text = "Prioridad: Alta"
        // Manejar clics en los botones de acción
        editTaskButton.setOnClickListener {
            // Lógica para editar la tarea
        }
        deleteTaskButton.setOnClickListener {
            // Lógica para eliminar la tarea
        }
        return rootView
    }

    private fun initViews() {
        taskNameTextView = rootView.findViewById(R.id.textViewTaskName)
        taskDescriptionTextView = rootView.findViewById(R.id.textViewTaskDescription)
        taskDueDateTextView = rootView.findViewById(R.id.textViewTaskDueDate)
        taskPriorityTextView = rootView.findViewById(R.id.textViewTaskPriority)
        editTaskButton = rootView.findViewById(R.id.buttonEditTask)
        deleteTaskButton = rootView.findViewById(R.id.buttonDeleteTask)
    }
}
