package com.example.ejerciciopoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var Athlete1 : Runner = Runner("Race",2.3f,"Daniel",60.0f,162.2f,20)
    var Athlete2 : Swimmer = Swimmer("Butterfly",1.4f,"Andrea",43f,156f,20)
    var Athlete3 : Ciclist = Ciclist("BMX",200f,"Hensy",160f,60f,20)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(Athlete1.getName())
        Athlete1.rest()
        println(Athlete1.getStyle())
        Athlete1.run()
        Athlete1.fight()

        println(Athlete2.getName())
        Athlete2.rest()
        println(Athlete2.getStyle())
        Athlete2.swim()
        Athlete2.fight()

        println(Athlete3.getName())
        Athlete3.rest()
        println(Athlete3.getBicicleType())
        Athlete3.riding()
        Athlete3.fight()
    }

}