package com.snikky15.learnkotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        supportActionBar?.hide()
        shadowRandomNumber()
        val backbtn = findViewById<Button>(R.id.gobackbtn)
        backbtn?.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun shadowRandomNumber() {
        val sp: SharedPreferences = getSharedPreferences("db_temp.db", MODE_PRIVATE)
        Log.e("ERR_catch2", sp.getInt("test", 0).toString())
        val textrandom = findViewById<TextView>(R.id.str_random)
        val randomtest = Random()
        var randomInt = 0
        val count = sp.getInt("test", 0)
        val test: Int = 0
        if(count > 0){
            randomInt = randomtest.nextInt(count + 1)
        }
        textrandom.text = Integer.toString(randomInt)
    }
}