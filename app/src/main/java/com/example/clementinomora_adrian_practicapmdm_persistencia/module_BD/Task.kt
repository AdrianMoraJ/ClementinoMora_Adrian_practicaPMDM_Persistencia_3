package com.example.clementinomora_adrian_practicapmdm_persistencia.module_BD

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entidad para las tareas
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // Cambiado a Int para auto-generación
    val moduleId: String, // ID del módulo al que pertenece la tarea
    val name: String,
    val description: String,
    val dueDate: String,
    val priority: String
) {
    // Constructor secundario para crear una nueva tarea sin especificar el ID
    constructor(moduleId: String, name: String, description: String, dueDate: String, priority: String) :
            this(0, moduleId, name, description, dueDate, priority)
}
