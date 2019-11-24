package com.example.carroapp

import android.content.Context
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carroapp.db.Carro
import kotlinx.android.synthetic.main.item_lista.view.*
import java.text.NumberFormat
import java.util.*

class ListaCarroAdapter
    internal constructor(context: Context):
    RecyclerView.Adapter<ListaCarroAdapter.ViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var itens = emptyList<Carro>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = inflater.inflate(
            R.layout.item_lista,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int  = itens.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itens[position]
        holder.itemMarca.text =  item.marca
        holder.itemModelo.text = item.modelo
        holder.itemAno.text = item.ano
        //holder.itemPreco.text = getString(R.string.money_sign, item.preco.toString())
        holder.itemPreco.text = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(item.preco)
    }

    inner class ViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){

        val itemMarca: TextView = itemView.itemMarca
        val itemModelo: TextView = itemView.itemModelo
        val itemAno: TextView = itemView.itemAno
        val itemPreco: TextView = itemView.itemPreco
    }

    /*private fun lista(): List<Carro>{
        return listOf(
            Carro("Volkswagem", "Jetta", "2018", 89.499),
            Carro("Fiat", "Argo", "2018", 59.999),
            Carro("Ford", "Fusion", "2018", 104.999),
            Carro("Honda", "Civic", "2018", 95.99)
        )
    }*/

    fun setCarroLista(carros: List<Carro>) {
        this.itens = carros
        notifyDataSetChanged()
    }

}




