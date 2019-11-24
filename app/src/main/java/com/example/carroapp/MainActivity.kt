package com.example.carroapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.carroapp.db.Carro
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var carro: Carro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun save(view: View){
        if(edtBrand.text.isNullOrEmpty()){
            Toast.makeText(
                this,
                getString(R.string.empty_brand_message),
                Toast.LENGTH_LONG
            ).show()
        } else if(edtModel.text.isNullOrEmpty()){
            Toast.makeText(
                this,
                getString(R.string.empty_model_message),
                Toast.LENGTH_LONG
            ).show()
        } else{
            carro = Carro()
            popObj()

            var intent = Intent()

            intent.putExtra(EXTRA_REPLY, carro)

            setResult(Activity.RESULT_OK, intent)

            finish()
            //startActivity(intent)
        }
    }

    private fun popObj(){
        carro.marca = edtBrand.text.toString()
        carro.modelo = edtModel.text.toString()
        carro.ano = edtYear.text.toString()
        carro.preco = edtPrice.text.toString().toDouble()
    }

    companion object{
        const val EXTRA_REPLY = "com.example.carroapp.REPLY"
    }
}
