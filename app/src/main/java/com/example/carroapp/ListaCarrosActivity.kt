package com.example.carroapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carroapp.db.Carro
import kotlinx.android.synthetic.main.activity_lista_carros.*
import java.lang.Exception

class ListaCarrosActivity : AppCompatActivity() {

    val REQUEST_CODE = 12

    private lateinit var carroViewModel: CarroViewModel

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_carros)

        recyclerView = recycler_carros

        montaLista(recyclerView)

        /*val adapter = ListaCarroAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)*/

        carroViewModel = ViewModelProviders.of(this).
                get(CarroViewModel::class.java)

        fbNew.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)

            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE
            && resultCode == Activity.RESULT_OK){

            data?.let { resultado ->
                try {
                    val carro: Carro = resultado.extras?.get(MainActivity.EXTRA_REPLY) as Carro
                    carro.let {
                        carroViewModel.insert((carro))
                    }
                } catch (e: Exception){
                    Log.d("TAG: ", e.message)
                }
            }
        }
    }

    private fun montaLista(recyclerView: RecyclerView){
        val adapter = ListaCarroAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        carroViewModel = ViewModelProviders.of(this).get(CarroViewModel::class.java)

        carroViewModel.carros.observe(this,
            Observer { carroLista ->
                carroLista?.let{ lista->
                    adapter.setCarroLista(lista)
                }
            })
    }

    override fun onRestart() {
        super.onRestart()

        montaLista(recyclerView)
    }
}















