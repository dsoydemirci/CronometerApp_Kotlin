package com.soydemircidogukan.kronometre1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.soydemircidogukan.kronometre1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var number = 0
    var runnable : Runnable = Runnable {  }
    var handler : Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)






    }
    fun start(view: View) {

        number = 0

        runnable = object : Runnable {
            override fun run() {

                number = number + 1
                binding.textView.text = "Time: $number"

                handler.postDelayed(this,1000)

            }

        }

        handler.post(runnable)

       // binding.button.isEnabled = false


    }

    fun stop(view: View) {

        handler.removeCallbacks(runnable)
        number = 0
        binding.textView.text = "Time: 0"

        //binding.button.isEnabled = true


    }


}