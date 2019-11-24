package com.example.carroapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CarroDAO {

    @Insert
    fun insert(carro: Carro)

    @Update
    fun update(carro: Carro)

    @Delete
    fun delete(carro: Carro)

    @Query("SELECT * FROM carro_tb ORDER BY marca")
    fun getAll():LiveData<List<Carro>>

    @Query("SELECT * FROM carro_tb where id = :id_")
    fun getByID(id_: Int): LiveData<Carro>

    @Query("DELETE FROM carro_tb")
    fun deleteAll()
}