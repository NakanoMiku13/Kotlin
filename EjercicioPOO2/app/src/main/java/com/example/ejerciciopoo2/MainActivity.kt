package com.example.ejerciciopoo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private fun compare(number: Int, function: (Int)->Boolean): Boolean{
        return function(number)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val number = 15
        val pairNumber = compare(number){num: Int ->
            num % 2 == 0
        }
        val primaryNumber = compare(number){
            var counter = 0
            var c = true
            for(i in 1..it)
                if(counter > 2) {
                    c = false
                    break
                }
                else{
                    if(it % i == 0) counter++
                }
            c
        }
        val coolNumber = compare(number){value : Int ->
            var cool = 0
            var c = false
            for(i in 1..value)
                if(cool == number) {
                    c = true
                    break
                }
                else cool += i
            c
        }
        if(pairNumber) println("Is pair");
        else println("It is not pair")
        if(primaryNumber) println("Is primary")
        else println("It is not primary")
        if(coolNumber) println("Is cool")
        else println("It is not cool")
    }
}