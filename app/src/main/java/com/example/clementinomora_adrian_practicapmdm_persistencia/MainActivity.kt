package com.example.clementinomora_adrian_practicapmdm_persistencia

import TaskListFragment
import YourTasks.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar el fragmento inicial
        if (savedInstanceState == null) {
            val initialFragment = TaskListFragment() // Instancia del fragmento que deseas mostrar inicialmente
            loadFragment(initialFragment)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
