package com.example.carroapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "carro_tb")
class Carro (
    var marca: String = "",
    var modelo: String = "",
    var ano: String =  "",
    var preco: Double = 0.0
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}