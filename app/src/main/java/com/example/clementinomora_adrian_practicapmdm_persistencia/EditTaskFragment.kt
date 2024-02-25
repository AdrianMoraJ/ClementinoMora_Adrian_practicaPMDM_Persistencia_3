import YourTasks.R
import android.util.Log
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.clementinomora_adrian_practicapmdm_persistencia.module_BD.DatabaseBuilder
import com.example.clementinomora_adrian_practicapmdm_persistencia.module_BD.Task
import kotlinx.coroutines.launch

class EditTaskFragment : Fragment() {

    private lateinit var editTextTaskName: EditText
    private lateinit var editTextTaskDescription: EditText
    private lateinit var textViewDueDate: TextView
    private lateinit var textViewPriority: TextView
    private lateinit var buttonSaveTask: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_task, container, false)
        initializeViews(view)
        setupListeners()
        return view
    }

    private fun initializeViews(view: View) {
        editTextTaskName = view.findViewById(R.id.editTextTaskName)
        editTextTaskDescription = view.findViewById(R.id.editTextTaskDescription)
        textViewDueDate = view.findViewById(R.id.textViewDueDate)
        textViewPriority = view.findViewById(R.id.textViewPriority)
        buttonSaveTask = view.findViewById(R.id.buttonSaveTask)
    }

    private fun setupListeners() {
        buttonSaveTask.setOnClickListener {
            saveTaskChanges()
        }
    }

    private fun saveTaskChanges() {
        val editedTaskName = editTextTaskName.text.toString()
        val editedTaskDescription = editTextTaskDescription.text.toString()
        val editedDueDate = textViewDueDate.text.toString()
        val editedPriority = textViewPriority.text.toString()

        // Crear una instancia de la tarea editada utilizando el constructor secundario
        val editedTask = Task(moduleId = "", name = editedTaskName, description = editedTaskDescription, dueDate = editedDueDate, priority = editedPriority)

        // Lanzar una coroutine para actualizar la tarea en la base de datos
        lifecycleScope.launch {
            // Guardar la tarea editada en la base de datos
            val dao = DatabaseBuilder.getInstance(requireContext()).taskDao()
            dao.updateTask(editedTask)

            // Mostrar un mensaje en el Logcat para indicar que se guardaron los cambios
            Log.d("EditTaskFragment", "Cambios guardados en la tarea: $editedTask")
        }
    }

}
