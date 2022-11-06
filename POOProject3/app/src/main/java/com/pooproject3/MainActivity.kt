package com.pooproject3

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tt = false
        var textViewMain = findViewById<TextView>(R.id.textViewMain)
        var editTextMain = findViewById<EditText>(R.id.editTextMain)
        //var textViewMain : TextView = findViewById(R.id.textViewMain)
        textViewMain.apply{
            text = "Este es un texto nuevo"
            setTextColor(Color.RED)
            setOnClickListener {
                Toast.makeText(this@MainActivity,"Presionaste el texto",Toast.LENGTH_SHORT).show()
                if(tt){
                    textViewMain.setTextColor(Color.GREEN)
                    tt = false
                    textViewMain.text = "Eres putisimo pero en verde"
                }else{
                    textViewMain.setTextColor(Color.RED)
                    tt = true
                    textViewMain.text = "Eres putisimo pero en rojo"
                }
            }
        }
        editTextMain.addTextChangedListener{
            if(editTextMain.text.length == 0) editTextMain.setError("No hay nada pendejo")
        }
        val ini = editTextMain.selectionStart
        val end = editTextMain.selectionEnd
        val all = editTextMain.selectAll()
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val countries = resources.getStringArray(R.array.countries)
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,countries)
        autoCompleteTextView.setAdapter(adapter)
        val multiAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView2)
        multiAutoCompleteTextView.setAdapter(adapter)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

    }
}