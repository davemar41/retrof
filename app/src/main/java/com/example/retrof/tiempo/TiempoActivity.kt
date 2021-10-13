package com.example.retrof.tiempo

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrof.R
import com.example.retrof.databinding.ActivityTiempoBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TiempoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind=ActivityTiempoBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val UrlApi0="https://samples.openweathermap.org/"

        bind.tiempoactivityRw.layoutManager=LinearLayoutManager(this)
        bind.tiempoactivityRw.adapter=null
        var retrofitTiempo=Retrofit.Builder()
            .baseUrl(UrlApi0)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiTiempo=retrofitTiempo.create(Apitiempo::class.java)
        var callTiempo=apiTiempo.getTiempo()
        callTiempo.enqueue(object :  Callback<Metereologia> {
            override fun onResponse(call: Call<Metereologia>, response: Response<Metereologia>) {
                for (res in response.body()!!.list) {
                    Log.d("Tag Respuesta", res.main.temp)

                }
                bind.tiempoactivityRw.adapter=Tiempoadapter(response.body()!!.list)

            }

            override fun onFailure(call: Call<Metereologia>, t: Throwable) {
                Log.e("TAG Failure", t.toString())
            }


        })



    }
}

