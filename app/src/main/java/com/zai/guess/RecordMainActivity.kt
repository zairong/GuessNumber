package com.zai.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_record_main.*
import kotlinx.android.synthetic.main.content_material.*

class RecordMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_main)
        val count = intent.getIntExtra("COUNTER",-1)
        record_counter.text = count.toString()

        save.setOnClickListener {
            val nick = nickname.text.toString()
            getSharedPreferences("guess", MODE_PRIVATE)
                    .edit()
                    .putInt("Rec_count",count)
                    .putString("Rec_nickname",nick)
                    .apply()
        }
    }

}