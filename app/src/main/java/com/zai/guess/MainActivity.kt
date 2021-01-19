package com.zai.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
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
            if (secretNumber.different(n)> 0){
                Toast.makeText(this, "Bigger", Toast.LENGTH_LONG).show()
            }else if (secretNumber.different(n)<0){
                Toast.makeText(this, "Smaller", Toast.LENGTH_LONG).show()
            }else
                Toast.makeText(this, "Bingo", Toast.LENGTH_LONG).show()

        }catch (e:NumberFormatException){
            //println("請輸入數字 1-10")
            Log.d("MainActivity","請輸入數字 1-10")
        }
    }

}