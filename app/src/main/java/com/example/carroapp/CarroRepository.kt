package com.example.carroapp

import androidx.lifecycle.LiveData
import com.example.carroapp.db.Carro
import com.example.carroapp.db.CarroDAO

class CarroRepository(private val carroDAO: CarroDAO) {

    fun insert(carro: Carro){
        carroDAO.insert(carro)
    }

    fun update(carro: Carro){
        carroDAO.update(carro)
    }

    fun delete(carro: Carro){
        carroDAO.delete(carro)
    }

    val carros: LiveData<List<Carro>> = carroDAO.getAll()
}