package com.zai.guess

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()
    val TAG = MaterialActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(findViewById(R.id.toolbar))
        Log.d(TAG,"SecretNumber:${secretNumber.secretNumber}")

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            AlertDialog.Builder(this)
                    .setTitle(getString(R.string.Replay))
                    .setMessage(getString(R.string.Are_you_sure))
                    .setPositiveButton(getString(R.string.ok),{dialog,which->
                        secretNumber.reset()
                        counter.text = secretNumber.count.toString()
                        number.setText("")
                    })
                    .setNeutralButton(getString(R.string.cancel),null)
                    .show()

        }
        counter.text = secretNumber.count.toString()

    }
    fun check(view: View){
        try {
            val n:Int =number.text.toString().toInt() //將 number import 改為 material.*
            // println("number:$n")
            Log.d(TAG,"number:$n")
            val diff = secretNumber.different(n)
            var message = getString(R.string.Bingo)
            if (diff> 0){
                message = getString(R.string.Smaller)
            }else if (diff <0){
                message = getString(R.string.Bigger)
            }
            counter.text = secretNumber.count.toString()
//            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_title))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok),null)
                .show()
        }catch (e:NumberFormatException){
            //println("請輸入數字 1-10")
            Log.d(TAG,"請輸入數字 1-10")
            bug.text = "請輸入數字 1-10 !!!"
        }
    }
}