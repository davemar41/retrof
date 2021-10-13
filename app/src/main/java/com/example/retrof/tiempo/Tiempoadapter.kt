package com.example.retrof.tiempo

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrof.R
import com.example.retrof.databinding.ListItemTiempoBinding
import java.text.SimpleDateFormat
import java.util.*


class Tiempoadapter(val metereologia: ArrayList<Tiempo>):
    RecyclerView.Adapter<Tiempoadapter.TiempoviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiempoviewHolder {
        var layoutinflado=LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_tiempo,parent,false)
        return  Tiempoadapter.TiempoviewHolder(layoutinflado)
    }

    override fun onBindViewHolder(holder: TiempoviewHolder, position: Int) {
        var itemtiempo= metereologia[position]
        holder.bindTiempo(itemtiempo)
    }

    override fun getItemCount(): Int {
        return metereologia.size
    }




    class TiempoviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            var binding=ListItemTiempoBinding.bind(itemView)
        fun bindTiempo(tiempo:Tiempo){

            var date= Date(tiempo.dt.toLong()*1000)
            var sdf=SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            var tiempo1=sdf.format(date)
            Log.d("TIEMPO ADAPTER: ", tiempo1)
            binding.fechalit.text=tiempo1
            binding.temperaturalit.text=tiempo.main.temp
            binding.humedadlit.text=tiempo.main.humidity








        }
    }



}