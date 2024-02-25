import YourTasks.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clementinomora_adrian_practicapmdm_persistencia.module_BD.DatabaseBuilder
import com.example.clementinomora_adrian_practicapmdm_persistencia.module_BD.Task
import com.example.clementinomora_adrian_practicapmdm_persistencia.view.TaskAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskListFragment : Fragment() {
    private lateinit var recyclerViewTasks: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_list, container, false)
        recyclerViewTasks = view.findViewById(R.id.recyclerViewTasks)
        setupRecyclerView()
        loadTasks()
        return view
    }

    private fun setupRecyclerView() {
        recyclerViewTasks.layoutManager = LinearLayoutManager(requireContext())
        taskAdapter = TaskAdapter(emptyList()) // Inicialmente, el adaptador estará vacío
        recyclerViewTasks.adapter = taskAdapter
    }

    private fun loadTasks() {
        // Lanzar una coroutine para cargar las tareas desde la base de datos en segundo plano
        GlobalScope.launch(Dispatchers.Main) {
            val dao = DatabaseBuilder.getInstance(requireContext()).taskDao()
            val tasks = dao.getAllTasks()
            // Actualizar el adaptador con las tareas cargadas
            taskAdapter.updateTasks(tasks)
        }
    }
    private fun addTask(task: Task) {
        taskAdapter.addTask(task)
    }

}
