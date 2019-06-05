package com.example.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Time
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    var code = ""
    val rightcode = 2222
    val TAG = "MyLog"
    val PASSWORD_LENGTH = 4
    companion object {
        val intentDataTag = "IntentTag"
    }

    fun update(text: String) {
        input.setText(text, TextView.BufferType.EDITABLE)
    }

    fun add_text(text: String) {
        input.setText(input.text.toString() + text, TextView.BufferType.EDITABLE)
    }
    fun buttonListener(view: View) {
        code += (view as Button).text
        add_text((view as Button).text.toString())
        Log.d("MyLog", "Button pressed")
        if (code.length == PASSWORD_LENGTH){
            check()
        }
    }

    fun check(){
        if (code == rightcode.toString()) {
            Toast.makeText(this, "RIGHT", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra(intentDataTag, input.text.toString())
            startActivity(intent)
        } else {
            Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show()
        }
        code = ""
        update(code)
    }

    fun DeleteButtonListener(view: View) {
        if (code.length == 0) return
        code = code.slice(0 until (code.length - 1))
        update(code)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate function")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener(::buttonListener)
        b2.setOnClickListener(::buttonListener)
        b3.setOnClickListener(::buttonListener)
        b4.setOnClickListener(::buttonListener)
        b5.setOnClickListener(::buttonListener)
        b6.setOnClickListener(::buttonListener)
        b7.setOnClickListener(::buttonListener)
        b8.setOnClickListener(::buttonListener)
        b9.setOnClickListener(::buttonListener)
        b0.setOnClickListener(::buttonListener)
        delete.setOnClickListener(::DeleteButtonListener)

    }
}
