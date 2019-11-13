package com.snikky15.learnkotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var counttest: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val textview = findViewById<TextView>(R.id.number)
        val button = findViewById<Button>(R.id.count)
        counttest = 10
        textview?.text = counttest.toString()
        button?.setOnClickListener{
            val countString = textview.text.toString()
            counttest =Integer.parseInt(countString)
            counttest++

            textview.text = counttest.toString()
        }
        val toastbtn = findViewById<Button>(R.id.toast)
        toastbtn?.setOnClickListener{
            Toast.makeText(this, "Hello u mutherfucker", Toast.LENGTH_LONG).show()
        }
        val randombtn = findViewById<Button>(R.id.random)
        randombtn?.setOnClickListener{
            val sp: SharedPreferences = getSharedPreferences("db_temp.db", Context.MODE_PRIVATE)
            val test = sp.edit()
            Log.e("ERR_catch", counttest.toString())
            test.putInt("test", counttest)
            test.apply()
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }
}
