package com.example.clementinomora_adrian_practicapmdm_persistencia.module_BD

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Module::class, Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moduleDao(): ModuleDao
    abstract fun taskDao(): TaskDao
}
