package com.example.retrof

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrof.databinding.ActivityMainBinding
import com.example.retrof.tiempo.TiempoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind=ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        /*Array[]
            "list"
                "dt"
                "main"
                    "temp"
                    "humidity"*/

        bind.tiempo.setOnClickListener {
            var intent= Intent(this,TiempoActivity::class.java)
            startActivity(intent)
        }
    }
}