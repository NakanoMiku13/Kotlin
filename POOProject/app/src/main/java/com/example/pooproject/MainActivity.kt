package com.example.pooproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Daniel: Person = Person()
        if(Daniel.alive) println("Yes")
        Daniel.die()
        if(Daniel.alive) println("Yes")
        else println("No")

    }
}