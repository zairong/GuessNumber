package com.zai.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","SecretNumber:${secretNumber.secretNumber}")
    }
    fun check(view:View){
        try {
            val n:Int =number.text.toString().toInt()
           // println("number:$n")
            Log.d("MainActivity","number:$n")
            val diff = secretNumber.different(n)
            var message = "Bingo"
            if (diff> 0){
                message = "再小一點"
            }else if (diff <0){
                message = "再大一點"
            }
//            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(message)
            .setPositiveButton("ok",null)
            .show()
        }catch (e:NumberFormatException){
            //println("請輸入數字 1-10")
            Log.d("MainActivity","請輸入數字 1-10")
        }
    }

}