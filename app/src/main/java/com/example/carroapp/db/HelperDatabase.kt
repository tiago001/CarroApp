package com.example.carroapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Carro::class], version = 1)
abstract class HelperDatabase: RoomDatabase() {

    abstract fun carroDao(): CarroDAO

    companion object{
        private var INSTANCE: HelperDatabase? = null

        fun getDatabase(context: Context): HelperDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HelperDatabase::class.java,
                    "carro_tb"
                )   .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}