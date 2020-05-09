package com.example.ochadukebiyori.androidcomponenttestexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, OtherActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (resultCode != RESULT_OK) { return }
            if (requestCode != 1) { return }

            findViewById<TextView>(R.id.helloWorld).text = data?.getStringExtra("greeting")
        }
}
