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
    val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"SecretNumber:${secretNumber.secretNumber}")
    }
    fun check(view:View){
        try {
            val n:Int =number.text.toString().toInt()
           // println("number:$n")
            Log.d("MainActivity","number:$n")
            val diff = secretNumber.different(n)
            var message = getString(R.string.Bingo)
            if (diff> 0){
                message = getString(R.string.Smaller)
            }else if (diff <0){
                message = getString(R.string.Bigger)
            }
//            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok),null)
            .show()
        }catch (e:NumberFormatException){
            //println("請輸入數字 1-10")
            Log.d(TAG,"請輸入數字 1-10")
        }
    }

}