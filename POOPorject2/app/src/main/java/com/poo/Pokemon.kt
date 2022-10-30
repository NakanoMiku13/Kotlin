package com.poo

class Pokemon(
    private var name : String = "None",
    private var attackPower : Float = 0f,
    private var life : Float = 100f
) {
    fun Pokemon(name : String,attackPower : Float){
        this.name = name
        this.attackPower = attackPower
    }
    fun getName():String{
        return this.name
    }
    fun getAttackPower():Float{
        return this.attackPower
    }
    fun getLife():Float{
        return this.life
    }
    fun setName(newName:String){
        this.name = newName
    }
    fun setAttackPower(newPowerAttack:Float){
        this.attackPower = newPowerAttack
    }
}