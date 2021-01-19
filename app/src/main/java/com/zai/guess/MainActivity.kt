package com.zai.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun check(view:View){
        try {
            val n:Int =number.text.toString().toInt()
           // println("number:$n")
            Log.d("MainActivity","number:$n")
        }catch (e:NumberFormatException){
            //println("請輸入數字 1-10")
            Log.d("MainActivity","請輸入數字 1-10")
        }
    }

}