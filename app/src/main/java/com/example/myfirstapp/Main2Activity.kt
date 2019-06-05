package com.example.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    companion object {
        val intentDataTag = "IntentTag"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val data = Array(10, {i -> "${(i + 1) * (i + 1)}"})
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        list.adapter = adapter
        list.setOnItemClickListener({ parent, view, position, id ->
            val intent = Intent(this, Main3Activity::class.java)
            intent.putExtra(intentDataTag, (view as TextView).text.toString())
            startActivity(intent)
        })
    }
}
