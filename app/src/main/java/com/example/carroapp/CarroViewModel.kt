package com.example.carroapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.carroapp.db.Carro
import com.example.carroapp.db.HelperDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CarroViewModel (application: Application): AndroidViewModel(application){
    private val repository: CarroRepository

    val carros: LiveData<List<Carro>>

    private val parentJob = Job()
    private val coroutineContext get() =
        parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    init{
        val carroDAO = HelperDatabase.getDatabase(application).carroDao()
        repository = CarroRepository(carroDAO)

        carros = repository.carros // carros
    }

    fun insert(carro: Carro) = scope.launch(Dispatchers.IO){
        repository.insert(carro)
    }

    fun update(carro: Carro) = scope.launch(Dispatchers.IO){
        repository.update(carro)
    }

    fun delete(carro: Carro) = scope.launch(Dispatchers.IO){
        repository.delete(carro)
    }
}